$(function(){
	var numpic = $('#slides li').size()-1;
	var nownow = 0;
	var inout = 0;
	var TT = 0;
	var SPEED = 5000;


	$('#slides li').eq(0).siblings('li').css({'display':'none'});


	var ulstart = '<div style="position:relative; width:1000px; margin:0 auto; height:19px;"><ul id="pagination">',
		ulcontent = '',
		ulend = '</ul></div>';
	ADDLI();
	var pagination = $('#pagination li');

	pagination.eq(0).addClass('current')

	function ADDLI(){
		for(var i = 0; i <= numpic; i++){
			ulcontent += '<li>' + '<a>' + (i+1) + '</a>' + '</li>';
		}

		$('#slides').after(ulstart + ulcontent + ulend);	
	}

	pagination.on('click',DOTCHANGE)

	function DOTCHANGE(){

		var changenow = $(this).index();

		$('#slides li').eq(nownow).css('z-index','900');
		$('#slides li').eq(changenow).css({'z-index':'800'}).show();
		pagination.eq(changenow).addClass('current').siblings('li').removeClass('current');
		$('#slides li').eq(nownow).fadeOut(400,function(){$('#slides li').eq(changenow).fadeIn(500);});
		nownow = changenow;
	}

	pagination.mouseenter(function(){
		inout = 1;
	})

	pagination.mouseleave(function(){
		inout = 0;
	})

	function GOGO(){

		var NN = nownow+1;

		if( inout == 1 ){
			} else {
			if(nownow < numpic){
			$('#slides li').eq(nownow).css('z-index','900');
			$('#slides li').eq(NN).css({'z-index':'800'}).show();
			pagination.eq(NN).addClass('current').siblings('li').removeClass('current');
			$('#slides li').eq(nownow).fadeOut(400,function(){$('#slides li').eq(NN).fadeIn(500);});
			nownow += 1;

		}else{
			NN = 0;
			$('#slides li').eq(nownow).css('z-index','900');
			$('#slides li').eq(NN).stop(true,true).css({'z-index':'800'}).show();
			$('#slides li').eq(nownow).fadeOut(400,function(){$('#slides li').eq(0).fadeIn(500);});
			pagination.eq(NN).addClass('current').siblings('li').removeClass('current');

			nownow=0;

			}
		}
		TT = setTimeout(GOGO, SPEED);
	}
	
	TT = setTimeout(GOGO, SPEED); 

})

//$(function(){
//	var numpic = $('#active_slides li').size()-1;
//	var nownow = 0;
//	var inout = 0;
//	var TT = 0;
//	var SPEED = 5000;
//
//
//	$('#active_slides li').eq(0).siblings('li').css({'display':'none'});
//
//
//	var ulstart = '<div style="position:relative; width:1000px; margin:0 auto; height:19px;"><ul id="active_pagination">',
//		ulcontent = '',
//		ulend = '</ul></div>';
//	ADDLI();
//	var active_pagination = $('#active_pagination li');
//	//var active_paginationwidth = $('#active_pagination').width();
////	$('#active_pagination').css('margin-left',(500-active_paginationwidth))
//
//	active_pagination.eq(0).addClass('ac_current')
//
//	function ADDLI(){
//		//var lilicount = numpic + 1;
//		for(var i = 0; i <= numpic; i++){
//			ulcontent += '<li>' + '<a >' + (i+1) + '</a>' + '</li>';
//		}
//
//		$('#active_slides').after(ulstart + ulcontent + ulend);
//	}
//
//	active_pagination.on('click',DOTCHANGE)
//
//	function DOTCHANGE(){
//
//		var changenow = $(this).index();
//
//		$('#active_slides li').eq(nownow).css('z-index','900');
//		$('#active_slides li').eq(changenow).css({'z-index':'800'}).show();
//		active_pagination.eq(changenow).addClass('ac_current').siblings('li').removeClass('ac_current');
//		$('#active_slides li').eq(nownow).fadeOut(400,function(){$('#active_slides li').eq(changenow).fadeIn(500);});
//		nownow = changenow;
//	}
//
//	active_pagination.mouseenter(function(){
//		inout = 1;
//	})
//
//	active_pagination.mouseleave(function(){
//		inout = 0;
//	})
//
//	function GOGO(){
//
//		var NN = nownow+1;
//
//		if( inout == 1 ){
//		} else {
//			if(nownow < numpic){
//				$('#active_slides li').eq(nownow).css('z-index','900');
//				$('#active_slides li').eq(NN).css({'z-index':'800'}).show();
//				active_pagination.eq(NN).addClass('ac_current').siblings('li').removeClass('ac_current');
//				$('#active_slides li').eq(nownow).fadeOut(400,function(){$('#active_slides li').eq(NN).fadeIn(500);});
//				nownow += 1;
//
//			}else{
//				NN = 0;
//				$('#active_slides li').eq(nownow).css('z-index','900');
//				$('#active_slides li').eq(NN).stop(true,true).css({'z-index':'800'}).show();
//				$('#active_slides li').eq(nownow).fadeOut(400,function(){$('#active_slides li').eq(0).fadeIn(500);});
//				active_pagination.eq(NN).addClass('ac_current').siblings('li').removeClass('ac_current');
//
//				nownow=0;
//
//			}
//		}
//		TT = setTimeout(GOGO, SPEED);
//	}
//
//	TT = setTimeout(GOGO, SPEED);
//
//})

$(function(){
	$(".about_zzrz ul li").click(function(){
		var Height ;
		var Left;
		var Top;
		var C_width;
		var C_height;
		var Index = 0;
		Index = $(this).index();
		var Src =$(this).find("img").attr("src");
		$(".company_img_show").find("img").attr("src",Src);
		C_width = document.documentElement.clientWidth;
		C_height = document.documentElement.clientHeight;
		Left = C_width/2 -345;
		Top = C_height/2 -390;

		Height = $("html").height();
		$(".djs-company_zj_bj").css({
			"display":"block",
			"height":Height
		});
		$(".djs-company_zj_show").css({
			"left":Left,
			"top":Top
		});
		$(".detail_img_tk .detail_img_error").click(
			function(){
				$(".djs-company_zj_bj").css("display","none");
			}
		);
		$(".djs-company_zj_bj").click(
			function(){
				$(".djs-company_zj_bj").css("display","none");
			}
		);

	});
	$(".member_left ul li").click(function(){
		var sub_xiala = $(this).find('.sub_xiala');
		var xiala_img = $(this).find('img');
		if(sub_xiala.css('display')=='none'){
			sub_xiala.show(0);
			xiala_img.removeClass('member_up');
			$(this).find(".member_list_big").css({
				"border-bottom":"0px solid #E2E4EA",
				"background-color":"#EBEBEB",
				"height":"40px"
			})

		}else{
			sub_xiala.hide(0);
			xiala_img.addClass('member_up');
			$(this).find(".member_list_big").css({
				"border-bottom":"1px solid #E2E4EA",
				"border-top":"1px solid #E2E4EA",
				"background-color":"#fff",
				"height":"38px"
			})
		}
	});
	$(".member_top_icon i").hover(function(){
		var Index = 0;
		Index = $(this).index();
		$(".member_icon_des ul li").eq(Index).fadeIn(300).siblings().fadeOut();
	},function(){
		var Index = 0;
		Index = $(this).index();
		$(".member_icon_des ul li").eq(Index).fadeOut();
	});

	$("#member_little").hover(function(){
		$("#member_little").css("display","block");
	},function(){
		$("#member_little").css("display","none");
	});
	$(".inD-list1 .inD-ul1 li").click(function(){
		var Height ;
		var Left;
		var Top;
		var C_width;
		var C_height;
		var Index = 0;
		Index = $(this).index();
		var Src =$(this).find("img").attr("src");
		$(".detail_img_show").find("img").attr("src",Src);
		C_width = document.documentElement.clientWidth;
		C_height = document.documentElement.clientHeight;
		Left = C_width/2 -480;
		Top = C_height/2 -350;

		Height = $("html").height();
		$(".djs-investDetail_zj_bj").css({
			"display":"block",
			"height":Height
		});
		$(".djs-investDetail_zj_show").css({
			"left":Left,
			"top":Top
		});
		$(".detail_img_tk .detail_img_error").click(
			function(){
				$(".djs-investDetail_zj_bj").css("display","none");
			}
		);
		$(".djs-investDetail_zj_bj").click(
			function(){
				$(".djs-investDetail_zj_bj").css("display","none");
			}
		);

	});
	$(".top_list ul li").hover(function(){
		$(this).find("img").attr("src","pic/jt_02.png");
	},function(){
		$(this).find("img").attr("src","pic/jt_01.png");
	});
	$(".detail_desR_a").click(function(){
		var Height ;
		var Left;
		var Top;
		var C_width;
		var C_height;
		C_width = document.documentElement.clientWidth;
		C_height = document.documentElement.clientHeight;
		Left = C_width/2 -132;
		Top = C_height/2 -112;

		Height = $("html").height();
		$(".detail_tk").css({
			"display":"block",
			"height":Height
		});
		$(".detail_tk .detail_tk_bd").css({
			"left":Left,
			"top":Top
		});
	});
	$(".detail_error,.detail_tk_qx").click(
		function(){
			$(".detail_tk").css("display","none");
		}
	);
var ul_w;
var total =$(".ryq_list ul li").size();
ul_w = total*172+"px";
$(".ryq_list ul").css("width",ul_w);
var num = 0;

$(".ryq_show .curr-next").click(function(){
	num ++;
	var max =$(".ryq_list ul li").size()-5;
	if(num > max)
	{
		num = 0;
	}
	$(".ryq_show .ryq_list ul").css("left",-172*num+"px");
});


$(".ryq_show .curr-pre").click(function(){
	num --;
	if(num < 0)
	{
		num = 0;
	}
	$(".ryq_show .ryq_list ul").css("left",-172*num+"px");
});
$(".djs_one_product_Ul p a").hover(function(){
	$(".djs_one_product_it").fadeIn(300);
},function(){
	$(".djs_one_product_it").fadeOut();
})
$(".djs_bztx_1 i").hover(function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_1 ul li").eq(Index).fadeIn(300).siblings().fadeOut();
},function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_1 ul li").eq(Index).fadeOut();
});
$(".djs_bztx_2 i").hover(function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_2 ul li").eq(Index).fadeIn(300).siblings().fadeOut();
},function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_2 ul li").eq(Index).fadeOut();
});
$(".djs_bztx_3 i").hover(function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_3 ul li").eq(Index).fadeIn(300).siblings().fadeOut();
},function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_3 ul li").eq(Index).fadeOut();
});
$(".djs_bztx_4 i").hover(function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_4 ul li").eq(Index).fadeIn(300).siblings().fadeOut();
},function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_4 ul li").eq(Index).fadeOut();
});
$(".djs_bztx_5 i").hover(function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_5 ul li").eq(Index).fadeIn(300).siblings().fadeOut();
},function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_5 ul li").eq(Index).fadeOut();
});
$(".djs_bztx_6 i").hover(function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_6 ul li").eq(Index).fadeIn(300).siblings().fadeOut();
},function(){
	var Index = 0;
	Index = $(this).index();
	$(".djs_bztx_wz_6 ul li").eq(Index).fadeOut();
});
});
$(function(){
	$("#djs_safe_list").hover(function(){
		$("#djs_safe_list").css("display","block");
	},function(){
		$("#djs_safe_list").css("display","none");
	})
});
$(function(){
	$("#djs_about_list").hover(function(){
		$("#djs_about_list").css("display","block");
	},function(){
		$("#djs_about_list").css("display","none");
	})
});
