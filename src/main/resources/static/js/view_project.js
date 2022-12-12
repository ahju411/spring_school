const session = localStorage.getItem("Session");

console.log("ㅏ이이너ㅁㅏㄴㅁ션세",session);
$(function (){

    project_get_project ()

})



function project_get_project (){


    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/myProject',
        data:{"id":session},
        crossDomain: true,
        dataType: 'json',
        success:function (data){

        },
        error:function (data){

        }
    })

}