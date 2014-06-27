
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.hsp.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>吃喝七里台</title>

<link href="./style.css" type="text/css" rel="stylesheet"/>
<script src="../js/jquery-1.11.1.js" language="javascript"></script>
<script src="./main.js" language="javascript"></script>


</head>

<body>
<div id="all">
<div class="headpic"><img src="./eating.png"></div>

<div class="main">
<div class="leftcom">

<div class="notice">
<div class="slidebarnotice">
<p class="slidebartext">公告栏</p>
</div>
</div>

<div class="navigator">
<ul class="navilist">
<li>首页</li>
</ul>

<p class="navitext"> 北洋特区</p>

<ul class="navilist">
<li>热门活动</li>
<li>北洋人的写字台</li>
<li>北洋缘</li>
</ul>

<p class="navitext">
分类活动</p>
<ul class="navilist">
<li>吃喝七里台</li>
<li>从北洋出发</li>
<li>北洋文艺苑</li>
<li>激情运动场</li>
<li>我要换书</li>
<li>逸游北洋</li>
<li>学霸去哪儿了</li>
<li>杂七杂八</li>
</ul>

<p class="navitext"> 个人中心</p>

<ul class="navilist">
<li>发起的活动</li>
<li>参加的活动</li>
</ul>


</div> 
</div>



<div class="maincontext">
<div class="top5">
<div class="slidebar">
<p class="slidebartext">热门TOP5</p>
</div>
</div>

<div class="new">
<div class="slidebar">
<p class="slidebartext" style="float:left">最新活动</p>
<input type="text" value="发起新活动" id="addnewbutton"/>
</div>


<table class="newtable" cellspacing="10px">
<%
List<Activity> activities = new QueryAllAction().queryAll();
for (Activity act : activities) {
%>
<tr>
<td colspan="3" class="newtabletitle"  ><%= act.getActivityName() %></td>
<td class="time" ><%= act.getFormatStartTime() %></td>
</tr>
<tr>
<td colspan="4" class="newtabletd" ><b>活动摘要：</b></td>
</tr>
<tr>
<td  class="newtabletd" >赞：</td>
<td  class="newtabletd" >参加人数：</td>
<td  class="newtabletd" ><%= act.getMaxNumber() %></td>
<td  class="newtabletd" id="showdetails"> 活动详情...</td>
</tr>

<tr>
<td colspan="4" class="newtabletd" ><hr /></td>
</tr>
<%
}
%>


</table>


</div>
</div>
</div>
</div>


<form action="/strutslogin/new-activity.do" name="newactivity" method="post">

<div id="addnew">
<div class="head"><p class="headtext">发起新活动</p>
<input type="image" src="closebutton.png" name="close_addnew" class="closebutton"  /></div>
<table cellspacing="10" class="addnewtable">
<tr>
<td class="tabletext">活动名称：</td>
<td colspan="5"><input type="text" size="30" name="activity_name" class="tableinput" />&nbsp;&nbsp;
</td>
</tr>
<tr>
<td class="tabletext">活动发起人：</td>
<td colspan="5"><input type="text" size="10" name="organizer" class="tableinput" />
</td>
</tr>

<tr>
<td class="tabletext">联系方式：<br /><small><small>（电话，QQ，微信，邮箱等）</small></small></td>
<td colspan="5"><input type="text" size="50"  maxlength="100" name="contact"  class="tableinput" />
</td>
</tr>

<tr>
<td class="tabletext">活动类别：</td>
<!--  <td colspan="5"><input type="text" size="20"  maxlength="100" name="activity_class"  class="tableinput" /> -->
<td colspan="5">
<select name="activity_class"  class="tableinput">
<option value="eating">吃喝七里台</option>
<option value="travel">从北洋出发</option>
<option value="art">北洋文艺苑</option>
<option value="sport">激情运动场</option>
<option value="book">我要换书</option>
<option value="game">逸游北洋</option>
<option value="study">学霸去哪儿了</option>
<option value="other">杂七杂八</option>
</select>
</td>
</tr>

<tr>
<td class="tabletext">活动摘要：</td>
<td colspan="5"><input type="text" size="50"  maxlength="100" name="activity_abstract"  class="tableinput" />
</td>
</tr>
<tr>
<td class="tabletext">活动地点：</td>
<td colspan="5"><input type="text" size="25"  maxlength="50" name="activity_place"  class="tableinput" />
</td>
</tr>

<tr>
<td class="tabletext">活动开始时间：<br /><small>(2014-05-09 08:30)</small></td>
<td colspan="5"><input type="text" size="4" maxlength="4" name="startyear"  class="tableinput" />-<input type="text" size="2" maxlength="2" name="startmonth"  class="tableinput" />-<input type="text" size="2" maxlength="2" name="startday"  class="tableinput" />&nbsp;&nbsp;<input type="text" size="2" maxlength="2" name="starthour"  class="tableinput" />:<input type="text" size="2" maxlength="2" name="startminute"  class="tableinput" />
</td>
</tr>

<tr>
<td class="tabletext">活动结束时间：</td>
<td colspan="5"><input type="text" size="4" maxlength="4" name="endyear"  class="tableinput" />-<input type="text" size="2" maxlength="2" name="endmonth"  class="tableinput" />-<input type="text" size="2" maxlength="2" name="endday"  class="tableinput" />&nbsp;&nbsp;<input type="text" size="2" maxlength="2" name="endhour"  class="tableinput" />:<input type="text" size="2" maxlength="2" name="endminute"  class="tableinput" />
</td>
</tr>

<tr>
<td class="tabletext">活动参与人数：</td>
<td colspan="2" ><input type="text" size="4"  maxlength="100" name="maxnumber"  class="tableinput" />
</td>
<td colspan="3"  class="tabletext" style="text-align:left">参与人范围：
<!-- <input type="text" size="15"  maxlength="100" name="range"  class="tableinput" style="text-align:left" />  -->
<select name="range">
  <option value="student">学生</option>
  <option value="anyone">任意</option>
</select>
</td>
</tr>

<tr>
<td class="tabletext" style="vertical-align:top">活动详细介绍：</td>
<td colspan="5" ><textarea cols="50" rows="15"  name="detail"></textarea>
</td>
</tr>

<tr>
<td colspan="6" style="text-align:center"><input type="submit" name="goactivity" value="发起活动" class="buttonblue"></td>
</tr>
<tr>
<td colspan="6" style="text-align:center"><input type="text" value="取消" name="cancel_addnew" class="buttonred" /></td>
</tr>
</table>


</div>
</form>

<div id="details">
<div class="head"><p class="headtext">活动详情</p>
<input type="image" src="closebutton.png" id="closedetails" class="closebutton"  /></div>
<table cellspacing="10" class="detailstable">
<tr>
<td colspan="3" class="newtabletitle">这是一个很长很很长长的标题，必须得写满20字</td>
<td  colspan="1" class="time" >2014.5.14 15:23</td>
</tr>
<tr>
<td colspan="2" class="detailstabletd">活动发起人：</td>
<td colspan="2" class="detailstabletd" >联系方式:</td>
</tr>
<tr>
<td colspan="2" class="detailstabletd">活动类别：</td>
<td colspan="2" class="detailstabletd" >活动地点:</td>
</tr>
<tr>
<td colspan="2" class="detailstabletd">开始时间：</td>
<td colspan="2" class="detailstabletd" >结束时间:</td>
</tr>

<tr>
<td colspan="2" class="detailstabletd">参与人数：</td>
<td colspan="2" class="detailstabletd">参与人范围：</td>
</tr>
<tr>
<td colspan="4" class="detailstabletd">活动详情：</td>
</tr>

<tr>
<td class="detailstabletd"></td>
<td class="detailstabletd">赞：</td>
<td class="detailstabletd">参加人数：</td>
<td class="detailstabletd"></td>
</tr>

<tr>
<td class="detailstabletd"></td>
<td colspan="2" class="detailstabletd" style="text-align:center"><input type="text" value="我要参加" class="buttonblue" id="wein"/></td>
<td class="detailstabletd"></td>
</tr>

<tr>
<td class="detailstabletd"></td>
<td colspan="2" class="detailstabletd" style="text-align:center"><input type="text" value="取消" class="buttonred" id="cancel_details"/></td>
<td class="detailstabletd"></td>
</tr>



</table>
</div>



<div id="participate">
<form action="#" name="participant" method="post">
<div class="head"><p class="headtext">我要参加</p>
<input type="image" src="closebutton.png" class="closebutton" id="close_participate"/></div>
<table cellspacing="10" class="participatetable">
<tr>
<td class="ptabletext">称呼：</td>
<td><input type="text" size="20"  maxlength="30" name="p_name"  class="tableinput" /></td>
</tr>
<tr>
<td class="ptabletext">联系方式：</td>
<td><input type="text" size="35"  maxlength="30" name="p_contact"  class="tableinput" /></td>
</tr>
<tr>
<td class="ptabletext">参与活动时间：</td>
<td><input type="text" size="35"  maxlength="30" name="p_time"  class="tableinput" /></td>
</tr>
<tr>
<td class="ptabletext">备注：</td>
<td><input type="text" size="35"  maxlength="30" name="p_others"  class="tableinput" /></td>
</tr>
<tr>
<td colspan="2" ><input type="submit" name="iparticipate" value="参加" class="buttonblue" style="margin-left:120px;"/></td>
</tr>

</table>
</form>
</div>
<div id="mask"></div>

</body>
</html>
