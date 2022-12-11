

$(function (){


})



function readURL_portfolioedit(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#pf_image_section').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

// 이벤트를 바인딩해서 input에 파일이 올라올때 (input에 change를 트리거할때) 위의 함수를 this context로 실행합니다.
$("#pf_imgInput").change(function(){
    readURL_portfolioedit(this);
});



