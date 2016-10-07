
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

	<script src="${pageContext.request.contextPath}/js/jquery-3.0.0.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">合众艾特网上书城</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li class="current"><a href="${pageContext.request.contextPath}/index">User首页</a></li>
				<li><a href="orderlist.html">我的订单</a></li>
				<li><a href="${pageContext.request.contextPath}/toshopingCart">购物车</a></li>
				<li><a href="${pageContext.request.contextPath}/loginout">注销</a></li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" id="shoping_cart" action="${pageContext.request.contextPath}/shopingCart">
			<table>
				<tr class="title">
					<th class="checker"></th>
					<th>书名</th>
					<th class="price">价格</th>
					<th class="store">库存</th>
					<th class="view">图片预览</th>
				</tr>

				<c:forEach var="book" items="${requestScope.bookList}" varStatus="vs">
					<c:choose>
						<c:when test="${vs.count%2==1}">
							<tr>
								<td><input type="checkbox" name="bookId" class="book-id" value="${book.bookId}" /></td>
								<td class="title">${book.bookName}</td>
								<td>￥${book.bookPrice}</td>
								<td>${book.bookStorage}</td>
								<td class="thumb"><img src="${pageContext.request.contextPath}/images/book/book_01.gif" /></td>
							</tr>
						</c:when>
						<c:when test="${vs.count%2==0}">
							<tr class="odd">
								<td><input type="checkbox" name="bookId" class="book-id" value="${book.bookId}" /></td>
								<td class="title">${book.bookName}</td>
								<td>￥${book.bookPrice}</td>
								<td>${book.bookStorage}</td>
								<td class="thumb"><img src="${pageContext.request.contextPath}/images/book/book_01.gif" /></td>
							</tr>
						</c:when>

					</c:choose>

				</c:forEach>

				<tr>
					<td colspan="5" class="page-spliter"><a href="toaddBook">增加图书</a></td>
				</tr>
			</table>
			<div class="page-spliter">
				<a href="${pageContext.request.contextPath}/index?currentPage=${currentPage-1}">&lt;</a>
				<a href="${pageContext.request.contextPath}/index?currentPage=0">首页</a>
				<c:forEach begin="0" end="${requestScope.totalPages-1}" var="currentPage">
					<a href="${pageContext.request.contextPath}/index?currentPage=${currentPage}">${currentPage+1}</a>
				</c:forEach>
				<%--<span class="current">1</span>--%>
				<%--<a href="#">2</a>--%>
				<%--<a href="#">3</a>--%>
				<%--<a href="#">4</a>--%>

				<span>...</span>
				<a href="${pageContext.request.contextPath}/index?currentPage=${requestScope.totalPages-1}">尾页</a>
				<a href="${pageContext.request.contextPath}/index?currentPage=${currentPage+1}">&gt;</a>
			</div>
			<div class="button"><input class="input-btn" id="input_btn" type="submit" name="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	合众艾特网上书城 &copy; 版权所有

</div>


<script>

	$(function() {
	 /*  $("#input_btn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/shopingCart",
//				data: $("#shoping_cart").serialize(),
				data: {"bookId":$(".book-id").val()},
				type:"POST",
				success:function(backData){
					console.info($(".book-id").val());
					if(backData==true) {
						alert("添加成功");
					}
				}
			})
		})*/
	})
</script>

</body>
</html>
