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
    let nickname  = $('#nickname').val()
    let pw= $('#password').val()
    let pwchk= $('#passwordcheck').val()

    let comment= $('#comment').val()
    let link= $('#link').val()







    if(pw===pwchk){
        $.ajax({
            type:'post',
            url:'http://39.122.95.89:25917/SignUp',
            data:{"id":id,"password":pw,"name":nickname,"image":img,"comment":comment,"link":link,"imageName":imagename},
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

