<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="listBook.do" method="post">
		이름 : <input type="text" name="name"> <input type="submit"
			value="검색">
	</form>

	<table>
		<tr>
			<td>도서명</td>
			<td>출판사</td>
			<td>도사가격</td>
			<td>판매이익금</td>
			<td>주문일</td>
			<td>주소</td>
			<td>전화</td>
		</tr>
		<c:if test="${not empty list }">
		<c:forEach items="${list}" var="o">
			<tr>
				<td>${o.bookname }</td>
				<td>${o.publisher }</td>
				<td>${o.price }</td>
				<td>${o.saleprice}-${price}</td>
				<td>${o.orderdate }</td>
				<td>${o.address }</td>
				<td>${o.phone }</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</body>
</html>