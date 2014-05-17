// JavaScript Document

var div0,div1;
window.onload=function()
{
var w=document.body.scrollWidth; 
var h=document.body.scrollHeight;
div0=document.getElementById('all');
div1=document.getElementById('mask');
div0.style.width=w+"px";
div0.style.height=h+"px";
div1.style.width=w+"px";
div1.style.height=h+"px";
}




function showlogin()
{	 var vis=document.getElementById('login_register');
		vis.style.display='block';
div1=document.getElementById('mask');
	div1.style.display='block';

	
	}
	
function hidelogin()
{	 var vis=document.getElementById('login_register');
		vis.style.display='none';
		
div1=document.getElementById('mask');
	div1.style.display="none";

	
	}
	
