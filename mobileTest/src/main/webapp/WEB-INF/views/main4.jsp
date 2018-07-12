<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<title>Insert title here</title>
<script type="text/javascript">

	function func1() {
		var fd = document.querySelector("#firstDiv");
		fd.innerHTML = "내용을 바꾸었어요";
	}
	function func2() {
		var arr = document.querySelectorAll("#secondDiv input:checked");
		console.log(arr.length);
		for (var i = 0; i < arr.length; i++) {
			console.log(arr[i].value);
		}
	}
</script>

</head>
<body>
<div id="firstDiv" style="background-color: #ffff00">DIV 내용</div>
	<form action="secondDiv">
		<input type="checkbox" name="framnework" value="jquerymobile">
		Jquery Mobile<br>
		
		<input type="checkbox" name="framnework" value="jquerymobile1">
		Sencha<br>
		
		<input type="checkbox" name="framnework" value="jquerymobile2">
		Sencha Touch1<br>	
	</form>
	<button onclick="func1()">div 찾기</button>
	<button onclick="func2()">check 찾기</button>
</body>
</html>