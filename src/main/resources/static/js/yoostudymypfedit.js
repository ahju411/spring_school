
// 테스트
let career_count =1;
let language_count =1;
let certificate_count =1;
let award_count = 1;
let career_list = []
let idcode

// 세션 임시
sessionStorage.setItem("sessionId","test2")
let sessionget = sessionStorage.getItem("sessionId")
alert("세션:"+sessionget)

$(function (){

    get_profileedit()


})




function get_profileedit(){
    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/getMymember',
        data:{"memberId":sessionget},
        crossDomain: true,
        dataType: 'json',
        success:function (data){

                let name =data.name
                let comment = data.comment
                let link = data.link
                idcode = data.id

                $('#profileedit_username').attr("value",name)
                $('#profileedit_usercomment').attr("value",comment)
                $('#profileedit_userlink').attr("value",link)

        },
        error:function (data){
            alert("접속오류 데스요")
        }
    })
}



function add_career(){

    let html =
        '<div id="career_item" class="input-group input-group-sm mb-3 " style="width: 300px;margin: auto;margin-top: 15px">'
    html +=
        '<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">'
    html += '<button id="carrer_del" type="button" class="btn btn-outline-secondary" style="background-color: whitesmoke" onclick="delete_career(this)">Del</button>'
    html += '</div>'
    $('#mpe_career').append(html)

}

function add_language(){

    let html =
        '<div id="language_item" class="input-group input-group-sm mb-3 " style="width: 300px;margin: auto;margin-top: 15px">'
    html +=
        '<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">'
    html += '<button id="language_del" type="button" class="btn btn-outline-secondary" style="background-color: whitesmoke" onclick="delete_career(this)">Del</button>'
    html += '</div>'
    $('#mpe_language').append(html)

}

function add_cert(){

    let html =
        '<div id="cert_item" class="input-group input-group-sm mb-3 " style="width: 300px;margin: auto;margin-top: 15px">'
    html +=
        '<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">'
    html += '<button id="cert_del" type="button" class="btn btn-outline-secondary" style="background-color: whitesmoke" onclick="delete_career(this)">Del</button>'
    html += '</div>'
    $('#mpe_cert').append(html)

}

function add_award(){

    let html =
        '<div id="award_item" class="input-group input-group-sm mb-3 " style="width: 300px;margin: auto;margin-top: 15px">'
    html +=
        '<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">'
    html += '<button id="award_del" type="button" class="btn btn-outline-secondary" style="background-color: whitesmoke" onclick="delete_career(this)">Del</button>'
    html += '</div>'
    $('#mpe_award').append(html)

}



function mpeEdit(){

    let edited_careers = $("#mpe_career input[type=text]");
    let edited_languages = $("#mpe_language input[type=text]");
    let edited_certs = $("#mpe_cert input[type=text]");
    let edited_awards = $("#mpe_award input[type=text]");

    let edited_careers_list = ''
    let edited_languages_list = ''
    let edited_certs_list = ''
    let edited_awards_list = ''


    $.each(edited_careers, function (index, value) {

        edited_careers_list += $(value).val()+":"

    });
    $.each(edited_languages, function (index, value) {
        edited_languages_list += $(value).val()+":"
    });
    $.each(edited_certs, function (index, value) {
        edited_certs_list += $(value).val()+":"

    });
    $.each(edited_awards, function (index, value) {
        edited_awards_list += $(value).val()+":"

    });
    console.log(edited_careers_list,edited_languages_list,edited_certs_list,edited_awards_list)



        let getname= $('#profileedit_username').val()
        let getcomment  = $('#profileedit_usercomment').val()
        let getlink= $('#profileedit_userlink').val()


            $.ajax({
                type:'post',
                url:'http://39.122.95.89:25917/memberUpdate',
                data:{"memberId":sessionget,"id":idcode,"name":getname,"comment":getcomment,"link":getlink
                    ,"career":edited_careers_list,"language":edited_languages_list
                    ,"award":edited_awards_list},
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







