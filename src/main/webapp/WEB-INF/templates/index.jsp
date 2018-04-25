<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<title>管理系统</title>
	<link rel="icon" href="${pageContext.request.contextPath }/img/favicon.ico" type="img/x-ico">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/ztree/css/metroStyle/metroStyle.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/wu.css" />

	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ztree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/menu.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/formatter.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/echarts/js/echarts-all-3.js"></script>
	<script type="text/javascript">
	//点击左侧菜单给右边打开页面并显示内容
	function addTab(name,url){
		if (url != null && url != '') {
	    	var a = $('#tt').tabs('exists',name);
			if (!a) {
				$('#tt').tabs('add',{
					cache:false,
					title: name,
					closable: true,
					href:url
				});
			}else{
				$('#tt').tabs('select',name);
			}
		}
	}
	
	/*菜单初始化*/
	$(function () {
		//动态添加左侧菜单栏
		$("#nav_dot").html(<%=request.getAttribute("menu")%>);
		//navList(<%=request.getAttribute("length")%>);
		navList(12);//菜单展示数量
	});
	</script>
</head>
<body class="easyui-layout">

	<!--头部栏 -->
	<div class="wu-header"  data-options="region:'north',border:false,split:false" style="height:71px">
		<div class="wu-header-left" style="margin-top: 13px;">
			 <img alt="" src="${pageContext.request.contextPath }/img/logo.png" height="48px" width="113px"/>
			 <span style="font-size: 24px;margin-left: -21px;position: relative;top: -15px;color: white;">管理系统</span>
		</div>
		<div class="wu-header-right" style="margin-top: 12px;">
            <p></p >
            <p><strong class="easyui-tooltip">${user.nickName}</strong>，欢迎您！ <a href="${pageContext.request.contextPath }/layout.do" style="color: #5BD1F8;">[注销]</a></p >
            <p style="margin-top: 11px;">
	            <div id="time">  
	              <!--   当前时间：  --> 
	                <script>  
	                document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());  
	                setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);  
	                </script>  
	            </div>
            </p>
        </div>
	</div>
	
	<!-- 左菜单 -->
	<div data-options="region:'west',split:false,border:false"
		style="width: 180px; padding-left: 5px; padding-top: 10px;">
		<div class="left_menu">
			<ul id="nav_dot">
				<li>
					<h4 class="M1"><span></span>权限管理</h4>
					<div class="list-item none">
						<a href="#" onclick="addTab('日志管理','/system/log/tolist.do')">日志管理</a>
						<a href="#" onclick="addTab('添加菜单','/system/power/toMenuAdd.do')">添加菜单</a>
						<a href="#" onclick="addTab('菜单管理','/system/power/toMenuList.do')">菜单管理</a>
						<a href="#" onclick="addTab('角色管理','/system/roles/tolist.do')">角色管理</a>
						<a href="#" onclick="addTab('账号管理','/system/tolist.do')">账号管理</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
	
	<!-- 内容 -->
	<div data-options="region:'center',border:false">
		<div id="tt" class="easyui-tabs" style="width: 700px; height: 250px;"
			data-options="fit:true,border:false">
			<div title="管理系统" style="padding: 10px">
				<div style="margin-top: 150px" align="center">
					<h1>欢迎进入后台系统</h1>
				</div>
			</div>

		</div>

	</div>
</body>
</html>