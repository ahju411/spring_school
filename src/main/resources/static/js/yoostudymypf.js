const session = localStorage.getItem("Session");

console.log("ㅏ이이너ㅁㅏㄴㅁ션세",session);
$(function (){

   pf_get_projects()

})

function delete_project(x){

    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/deleteProject',
        data:{"id":x},
        crossDomain: true,
        dataType: 'json',
        success:function (data){
           alert("성공적으로 지웠습니다.")
            location.href="http://localhost:63342/spring_school/templates/yoostudy_mypf_new.html?_ijt=o8o0mg250c4ap4jjk6lfbtuovp&_ij_reload=RELOAD_ON_SAVE"

        },
        error:function (data){
            alert("지우는데 오류가 발생했습니다.")
        }
    })


}


function pf_get_projects(){


    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/myProject',
        data:{"id":session},
        crossDomain: true,
        dataType: 'json',
        success:function (data){
            let html=''
            for(let i=0;i<data.length;i++){
                html+='<div>\n' +
                    '  <div  style="margin: 100px;">\n' +
                    '    <hr style="border: double 10px gray;">\n' +
                    '    <div id="testget"><button id="deletebtn" type="button"  class="btn btn-outline-secondary" style="background-color: whitesmoke;\n' +
                    '        onclick="delete_project('+data[i].pj_id+')">삭제</button>\n' +
                    '      <H1 id="detail_name">'+data[i].pjName+'</H1>\n' +
                    '      <H7 id="detail_shortinfo">'+data[i].pjShortInfo+'</H7>\n' +
                    '    </div>\n' +
                    '\n' +
                    '    <div>\n' +
                    '      <H1>LANGUAGE</H1>\n' +
                    '      <H7 id="detail_language">'+data[i].language+'</H7>\n' +
                    '    </div>\n' +
                    '\n' +
                    '\n' +
                    '    <div>\n' +
                    '      <H1>INFO</H1>\n' +
                    '      <H7 id="detail_longinfo">'+data[i].pjLongInfo+'</H7>\n' +
                    '\n' +
                    '      <div>\n' +
                    '        <H1>LINK</H1>\n' +
                    '        <a id="detail_link" href="'+data[i].pjLink+'">'+data[i].pjLink+'</a>\n' +
                    '      </div>\n' +
                    '      <hr style="border: double 10px gray;">\n' +
                    '    </div>\n' +
                    '  </div>\n' +
                    '    \n' +
                    '    '

            }
            $('#main').html(html).trigger("create");



        },
        error:function (data){


        }
    })
}





