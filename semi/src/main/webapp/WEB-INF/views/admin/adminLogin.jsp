<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href='/css/fontawesome/all.css' rel='stylesheet' />
<script src='/css/fontawesome/all.js'></script>
<title>헤더</title>
<style type="text/css">
.wrapper{height:600px; padding-top: 100px;}
#login {
	display: inline-block;
}
h1{margin-bottom: 20px}

#login>#admin_id {
	width: 384px;
	height: 59px;
	border: 1px solid black;
	border-radius: 10px;
	margin-bottom: 10px;
	display: table-cell;
	vertical-align: middle;
}

#login>#admin_id>input {
	border: none;
}

#login>#admin_password {
	width: 384px;
	height: 59px;
	border: 1px solid black;
	border-radius: 10px;
	display: table-cell;
	vertical-align: middle;
}

#login>#admin_password>input {
	border: none;
}

#login_btn {
	width: 384px;
	height: 59px;
	background-color: gray;
	color: white;
	margin-bottom: 30px;
	border-radius: 10px;
	border: 0px
}

a {
	text-decoration: none;
	color: black;
}
.input_row:focus{outline: none}
.input_row{width: 185px}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#login_btn").click(function() {
			var admin_id = $("#admin_id").val();
			var admin_password = $("#admin_password").val();
			if (admin_id == "") {
				alert("아이디를 입력하세요.");
				$("#admin_id").focus(); // 입력포커스 이동
				return; // 함수 종료
			}
			if (admin_password == "") {
				alert("비밀번호를 입력하세요.");
				$("#admin_password").focus();
				return;
			}
			// 폼 내부의 데이터를 전송할 주소
			document.form1.action = "${contextPath}/admin/loginCheck
			// 제출
			document.form1.submit();
		});
	});
</script>
</head>
<body>
	<div class="wrapper">
		<div>
			<h1>관리자 로그인</h1>
		</div>

	<form action="${contextPath}/admin/loginCheck" name="form1" method="post">
		<div id="login">
			<!-- 아이디 -->
			<div id="admin_id"> 
				<i class="fas fa-user"></i> 
				<input class="input_row" type="text" name="admin_id" placeholder="아이디를 입력해주세요">
			</div>
			<br>
			<!-- 비밀번호 -->
			<div id="admin_password">
				<i class="fas fa-lock"></i>
				<input  class="input_row" type="password" name="admin_password" placeholder="비밀번호를 입력해주세요">
			</div>
			<br>
			<div>
				<button id="login_btn">로그인하기</button>
			</div>
		</div>
	</form>

	</div>
</body>
</html>