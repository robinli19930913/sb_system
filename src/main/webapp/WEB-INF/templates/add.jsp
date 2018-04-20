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
    <form class="menu_add_form">
        <div class="easyui-panel" style="padding:30px 60px;">
            <div class="input_container">
                <input class="easyui-textbox" label="用户名：" labelPosition="top" data-options="prompt:'请输入用户名',iconCls:'icon-man'" style="width:100%;height:52px">
            </div>
            <div class="input_container">
                <input class="easyui-textbox" label="密码：" labelPosition="top" data-options="prompt:'请输入密码',iconCls:'icon-lock'" style="width:100%;height:52px">
            </div>
            <div class="input_container">
                <input class="easyui-textbox" label="邮箱：" labelPosition="top" data-options="prompt:'请输入邮箱',validType:'email'" style="width:100%;height:52px">
            </div>
            <div class="input_container">
                <input class="easyui-textbox" label="个人简介：" labelPosition="top" multiline="true" style="width:100%;height:120px">
            </div>
            <div>
            	<center>
                	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:50%;height:32px">注册</a>
            	</center>
            </div>
        </div>
    </form>
  </body>
</html>