<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=11,IE=10,IE=9,IE=8">
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=0.3; maximum-scale=0.5"/>
<!-- 倒计时五秒 -->
<%-- <meta http-equiv="refresh" content="3;${pageContext.request.contextPath }/"> --%>
<title>错误提示页面</title>
<link rel="icon" href="img/mobo.ico" type="img/x-ico">

<link rel="apple-touch-icon-precomposed" href="http://static.html580.com/assets/images/favicon.ico">
<link href="http://static.html580.com/themes/html580/css/error.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
      var app = {};
	  app.debug = false;
	  app.base = 'http://static.html580.com/assets/libs/';
    </script>
</head>
<body>
<div style="left: 0px;" id="rocket"><span style="margin-left: -8px; left: 50px; bottom: 78px;" class="steam1"></span></div>
<hgroup>
<h1>页面出错。。。请先登录</h1>
<a href="${pageContext.request.contextPath }/">直接点击登录</a>或稍等<span style="color: red;" id="secondSpan">3</span>秒
</hgroup>
<script src="http://static.html580.com/assets/libs/seajs/seajs/3.0.0/sea.js"></script>
<script src="http://static.html580.com/assets/libs/seajs/seajs/3.0.0/seajs-css.js"></script>
<script src="http://static.html580.com/assets/libs/seajs-config.js"></script>
<script>
	seajs.use("http://static.html580.com/themes/html580/js/error.js");
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
<script type="text/javascript">  
$(function() {
	//设定倒数秒数  
	var second = 3;  
	//显示倒数秒数  
	function showTime(){
		if (second == -1) {
			second = 3;
		} else { 
			$("#secondSpan").html(second);
			second--; 
		} 
		setTimeout(function() { 
			showTime() 
		},1000)
	}  
	showTime();
});
</script >  
</body>
</html>