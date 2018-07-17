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
		var list;
		$.ajax({
			url : "listBoard.do",
			success : function(data) {
				list = eval("(" + data + ")");

				$.each(list, function(i, b) {
					var li = $("<li></li>");

					var a = $("<a href='#'></a>")
					var spanTitle = $("<span></span>").html(b.title);
					var spanWriter = $("<span class='ui-li-count'></span>")
							.html(b.writer);

					$(a).append(spanTitle, spanWriter);
					$(li).append(a);
					$("#list").append(li);
				});
				$("#list").listview("refresh");
			}

		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div data-role="page">
		<div data-role="header">게시물 목록</div>
		<div data-role="content">
			<ul data-role="listview" id="list">
				<li data-role="list-driver">Title<span class="ui-li-conut">Writer</span></li>
			</ul>
		</div>
		<div data-role="footer">성인이 게시판</div>
	</div>
</body>
</html>