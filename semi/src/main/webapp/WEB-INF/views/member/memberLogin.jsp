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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script defer src="/js/memberLogin.js"></script>
<title>로그인</title>
<style type="text/css">
	.wrapper{height:600px; padding-top: 100px;}
	
	#login {display: inline-block;}
	
	#id, #password{
		padding: 17px 25px 17px 35px;
	    box-sizing: border-box;
	    text-align: left;
	    border: 2px solid #dadada;
	    box-shadow: 0 2px 6px 0 rgb(68 68 68 / 8%);
	    height: 100%;
	    margin-top: 20px;
	    border-radius: 6px;
	}
	
	.input_row{
	    width: 250px;
	    height: 20px;
	    border: none;
	    font-size: 16px;
	    text-align: center;
	}
	
	.input_row:focus{outline: none}
	
	#login_btn {
	    padding: 15px 55px;
	    border-radius: 6px;
	    margin-top: 10px;
	    border: none;
	    background-color: #313131;
	    color: white;
	}
	
	a {
		text-decoration: none;
		color: black;
	}
	#text_id {
		float: left;
	}
	#text_register {
		float: right;
	}
	#text_admin {
		float: right;
		margin-top: 5px
	}
	.login_warn{
		margin-top:30px;
		text-align:center;
		color:red;
	}
	.login_bottom{margin-top: 30px; font-size: 14px}
</style>
</head>

<body>
	<div class="wrapper">
		<div>
			<h1>로그인</h1>
		</div>
		<form id = "login_form" method = "post">
			<div id="login">
				<!-- 아이디 -->
				<div id="id">
					<i class="fas fa-user"></i> <input type="text" name="id" class="input_row"
						placeholder="아이디를 입력해 주세요">
				</div><br>
				<!-- 비밀번호 -->
				<div id="password">
					<i class="fas fa-lock"></i> <input type="password" name="password" class="input_row"
						placeholder="비밀번호를 입력해 주세요">
				</div><br>
				 <c:if test = "${result == 0 }">
                	<div class = "login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다.</div>
            	</c:if>
 
				<div>
					<button id="login_btn">로그인하기</button>
				</div>
			</div>
		</form> 
		<div class="login_bottom">
			<div id="text_id"><a href="">아이디/비밀번호 찾기</a></div>
			<div id="text_register"><a href="${contextPath}/memberSignup">회원가입</a></div></br>
			<div id="text_admin"><a href="${contextPath}/admin/adminLogin">관리자 로그인</a></div>
		</div>
	</div>
</body>
</html>