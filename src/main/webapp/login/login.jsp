<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/signin.css" rel="stylesheet">

<%@include file="/common/jquery.jsp"%>
<script>
	function getCookie(name) {
		var cookies = document.cookie;

		var cookieArr = cookies.split("; ");
		var cookieResult = "";

		for ( var i in cookieArr) {
			var cookie = cookieArr[i];
			var cookieNameValue = cookie.split("=");

			var cookieName = cookieNameValue[0];
			var cookieValue = cookieNameValue[1];

			if (name == cookieName) {
				cookieResult = cookieValue;
				break;
			}
		}

		return cookieResult;

	}
	
	function setcookie(cookieName, cookieValue, expires){
		var dt = new Date();
		dt.setDate(dt.getDate() + parseInt(expires));
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + dt.toGMTString();
	}

	// 쿠키 삭제
	function deleteCookie(cookieName){
		setcookie(cookieName, "", -1);
	}
	// 문서 로딩 완료후 실행
	$(function() {

		if (getCookie("rememberMe") == "y") {
			//std_id input에 std_id cookie 값을 설정
			$("#std_id").val(getCookie("std_id"));
			$("#rememberMe").attr("checked", true);
			$("#rememberMe").val(getCookie("rememberMe"));
			
		}
		
		//rememberMe 체크박스 클릭 이벤트
		$("#rememberMe").on("click", function(){
			if($(this).is(":checked")){
				// rememberMe cookie 설정
				setcookie("rememberMe", "y", 30);
				setcookie("std_id", $("#std_id").val(), 30);
			} else {
				// 쿠키 제거
				deleteCookie("rememberMe");
			}
		});

	});
</script>

</head>

<body>

	<!-- 
	  		1. 사용자가 로그인 화면을 접속한다 (localhost:8180/login/login.jsp)
	  		2. 사용자가 아이디, 비밀번호를 입력후 singin 버튼을 클릭
	  			-> singin 버튼이 속한 form 태그의 action 속성에 설정된 url로 요청
	  		3. LoginServlet 파라미터(std_id, pass)를 확인 후 고정된 값을 비교
	  			같을 경우 response객체의 writer 객체를 이용하여 화면에 "접속성공"
	  			틀릴 경우 "접속실패" 메세지를 출력
	   -->

	<div class="container">
		<form class="form-signin" action="/loginServlet" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
<!-- 			<label for="std_id" class="sr-only">Id</label> -->
			
			<%
// 				String std_id = request.getParameter("std_id");
// 					std_id = std_id == null ? "" : std_id;
			%>
			
			 <input type="text"
				id="std_id" name="std_id" class="form-control"
				placeholder="id" required autofocus
				value="${param.std_id}" > 
				
				<label
				for="pass" class="sr-only">Pass</label> <input
				type="password" id="pass" name="pass" class="form-control"
				placeholder="pass" required>

			<div class="checkbox">
				<label> <input type="checkbox" id="rememberMe"
					name="rememberMe" value=""> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>
	<!-- /container -->

</body>
</html>
