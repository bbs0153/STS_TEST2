<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.btn {
	display: inline-block;
}
</style>




<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="btn" id="prev">
		<a href="listGoods.do">Prev</a>
	</div>
	<c:forEach items="${list}" var="g">
		<div class="btn" id="">
			<table>
				<tr><td><input type="checkbox" name="no">${g.no}</td></tr>
				<tr><td><img src="resources/img/${g.fname}" width="100" height="100"></td></tr>
				<tr><td>상품이름:${g.item }</td></tr>
				<tr><td>가격:${g.price }</td></tr>
				<tr><td>수량:${g.qty }</td></tr>
			</table>
		</div>
	</c:forEach>
	<div class="btn" id="next">
		<a href="listGoods.do">Next</a>
	</div>

	<div id="order">
		<span>총금액</span>
	</div>
</body>
</html>