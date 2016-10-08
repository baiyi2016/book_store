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
				<li><a href="${pageContext.request.contextPath}/index">User首页</a></li>
				<li><a href="${pageContext.request.contextPath}/orderList">我的订单</a></li>
				<li class="current"><a href="${pageContext.request.contextPath}/toshopingCart">购物车</a></li>
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
		<form method="post" name="shoping" action="${pageContext.request.contextPath}/addOrder">
			<table>
				<tr class="title">
					<th class="view">图片预览</th>
					<th>书名</th>
					<th class="nums">数量</th>
					<th class="price">价格</th>
					<th class="price">小计</th>
					<th class="price">操作</th>
				</tr>

				<c:forEach items="${sessionScope.map}" var="map" varStatus="vs">
					<tr>
						<td class="thumb"><img src="images/book/book_01.gif" /></td>
						<td class="title">${map.value.book.bookName}</td>
						<td><input  class="input-text" id="shoping_count${vs.count}" bookId="${map.value.book.bookId}" type="number" name="shopingCount" value="${map.value.shopingCount}"/></td>
						<td>￥<span id="book_price${vs.count}">${map.value.book.bookPrice}</span></td>
						<td>￥<span id="one_total_count${vs.count}">${map.value.book.bookPrice}</span></td>
						<td><a href="${pageContext.request.contextPath}/deleteShopingCart?bookId=${map.value.book.bookId}">删除</a></td>
					</tr>
				</c:forEach>


				<%--<tr class="odd">--%>
					<%--<td class="thumb"><img src="images/book/book_02.gif" /></td>--%>
					<%--<td class="title">痕记</td>--%>
					<%--<td><input class="input-text" type="text" name="nums" value="1" /></td>--%>
					<%--<td>￥<span>22.80</span></td>--%>
				<%--</tr>--%>
				<%--<tr>--%>
					<%--<td class="thumb"><img src="images/book/book_03.gif" /></td>--%>
					<%--<td class="title">天堂之旅</td>--%>
					<%--<td><input class="input-text" type="text" name="nums" value="1" /></td>--%>
					<%--<td>￥<span>25.00</span></td>--%>
				<%--</tr>--%>

			</table>
			<div class="button">
				<h4>总价：￥<span id="total_price">0</span>元</h4>
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	合众艾特网上书城 &copy; 版权所有

</div>


<script type="text/javascript">
	$(function(){

		priceCount();

		$(".input-text").change(function(){
			var bookId = $(this).attr("bookId");
			var shopingCount = $(this).val();
			priceCount();
			$.ajax({
				url:"${pageContext.request.contextPath}/updateCart",
				type:"POST",
				data:{"bookId":bookId,"shopingCount":shopingCount},
				success:function(backData) {

				}
			})
		});

		function priceCount(){
			var totalPrice=0;
			for(var i=1;i<10;i++) {
				var shopingCount = $("#shoping_count"+i).val()*$("#book_price"+i).text();
				if(!isNaN(shopingCount)) {
					totalPrice += $("#shoping_count"+i).val()*$("#book_price"+i).text();
				}else {
					break;
				}
				$("#one_total_count"+i).html(shopingCount);
			}
			$("#total_price").html(totalPrice);
		}
	})



</script>


</body>
</html>
