<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>보호자 회원가입</title>
    <link rel="stylesheet" href="css/signUp.css" />
    <link href='/css/common.css' rel='stylesheet' />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script defer src="js/memberSignup.js"></script>
    <script defer src="js/file-upload.js"></script>
  </head>
  <body>
    <form name="join_form" action="" method="post" id="join_form">
      <!-- 선택 -->
      <select id="classification" class="sel" onchange="moveurl(this.value)">
        <option value="memberSignup"selected>보호자</option>
        <option value="employeeSignup">요양보호사</option>
      </select>
      <div class="join_content">
        <h1 class="classification_title">보호자 회원가입</h1>
        <!-- 아이디 -->
        <div class="join_row">
          <h3 class="join_title"><label for="id">아이디 (5~20자)</label></h3>
          <input
            class="join_input"
            type="text"
            id="id"
            name="id"
            title="id"
            maxlength="20"
            placeholder="소문자&숫자&특수문자(_,-) 가능"
          />
        </div>
        <span class="id_check"></span>    
		<!-- 비밀번호 -->
        <div class="join_row">
          <h3 class="join_title"><label for="password">비밀번호</label></h3>
          <input
            class="join_input"
            type="text"
            id="password"
            name="password"
            title="password"
            maxlength="20"
          />
        </div>

        <!-- 비밀번호 재입력 -->
        <div class="join_row">
          <h3 class="join_title"><label for="password2">비밀번호 재입력</label></h3>
          <input
            class="join_input"
            type="text"
            id="password2"
            name="password2"
            title="input password confirm"
            maxlength="20"
          />
        </div>

        <!-- 이름 -->
        <div class="join_row">
          <h3 class="join_title"><label for="member_name">이름</label></h3>
          <input
            class="join_input"
            type="text"
            id="member_name"
            name="member_name"
            title="input first name"
            maxlength="20"
          />
        </div>
        <!-- 보호자 생년월일 -->
        <div class="join_row">
          <h3 class="join_title">
            <label for="member_birth">보호자 생년월일</label>
          </h3>
          <input type="date" name="member_birth" id="member_birth"/>
        </div>
        <!-- 생년월일 -->
        <!-- <div class="join_row">
        <h3 class="join_title"><label for="birth">생년월일</label></h3>
        <input
          class="join_input"
          type="text"
          id="birth"
          name="birth"
          title="input birth"
          maxlength="6"
        />
      </div> -->
        <!-- 휴대전화 -->
        <div class="join_row">
          <h3 class="join_title"><label for="phone">휴대전화</label></h3>
          <input
            class="join_input"
            type="text"
            id="phone"
            name="phone"
            title="input phone number"
            maxlength="13"
          />
        </div>
        <!-- 주소 -->
        <div class="join_row">
          <h3 class="join_title"><label for="address">주소</label></h3>
          <input
            class="join_input"
            type="text"
            id="address"
            name="address"
            title="input address"
            maxlength="50"
          />
        </div>
        <!-- 환자이름 -->
        <div class="join_row">
          <h3 class="join_title">
            <label for="patient_name">환자 이름</label>
          </h3>
          <input
            class="join_input"
            type="text"
            id="patient_name"
            name="patient_name"
            title="patient name"
            maxlength="6"
          />
        </div>
        <!-- 환자 생년월일 -->
        <div class="join_row">
          <h3 class="join_title">
            <label for="patient_birth">환자 생년월일</label>
          </h3>
          <input type="date" name="patient_birth" id="patient_birth"/>
        </div>
        <!-- 환자 생년월일 -->
        <!-- <div class="join_row">
        <h3 class="join_title"><label for="patient_birth">환자 생년월일</label></h3>
        <input
          class="join_input"
          type="text"
          id="patient_birth"
          name="patient_birth"
          title="input address"
          maxlength="6"
        />
      </div> -->
        <!-- 회원가입 버튼 -->
        <div class="btn_area">
          <button type="button" id="btnJoin" class="btn">
            <span>회원가입</span>
          </button>
        </div>
      </div>
    </form>
  </body>
</html>

