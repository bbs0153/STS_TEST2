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
	$(function () {
		var arr;
		$.ajax({url:"listGoods.do", success:function(data){
			arr = eval("("+data+")");
			$.each(arr, function(idx, g) {
				var li = $('<li></li>');
				var a = $('<a href="#goodsDetail"></a>');
				var img = $('<img></img>').attr({
					src: "resources/img/" + g.fname,
					width: "50",
					height: "50"
				})
				var item = $('<span></span>').html(g.item);
				$(a).append(img, item);
				$(li).append(a);
				$('#goodsList').append(li);
			})
		}})
	})
</script>
</head>
<body>
	<div data-role="page" id="main">
      <div data-role="header"></div>
      <div data-role="content">
        아이디 : ${id }
      	<c:if test="${not empty id }">
      		<a href="logout.jsp" data-role="button">로그아웃</a>
      	</c:if>
      	
      	<c:if test="${empty id }">
      		<a href="#login" data-role="button">로그인</a>
      	</c:if>       
         <a href="#list" data-role="button">상품목록</a>
      </div>
      <div data-role="footer"></div>
   </div>   
   
   <div data-role="page" id="login">
      <div data-role="header">
      
      </div>
      <div data-role="content">
         <form action="login.do" method="post">
            <div data-role="fieldcontain">
               <label for="id">아이디</label>
               <input type="text" name="id" id="id">
            </div>
            <div data-role="fieldcontain">
               <label for="pwd">암호</label>
               <input type="password" name="pwd" id="pwd">
            </div>
            
            <input type="submit" value="로그인">
            <input type="reset" value="취소">
            
         </form>
      </div>
      <div data-role="footer"></div>
   </div>
   <div data-role="page" id="list">
      <div data-role="header"></div>
      <div data-role="content">
      	<ul data-role="listview" id="goodsList">
      	
      	</ul>
      </div>
      <div data-role="footer"></div>
   </div>	
</body>
</html>