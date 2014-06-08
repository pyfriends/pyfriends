// JavaScript Document


///placeholder插件/
(function ($) {
    $.fn.extend({
        placeholder : function () {
            if ("placeholder" in document.createElement("input")) {
                return this //如果原生支持placeholder属性，则返回对象本身
            } else {

                return this.each(function () {				
                    var _this = $(this);
                    _this.val(_this.attr("placeholder")).focus(function () {
                        if (_this.val() === _this.attr("placeholder")) {
                            _this.val("")
                        }
                    }).blur(function () {
                        if (_this.val().length === 0) {
                            _this.val(_this.attr("placeholder"))
                        }
                    })
                })
            }
        }
    })
})(jQuery);



//主体
$(document).ready(function(){
	var h_page=$(document).height();
	var w_page=$(document).width();

	$('#mask').css({"height":h_page+'px',"width":w_page+'px','top':'0px','left':'0px'});
	$('#reg_log').click(function()
	{	
		$('#login_register').fadeIn('slow').show();
	$('#mask').fadeIn('slow').show();
		})
	$('#closebutton').click(function()
	{
		$('#login_register').fadeOut('slow');
		$('#mask').fadeOut('slow');
	
		})	
		
		
			
		$('#feature1').hover(
		function(){
		$('#hotmask').fadeIn(500);
		},function(){$('#hotmask').fadeOut(500);	})
		
$('input[placeholder][type=text]').placeholder();
	

		
			
	
		
			
			
			
	
	
	
	})





	
