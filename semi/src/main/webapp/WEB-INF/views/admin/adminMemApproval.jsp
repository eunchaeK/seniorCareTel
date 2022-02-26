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
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <style type="text/css">
  	.wrapper{
  	  height:100vh;
  	  text-align: center;
  	}
  	table{
  		margin: 0 auto;
  		border-spacing: 0 30px;
  	}
  	table tr td{
  		text-align: left;
  	}
  	table tr td:first-child{
  		text-align: right;
  		padding-right: 10px
  	}
  	input[type=text]{height: 28px; width: 200px}
  	/* datepicker 버튼 */
  	.ui-datepicker-trigger{
  		height: 30px;
  		width: 38px;
  		font-size: 11px;
  		margin-left: 3px
  	}
  	#submitBtn{text-align: left;}
  	#radioWrap{text-align: left;}
  </style>
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script type="text/javascript">
  	  $.datepicker.setDefaults({
		  dateFormat: 'yy-mm-dd',
		  prevText: '이전 달',
		  nextText: '다음 달',
		  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		  showMonthAfterYear: true,
		  changeMonth: true,
	      changeYear: true,
	      yearRange: "1910:c",
	      showOn:"button",
	      buttonText:"선택",
	      showButtonPanel: false
          //buttonImage:"https://t1.daumcdn.net/cfile/tistory/26100D4F5864C76827",
          //buttonImageOnly:true
		  //yearSuffix: '년'
	   });

		$(function () {
		  $('input.date').datepicker({});
		  
		  $("#approvalBtn").click(function(){
	            var isRight = true;
	            $("table").find("input").each(function(index, item){
	                // 아무값없이 띄어쓰기만 있을 때도 빈 값으로 체크되도록 trim() 함수 호출
	                if ($(this).val().trim() == '') {
	                    alert("모든 항목을 입력하세요.");
	                    isRight = false;
	                    return false;
	                }
	            });

	            if (isRight) {
	            	$("form").submit();
	            }else{
	            	return false;
	            }
	        });

		});
		
  </script>
</head>
<body>
 <div class="wrapper">
	<form name="approvalFrom" method="post" action="${contextPath}/admin/memberapproval">
	<h1>회원 승인</h1>
	
	<table>
	   <tr>
	      <td><label for="number">등록번호</label></td>
	      <td><input type="text" id="number" name="number" readonly="readonly" value="${member.number}"></td>
	   </tr>
	   <tr>
	      <td><label for="member_name">회원이름</label></td>
	      <td><input type="text" id="member_name" name="member_name" value="${member.member_name}"></td>
	    </tr>
	    <tr>
	       <td><label for="date">생년월일</label></td>
	       <td><input type="text" id="date" class="date" name="birth" value="${member.birth}"></td>
	    </tr>
	    <tr>
	       <td><label for="address">주소</label></td>
	       <td><input type="text" id="address" name="address" value="${member.address}"></td>
	    </tr>
	    <tr>
	       <td><label for="phone">핸드폰 번호</label></td>
	       <td><input type="text" id="phone" name="phone" value="${member.phone}"></td>
	    </tr>
	    <tr>
	       <td><label for="patient_number">환자 번호</label></td>
	       <td>
	          <input type="text" id="patient_number" name="patient_number">
	       </td>
	    </tr>
	     <tr>
	       <td><label for="patient_name">환자 이름</label></td>
	       <td><input type="text" id="patient_name" name="patient_name" value="${member.patient_name}"></td>
	    </tr>
	     <tr>
	       <td><label for="patient_birth">환자 생년월일</label></td>
	       <td><input type="text" id="patient_birth" class="date" name="patient_birth" value="${member.patient_birth}"></td>
	    </tr>
	    <tr>
	       <td><label for="approval">승인여부</label></td>
		   <td id="radioWrap">
	         <input type="radio" id="appTrue" name="approval" value="true" checked/><label for="appTrue">승인</label>
	       </td>
	    </tr>
	    <tr>
	       <td><p>&nbsp;</p></td>
	       <td id="submitBtn">
	       		<input type="submit"  value="승인하기" id="approvalBtn">
	       		<input type="reset" value="정보 초기화">
	       </td>
	    </tr>
	</table>
	</form>
 </div>

</body>
</html>