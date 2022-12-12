$(function (){

})

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

function input_project (){

    let id= $('#id').val()
    let pjName  = $('#pjName').val()
    let pjShortInfo = $('#pjShortInfo')
    let pjLongInfo = $('#pjLongInfo')
    let pjLink = $('#pjLink').val()
    let language = $('#language').val()

    $.ajax({
        type:'post',
        url:'http://39.122.95.89:25917/saveProject',
        data:{"id":id, "pjName":pjName, "pjShortInfo":pjShortInfo, "pjLongInfo":pjLongInfo, "pjLink":pjLink,"language":language},
        crossDomain: true,
        dataType: 'json',
        success:function (data){


        },
        error:function (data){

        }
    })

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

