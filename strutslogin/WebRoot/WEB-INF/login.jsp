<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="北洋小伙伴,天津大学"/>
<meta name="author" content="刘文图熙1895"/>

<title>欢迎来到北洋小伙伴</title>

<link href="/strutslogin/css/style.css" type="text/css" rel="stylesheet"/>
<script src="/strutslogin/js/jquery-1.11.1.js" language="javascript"></script>
<script src="/strutslogin/js/main.js" language="javascript"></script>


</head>

<body background="/strutslogin/pic/bg.jpg" bgproperties="fixed" >

<div id="all">

  
<ul>
<li id="reg_log" >登陆/注册&nbsp;</li>

<li>加入收藏&nbsp;</li>
</ul>




<div class="main">

<div class="logo"><img src="/strutslogin/pic/logo.png"/></div>



 <div class="maintable">
<table   align="center" class="table1" >
  <tr>
	<td   nowrap="nowrap" class="featuretd" id="feature1"><a href="hot.html"><img src="/strutslogin/pic/11.png" class="picmask" id="hotmask" /><img src="/strutslogin/pic/hot.gif" class="hotpic" id="hot"></a>
  </td>
   
    <td   nowrap="nowrap" class="featuretd"><img src="/strutslogin/pic/11.png" class="picmask" /><img src="/strutslogin/pic/blog.gif" class="hotpic"></td>
    
    <td   nowrap="nowrap"><img src="/strutslogin/pic/love.gif"></td>
  </tr>

</table>
`
<table  align="center" class="table2" >

<tr>
	<td   nowrap="nowrap"><a href="eating/eating.jsp"><img src="/strutslogin/pic/eating.gif"></a>
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/outdoor.gif">
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/art.gif">
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/sports.gif">
  </td>
  
  </tr>
<tr>
	<td   nowrap="nowrap"><img src="/strutslogin/pic/bookexchange.gif">
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/game.gif">
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/learning.gif">
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/others.gif">
  </td>
  </tr>
</table>
</div>

</div>

</div>




<form action="/strutslogin/login.do" name="loginregister" method="post">
<div id="login_register">
<div class="loginhead"><p class="loginheadtext">Login/Register</p>
<input type="image" src="/strutslogin/pic/closebutton.png" id="closebutton" />
</div>


<div class="loginmain">
<table cellspacing="10px" style="float:left">
<caption>登陆</caption>
<tr>
<td colspan="2" nowrap="nowrap"><img src="/strutslogin/pic/username.png" /><input type="email" name="useremail" placeholder="  输入注册邮箱" size="25" class="tableinput"/> </td>
</tr>
<tr>
<td colspan="2" nowrap="nowrap" ><img src="/strutslogin/pic/password.png" /><input type="password"  name="password" placeholder="  输入密码" size="25"  class="tableinput"/> </td>
</tr>

<tr>
<td class="logintable" nowrap="nowrap"><input type="checkbox" value="remember"  />记住我</td>
<td class="logintable">忘记密码？</td>
</tr>

<tr>
<td colspan="2"  class="loginbutton" nowrap="nowrap"><input type="submit" value="登陆" name="loginsubmit" class="buttonblue"></td>
</tr>



</table>


<table cellspacing="10px" id="register" >
<caption>快速注册</caption>
<tr>
<td class="registertext" nowrap="nowrap">注册邮箱：</td>
<td nowrap="nowrap"><input type="email" name="registermail" size="20" class="tableinput" placeholder="输入注册邮箱" /></td>
</tr>

<tr>
<td class="registertext" nowrap="nowrap">密码：</td><td><input type="password" name="registerpassword" size="20" class="tableinput" placeholder="输入密码"/></td>
</tr>

<tr>
<td class="registertext" nowrap="nowrap">确认密码：</td><td><input type="password" placeholder="再次确认密码" name="repeatpassword" size="20" class="tableinput"/></td>
</tr>


<tr>
<td colspan="2" class="loginbutton" nowrap="nowrap"><input type="submit" value="注册" name="registersubmit" class="buttonred"/></td>
</tr>

</table>
</div>
</div>

</form>

<div id="mask"></div>
</body>
</html>
