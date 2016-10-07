<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">合众艾特网上书城</div>
	<div id="navbar">
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="register">
	<div class="title">
		<h2>欢迎注册合众艾特网上书城</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="current">1.填写注册信息</li>
			<li class="unpass">2.注册成功</li>
		</ul>
	</div>
	<form method="post">
		<dl>
			<dt>用 户 名：</dt>
			<dd><input class="input-text" type="text" name="userName" /><span id="name">当前用户已存在！</span></dd>
			<dt>密　　码：</dt>
			<dd><input class="input-text" type="password" name="passWord" /><span id="password">密码过于简单！</span></dd>
			<dt>确认密码：</dt>
			<dd><input class="input-text" type="password" name="rePassWord" /><span id="pwdd">两次密码输入不一致！</span></dd>
			<dt>Email地址：</dt>
			<dd><input class="input-text" type="text" name="email" /><span id="email">邮箱输入不正确！</span></dd>
			<dt></dt>
			<dd class="button"><input class="input-reg" type="submit" name="register" value="" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	合众艾特网上书城 &copy; 版权所有

</div>
<script>
	$(document).ready(function(){
		$(".input-reg").click(function(){
			$.post("adduser",{username:name.val(),password:password.val(),email:email.val()},function(date){
               if(name==null){
				   alert("名字不能为空")
			   }if(password==null){
				   alert("密码不能为空")
			   }if(pwdd!=password){
					alert("两次输入的密码不一致")
				}if(email==null){
					alert("邮箱不能为空")
				}else{
					return "register_success.html";
				}
			})
		})
	})
</script>
</body>
</html>
