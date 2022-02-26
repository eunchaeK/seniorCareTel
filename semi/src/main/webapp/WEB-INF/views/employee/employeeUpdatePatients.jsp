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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<style>
.text_center {
	text-align: center;
	
	/* 검색 버튼 */ 
	# searchBtn { width : 42px;
	background-color: orange;
	cursor: pointer;
}
}
</style>
<script type="text/javascript">
$(function () {
	$("input[type=submit]").click(function(){
    let discharge_date = $("#discharge_date");
    if (discharge_date.val() == '' || discharge_date.val().length == 0) {
    	discharge_date.attr("disabled", "disabled");
    }
    $("form").submit();
	});
});
</script>
</head>
<body>
	<form method="post">
		<h1 class="text_center">예약 정보 수정창</h1>
		<table align="center">
			<tr class="tblRow">
				<td width="200"><label for="patient_number">환자번호</label></td>
				<td width="400"><input type="text" id="patient_number" name="patient_number" readonly="readonly" value="${patient.patient_number}"></td>
			</tr>
			<tr ">
				<td width="200"><label for="patient_name">환자이름</label></td>
				<td width="400"><input type="text" id="patient_name" name="patient_name" value="${patient.patient_name}"></td>
			</tr>
			<tr>
				<td width="200"><label for="patient_birth">생년월일</label></td>
				<td width="400"><input type="text" id="patient_birth"
					name="patient_birth" value="${patient.patient_birth}"></td>
			</tr>
			<tr>
				<td width="200"><label for="patient_address">주소</label></td>
				<td width="400"><input type="text" id="patient_address"
					name="patient_address" value="${patient.patient_address}"></td>
			</tr>
			<tr>
				<td width="200"><label for="patient_phone">연락처</label></td>
				<td width="400"><input type="text" id="patient_phone"
					name="patient_phone" value="${patient.patient_phone}"></td>
			</tr>
			<tr>
				<td width="200"><label for="hospitalization_date">입원 날짜</label></td>
				<td width="400"><input type="text" id="hospitalization_date"
					name="hospitalization_date" value="${patient.hospitalization_date}"></td>
			</tr>
			<tr>
				<td width="200"><label for="discharge_date">퇴원 날짜</label></td>
				<td width="400"><input type="text" id="discharge_date"
					name="discharge_date" value="${patient.discharge_date}"></td>
			</tr>
			<tr>
				<td width="200"><label for="application">장기 요양 서류</label></td>
				<td width="400"><input type="text" id="application"
					name="application" value="${patient.application}"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400"><input type="submit" value="수정하기"> <input
					type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>