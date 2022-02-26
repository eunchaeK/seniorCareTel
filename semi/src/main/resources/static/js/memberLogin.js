/* 로그인 버튼 클릭 메서드 */
$('#login_btn').click(function () {
  //console.log('로그인 버튼 작동');
  /*로그인 메서드 서버 요청*/
  $("#login_form").attr("action", "/member/memberLogin");
  $("#login_form").submit();
});
