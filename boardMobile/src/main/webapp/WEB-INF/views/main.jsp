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

				$.each(list, function(idx, b) {
					var li = $("<li></li>");
					var a = $("<a href='#detail'></a>");
					var h3Title = $("<h3></h3>").html(b.title);

					var str = b.content;
					if (str.length > 20) {
						str = str.substring(0, 20);
					}

					var pContent = $("<p></p>").html(str + "...");
					var pWriter = $("<p class='ui-li-aside'></p>").html(
							b.writer);
				
					$(a).append(h3Title, pContent, pWriter);
					$(li).append(a);
					$("#list").append(li);

					$(a).attr("idx", idx);
					$(a).click(function() {
						i = $(this).attr("idx");
						var selB = list[i];
						$("#content").html(selB.content);
					});

				});
				$("#list").listview("refresh");
			}

		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div data-role="page" id="mainPage">
		<div data-role="header">
			<h1>게시판</h1>
		</div>

		<div data-role="content">
			<ul data-role="listview" data-insert="true" id="list">
				<li data-role="list-divider">Monday, July 16, 2018<span
					class="ui-li-count"></span></li>
			</ul>
		</div>

		<div data-role="footer" data-position="fixed">성인이 게시판</div>
	</div>


	<div data-role="page" id="detail">
		<div data-role="header">
			<h1>게시물 상세</h1>
			<a href="#" data-role="button" data-rel="back" data-icon="arrow-l">이전</a>
		</div>

		<div data-role="content">
			<p id="content">
		</div>

		<div data-role="footer" data-position="fixed">성인이 게시판</div>
	</div>
</body>
</html>