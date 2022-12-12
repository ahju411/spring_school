



function logintest (){
    // sessionStorage.setItem("sessionId")


    let id= $('#id').val()
    let pw  = $('#pw').val()


    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/login',
        data:{"memberId":id, "password":pw},
        crossDomain: true,
        dataType: 'json',
        success:function (data){
            if(data.result=== 'fail'){
                alert('실패')
            }
            else{
                localStorage.setItem("Session",data.result);
                location.href ='http://localhost:63342/spring_school/templates/yoostudy_home.html?_ijt=ju1tdco3ftl3o8ah8mo8ifhlbf&_ij_reload=RELOAD_ON_SAVE'
            }


        },
        error:function (data){
            alert(data)
        }
    })


}

