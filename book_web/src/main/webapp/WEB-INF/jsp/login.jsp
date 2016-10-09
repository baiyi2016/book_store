<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/7
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title></title>
  <link type="text/css" rel="stylesheet" href="css/style.css" />
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
<div id="login">
  <h2>用户登陆</h2>
  <form method="post" action="" id="userform">
    <dl>
      <dt>用户名：</dt>
      <dd><input class="input-text" type="text" name="username"/><span id="yonghu"></span></dd>
      <dt>密　码：</dt>
      <dd><input class="input-text" type="password" name="password" /><span id="mima"></span></dd>
      <dt></dt>
      <dd class="button"><input class="input-btn" type="button" name="submit" value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='toadd';" /></dd>
    </dl>
  </form>
</div>
<div id="footer" class="wrap">
  合众艾特网上书城 &copy; 版权所有
</div>
<script language="JavaScript">
$(document).ready(function(){
  $(".input-btn").click(function(){
    $.post("getuser",$("#userform").serialize(),function(backData){
      if(backData==true) {
         location.href="${pageContext.request.contextPath}/index";
      }
    })
//    if($(".ptext").val()!=p) {
//        $("#yonghu").html("用户名不正确")
//    }else{
//
//    }
  })
})
</script>
</body>
</html>

