$(function (){

})

let img =''
let img2 =''
let imagename=''

window.addEventListener('load', () => {
    const forms = document.getElementsByClassName('validation-form');

    Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
            if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
            }

            form.classList.add('was-validated');
        }, false);
    });
}, false);


function input_memberdb (){

    let id= $('#id').val()
    let nickname  = $('#name').val()
    let pw= $('#password').val()
    let pwchk= $('#passwordcheck').val()

    let comment= $('#comment').val()
    let link= $('#link').val()

    let form = $('#fileRegister')[0];
    var formData = new FormData(form);
    formData.append('id',id);
    formData.append('name',nickname);
    formData.append('password',pw);
    formData.append('comment',comment);
    formData.append('link',link);

    console.log($('#image').file);
    console.log('이이하');
    console.log(formData);
    console.log(formData.get('imgs'));
    console.log(formData.get('id'));



    if(pw===pwchk){
        $.ajax({
            type:'post',
            url:'http://39.122.95.89:25917/SignUp',
            processData: false,
            contentType: false,
            //data:{"id":id,"password":pw,"name":nickname,"image":img,"comment":comment,"link":link,"imageName":imagename},
            data:formData,
            crossDomain: true,
            dataType: 'json',
            success:function (data){
                var link ='http://localhost:63342/spring_school/templates/yoostudy_home.html?_ijt=8obg05gacnnlkb8mhbno3mbb4n&_ij_reload=RELOAD_ON_SAVE'
                 location.href=link;



            },
            error:function (data){

            }
        })
    }
    else{
        alert("비밀번호가 일치하지않습니다. 다시한번 확인해주세요.")
    }
}

function readURL(input) {
    console.log("asd")
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#image_section').attr('src', e.target.result);
            img=e.target.result

            img = e.target.result;

            console.log("보낸 이미지값",img)



        }

        reader.readAsDataURL(input.files[0]);
        let test =document.getElementById('imgInput').files;
        imagename = test[0].name
        console.log("이미지 파일이름:",imagename)



    }
}




window.addEventListener('load', () => {
    const forms = document.getElementsByClassName('validation-form');

    Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
            if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
            }

            form.classList.add('was-validated');
        }, false);
    });
}, false);

