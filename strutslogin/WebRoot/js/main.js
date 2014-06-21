// JavaScript Document


///placeholder插件/



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
		


	
	})





	
