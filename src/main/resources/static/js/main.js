$(window).scroll(function(){
        var _top=$(window).scrollTop();
        if(_top>180){
            $(".menu").css({
                'position':'fixed',
                'top':'0'
            });
        }else{
            $(".menu").css({
                'position':'absolute',
            });
        }
    });
$(".tab").on("click","span",function(){
    $(this).addClass("select").siblings("span").removeClass("select");
    $(this).parents(".item").find(".item-content-list").eq($(this).index()).show().siblings("ul").hide();
})