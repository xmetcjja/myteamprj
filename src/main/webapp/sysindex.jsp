<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base target="mainFrame">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
</head>
<body>
	<div style="font-size:30px;height:60px;font-weight: bolder;border-bottom: 1px solid black;" id="titlediv" align="center">学生管理系统</div>
	<div style="float: left;width:150px;border-right: 1px solid black;" id="leftdiv">
		<dl>
			<dt>学生管理</dt>
			<dd><a href="stuquery">学生查询</a></dd>
			<dd><a href="stutoadd">学生新加</a></dd>
			<dt>班级管理</dt>
			<dd><a href="claquery">班级查询</a></dd>
			<dd><a href="clatoadd">班级新加</a></dd>
		</dl>
	</div>
	<div style="float: left" id="maindiv">
		<iframe id="mainFrame" name="mainFrame" style="width:100%;height: 100%;border: 0px;" src="welcome.jsp"></iframe>
	</div>
	<script type="text/javascript">
		var height = document.documentElement.clientHeight;//得到页面显示部分的高度
		var width = document.documentElement.clientWidth;
		var titlediv = document.getElementById("titlediv");
		var leftdiv = document.getElementById("leftdiv");
		var maindiv = document.getElementById("maindiv")
		var titleheight = titlediv.style.height.slice(0,-2)-'0';//得到标题层的高度，并把单位除去
		var leftwidth = leftdiv.style.width.slice(0,-2) - '0';//得到左边菜单层的宽度，并把单位除去
		leftdiv.style.height = height - titleheight-10 + "px";//设置左边菜单层的高度，此高度要减去上边标题层的高度
		maindiv.style.width = width - leftwidth - 30 + "px";//设置右边显示层的宽度，此宽度要减去左边菜单层的宽度
		maindiv.style.height = height - titleheight - 30 + "px";
	</script>
</body>
</html>