
// 테스트
let career_count =1;
let language_count =1;
let certificate_count =1;
let award_count = 1;
let career_list = []




$(function (){

    get_member_profile()
    get_member_profolio()

})

function get_member_profile(){

}

function  get_member_profolio(){

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


function update_my(){

}

function add_list_career(x){
    career_list.push(x)
}

function mpeEdit(){

    let edited_careers = $("#mpe_career input[type=text]");
    let edited_languages = $("#mpe_language input[type=text]");
    let edited_certs = $("#mpe_cert input[type=text]");
    let edited_awards = $("#mpe_award input[type=text]");

    let edited_careers_list = []
    let edited_languages_list = []
    let edited_certs_list = []
    let edited_awards_list = []


    $.each(edited_careers, function (index, value) {
        edited_careers_list.push($(value).val())
        // console.log('인덱스값' + index);
        // console.log(value);
        // console.log('id =' + $(value).attr("id"));
        // console.log('name =' + $(value).attr("name"));
        // console.log('value =' + $(value).val());
    });
    $.each(edited_languages, function (index, value) {
        edited_languages_list.push($(value).val())

    });
    $.each(edited_certs, function (index, value) {
        edited_certs_list.push($(value).val())

    });
    $.each(edited_awards, function (index, value) {
        edited_awards_list.push($(value).val())

    });
    console.log(edited_careers_list,edited_languages_list,edited_certs_list,edited_awards_list)




}







