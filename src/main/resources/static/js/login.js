


function check_isinMember() {
     let getId= $('#login_id_text').val()
     let getPw  = $('#login_pw_text').val()

     if(getId==="" || getPw===""){
         alert("아이디 혹은 비밀번호를 입력해주세요.")
     }

     else{

        logintest(getId,getPw)
     }


 }

function check_id() {
    alert("중복체크입니다. 연결(X)")
}


function logintest (x,y){
    sessionStorage.setItem("sessionId",x)
    var link ='http://localhost:63342/spring_school/templates/yoostudy_home.html?_ijt=ju1tdco3ftl3o8ah8mo8ifhlbf&_ij_reload=RELOAD_ON_SAVE'
    location.href=link;

    // $.ajax({
    //     type:'post',
    //     url:'http://39.122.95.89:25917/login',
    //     data:{"memberId":x,"password":y},
    //     crossDomain: true,
    //     dataType: 'json',
    //     success:function (data){
    //         $.each(data,function (index,list){
    //             alert("접속성공");
    //
    //         })
    //     },
    //     error:function (data){
    //         alert("접속오류 데스요")
    //     }
    // })


}

