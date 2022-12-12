const session = localStorage.getItem("Session");

console.log("ㅏ이이너ㅁㅏㄴㅁ션세",session);
$(function (){


})




function add_portfolio(){



    let getPJname = $("#pj_name").val();
    let getPJShortinfo = $("#pj_shortinfo").val();
    let getPJlanguage = $("#pj_language").val();
    let getPJLonginfo = $("#pj_longinfo").val();
    let getPJLink = $("#pj_link").val();

    console.log(getPJname)

    let form = $('#fileport')[0];
    var formData2 = new FormData(form);
    formData2.append('id',sessionget);
    formData2.append('pjName',getPJname);
    formData2.append('pjLink',getPJLink);
    formData2.append('pjLongInfo',getPJLonginfo);
    formData2.append('pjShortInfo',getPJShortinfo);
    formData2.append('language',getPJlanguage);

    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/saveProject',
        processData: false,
        contentType: false,
        // data:{"memberId":sessionget,"id":idcode,"name":getname,"comment":getcomment,"link":getlink
        //     ,"career":edited_careers_list,"language":edited_languages_list
        //     ,"award":edited_awards_list,"certificate":edited_certs_list},
        data:formData2,
        crossDomain: true,
        dataType: 'json',
        success:function (data){


        },
        error:function (data){

        }
    })



}

