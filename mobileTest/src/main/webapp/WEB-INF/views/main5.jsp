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



	function saveLocal() {

		if (window.localStorage) {

			var v = document.querySelector("#lv").value;
			window.localStorage.setItem("lv", v);
		}

	}
	function readLocal() {

		if (window.localStorage) {

			var v = window.localStorage.getItem("lv");
			document.querySelector("#span_lv").innerHTML = v;
		}

	}
	function saveSession() {

		if (window.sessionStorage) {

			var v = document.querySelector("#sv").value;
			window.sessionStorage.setItem("sv", v);
		}

	}
	function readSession() {

		if (window.sessionStorage) {

			var v = window.sessionStorage.getItem("sv");
			document.querySelector("#span_sv").innerHTML = v;
		}

	}
</script>

</head>
<body>
<h3>Local Storage Test</h3>
<input type="text" id="lv">
<button onclick="saveLocal()">저장</button>
<br>
<span id="span_lv"></span>
<button onclick="readLocal()">읽기</button>

<hr>

<h3>Session Storage Test</h3>
<input type="text" id="sv">
<button onclick="saveSession()">저장</button>
<br>
<span id="span_sv"></span>
<button onclick="readSession()">읽기</button>

</body>
</html>