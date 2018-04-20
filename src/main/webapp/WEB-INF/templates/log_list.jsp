<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志管理</title>
	<style type="text/css">
		.form-div {margin-left: 20px; margin-top: 10px;}
	</style>
</head>
<body>
	<script type="text/javascript">
		$().ready(function (){
			$("#log_list").datagrid({
				url:"<%=request.getContextPath()%>/log/list.do",
				pagination:true,
				pageList:[20,50,100,300],
				pageSize:20,
				fit:true,
				border:false,
				toolbar:'#log_tb',
				emptyMsg: '<span>暂无记录，请更换条件重新搜索</span>',
				columns:[[
				          {field:'id',title:'编号',width:100}, 
				          {field:'url',title:'接口路径',width:100}, 
				          {field:'ip',title:'操作IP',width:100}, 
				          {field:'operationName',title:'操作账号',width:100},
				          {field:'method',title:'执行方法',width:100},
				          {field:'costtime',title:'执行时间',width:100},
				          {field:'createTime',title:'操作时间',width:100,
				        	  formatter: function(value,row,index){
				        		 return getDateFormat(value);
				  			  }
				          }
				]],
				onLoadSuccess: function(result) {
					$("#startTime").datebox('setValue', result.data.startTime);	
					$("#endTime").datebox('setValue', result.data.endTime);
	             },
				fitColumns:true,
				singleSelect:true
			});
			
			$("[name='startTime']").textbox({
				width:"220px"
			});
			$("[name='endTime']").textbox({
				width:"220px"
			});
			
			//清空
			$("#qk").click(function () {
				$("#logForm").form("clear");
				$('#log_list').datagrid('load',{});
			});
			
			//搜索
			$("#ss").click(function () {
				var startTime = $("[name='startTime']").val();
				var endTime = $("[name='endTime']").val();
				
				$('#log_list').datagrid('load',{
					startTime: startTime,
					endTime: endTime
				});
			});
			
		});
		
		
	</script>
	<table id="log_list"></table>
	<div id="log_tb" style="padding:2px 5px;">
		<form id="logForm" method="post">
			操作时间 从: <input name="startTime" id="startTime" class="easyui-datebox" style="width:110px">
			到: <input name="endTime" id="endTime" class="easyui-datebox" style="width:110px">
			<a href="#" id="qk" class="easyui-linkbutton" iconCls="icon-clear">清空</a>
			<a href="#" id="ss" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		</form>
	</div>
</body>
</html>