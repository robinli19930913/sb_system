<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
	<style type="text/css">
		.form-div {margin-left: 20px; margin-top: 10px;}
	</style>
</head>
<body>
	<script type="text/javascript">
		$().ready(function (){
			$("#user_list").datagrid({
				url:"<%=request.getContextPath()%>/list.do",
				pagination:true,
				pageList:[20,50,100,300],
				pageSize:20,
				fit:true,
				border:false,
				emptyMsg: '<span>暂无记录，请更换条件重新搜索</span>',
				columns:[[
				          {field:'userId',title:'账号ID',width:100}, 
				          {field:'userName',title:'账号',width:100}, 
				          {field:'nickName',title:'姓名',width:100}, 
				          {field:'phone',title:'电话',width:100}, 
				          {field:'fkUpdateName',title:'更新姓名',width:100}, 
				          {field:'updateTime',title:'更新时间',width:100,
				        	  formatter: function(value,row,index){
				        		  return getDateFormat(value);
				  			  }  
				          }, 
				          {field:'state',title:'状态',width:100,
				        	  formatter: function(value,row,index){
								   if(value==1){
									   return "启用";
								   }else if(value==2){
									   return "禁用"
								   }else{
									   return "待审核";
								   }
							   }
				          },
				          {field:'caozuo',title:'操作',width:100,
				        	  formatter: function(value,row,index){
				        		 var html = "<a href='#' style='color:  #4178BC;' onclick='updateUser("+row.userId+",\""+row.nickName+"\",\""+row.phone+"\")'>修改</a>&nbsp;";
				        		 if(row.state==1){
									   html += "<a href='#' style='color:  #4178BC;' onclick='updateState("+row.userId+",2)'>禁用</a>";
								 }
				        		 if(row.state==2){
									   html += "<a href='#' style='color:  #4178BC;' onclick='updateState("+row.userId+",1)'>启用</a>";
								 }
				        		 if(row.state==3){
									   html += "<a href='#' style='color:  #4178BC;' onclick='updateState("+row.userId+",1)'>审核通过</a>";
								 }
				        		 return html;  
				  			  }
				          }
				]],
				fitColumns:true,
				toolbar: [{
					iconCls: 'icon-add',
					text:'添加账户',
					handler: function(){
						$("#user_add_dlg").dialog({
							title:"添加账户",
							modal:true,
							closed:true
						});
						$("#user_add_ff").form("clear");
						$("#user_add_dlg").dialog("open");
					}
				}],
				singleSelect:true
			});
			
			$("[name='type']").combobox({
				valueField: 'value',
				textField: 'label',
				width:"80%",
				editable:false,//禁止输入
				data: [
					{
					label: '超级管理员',
					value: '1',
					selected:true//默认选中
				},
				{
					label: '代理商',
					value: '2'
				},
				{
					label: '其他',
					value: '3'
				}
				],
				panelHeight:'auto'//适配大小
			});
			
			$("#user_add_dlg").dialog({
				width:"400px",
				height:"300px",
				closed:true
			});
			$("#user_update_dlg").dialog({
				width:"300px",
				height:"200px",
				closed:true
			});			
			$("#user_update_submit").linkbutton({
				iconCls: "icon-save",
				width:"45%"
			});
			$("#user_update_reset").linkbutton({
				iconCls: "icon-reload",
				width:"45%"
			});
			$("#user_add_submit").linkbutton({
				iconCls: "icon-save",
				width:"45%"
			});
			$("#user_add_reset").linkbutton({
				iconCls: "icon-reload",
				width:"45%"
			});
			
			$("#user_add_submit").bind("click",function (){
				if($("#user_add_ff").form('validate')){
					$.post("${pageContext.request.contextPath }/addUser.do",$("#user_add_ff").serialize(),function(result){
						if(result.success){
							$.messager.show({
								title:'温馨提示',
								msg:result.msg,
								timeout:1000
							});
							$('#user_add_ff').form('clear');
							$("#user_add_dlg").dialog("close");
							$('#user_list').datagrid('load',{});
						}else{
							$.messager.show({
								title:'温馨提示',
								msg:result.msg,
								timeout:1000
							});
						}
					});
				}
			});
			
			$("#user_add_reset").bind("click",function (){
				$('#user_add_ff').form('clear');
			});
			
			$("[name='urids']").combotree({
				url:"${pageContext.request.contextPath }/power/getRolesListByPower.do",
				method:"get",
				width:"80%",
				multiple:true
			});
			
			$("[name='uurids']").combotree({
				url:"${pageContext.request.contextPath }/power/getRolesListByPower.do",
				method:"get",
				width:"80%",
				multiple:true
			});
			
			$("[name='nickName']").textbox({
				width:"80%",
				required:true
			});
			$("[name='uuserId']").textbox({
				width:"80%"
			});
			$("[name='unickName']").textbox({
				width:"80%",
				required:true
			});
			$("[name='userName']").textbox({
				width:"80%",
				required:true
			});
			$("[name='phone']").numberbox({
				width:"80%"
			});
			$("[name='uphone']").numberbox({
				width:"80%"
			});
			$("[name='password']").textbox({
				width:"80%",
				required:true
			});
			
		});
		
		function updateUser(userId,nickName,phone){
			$("#user_update_dlg").dialog({
				title:"修改用户",
				modal:true
			});
			$("#user_update_ff").form("clear");
			$("#unickName").textbox('setValue', nickName);
			$("#uphone").textbox('setValue', phone);
			$("#uuserId").textbox('setValue',userId);
			$("#uurids").combotree("reload","${pageContext.request.contextPath }/power/getRolesListByPower.do?userId="+userId);//重新加载
			$("#user_update_dlg").dialog("open");
		}
		
		$("#user_update_submit").bind("click",function (){
			if(confirm("确定执行该操作吗？")){
				$.post("${pageContext.request.contextPath }/updateUser.do",$("#user_update_ff").serialize(),function(result){
					if(result.success){
						$.messager.show({
							title:'温馨提示',
							msg:result.msg,
							timeout:1000
						});
						$("#user_update_dlg").dialog("close");
						$('#user_list').datagrid('load',{});
					}else{
						$.messager.show({
							title:'温馨提示',
							msg:result.msg,
							timeout:1000
						});
					}
				});
			}
		});
		
		function updateState(userId,state){
			if(confirm("确定执行该操作吗？")){
				$.post("${pageContext.request.contextPath }/updateState.do",{"userId":userId,"state":state},function(result){
					if(result.success){
						$.messager.show({
							title:'温馨提示',
							msg:result.msg,
							timeout:1000
						});
						$('#user_list').datagrid('load',{});
					}else{
						$.messager.show({
							title:'温馨提示',
							msg:result.msg,
							timeout:1000
						});
					}
				});
			}
		}
	</script>
	<table id="user_list"></table>
	
	<div id="user_add_dlg">
		<center>
			<form id="user_add_ff">
				<div class="form-div" style="margin-top: 10px;">
					账号：<input name="userName">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					姓名：<input name="nickName">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					电话：<input name="phone">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					密码：<input name="password">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					类型：<input name="type">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					角色：<input name="urids">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					<a id="user_add_submit">提交</a>
					<a id="user_add_reset">重置</a>
				</div>
			</form>
		</center>
	</div>
	
	<div id="user_update_dlg">
		<center>
			<form id="user_update_ff">
				<input name="uuserId" id="uuserId" type="hidden">
				<div class="form-div" style="margin-top: 10px;">
					姓名：<input name="unickName" id="unickName">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					电话：<input name="uphone" id="uphone">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					角色：<input name="uurids" id="uurids">
				</div>
				<div class="form-div" style="margin-top: 10px;">
					<a id="user_update_submit">提交</a>
					<a id="user_update_reset">重置</a>
				</div>
			</form>
		</center>
	</div>
</body>
</html>