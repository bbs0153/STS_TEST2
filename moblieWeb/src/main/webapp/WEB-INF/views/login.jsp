<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
      content="width=device-width,
      initial-scale=1.0,
      maximum-scale=1.0,
      minimum-scale=1.0,
      user-scalable=no">

<link rel="shortcut icon" href="resources/img/bit.png">
<link rel="apple-touch-icon" href="resources/img/bit.png">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
	<div data-role="page" id="loginResult">
      <div data-role="header">
      	<h2>로그인 결과</h2>
      </div>
      <div data-role="content">
      	<p>
      	<%= session.getAttribute("msg") %>
      	</p>
      
      	<c:if test="${not empty id }">      		
	      	
	      	<a href="main.html#main" data-role="button">앱 홈</a>
      	</c:if>
      	
      	<c:if test="${empty id }">
      		<a href="main.html#login" data-role="button">로그인 홈</a>
	      	<a href="main.html#main" data-role="button">앱 홈</a>      		
      	</c:if>
      </div>
      <div data-role="footer"></div>
   </div>
</body>
</html>