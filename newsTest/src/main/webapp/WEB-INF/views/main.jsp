<!DOCTYPE html>
<html>
<head>
<title>jQuery Mobile</title>
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
			url : "listNews.do",
			success : function(data) {
				list = eval("(" + data + ")");

				$.each(list ,function(i, n) {
					var li = $("<li></li>")
					var a1 = $("<a href='#detail' data-transition='false'></a>").html(n.title);
					$(li).append(a1);
					$("#list").append(li);
					
					
					$(a1).attr("i",i);			
					$(a1).click(function() {
						
						$("#content").html("");
						
						idx = $(this).attr("i");
						var selN = list[idx];
						
						var h1 = $("<h1></h1>").html(selN.title)
						var p = $("<p></p>").html(selN.content)
						
						$("#content").append(h1,p)
					});
					
					
				});
				
				$("#list").listview("refresh")
			}
		});

	});
</script>
</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h1>News</h1>
		</div>
		<div data-role="content" id="list">
			<ul id="ul">
		
			</ul>
		</div>
	</div>

	<div id="detail" data-role="page" data-add-back-btn="true">
		<div data-role="header">
			<h1>News</h1>
		</div>
		<div data-role="content" id=content>

		</div>
	</div>
</body>
</html>