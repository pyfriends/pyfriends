// JavaScript Document


///placeholder插件/



//主体

//

//
$(function($) {
    //判断浏览器是否支持 placeholder属性
    function isPlaceholder() {
        var input = document.createElement('input');
        return 'placeholder' in input;
    }

    function changeToOriginalColor(self) {
        var index = $(self).index();
        var color = originalColor[$(self).index()];
        $(self).css('color', color);
    }

    if(!isPlaceholder()) {
        var texts = $(':text');
        var len = texts.length;
        var originalColor = [];
        for(var i = 0; i < len; i++) {
            var self = texts[i];
            var placeholder = $(self).attr('placeholder');
            if($(self).val() == "" && placeholder != null) {
                $(self).val(placeholder);
                originalColor[i] = $(self).css('color');
                $(self).css('color', '#777');
            }
        }
        texts.focus(function() {
            if($(this).attr('placeholder') != null && $(this).val() == $(this).attr('placeholder')) {
                $(this).val('');
                changeToOriginalColor(this);
            }
        }).blur(function() {
            if($(this).attr('placeholder') != null && ($(this).val() == '' || $(this).val() == $(this).attr('placeholder'))) {
                $(this).val($(this).attr('placeholder'));
                $(this).css('color', '#777');
            }
        });
    }
});



















$(document).ready(function(){
	var h_page=$(document).height();


	$('#mask').css({"height":h_page+'px','top':'0px'});

	$('#reg_log').click(function()
	{	
		$('#login_register').fadeIn('slow').show();
	$('#mask').fadeIn('slow').show();
		}),
	$('#closebutton').click(function()
	{
		$('#login_register').fadeOut('slow');
		$('#mask').fadeOut('slow');
	
		}),
		
		
			
		$('#feature1').hover(
		function(){
		$('#hotmask').fadeIn(500);
		},function(){$('#hotmask').fadeOut(500);	}),
		
		
		$("#login_register").draggable(
				{cursor:"move",
				 handle:"#loginhead",			
					
				}),

	
		
		 $("#registerform").validate({

		        rules: {
		   	registermail: {
		    required: true,
		    email: true
		   },
		   registerpassword: {
			   required: function(){
			    	if($("#registerpassword").attr("value")==null)
			    		{return false;}
			    	else return true;
			    		},
		    rangelength:[6,12]
		   },
		   repeatpassword: {
		    required: function(){
		    	if($("#repeatpassword").attr("value")==null)
	    		{return false;}
	    	else return true;
	    		},
		    equalTo: "#registerpassword"
		   }
		  },
		        messages: {
		    registermail: {
		    required: "",
		    email: "请输入正确的邮箱"
		   },
		   registerpassword: {
		    required: "",
		    rangelength: "密码长度为6-12位"
		   },
		   repeatpassword: {
		    required: "",
		    equalTo: "两次密码不相符"
		   }
		  },
		  
		  errorPlacement: function(error, element) {  
			  error.appendTo(element.parent());
			}
		  
		    });
		

	$('input[placeholder][type=text]').placeholder();
	
	});





	
