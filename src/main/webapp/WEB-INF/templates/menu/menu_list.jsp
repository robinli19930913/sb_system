<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
	<style type="text/css">
		.form-div {margin-left: 20px; margin-top: 10px;}
	</style>
</head>
<body>
	<script type="text/javascript">
		$().ready(function (){
			$("#menu_list").datagrid({
				url:"<%=request.getContextPath()%>/power/getMenuList.do",
				fit:true,
				border:false,
				toolbar:'#menu_tb',
				emptyMsg: '<span>暂无记录，请更换条件重新搜索</span>',
				columns:[[
				          {field:'id',title:'菜单ID',width:100}, 
				          {field:'name',title:'菜单名称',width:100}, 
				          {field:'url',title:'菜单路径',width:100}, 
				          {field:'del',title:'菜单状态',width:100,
				        	  formatter: function(value,row,index){
								   if(value==1){
									   return "禁用";
								   }else{
									   return "启用";
								   }
							   }
				          },
				          {field:'caozuo',title:'操作',width:100,
				        	  formatter: function(value,row,index){
				        		  var html = "";
				        		  if(row.del == 1){
				        			  html += "<a href='#' style='color:  #4178BC;' onclick='delMenu("+row.id+",0)'>启用</a>&nbsp;";
				        		  }
				        		  if(row.del == 0){
				        			  html += "<a href='#' style='color:  #4178BC;' onclick='delMenu("+row.id+",1)'>禁用</a>&nbsp;";
				        		  }
				        		  html += "<a href='#' style='color:  #4178BC;' onclick='updateMenu("+row.id+",\""+row.name+"\",\""+row.url+"\")'>修改</a>";
				        		 return html;  
				  			  }
				          }
				]],
				fitColumns:true,
				singleSelect:true
			});
			
			$("[name='menu_del']").combobox({
				valueField: 'value',
				textField: 'label',
				editable:false,//禁止输入
				data: [{
					label: '禁用',
					value: '1'
				},{
					label: '启用',
					value: '0'
				}],
				panelHeight:'auto'
			});
			
			$("[name='menu_name']").combobox({
				url:"${pageContext.request.contextPath }/power/getMenulist.do",
				method:"get",
				textField:"name",
				valueField:"name"
			});
			
			//清空
			$("#qk").click(function () {
				$("#menu_form").form("clear");
				$('#menu_list').datagrid('load',{});
			});
			
			//搜索
			$("#ss").click(function () {
				var name = $("[name='menu_name']").val();
				var del = $("[name='menu_del']").val();
				$('#menu_list').datagrid('load',{
					name: name,
					del: del
				});
			});
			
			$("#menu_update_dlg").dialog({
				width:"300px",
				height:"200px",
				closed:true
			});
			
			$("#menu_update_name").textbox({
				width:"90%"
			});
			$("[name='id']").textbox({
				width:"100%"
			});
			
			$("#menu_update_submit").linkbutton({
				iconCls: "icon-save",
				width:"45%"
			});
			$("#menu_rids").combotree({
				url:"${pageContext.request.contextPath }/power/getRolesListByPower.do",
				method:"get",
				width:"80%",
				multiple:true
			});
		});
		
		//启用禁用
		function delMenu(id,del){
			if(confirm("确定执行该操作吗？")){
				$.post("${pageContext.request.contextPath }/power/delMenu.do",{"id":id,"del":del},function(data){
					$('#menu_list').datagrid('load',{});
				},"json");
			}
		}
		//修改
		function updateMenu(id,name,url){
			$("#menu_update_dlg").dialog({
				title:"修改菜单",
				modal:true
			});
			$("#menu_update_ff").form("clear");
			$("#menu_update_name").textbox('setValue', name);
			$("#menu_update_id").textbox('setValue', id);
			$("#menu_rids").combotree("reload","${pageContext.request.contextPath }/power/getRolesListByPower.do?menuId="+id);//重新加载
			$("#menu_update_dlg").dialog("open");
		}
		
		$("#menu_update_submit").click(function () {
			$.post("${pageContext.request.contextPath }/power/updateMenu.do",$("#menu_update_ff").serialize(),function(result){
				if(result.success){
					$("#menu_update_dlg").dialog("close");
					$('#menu_list').datagrid('load',{});
				}else{
					$.messager.show({
						title:'温馨提示',
						msg:result.msg,
						timeout:1000
					});
				}
			},"json");
		});
	</script>
	<table id="menu_list"></table>
	<div id="menu_tb" style="padding:2px 5px;">
		<form id="menu_form" method="post">
			菜单名称: <input name="menu_name">
			菜单状态: <input name="menu_del">
			<a href="#" id="qk" class="easyui-linkbutton" iconCls="icon-clear">清空</a>
			<a href="#" id="ss" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</form>
	</div>
	<div id="menu_update_dlg">
		<center>
			<form id="menu_update_ff" method="post">
				<input type="hidden" name="id" id="menu_update_id"/>
				<table cellspacing="10">
					<tr>
						<td>菜单名称：<input name="name" id="menu_update_name"></td>
					</tr>
					<tr>
						<td>角色权限：<input name="mrids" id="menu_rids"></td>
					</tr>
					<tr align="center">
						<td><a id="menu_update_submit">保存</a></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
</body>
</html>