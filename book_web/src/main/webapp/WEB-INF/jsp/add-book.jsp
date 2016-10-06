<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/6
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书增加页面</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
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
    <h2>欢迎增加合众艾特网上图书</h2>
  </div>
  <div class="steps">
    <ul class="clearfix">
      <li class="current">1.填写图书信息</li>
      <li class="unpass">2.增加成功</li>
    </ul>
  </div>
  <form method="post" action="addBook">
    <dl>
      <dt>图 书 名：</dt>
      <dd><input class="input-text" type="text" name="bookName" /><span>图书名必填</span></dd>
      <dt>仓库数量：</dt>
      <dd><input class="input-text" type="number" name="bookStorage" /><span>仓库数量必填</span></dd>
      <dt>图书价格：</dt>
      <dd><input class="input-text" type="number" name="bookPrice" /><span>图书价格必填</span></dd>
      <dt>图片预览：</dt>
      <dd><input class="input-text" type="text" name="bookImgUrl" /><span>图片地址必填</span></dd>
      <dt></dt>
      <dd class="button"><input class="input-reg" type="submit" name="register" value="" /></dd>
    </dl>
  </form>
</div>
<div id="footer" class="wrap">
  合众艾特网上书城 &copy; 版权所有

</div>
</body>
</html>
