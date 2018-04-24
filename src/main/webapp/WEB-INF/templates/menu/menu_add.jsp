<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>菜单添加</title>
    <style type="text/css">
        .menu_add_form{
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
				panelHeight:'auto'//适配大小
			});
			$("[name='pid']").combobox({
				url:"${pageContext.request.contextPath }/power/getMenu.do",
				method:"get",
				textField:"name",
				valueField:"id",
				panelHeight:'auto'
			});
			
			$("#powerids").combotree({//这里配置后，下面标签里面就不要在写class 属性，否则会执行两次
				url:"power/getRolesList.do",
				method:"get",
				multiple:true
			});
			
			$("#menuAddBtn").bind("click",function (){
				$.post("${pageContext.request.contextPath }/power/addMenu.do",$("#menu_add_form").serialize(),function(result){
					if(result.success){
						$.messager.show({
							title:'温馨提示',
							msg:result.msg,
							timeout:1000
						});
						$('#menu_add_form').form('clear');
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
    <form class="menu_add_form" id="menu_add_form">
        <div class="easyui-panel" style="padding:30px 60px;" align="center">
			<div class="input_container">
				<input label="父类菜单：" name="pid" id="pid" labelPosition="top" style="width:50%;height:52px;">
			</div>
			<div class="input_container">
				<input class="easyui-textbox" label="菜单名称：" name="name" id="name" labelPosition="top" data-options="prompt:'请输入菜单名称',required:true" style="width:50%;height:52px;">
			</div>
			<div class="input_container">
				<input class="easyui-textbox" label="接口路径：" name="url" id="url" labelPosition="top" data-options="prompt:'接口路径'" style="width:50%;height:52px">
			</div>
			<div class="input_container">
				<input class="easyui-combobox" label="是否启用：" name="del" id="del" labelPosition="top" style="width:50%;height:52px;">
			</div>
			<div class="input_container">
				<input label="角色权限：" name="powerids" id="powerids" labelPosition="top" style="width:50%;height:52px;">
			</div>
			<div style="margin-top: 22px;" align="center">
				<a href="#" class="easyui-linkbutton" id="menuAddBtn" iconCls="icon-ok" style="width:50%;height:32px">确认提交</a>
			</div>
        </div>
    </form>
  </body>
</html>