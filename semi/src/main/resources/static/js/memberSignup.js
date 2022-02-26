const id = $('#id');
const password = $('#password');
const password2 = $('#password2');
const member_name = $('#member_name');
const birth = $('#birth');
const phone = $('#phone');
const address = $('#address');
const patient_name = $('#patient_name');
const patient_birth = $('#patient_birth');
const btnJoin = $('#btnJoin');
const getId = RegExp(/^[a-z0-9_]{5,20}$/);
// 최소 8 자, 최소 하나의 문자, 숫자
const getPw = RegExp(/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$/);
// 한글사용
const getNameKorean = RegExp(/^[가-힣]{1,4}$/);
const getTel = RegExp(/^\d{3}-\d{3,4}-\d{4}$/);

btnJoin.click(function() {
	if(check()){
		$('#join_form').attr("action","/memberSignup");
		console.log("완료");
		$('#join_form').submit();
		console.log("완료2");
		return true;
	} else {
		return false;
	}
});

//유효성검사
function check() {
  if (id.val() === '' || id.val() === null) {
    alert('ID를 입력해주세요.');
    id.focus();
    return false;
  } else if (!getId.test(id.val())) {
    alert('id: 5~20자 소문자와 숫자와 특수문자(_,-)로 작성해주세요.');
    id.focus();
    return false;
  } else if (password.val() === '' || password.val() === null) {
    alert('비밀번호를 입력해주세요.');
    password.focus();
    return false;
  } else if (!getPw.test(password.val())) {
    alert('pw: 8~16자 최소 하나의 문자, 숫자로 이루게 해주세요');
    password.focus();
    return false;
  } else if (password2.val() === '' || password2.val() === null) {
    alert('비밀번호 재입력 해주세요');
    password2.focus();
    return false;
  } else if (password.val() != password2.val()) {
    alert('비밀번호가 일치하지 않습니다.');
    password2.focus();
    return false;
  } else if (member_name.val() === '' || member_name.val() === null) {
    alert('이름을 입력해주세요.');
    member_name.focus();
    return false;
  } else if (!getNameKorean.test(member_name.val())) {
    alert('한국어로 적어주세요');
    member_name.focus();
    return false;
  } else if (birth.val() === '' || birth.val() === null) {
    alert('생년월일을 입력해주세요.');
    birth.focus();
    return false;
  } else if (phone.val() === '' || phone.val() === null) {
    alert('전화번호를 입력해주세요');
    phone.focus();
    return false;
  } else if (!getTel.test(phone.val())) {
    alert('tel: 000-0000-0000');
    phone.focus();
    return false;
  } else if (address.val() === '' || address.val() === null) {
    alert('주소를 입력해주세요.');
    address.focus();
    return false;
  } else if (patient_name.val() === '' || patient_name.val() === null) {
    alert('환자이름을 입력해주세요.');
    patient_name.focus();
    return false;
  } else if (!getNameKorean.test(patient_name.val())) {
    alert('한국어로 적어주세요');
    patient_name.focus();
    return false;
  } else if (patient_birth.val() === '' || patient_birth.val() === null) {
    alert('환자의 생년월일을 입력해주세요.');
    patient_birth.focus();
    return false;
  } else {
    password2.attr('disabled', true);
    alert('회원가입 완료!');
    //location.href = 'index.html';
    return true;
  }
}

		
// select가 변경되었을 때
function moveurl(url) {
  location.href = url;
}

$('#id').on("propertychange change keyup paste input", function(){
	var id = $('#id').val();
	
	if(id != '' || id.length != 0){
		$.ajax({
            url:'/idCheck', //Controller에서 인식할 주소
            type:'post', //POST 방식으로 전달
            data:{id:id},
            success:function(result){
				if(result != 'fail'){
					 $('.id_ok').css("display", "inline-block");
            		 $('.id_already').css("display", "none");
				}else{
					 $('.id_ok').css("display", "none");
            		 $('.id_already').css("display", "inline-block");
				}
            },
            error:function(){
                alert("에러입니다");
            }
        });
	}else{
		 $('.id_ok').css("display", "none");
		 $('.id_already').css("display", "none");
	}
});