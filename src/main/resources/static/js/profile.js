$(function (){
    get_profile()
})


function get_profile(){
    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/memberList',
        success:function (data){
            for(let i =0 ; i<data.length;i++){
                if(data[i].memberId==="test2"){ // 이거 나중에 세션아이디랑 비교할거임 test2 대신에
                    let name =''
                    let comment = ''
                    let link = ''

                    name = data[i].name
                    comment = data[i].comment
                    link = data[i].link


                    $('#profile_username').html(name).trigger('create')
                    $('#profile_usercomment').html(comment).trigger('create')
                    $('#profile_userlink').html(link).trigger('create')

                }
            }

        },
        error:function (data){
            alert("접속오류 데스요")
        }
    })
}
