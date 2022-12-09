$(function (){

})


function input_memberdb (){

    let id= $('#id').val()
    let nickname  = $('#nickname').val()
    let pw= $('#password').val()
    let pwchk= $('#passwordcheck').val()

    let comment= $('#comment').val()
    let link= $('#link').val()

    if(pw===pwchk){
        $.ajax({
            type:'post',
            url:'http://39.122.95.89:25917/SignUp',
            data:{"id":id,"password":pw,"name":nickname},
            crossDomain: true,
            dataType: 'json',
            success:function (data){
                alert("보내기 성공입니다")
            },
            error:function (data){
                alert("보내기오류 데스요")
            }
        })
    }
    else{
        alert("비밀번호가 일치하지않습니다. 다시한번 확인해주세요.")
    }
}

