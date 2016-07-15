// 成功提示框
jQuery.extend({
	messageOk : function(msg,func){
		var html = '<div id="ajaxMessageId" ><div class="mask" style="z-index:10086;"></div><div id="myTip" class="dialog" style="border:1px solid #b2b2b2;"><div class="bSucces"><s></s>'+msg+'<a href="javascript:void(0);" class="cancelTwo"></a></div></div><div>';
		$('body').append(html);
		$("#ajaxMessageId > .mask").show();
		$("#myTip").show();
		if($.isFunction(func)){
			func();
		}
		setTimeout(function(){
			$('#ajaxMessageId').remove();
		},1000);
		$('.cancelTwo').click(function(){
			$('#ajaxMessageId').remove();
		});
	}
});

/**
 * Jquery Drop-down menu 1.0.0
 */
	var timeout = 500;
	var closetimer = 0;
	var ddmenuitem = 0;
	function jsddm_open() {
		jsddm_canceltimer();
		jsddm_close();
		ddmenuitem = $(this).find('ul').eq(0).css('visibility', 'visible');
	}
	function jsddm_open1() {
		$(".focuss #products").css("background", "#000");
		jsddm_canceltimer();
		jsddm_close();
		ddmenuitem = $(this).find('ul').eq(0).css('visibility', 'visible');
	}
	function jsddm_close() {
		if(ddmenuitem){
			ddmenuitem.css('visibility', 'hidden');
		}
	} 
	function jsddm_close1() {
		if(ddmenuitem){
			ddmenuitem.css('visibility', 'hidden');
			$(".focuss #products").css("background", "");
		}
	} 
	function jsddm_timer() {	
		closetimer = window.setTimeout(jsddm_close, timeout);
	}
	function jsddm_timer1() {
		closetimer = window.setTimeout(jsddm_close1, timeout);
	}
	function jsddm_canceltimer() {	
		if(closetimer) {	
			window.clearTimeout(closetimer);
			closetimer = null;}
		}
	document.onclick = jsddm_close;
	
	$(document).ready(function() {
		$('#userMenu > li').bind('mouseover', jsddm_open);
		$('#userMenu > li').bind('mouseout',  jsddm_timer);
		
		$('.focuss').bind('mouseover', jsddm_open1);
		$('.focuss').bind('mouseout',  jsddm_timer1);
	});
	