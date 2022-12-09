$(function (){

   createProject()
})



function createProject() {
    let length = 5
    let btnhtml = ''
    let projecthtml = ''

    for(let i=0 ; i<length ; i++){
        if(i==0){
            btnhtml +='<button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 0"></button>'

        }
        else if(i>=1){
            btnhtml += ' <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="' + i + '" aria-label="Slide ' + i + '"></button>'
        }
    }

    $('#myCarouselbtn').html(btnhtml).trigger("create");


    for(let i=0 ; i<length ; i++) {
        if (i == 0) {
            projecthtml += '<div class="carousel-item active" >\n' +
                '\n' +
                '                    <svg class="bd-placeholder-img " width="100%" height="100%" xmlns="http://www.w3.org/2000/svg"  aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>\n' +
                '\n' +
                '                    <div class="container" >\n' +
                '                        <div class="carousel-caption text-start">\n' +
                '                            <h1>맛집 어플</h1>\n' +
                '                            <p>사용 언어 : JAVA</p>\n' +
                '                            <p>주변의 맛집을 검색하는 Android APP입니다.</p>\n' +
                '                            <p><a class="btn btn-lg btn-primary" href="#">더 보기</a></p>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '\n' +
                '                </div>'
        } else if (i >= 1) {
            projecthtml += '<div class="carousel-item">\n' +
                '                <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>\n' +
                '\n' +
                '                <div class="container">\n' +
                '                    <div class="carousel-caption">\n' +
                '                        <h1>맛집 어플</h1>\n' +
                '                        <p>사용 언어 : JAVA </p>\n' +
                '                        <p>주변의 맛집을 검색하는 Android APP입니다.</p>\n' +
                '                        <p><a class="btn btn-lg btn-primary" href="#">더 보기</a></p>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </div>'
        }
    }
    $('#here').html(projecthtml).trigger("create");

}


