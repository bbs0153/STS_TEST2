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

</script>
<title>Insert title here</title>
</head>
<body>
<div data-role="page">
   <div data-role="header">
      <h1>Collapsible Block</h1>
   </div>
   
   <div data-role="content">
      <div data-role="collapsible">
         <h3>I'm a header</h3>
         <p>I'm the collapsible content, By default I'm closed,
         but you can click the header to open me</p>
      </div>
      
      <div data-role="collapsible-set">
         <div data-role="colapsible">
            <h3>Collapsible</h3>
            <p>Collapsible Content Block</p>
         </div>
         
         <div data-role="collapsible" data-collapsed="false">
            <h3>Collapsible2</h3>
            <p>Collapsible Content Block2</p>
         </div>
         
         <div data-role="collapsible">가 있습니다.
            <h3>Collapsible3</h3>
            <p>Collapsible Content Block3</p>
         </div>
         
      </div>
   </div>
   <div data-role="footer">
      비트캠프
   </div>
</div>
</body>
</html>