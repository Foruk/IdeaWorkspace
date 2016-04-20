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
	<title>首页</title>
	<link rel="stylesheet" href="css/alertify.css" />
	<link href="css/pagination.css" rel='stylesheet' type='text/css' />
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/index.css" rel='stylesheet' type='text/css' />
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
<script type="text/javascript" src="js/index.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
			
			$(function(){
			$("#content").html($("#asd").val());
			});
			
		
</script>
<!---->

</head>
<body>
<input type="hidden" id="totalrows" value="<s:property value="totalRows"/>">
<input type="hidden" id="pagesize" value="<s:property value="pagesize"/>">
<input type="hidden" id="current" value="<s:property value="currentPage"/>">
<input type="hidden" id="userid" value="<%=session.getAttribute("userid")%>">
<input type="hidden" id="account" value="<%=session.getAttribute("account")%>">
<input type="hidden" id="owner" value="<%=session.getAttribute("owner")%>">
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
						<li class="active"><a href="javascript:void(0)" onclick="checkLogin('manage')">个人中心</a></li>					
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
				 <li class="active"><a href="getAllNews.action">新闻列表</a></li>
				 <li><a id="userList" href="getAllUser.action">用户列表</a></li>
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
				 
				 <s:iterator value="newsList" id="news" status="st">
				
				 
				 <div class="Q-tpList" style="z-index:96;width:670px;height:180px">
				 	<div class="Q-tpWrap">
					<a target="_blank" class="pic"  href="newsdetail.action?newsid=<s:property value="newsid"/>">
						<img class="picto" src="<%=basePath %>newsImages/<s:property value="image"/>"></a>
					<em class="f14 l24">
						<span>
							<span class="">
								<a target="_blank" class="linkto" href="newsdetail.action?newsid=<s:property value="newsid"/>"><s:property value="title"/></a>
							</span>
						</span>
					</em>
					<!--  <p class="l22" style="width: 350px;position: relative;height: 40px;overflow: hidden;text-overflow: ellipsis;"><s:property value="maincontent" escape="false"/></p>-->
					<span style="position:absolute;left:85%;bottom:40%">By:<s:property value="publisher"/></span>
					<h3 style="position:absolute;left:85%;bottom:50%;font-size:10px;"><i>类别：<s:property value="categoryname"/></i></h3>
					<div class="btns">
									
						<a name="edit_a" class="option_edit" href="newsedit.action?newsid=<s:property value="newsid"/>"><img src="images/Edit.jpg"/></a>
						<a name="delete_a" class="option_delete" href="javascript:void(0)" onclick="deleteNews(<s:property value="newsid"/>)"><img src="images/Delete.png"/></a>

					</div>				
					</div>
				</div>
				 </s:iterator>
				 		 
				 <div class="pages" id="pagination">
					
				 </div>				 
			 </div>
			 
			 <div class="col-md-4 content-main-right">
				 <div class="search">
						 <h3>SEARCH HERE</h3>
						<form id="form1" action="searchNews.action" method="post" >
							<input type="text"  name="searchtext">
							<input type="submit" value="">
							<label><input checked="checked" type="radio" name="search" value="title">根据新闻标题</label>
							<label><input type="radio" name="search" value="publisher">根据发布人</label>
							<label><input type="radio" name="search" value="category">根据新闻类别</label>
						</form>
				 </div>
				 <div class="categories">
					 <h3>CATEGORIES</h3>
					 <li><a id="release" href="javascript:void(0);" onclick="checkLogin('fabu')" class="button yellow">发布新闻</a></li>
					 <li><a href="javascript:void(0);" onclick="checkLogin('my')" class="button green">只看自己发布的新闻</a></li>
					 <li><a href="getAllNews.action" class="button red">所有新闻</a></li>
				 </div>
				 <div class="archives">
					 <h3>ARCHIVES</h3>
					 <li class="active"><a href="#">July 2014</a></li>
					 <li><a href="#">June 2014</a></li>
					 <li><a href="#">May 2014</a></li>
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
