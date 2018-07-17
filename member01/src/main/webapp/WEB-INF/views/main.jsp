<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html manifest="resources/conf/bit.manifest">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="with=device-width,
initial-scale=1.0,
maximum-scale=1.0,
minimum-scale=1.0,
user-scalable=no">
<link rel="shortcut-touch-icon" href="resources/img/bit.png">
<link rel="apple-touch-icon" href="resources/img/bit.png">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#add").click(function() {

			data = $("#joinForm").serializeArray();
			$.ajax({
				url : "insertMember.do",
				data : data,
				success : function(data) {
					var list = eval("(" + data + ")");
						alert(list);
				}
			});

		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>회원 등록</h1>
		</div>
		<div data-role="content">
			<form id="joinForm" method="post" action="#">
				<div data-role="fieldcontain">
					<label for="age">Age</label> <input id="age" type="text" name="age">
				</div>

				<div data-role="fieldcontain">
					<label for="email">Email</label> <input id="email" type="text"
						name="email">
				</div>

				<div data-role="fieldcontain">
					<label for="url">URL</label> <input id="url" type="text" name="url">
				</div>

				<div data-role="fieldcontain">
					<label for="tel">Tel</label> <input id="tel" type="text" name="tel">
				</div>

			</form>
				<a href="#" id="add">등록</a>
		</div>
	</div>
</body>
</html>