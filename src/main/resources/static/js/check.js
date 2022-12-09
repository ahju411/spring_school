$(function (){

})



 function check_isinMember() {
     let getId= $('#login_id_text').val()
     let getPw  = $('#login_pw_text').val()

     if(getId==="" || getPw===""){
         alert("아이디 혹은 비밀번호를 입력해주세요.")
     }

     alert(getId+getPw+"회원있는지 체크입니다. 연결(X)")
 }

function check_id() {
    alert("중복체크입니다. 연결(X)")
}