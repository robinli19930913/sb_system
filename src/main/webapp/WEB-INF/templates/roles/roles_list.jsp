<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
	<style type="text/css">
		.form-div {margin-left: 20px; margin-top: 10px;}
	</style>
</head>
<body>
	<script type="text/javascript">
		$().ready(function (){
			$("#roles_list").datagrid({
				url:"<%=request.getContextPath()%>/power/rolesList.do",
				fit:true,
				border:false,
				emptyMsg: '<span>暂无记录，请更换条件重新搜索</span>',
				columns:[[
				          {field:'id',title:'角色ID',width:100}, 
				          {field:'name',title:'角色名称',width:100},
				          {field:'updateTime',title:'更新时间',width:100,
				        	  formatter: function(value,row,index){
				        		  return getDateFormat(value);
				  			  }  
				          }, 
				          {field:'level',title:'角色级别',width:100,
				        	  formatter: function(value,row,index){
								   if(value==1){
									   return "超级管理";
								   }else if(value==2){
									   return "代理商"
								   }else{
									   return "其他";
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
					text:'添加角色',
					handler: function(){
						$("#roles_add_dlg").dialog({
							title:"添加角色",
							modal:true,
							closed:true
						});
						$("#roles_add_ff").form("clear");
						$("#roles_add_dlg").dialog("open");
					}
				}],
				singleSelect:true
			});
			
			
		});
		
		
	</script>
	<table id="roles_list"></table>
	
	<div id="role_add_dlg">
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
					<a id="role_add_submit">提交</a>
					<a id="role_add_reset">重置</a>
				</div>
			</form>
		</center>
	</div>
</body>
</html>