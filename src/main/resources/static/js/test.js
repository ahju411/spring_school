$(function (){
    test()
})

function test (){
    $.ajax({
        type:'get',
        url:'http://39.122.95.89:25917/list',
        success:function (data){
            let html =''
            let carrer = ''
            $.each(data,function (index,list){
                html += list.name
                carrer += '<p style="text-align: center">22.09~: '+list.career+'</p>'
            })
            $('#testget').html(html).trigger('create')
            $('#testcarrer').html(carrer).trigger('create')

        },
        error:function (data){
            alert("접속오류 데스요")
        }
    })
}

function test_input (){

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
            dataType: 'jsonp',
            format: 'json',
            success:function (data){
                alert(data)
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