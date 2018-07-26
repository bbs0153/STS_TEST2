<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		$.ajax({
			url : "listGoods.do",
			success : function(data) {
				list = eval("(" + data + ")");
				$.each(list, function(idx, g) {

					var h3 = $("<h3></h3>").html(g.item);
					var p1 = $("<p></p>").html(g.no);
					var p2 = $("<p></p>").html(g.price);
					var p3 = $("<p></p>").html(g.qty);

					$("#list").append(h3, p1, p2, p3);
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
		<div data-role="header">
			<h1>상품목록</h1>
		</div>

		<div data-role="content">
			<div data-role="collapsible" id="list">
			</div>
		</div>
	</div>
</body>
</html>