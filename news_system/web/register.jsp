<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0042)http://reg.ztgame.com/registe/register.jsp -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>账号注册</title>
<link href="register/index.css" rel="stylesheet" type="text/css">

<script language="javascript" type="text/javascript" src="register/swfobject.js"></script>
<script type="text/javascript" src="register/jquery.form.js"></script>
<script language="javascript" type="text/javascript" src="register/reg_selfdom.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>		
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/register.js"></script>
</head>


<body>
   <iframe src="register/header.htm" class="header_iframe" frameborder="0" scrolling="no"></iframe>
<input id="vali" type="hidden" value=""/>
    <div id="MAIN">
		<div class="left"><img alt="" src="register/left_bg.jpg"></div>
		<div class="middle_bg">
			<div class="title"><h1 style="font-size:25px;color:#0262a7;">新用户注册</h1></div>
			<div class="tab_btn_div">
				<div class="tab_btn tab_btn_1_2"></div>
				<div class="link_txt">				
					<a class="zcfs_btn" onclick="showDiv()"></a>
				</div>
			</div>
	
		<form method="post" id="form1" action="register.action" onsubmit="return check()"">
			<ul>
				<li class="inputTxt li_checked">
					<div class="left">
						<span class="spanTxt">账号名称</span>：
						<span class="longInputSpan" style="background:url(&#39;register/input_bg.gif&#39;) no-repeat;"><input type="text" id="account" name="user.account"class="long_input"></span>
						<a href="javascript:void(0)" onclick="checkAccount()">检查用户名</a>
					</div>
				</li>								
				
				<li class="inputTxt passLi">
					<div class="left">
						<span class="spanTxt">设置密码</span>：
						<span class="longInputSpan"><input name="user.password" id="password" type="password" class="long_input"></span>
					 <!--  	<img class="nonSuccess" alt="" src="images/register_new/v_ok.gif" align="absmiddle"/> -->
					</div>					
				</li>
				<li class="inputTxt passLi">
					<div class="left">
						<span class="spanTxt">确认密码</span>：
						<span class="longInputSpan"><input name="user.password2" id="password2" type="password" class="long_input"></span>
					 <!--  	<img class="nonSuccess" alt="" src="images/register_new/v_ok.gif" align="absmiddle"/> -->
					</div>				
				</li>
				<li class="inputTxt">
					<div class="left">
						<span class="spanTxt">账号昵称</span>：
						<span class="longInputSpan"><input type="text" class="long_input" name="user.nickname" id="realname" maxlength="15" onfocus="textshow_other(this);"></span>
						<!--  <img class="nonSuccess" alt="" src="images/register_new/v_ok.gif" align="absmiddle" align="absmiddle"/>  -->
					</div>
				</li>
				<li class="inputTxt">
					<div class="left">
						<span class="spanTxt">性别</span>：
						<span class="longInputSpan"><select style="width:280px;height:20px;color:initial;" name="user.gender"><option>男</option><option>女</option></select></span>
						<!--  <img class="nonSuccess" alt="" src="images/register_new/v_ok.gif" align="absmiddle"/>  -->
					</div>
				</li>
				<li class="inputTxt">
					<div class="left">
						<span class="spanTxt">出生年月</span>：
						<span class="longInputSpan"><input type="text" id="username" name="user.birthday" class="long_input"></span>
						<!--  <img class="nonSuccess" alt="" src="images/register_new/v_ok.gif" align="absmiddle"/>  -->
					</div>
				</li>
				<li class="inputTxt">
					<div class="left">
						<span class="spanTxt">地址</span>：
						<span class="longInputSpan"><input type="text" id="username" name="user.address" class="long_input" "></span>
						<!--  <img class="nonSuccess" alt="" src="images/register_new/v_ok.gif" align="absmiddle"/>  -->
					</div>
				</li>											
				<li class="li_bottom">
					<span class="spanTxt">&nbsp;</span>　
					<input type="submit" value="提交" />
					<img src="register/submitBut_ok">
				</li>
				<li class="bottom_line"></li>
			</ul>
		</form>
		
		</div>
		<div class="left"><img alt="" src="register/right_bg.jpg"></div>
    </div> 
	<iframe src="register/footer.htm" class="footer_iframe" frameborder="0" scrolling="no"></iframe>
		




<script language="JavaScript" type="text/JavaScript">
	document.write("<scr"+"ipt src='http://js.ztgame.com/stat.js'></scr"+"ipt>");
</script><script src="register/stat.js"></script></body></html>
