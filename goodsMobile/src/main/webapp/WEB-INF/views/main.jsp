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
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
$(function() {
   var list;
   $.ajax({
      url: "listGoods.do",
      success: function(data) {
         list = eval("("+data+")");
         $.each(list, function(idx, g) {
            var li = $("<li></li>");
            
            var a = $("<a href='#detailView'></a>");
            $(a).attr("idx",idx);
            
            $(a).click(function(){
               i = $(this).attr("idx");
               var selG = list[i];
               $("#detailImg").attr("src", "resources/img/"+ selG.fname);
               $("#detailItem").html(selG.item);
               $("#detailPrice").html(selG.price);
               $("#detailQty").html(selG.qty);
            });
            
            
            var img = $("<img></img>").attr({
               src: "resources/img/"+g.fname,
               width: "100"
            });
            
            
            var span = $("<span></span>").html(g.item);
            
            $("#list").append(li);
            $(li).append(a);
            $(a).append(img, span);
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
		<div data-role="header">상품목록</div>
		<div data-role="content">
			<ul data-role="listview" id="list">
			<li><a href="#"><img width="100" height="100" src="resources/ICONS/ball1.jpg"></a></li>
			<li><a href="#"><img width="100" height="100" src="resources/ICONS/cloth.jpg"></a></li>
			<li><a href="#"><img width="100" height="100" src="resources/ICONS/uj.jpg"></a></li>
			</ul>
		</div>
		<div data-role="footer">성인이몰</div>
	</div>
</body>
</html>