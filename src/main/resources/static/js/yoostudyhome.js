$(function (){

   test();

})

function test() {
    let clicked = ''
    $(".dropdown-menu li").click(function(){
        clicked = ($(this).text());
        $("#drop-btn").text(clicked) ;
        $("#test-text").text(clicked);

        create(clicked)

    })
}

function create(text) {
    let length = 16
    let html = ''
    for(let i=0 ; i<length ; i++){
        html += '<div class="col-lg-4" >\n' +
            '                <svg class="bd-placeholder-img rounded-circle"style="" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>\n' +
            '\n' +
            '                <h2 class="fw-normal" id="test-text">'+text+'</h2>\n' +
            '                <p>Some representative placeholder content for the three columns of text below the carousel. This is the first column.</p>\n' +
            '                <p><a class="btn btn-secondary"style="background-color: whitesmoke;color: black" href="#">View details &raquo;</a></p>\n' +
            '            </div>'

    }
    $('#rowtest').html(html).trigger("create");

}


