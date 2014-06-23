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
<script src="/strutslogin/js/jquery.validate.js" language="javascript"></script>
<script src="/strutslogin/js/jquery.metadata.js" language="javascript"></script>
<script src="/strutslogin/js/main.js" language="javascript"></script>


</head>

<body background="/strutslogin/pic/bg.jpg" bgproperties="fixed" >

<div id="all">

  
<ul>
<li id="reg_log" >登录/注册&nbsp;</li>

<li>加入收藏&nbsp;</li>
</ul>




<div class="main">

<div class="logo"><img src="/strutslogin/pic/logo.png"/></div>



 <div class="maintable">
<table   align="center" class="table1" >
  <tr>
	<td   nowrap="nowrap" class="featuretd" id="feature1"><a href="hot.html" ><img src="/strutslogin/pic/11.png" class="picmask" id="hotmask" /><img src="/strutslogin/pic/hot.gif" class="pic" id="hot"/></a>
  </td>
   
    <td   nowrap="nowrap" class="featuretd"><img src="/strutslogin/pic/11.png" class="picmask" /><img src="/strutslogin/pic/blog.gif" class="pic"/></td>
    
    <td   nowrap="nowrap"><img src="/strutslogin/pic/love.gif"/></td>
  </tr>

</table>

<table  align="center" class="table2" >

<tr>
	<td   nowrap="nowrap"><a href="eating/eating.html" ><img src="/strutslogin/pic/eating.gif" class="pic" /></a>
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/outdoor.gif"/>
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/art.gif"/>
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/sports.gif"/>
  </td>
  
  </tr>
<tr>
	<td   nowrap="nowrap"><img src="/strutslogin/pic/bookexchange.gif"/>
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/game.gif"/>
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/learning.gif"/>
  </td>
  	<td   nowrap="nowrap"><img src="/strutslogin/pic/others.gif"/>
  </td>
  </tr>
</table>
</div>

</div>

</div>





<div id="login_register">
<div class="loginhead"><p class="loginheadtext">Login/Register</p>
<img src="/strutslogin/pic/closebutton.png" id="closebutton" />
</div>

<form action="/strutslogin/login.do" id="loginform" method="post">

<div id="login">
<div class="formhead">登录</div>

<div class="formdiv"><label for="useremail" ><img src="/strutslogin/pic/username.png" /></label><input type="email" id="useremail" name="useremail" placeholder="  输入注册邮箱" size="20" class="tableinput"/>
</div>
<br />
<div class="formdiv"><label for="password" ><img src="/strutslogin/pic/password.png" /></label><input type="password" id="password" name="password" placeholder="  输入密码" size="20"  class="tableinput"/>
</div>
<br />
<div class="formdiv"><input type="checkbox" id="rememberme" value="remember" checked />记住我  &nbsp &nbsp 忘记密码？</div>
<br />
<div class="formbutton"><input type="submit" value="登录" name="loginsubmit" class="buttonblue"/></div>
</div>
</form>



<form action="/strutslogin/login.do" id="registerform" method="post">
<div id="register" >
<div class="formhead">快速注册</div>

<div class="formdiv"><label for="registermail">注册邮箱：</label>
<input type="text" id="registermail" name="registermail" size="20" class="tableinput" placeholder="输入注册邮箱" /></div>
<br/>
<div class="formdiv"><label for="registerpassword">密  &nbsp &nbsp  &nbsp 码：</label><input type="password" id="registerpassword" name="registerpassword" size="20" class="tableinput" placeholder="输入6-12位密码" /></div>
<br/>
<div class="formdiv"><label for="repeatpassword">确认密码：</label><input type="password"  id="repeatpassword" name="repeatpassword"  size="20" class="tableinput" placeholder="再次输入密码" /></div>
<br/>
<div class="formbutton"><input type="submit" value="注册" name="registersubmit" class="buttonred"/></div>
</div>

</form>
</div>


<div id="mask"></div>
</body>
</html>
