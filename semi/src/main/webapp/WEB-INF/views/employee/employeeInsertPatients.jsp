<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정창</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link href='/css/common.css' rel='stylesheet' />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<style>
* {
	box-sizing: border-box;
}

input {
	width: 384;
	height: 57;
	border-radius: 10px;
	border: 1px solid #c4c4c4;
	font-size: 18px;
	padding: 10px 15px;
	margin: 8px 0px;
}

.control>input {
	background-color: white;
	border: 1px solid #c4c4c4;
	border-radius: 5px;
	margin-top: 30px;
}

.text_center {
	text-align: center;
}

label {
	font-size: 18px;
}
</style>
</head>
<body>
	<form method="post">
		<h1 class="text_center">환자 입력</h1>
		<table align="center">
			<tr class="tblRow">
				<td width="200"><label for="patient_name">환자이름</label></td>
				<td width="400"><input type="text" id="patient_name"
					name="patient_name" value="${patients.patient_name}"></td>
			</tr>
			<tr>
				<td width="200"><label for="patient_birth">생년월일</label></td>
				<td width="400"><input type="text" id="patient_birth"
					name="patient_birth" value="${patients.patient_birth}" placeholder="ex) 1962-07-06"></td>
			</tr>
			<tr>
				<td width="200"><label for="patient_address">주소</label></td>
				<td width="400"><input type="text" id="patient_address"
					name="patient_address" value="${patients.patient_address}" placeholder="ex) 수원시"></td>
			</tr>
			<tr>
				<td width="200"><label for="patient_phone">연락처</label></td>
				<td width="400"><input type="text" id="patient_phone"
					name="patient_phone" value="${patients.patient_phone}" placeholder="ex) 01012345678"></td>
			</tr>
			<tr>
				<td width="200"><label for="hospitalization_date">입원 날짜</label></td>
				<td width="400"><input type="text" id="hospitalization_date"
					name="hospitalization_date" value="${patients.hospitalization_date}" placeholder="ex) 2022-01-04"></td>
			</tr>
			<tr>
				<td width="200"><label for="application">장기 요양 서류</label></td>
				<td width="400"><input type="text" id="application"
					name="application" value="${patients.application}"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400"><input type="submit" value="입력하기"> <input
					type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>