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
<title>Reservation</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style type="text/css">
/* 말머리 부분*/
#head {
	text-align: left;
}

.wrapper {
	height: 100vh;
}

/* 검색부분 */
.searchArea {
	margin: 15px 0px;
}

.leftAlign {
	text-align: left;
}

/* 검색부분 (https://wazacs.tistory.com/34) */
/* 검색타입 */
/* IE */
#searchType::-ms-expand {
	display: none;
}

#searchType {
	-o-appearance: none;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	width: 110px;
	height: 30px;
	background:
		url('https://image.flaticon.com/icons/png/512/1174/1174405.png')
		calc(100% - 5px) center no-repeat;
	background-size: 18px;
	padding: 6px 30px 5px 10px;
	border-radius: 4px;
	outline: 0 none;
}

#searchType option {
	background: #ebebeb;
	padding: 3px 3px;
}

/* input 태그 */
.searchText {
	width: 140px;
	height: 28px;
	border: 1px solid #454545;
	border-radius: 4px;
	padding: 0px 10px;
	outline: 0 none;
}

/* 버튼 클래스(검색, 회원삭제) */
.btn {
	margin: 0;
	padding: 0;
	border: 0;
	border-radius: 4px;
	height: 30px;
}

.delete {
	float: right;
	background-color: orange;
	margin-top: 10px;
	padding: 5px;
}

/* 검색 버튼 */
#searchBtn {
	width: 42px;
	background-color: orange
}

/* 테이블 css */
#reservTable {
	border: 1px solid black;
	text-align: center;
	width: 100%;
}

#reservTable tr {
	text-align: center;
}

#tableHead {
	background-color: #c4c4c4
}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	//검색리스트 요청 ajax
	$(document).ready(function () {
		
		$("#searchBtn").click(function searchList() {
			const type = $("#searchType").val();
			const keyword = $('#searchKey').val().trim();
			
			//검색 내용 없을 시 alert(전체보기 검색 제외)
			if(type != "" && keyword == ""){
				alert('검색할 내용을 입력하세요!');
				return false;
			}
			
			$.ajax({
				/* post로 나중에 바꾸기 */
				type: "GET",
				url: "/getSearchList",
				data:{
					"type" : type,
					"keyword" : keyword
				},
				error : function(error) {
				   alert("Error!");
				},
				success: function(result){
					//테이블 초기화
					$('#reservTable > tbody').empty();
					$('.paging').empty();
					if(result.length>=1){
						result.forEach(function(item){
							str = "<tr>";
							str +="<td><input type='checkbox' class='delCheck' name='delete_numbers' value="+item.visit_number+"/></td>";
							str += "<td>" + item.visit_number + "</td>";
							str += "<td>" + item.visit_meeting + "</td>";
							str += "<td>" + item.visit_date + "</td>";
							str += "<td>" + item.visit_time + "</td>";
							str += "<td>" + item.member_name + "</td>";
							str += "<td>" + item.patient_name + "</td>";
							str += "<td><a href='${contextPath}/admin/adminModReservation?visit_number=" + item.visit_number +"'>수정</a></td>";
							str += "</tr>";
							$('#reservTable').append(str);
						});
					}else{
						str = "<tr>";
						str += "<td colspan='8'><div>해당 회원 데이터가 없습니다.</div></td>";
						str += "</tr>";
						$('#reservTable').append(str);
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<div id="head">
		<h1>면회 관리</h1>
	</div>

	<div class="wrapper">
		<div class="searchArea leftAlign">
			<form name="searchForm" autocomplete="on">
				<select id="searchType" name="type">
					<option value="">전체보기</option>
					<option value="visit_meeting">면회방법</option>
					<option value="visit_date">면회날짜</option>
					<option value="member_name">보호자이름</option>
					<option value="patient_name">환자이름</option>
				</select> 
				<input type="search" name="keyword" class="searchText" id="searchKey" /> 
				<input type="button" id="searchBtn" class="btn"	value="검색" />
			</form>
		</div>

		<form action="/admin/reservDelete" method="post" name="reservationList">
			<table id="reservTable">
				<thead>
					<tr id="tableHead">
						<td><input type="checkbox" name="selectAll" value=""
							onclick="checkAll(this)" /></td>
						<td><b>예약번호</b></td>
						<td><b>면회방법</b></td>
						<td><b>면회날짜</b></td>
						<td><b>면회시간</b></td>
						<td><b>보호자이름</b></td>
						<td><b>환자이름</b></td>
						<td><b>수정</b></td>
					</tr>
				</thead>
	
				<tbody>
					<c:forEach var="reservation" items="${reservationList}">
						<tr>
							<td><input type="checkbox" class="delCheck"	
								name="delete_numbers" onclick="selectBox()"	
								value="${reservation.visit_number}" /></td>
							<td>${reservation.visit_number}</td>
							<td>${reservation.visit_meeting}</td>
							<td>${reservation.visit_date}</td>
							<td>${reservation.visit_time}</td>
							<td>${reservation.member_name}</td>
							<td>${reservation.patient_name}</td>
							<td><a href="${contextPath}/admin/adminModReservation?visit_number=${reservation.visit_number}">수정</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
			<div class="bottom">
				<div class="leftAlign">
					<div>전체 면회 에약 수: ${reservListCnt}
						<input type="button" onclick="checkSelect()" class="btn delete" value="선택삭제">
					</div>
				</div>
				<ul class="paging">
					<c:if test="${paging.prev}">
						<span><a
							href='<c:url value="/admin/reservList?page=${paging.startPage-1}"/>'>이전</a></span>
					</c:if>
					<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
						var="num">
						<span><a
							href='<c:url value="/admin/reservList?page=${num}"/>'>${num}</a></span>
					</c:forEach>
					<c:if test="${paging.next && paging.endPage>0}">
						<span><a
							href='<c:url value="/admin/reservList?page=${paging.endPage+1}"/>'>다음</a></span>
					</c:if>
				</ul>
			</div>
		</form>
	</div>

	<script type="text/javascript">
	//삭제 버튼 
	function checkAll(checkAll){
	    let checkboxes = document.getElementsByName("delete_numbers");
	
	    checkboxes.forEach((checkbox)=>{
	        checkbox.checked=checkAll.checked;
	    });
	}
	
	function selectBox(){
		  // 전체 체크박스
		  const checkboxes 
		    = document.querySelectorAll('input[name="delete_numbers"]');
		  // 선택된 체크박스
		  const checked 
		    = document.querySelectorAll('input[name="delete_numbers"]:checked');
		  // select all 체크박스
		  const selectAll 
		    = document.querySelector('input[name="selectAll"]');
		  
		  if(checkboxes.length === checked.length)  {
		    selectAll.checked = true;
		  }else {
		    selectAll.checked = false;
		  }
	}
	
	function checkSelect(){
		const checked = document.querySelectorAll('input[name="delete_numbers"]:checked');
		
		if(checked.length === 0){
			alert('삭제할 데이터를 선택해주세요.');
			return false;
		}else{
			if(confirm(checked.length +"개의 데이터를 삭제하시겠습니까?")){
				document.reservationList.submit();
			}else{
				return;
			}
		}
	}
 
 </script>
</body>
</html>