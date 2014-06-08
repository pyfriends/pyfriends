// JavaScript Document


$(document).ready(function(){
	var h_page=$(document).height();
	var w_page=$(document).width();
	$('#mask').css({"height":h_page+'px',"width":w_page+'px','left':'0px','top':'0px'});
	

	$('#addnewbutton').click(function()
	{	var s_top=$(document).scrollTop();
		$('#addnew').css('top',s_top+50+'px').fadeIn('slow').show();
	$('#mask').fadeIn('slow').show();
	
		})
	$("input[name='close_addnew']").click(function()
	{
		$('#addnew').fadeOut('slow');
		$('#mask').fadeOut('slow');
		})	
	
	$("input[name='cancel_addnew']").click(function()
	{
		$('#addnew').fadeOut('slow');
		$('#mask').fadeOut('slow');
		})	
		
		
	$('#showdetails').click(function()
	{	var s_top=$(document).scrollTop();
		$('#details').css('top',s_top+50+'px').fadeIn('slow').show();
		$('#mask').fadeIn('slow').show();
		})
		
		$("#closedetails").click(function()
	{
		$('#details').fadeOut('slow');
		$('#mask').fadeOut('slow');
		})	
		
		$("#cancel_details").click(function()
	{
		$('#details').fadeOut('slow');
		$('#mask').fadeOut('slow');
		})	
		
		$('#wein').click(function()
	{	var s_top=$(document).scrollTop();
		$('#participate').css('top',s_top+100+'px').fadeIn('slow').show();
		})
		
		$("#close_participate").click(function()
	{
		$('#participate').fadeOut('slow');

		})	
	
	
	})




