<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<script type="text/javascript">
	$(function(){
		
		var arr
		$.ajax({url:"listBoard.do",success:function(data){
			arr = eval("("+data+")");
			$.each(arr, function(idx, b){
				var tr = $("<tr></tr>");
														
				$("<td></td>").html(b.no).appendTo(tr);
				$("<td></td>").html(b.title).appendTo(tr);
				$("<td></td>").html(b.writer).appendTo(tr);
				$("<td></td>").html(b.content).appendTo(tr);
				$("<td></td>").html(b.hit).appendTo(tr);
				
				$(tr).append(a);
				$("#tb").append(tr);
			});
			
			$("#list").listview("refresh");
		}});
	});
</script>
<body>
<table id="tb">
</table>
</body>
</html>