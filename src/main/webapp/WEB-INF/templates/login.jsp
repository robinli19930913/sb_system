<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<title>登录页面</title>
	<link rel="icon" href="${pageContext.request.contextPath }/img/favicon.ico" type="img/x-ico">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/gray/dialog.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/supersized.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/style.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/supersized.3.2.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/supersized-init.js"></script>
</head>
<body>
<div class="page-container" style="width:400px;padding:50px 60px;margin-top: 100px" align="center">
<h1>登录页面</h1>
<form id="login_form" method="post">
	<div style="margin-bottom:20px">
		<input type="text" id="username" name="username" class="username" placeholder="请输入账号" style="width:90%;height:34px;padding:10px;">
	</div>
	<div style="margin-bottom:20px">
		<input type="password" id="password" name="password" class="password" placeholder="请输入密码" style="width:90%;height:34px;padding:10px">
	</div>
</form>
<div>
	<div>
		<button type="submit" id="login">登	录</button>
	</div>
</div>
</div>

<script type="text/javascript">
	$(function () {
		$('#login').click(function () {
			$.messager.progress({text:"正在登录..."});
			var username = $("#username").val();
			var password = $("#password").val();
			$.post("${pageContext.request.contextPath }/login.do",{username:username,password:password},function (result){
				if(result.success){
					location.href="${pageContext.request.contextPath }/index.do";
				}else{
					$.messager.progress('close');
					$.messager.show({
						title:'温馨提示',
						msg:result.msg,
						showType:'show'
					});
					$("#login_form").form("clear");
				}
			},"json");
		});
	});
</script>
</body>
</html>