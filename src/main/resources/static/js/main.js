$(window).on('scroll', function() {
    var windowScrollHeight = $(window).scrollTop();
    if(windowScrollHeight > 200){
     // document.getElementsByClassName('navbar')[0].style.bottom = '0';
      //$('.navbar-brand').css('font-size', '20px');
    }
    if(windowScrollHeight <= 200){
         //document.getElementsByClassName('navbar')[0].style.bottom = '0';
    }
  })