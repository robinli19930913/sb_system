<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>角色添加</title>
    <style type="text/css">
        .roles_add_form{
            margin:32px auto;
            width:50%;
        }
        .input_container{
            margin-bottom:30%;
        }
    </style>
  </head>
  <body>
  	<script type="text/javascript">
		$().ready(function (){
			$("[name='del']").combobox({
				valueField: 'value',
				textField: 'label',
				editable:false,//禁止输入
				data: [{
					label: '启用',
					value: '0',
					selected:true//默认选中
				},{
					label: '禁用',
					value: '1'
				}],
				panelHeight:'auto'
			});
			
			$("#powerids").combotree({
				url:"power/getPowerList.do",
				method:"get",
				multiple:true,
				width:"250px"
			});
			
			$("#rolesAddBtn").bind("click",function (){
				$.post("${pageContext.request.contextPath }/power/addMenu.do",$("#roles_add_form").serialize(),function(result){
					if(result.success){
						$.messager.show({
							title:'温馨提示',
							msg:result.msg,
							timeout:1000
						});
						$('#roles_add_form').form('clear');
					}else{
						$.messager.show({
							title:'温馨提示',
							msg:result.msg,
							timeout:1000
						});
					}
				});
			});
		});
  	</script>
    <form class="roles_add_form" id="roles_add_form">
        <div class="easyui-panel" style="padding:30px 60px;">
	        <center>
	            <div class="input_container">
	                <input class="easyui-combobox" label="角色名称：" name="name" id="name" data-options="prompt:'角色名称'" labelPosition="top" style="width:50%;height:52px;">
	            </div>
	            <div class="input_container">
	                <input class="easyui-numberbox" label="角色级别：" name="level" id="level" labelPosition="top" data-options="prompt:'角色级别'" style="width:50%;height:52px">
	            </div>
	            <div class="input_container">
	                <input class="easyui-combobox" label="是否启用：" name="del" id="del" labelPosition="top" style="width:50%;height:52px;">
	            </div>
	            <div class="input_container">
	                <input class="easyui-combotree" label="菜单权限：" name="powerids" id="powerids" labelPosition="top" style="width:50%;height:52px;">
	            </div>
	            <div>
	            	<center style="margin-top: 22px;">
	                	<a href="#" class="easyui-linkbutton" id="rolesAddBtn" iconCls="icon-ok" style="width:50%;height:32px">确认提交</a>
	            	</center>
	            </div>
            </center>
        </div>
    </form>
  </body>
</html>