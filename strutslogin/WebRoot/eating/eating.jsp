
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.hsp.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>吃喝七里台</title>


<link href="../css/jquery-ui.css" type="text/css" rel="stylesheet"/>
<link href="./style_eating.css" type="text/css" rel="stylesheet"/>

<script src="../js/jquery-1.11.1.js" language="javascript"></script>
<script src="./main_eating.js" language="javascript"></script>
<script src="../js/jquery-ui.js" language="javascript"></script>

</head>

<body>

<div id="personal">  
<ul>
<li id="reg_log" >登录/注册&nbsp;</li>

<li>加入收藏&nbsp;</li>
</ul>

</div>



<div id="all">
<div class="headpic"><img src="./eating.png" /></div>

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

<%
List<Activity> activities = new QueryAllAction().queryAll();
for (Activity act : activities) {
%>
<table class="newtable" cellspacing="10px">

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
<td colspan="4" class="newtabletd" ><hr/></td>
</tr>


</table>


<%
}
%>
</div>
</div>
</div>
</div>





<div id="participate">

<div class="head" id="participatehead"><p class="headtext">我要参加</p>
<img src="closebutton.png"  class="closebutton" id="close_participate"/></div>
<form action="" name="participant" method="post">
<div id="participateform">
<div id="participateform_label">
<div><label>称呼：</label><br/></div>
<div><label>联系方式：</label><br/></div>
<div><label>参与活动时间：</label><br/></div>
<div><label>备注：</label></div>
</div>

<div id="participateform_input">
<div><input type="text" size="20"  maxlength="30" name="p_name"  class="tableinput" /></div>
<div><input type="text" size="35"  maxlength="30" name="p_contact"  class="tableinput" /></div>
<div><input type="text" size="35"  maxlength="30" name="p_time"  class="tableinput" /></div>
<div><input type="text" size="35"  maxlength="30" name="p_others"  class="tableinput" /></div>
<div><input type="submit" name="iparticipate" value="参加" class="buttonblue" style="margin-left:150px;"/></div>
</div>
</div>
</form>
</div>

<div id="details">
<div class="head" id="detailshead"><p class="headtext">活动详情</p>
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

<div id="addnew">
<div class="head" id="addnewhead" ><p class="headtext">发起新活动</p>
<img src="closebutton.png" id="addnewclose" class="closebutton"  /></div>
<form action="/strutslogin/new-activity.do" name="newactivity" method="post">

<div id="addnewform">
<div id="addnewform_label">
<div><label>活动名称：</label><br/></div>
<div><label>活动发起人：</label><br/></div>
<div><label>联系方式：</label><br/></div>
<div><label>活动类别：</label><br/></div>
<div><label>活动摘要：</label><br/></div>
<div><label>活动地点：</label><br/></div>
<div><label>活动开始时间：</label><br/></div>
<div><label>活动结束时间：</label><br/></div>
<div><label>活动参与人数：</label><br/></div>
<div><label>活动详细介绍：</label></div>
</div>

<div id="addnewform_input">
<div><input type="text" size="20" maxlength="20" name="activity_name" class="tableinput" placeholder="不超过20字的活动名"/></div>
<div><input type="text" size="10" name="organizer" class="tableinput" placeholder="组织者称呼" /></div>
<div><input type="text" size="40"  maxlength="100" name="contact"  class="tableinput" placeholder="QQ，电话，微信，邮箱等" /></div>
<div><select name="activity_class"  id="adclass">
<option value="eating">吃喝七里台</option>
<option value="travel" selected="selected">从北洋出发</option>
<option value="art">北洋文艺苑</option>
<option value="sport">激情运动场</option>
<option value="book">我要换书</option>
<option value="game">逸游北洋</option>
<option value="study">学霸去哪儿了</option>
<option value="other">杂七杂八</option>
</select>
</div>

<div><input type="text" size="40"  maxlength="50" name="activity_abstract"  class="tableinput" placeholder="不超过50字的活动摘要"/></div>
<div><input type="text" size="25"  maxlength="50" name="activity_place"  class="tableinput" placeholder="活动举办地点"/></div>
<div><input type="text" size="11" maxlength="11" class="tableinput" id="startdate" placeholder="活动开始日期" />

&nbsp;&nbsp;
<select name="starthour" id="starthour"></select>
&nbsp;:&nbsp;
<select name="startminute" name="startminute">
<option>00</option>
<option>15</option>
<option>30</option>
<option>45</option>
</select></div>

<div><input type="text" size="11" maxlength="11" class="tableinput" id="edddate" placeholder="活动结束日期" />
&nbsp;&nbsp;

<select name="endhour" id="endhour"></select>

&nbsp;:&nbsp;
<select name="endminute" name="endminute">
<option>00</option>
<option>15</option>
<option>30</option>
<option>45</option>
</select>
</div>



<div><input type="text" size="4"  maxlength="4" name="maxnumber"  class="tableinput" />&nbsp;&nbsp;参与人范围：
<select name="range" id="range" >
  <option value="student" selected=true>学生</option>
  <option value="anyone">任意</option>
</select>
</div>

<textarea cols="40" rows="10"  name="detail" placeholder="请详细描述您的活动"></textarea>


</div>
</div>


<div class="newbutton"><input type="submit" name="goactivity" value="发起活动" class="buttonblue"/><br/></div>
<div class="newbutton"><input type="text" value="取消" name="cancel_addnew" class="buttonred" /></div>
</form>
</div>



<div id="mask"></div>

</body>
</html>
