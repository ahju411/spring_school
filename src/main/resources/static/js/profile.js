const session = localStorage.getItem("Session");

console.log("ㅏ이이너ㅁㅏㄴㅁ션세",session);

$(function (){
    get_profile()
    get_projects()
})

function get_projects(){



    let pjName  = $('#pjName').val()
    let pjShortInfo = $('#pjShortInfo')

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



function get_profile(){
    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/getMymember',
        data:{"id":session},
        crossDomain: true,
        dataType: 'json',
        success:function (data){

                    let name =''
                    let comment = ''
                    let link = ''

                    let award =''
                    let career = ''
                    let cert =''
                    let language =''
                    let html =''
                    let html2 =''
                    let html3 =''
                    let html4 =''


                    name = data.name
                    comment = data.comment
                    link = data.link
                    award = data.award
                    career = data.career
                    cert = data.certificate
                    language = data.language

                    award = award.split(":")

                    career = career.split(":")
                    cert = cert.split(":")
                    language = language.split(":")

                    for(let i =0 ; i<award.length;i++){
                        html += '<div><p style="text-align: center">'+award[i]+'</p></div>'
                    }

                    for(let i =0 ; i<career.length;i++){
                        html2 += '<p style="text-align: center">'+career[i]+'</p>'
                    }

                    for(let i =0 ; i<cert.length;i++){
                        html3 += '<p style="text-align: center">'+cert[i]+'</p>'
                    }

                    for(let i =0 ; i<language.length;i++){
                        html4 += '<p style="text-align: center">'+language[i]+'</p>'
                    }



                    $('#profile_username').html(name).trigger('create')
                    $('#profile_usercomment').html(comment).trigger('create')
                    $('#profile_userlink').html(link).trigger('create')

                    $('#testcareer').html(html2).trigger('create')
                    $('#testaward').html(html).trigger('create')
                    $('#testcert').html(html3).trigger('create')
                    $('#testlanguage').html(html4).trigger('create')




        },
        error:function (data){

        }
    })
}
