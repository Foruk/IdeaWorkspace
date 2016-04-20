<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>用户列表</title>
	<link rel="stylesheet" href="css/alertify.css" />
	<link href="css/pagination.css" rel='stylesheet' type='text/css' />
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/index.css" rel='stylesheet' type='text/css' />
	<link href="css/userList.css" rel='stylesheet' type='text/css' />
	<link href="css/button.css" rel='stylesheet' type='text/css' />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Blogname Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" 
	/>
	<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!----webfonts---->
		<link href='css/index1.css' rel='stylesheet' type='text/css'>
		<link href='css/index2.css' type='text/css'>
		<!----//webfonts---->
		  <script src="js/jquery.min.js"></script>
		<!--end slider -->
		<!--script-->
		<script src="js/jquery.alertify.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/userList.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});		
</script>
<!---->
<style type="text/css">
.button.yellow{
border:1px solid #d2a000;
box-shadow: 0 1px 2px #fedd71 inset,0 -1px 0 #a38b39 inset,0 -2px 3px #fedd71 inset;
background: -webkit-linear-gradient(top,#fece34,#d8a605);
background: -moz-linear-gradient(top,#fece34,#d8a605);
background: linear-gradient(top,#fece34,#d8a605);
}
.button.green{
border:1px solid #64c878;
box-shadow: 0 1px 2px #b9ecc4 inset,0 -1px 0 #6c9f76 inset,0 -2px 3px #b9ecc4 inset;
background: -webkit-linear-gradient(top,#90dfa2,#84d494);
background: -moz-linear-gradient(top,#90dfa2,#84d494);
background: linear-gradient(top,#90dfa2,#84d494);
}
.button.red{
border:1px solid #b42323;
box-shadow: 0 1px 2px #e99494 inset,0 -1px 0 #954b4b inset,0 -2px 3px #e99494 inset;
background: -webkit-linear-gradient(top,#d53939,#b92929);
background: -moz-linear-gradient(top,#d53939,#b92929);
background: linear-gradient(top,#d53939,#b92929);
}
</style>
</head>
<body>
<input type="hidden" id="totalrows" value="<s:property value="totalRows"/>">
<input type="hidden" id="pagesize" value="<s:property value="pagesize"/>">
<input type="hidden" id="current" value="<s:property value="currentPage"/>">
<input type="hidden" id="account" value="<%=session.getAttribute("account")%>">
<input type="hidden" id="radio" value="<%=session.getAttribute("radio")%>">
<input type="hidden" id="searchtext" value="<%=session.getAttribute("searchtext")%>">
<!---strat-banner---->
<div class="banner">				
	 <div class="header">  
		  <div class="container">
			  <div class="logo">
					<span id="welcome">欢迎 <i id="user"></i></span><a style="display:block;" id="loginbtn" href="login.jsp">登录</a> <!--  <img src="images/logo.png" title="soup" />-->
			 </div>
			 <!---start-top-nav---->
			 <div class="top-menu">
				  <span class="menu"> </span> 
				   <ul>
						<li class="active"><a href="index.html">HOME</a></li>						
						<li><a href="contact.html">CONTACT</a></li>	
						<li><a href="terms.html">TERMS</a></li>						
						<div class="clearfix"> </div>
				 </ul>
			 </div>
			 <div class="clearfix"></div>
					<script>
					$("span.menu").click(function(){
					$(".top-menu ul").slideToggle("slow" , function(){
					});
					});
					</script>
				<!---//End-top-nav---->					
		 </div>
	 </div>
	 <div class="container">
		 <div class="banner-head">
			 <h1>Lorem ipsum dolor sit amet</h1>
			 <h2>cliquam tincidunt mauris</h2>
		 </div>
		 <div class="banner-links">
			 <ul>
				 <li><a href="getAllNews.action">新闻列表</a></li>
				 <li class="active"><a href="getAllUser.action">用户列表</a></li>
				 <li><a href="getAllCategory.action">类别列表</a></li>
				 <div class="clearfix"></div>
			 </ul>
		 </div>
	 </div>
</div>
<!---//End-banner---->
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">
				<table class="tableimg">
				<tr>
					<th><input disabled="disabled" type="checkbox"/></th><th>编辑</th><th>账号</th><th>用户名</th><th>出生年月</th><th>密码</th><th>性别</th><th>地址</th><th>身份</th>
				</tr>
				<s:iterator value="userList">
				<tr>
					<td><input value="<s:property value="userid"/>" name="check" type="checkbox"/></td><td><a href="userEdit.action?userid=<s:property value="userid"/>&editflag=1"><img style="width:20px;height:15px;" src="images/Edit.jpg"/></a></td><td><s:property value="account"/></td><td><s:property value="nickname"/></td><td><s:property value="birthday"/></td><td><s:property value="password"/></td><td><s:property value="gender"/></td><td><s:property value="address"/></td><td><s:property value="jurisdiction"/></td>
				</tr>			
				 </s:iterator> 
				 </table>
				 <input class="btn2 pbtn1" onmouseover="this.style.borderColor='#f76b00'" onmouseout="this.style.borderColor='#dcdcdc'" type="button" onclick="deleteUser()" value="删除选中"/>
				 <input style="border-color: rgb(144,144,144);" class="btn6" type="button" onclick="addUser.jsp" onmouseover="this.style.backgroundPosition='left -35px'" onmouseout="this.style.backgroundPosition='left top'" value="添加用户"/>
				 <div class="pages" id="pagination">
					
				 </div>				 
			 </div>
			 
			 <div class="col-md-4 content-main-right">
				 <div class="search">
						 <h3 style="position:relative">搜索用户</h3>
						<form id="form1" action="searchUser.action" method="post" >
							<input type="text"  name="searchtext">
							<input type="submit" value="">
							<label><input checked="checked" type="radio" name="search" value="account">账号</label>
							<label><input type="radio" name="search" value="nickname">用户昵称</label>
							<input type="reset" value="重置"/>
						</form>
				 </div>
				 			 </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<!--fotter-->
<div class="fotter">
	 <div class="container">
		 <div class="col-md-4 fotter-info">
			 <h3>INTEGER VITAE LIBERO</h3>
			 <p>Raesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. </p>
			 <p>Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus. Phasellus ultrices nulla quis nibh. Quisque a lectus. </p>
		 </div>
		 <div class="col-md-4 fotter-list">
			 <h3>VESTIBULUM COMMO</h3>
			 <ul>
			 <li><a href="#">Ut alliquam solicitudin</a></li>
			 <li><a href="#">Neque id cursus faucibus</a></li>
			 <li><a href="#">Raesent dapibus neque id cursus</a></li>
			 </ul>
		 </div>
		 <div class="col-md-4 fotter-media">
				<h3>FOLLOW US ON....</h3>
				 <div class="social-icons">
				 <a href="#"><span class="fb"> </span></a>
				 <a href="#"><span class="twt"> </span></a>
				 <a href="#"><span class="in"> </span></a>				 			 
			    </div>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!---fotter/-->
<div class="copywrite">
	 <div class="container">
	 <p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
</div>
</div>
<!---->
<script type="text/javascript">
		$(document).ready(function() {
				/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
				*/
		$().UItoTop({ easingType: 'easeOutQuart' });
});
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>



</body>
</html>
