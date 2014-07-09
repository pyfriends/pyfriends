// JavaScript Document


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





jQuery(function($){
	 $.datepicker.regional['zh-CN']={
			 dayNamesMin:["日","一","二","三","四","五","六"],
				
	              dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
				monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
				monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
				showMonthAfterYear:true,
				dateFormat:"yy-mm-dd",
				changeMonth:true,
				changeYear:true,
				nextText:"下个月",
				preText:"上个月"
	 };
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
});



$(document).ready(function(){
	var h_page=$(document).height();

	$('#mask').css({"height":h_page+'px','top':'0px'});
	

	
	
	//各个层的显示和隐藏
	$('#addnewbutton').click(function()
	{	var s_top=$(document).scrollTop();
		$('#addnew').css('top',s_top+50+'px').fadeIn('slow').show();
	$('#mask').fadeIn('slow').show();
	
		}),
	$("#addnewclose").click(function()
	{
		$('#addnew').fadeOut('slow');
		$('#mask').fadeOut('slow');
		}),	
	
	$("input[name='cancel_addnew']").click(function()
	{
		$('#addnew').fadeOut('slow');
		$('#mask').fadeOut('slow');
		}),	
		
		
	$('#showdetails').click(function()
	{	var s_top=$(document).scrollTop();
		$('#details').css('top',s_top+50+'px').fadeIn('slow').show();
		$('#mask').fadeIn('slow').show();
		}),
		
		$("#closedetails").click(function()
	{
		$('#details').fadeOut('slow');
		$('#mask').fadeOut('slow');
		}),	
		
		$("#cancel_details").click(function()
	{
		$('#details').fadeOut('slow');
		$('#mask').fadeOut('slow');
		}),	
		
		$('#wein').click(function()
	{	var s_top=$(document).scrollTop();
		$('#participate').css('top',s_top+100+'px').fadeIn('slow').show();
		}),
		
		$("#close_participate").click(function()
	{
		$('#participate').fadeOut('slow');

		}),
		
	
	
		
		
		
		
	//拖拽控件	
		
		$("#addnew").draggable(
				{cursor:"move",
				 handle:"#addnewhead",			
					
				}),	
		$("#participate").draggable(
			{cursor:"move",
			 handle:"#participatehead",			
							
			   }),
		$("#details").draggable(
			{cursor:"move",
			 handle:"#detailshead",			
										
				 });
	
	//日期选择器

	$("#startdate").datepicker();
	$("#edddate").datepicker();		
	
	//选择表生成
		for(i=0;i<24;i++)
			{	if(i<10)
				{$("#starthour").append("<option>"+"0"+i+"</option>");
				$("#endhour").append("<option>"+"0"+i+"</option>");}
				
			
				else if(i>=10 && i<24) 
				{$("#starthour").append("<option>"+i+"</option>");
				$("#endhour").append("<option>"+i+"</option>");}
			
				
			
				
			
			}

		

			   
		
	
	
	});




