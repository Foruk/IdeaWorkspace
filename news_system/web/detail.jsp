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
	<title>Home</title>
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/video-js.css" rel="stylesheet">
	<link href="css/button.css" rel='stylesheet' type='text/css' />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Blogname Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" 
	/>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!----webfonts---->
		<%--<link href='http://fonts.useso.com/css?family=Oswald:100,400,300,700' rel='stylesheet' type='text/css'>--%>
		<%--<link href='http://fonts.useso.com/css?family=Source+Sans+Pro:200,300,400,600,700,300italic,400italic,600italic' rel='stylesheet' type='text/css'>--%>
		<!----//webfonts---->
		  <script src="js/jquery.min.js"></script>
		<!--end slider -->
		<!--script-->
  <!-- If you'd like to support IE8 -->
<script src="js/videojs-ie8.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script charset="utf-8" type="text/javascript" src="js/detail.js"></script>
<link href="css/detail.css" rel='stylesheet' type='text/css' />
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

</head>
<body>
<input id="newsvideo" type="hidden" value="<s:property value='news.video'/>">
<input id="newsimg" type="hidden" value="<s:property value='news.image'/>">
<input id="newsenc" type="hidden" value="<s:property value='news.enclosure'/>">
<input id="newsid" type="hidden" value="<s:property value='news.newsid'/>">
<input id="account" type="hidden" value="<%=session.getAttribute("account")%>">
<!---strat-banner---->
<div class="banner">				
	 <div class="header">  
		  <div class="container">
			  <div class="logo">
					<a href="index.html"> <img src="images/logo.png" title="soup" /></a>
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
				 <li class="active"><a href="#">LOREM IPSUM</a></li>
				 <li><a href="#">DOLAR SITE AMET</a></li>
				 <li><a href="#">MORBI IN SEM</a></li>
				 <div class="clearfix"></div>
			 </ul>
		 </div>
	 </div>
</div>
<!---//End-banner---->
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">
				 <div class="content-grid">
				 <input onclick="download()" type="button" id="download" value="下载附件" class="btn22">
					 <div class="content-grid-head">
						 <h4><s:property value="news.date"/>,Posted by: <s:property value="news.publisher"/></h4>
						 <div class="clearfix"></div>
					 </div>
					 <div class="content-grid-single">
						 <h3>标题：<s:property value="news.title"/></h3>
						 <div id="img">
						 	<img class="single-pic" src="<%=basePath %>newsImages/<s:property value="news.image"/>" alt=""/>
						 </div>
						 <div id="video">
						 <video id="my-video" class="video-js" controls="controls" preload="auto" width="684" height="264"
						  poster="MY_VIDEO_POSTER.jpg" data-setup="{}">
						    <source id="source" src="<%=basePath %>newsVideo/<s:property value="news.video"/>" type='video/mp4'>
						    <source src="MY_VIDEO.webm" type='video/webm'>
						    <p class="vjs-no-js">
						      To view this video please enable JavaScript, and consider upgrading to a web browser that
						      <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
						    </p>
						  </video>			
						  </div>			 
						 <span>内容：</span><p id="content"></p>						 											 
					  </div>
					 
				 </div>
				 <div style="margin-bottom:5px;margin-top:5px;">
				 	<strong style="font-size: 20px;">评论:</strong>
				 </div>
				 <div class="commentarea">
					 <div class="comment-contain">
					 <textarea id="comment" style="border:0;" class="comment"></textarea>
					 </div>
					 <div style="position:relative;display:block;height:40px">
					 	<div class="submitdiv">
					 		<a id="loginbtn" href="login.jsp" class="submitbtn" hideFocus=true>登录</a>
							<a id="submitbtn" href="javascript:void(0)" onclick="publish()" class="submitbtn" hideFocus=true>发表</a>
					 	</div>
					 </div>	
				 </div>
				 <div class="allcomment">
				 	<ul id="comment_ul">
				 	</ul>
					 <div class="loadMore">
						 <a id="loadbtn" onclick="loadmore()">加载更多</a>
						 <img id="loadimg" src="image/load.jpg" alt="">
						 <span id="msg" style="display: none"></span>
					 </div>
				 </div> 			 
			 </div>
			 <input type="hidden" id="text" value="<s:property value="news.maincontent"/>"></input>
			 <%--<div class="col-md-4 content-main-right">--%>
				 <%--<div class="search">--%>
						 <%--<h3>SEARCH HERE</h3>--%>
						<%--<form>--%>
							<%--<input type="text" value="" onfocus="this.value=''" onblur="this.value=''">--%>
							<%----%>
							<%--<input type="submit" value="">--%>
							<%--<input type="radio" name="search" value="根据新闻标题">--%>
							<%--<input type="radio" name="search" value="根据发布人">--%>
							<%--<input type="radio" name="search" value="根据新闻类别">--%>
						<%--</form>--%>
				 <%--</div>--%>
				 <%--<div class="categories">--%>
					 <%--<h3>CATEGORIES</h3>--%>
					 <%--<li class="active"><a href="#">Donec quis dui at dolor tempor</a></li>--%>
					 <%--<li><a href="#">Vestibulum commodo felis quis tort</a></li>--%>
					 <%--<li><a href="#">Fusce pellentesque suscipit</a></li>--%>
				 <%--</div>--%>
				 <%--<div class="archives">--%>
					 <%--<h3>ARCHIVES</h3>--%>
					 <%--<li class="active"><a href="#">July 2014</a></li>--%>
					 <%--<li><a href="#">June 2014</a></li>--%>
					 <%--<li><a href="#">May 2014</a></li>--%>
				 <%--</div>--%>
			 <%--</div>--%>
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
<script src="http://vjs.zencdn.net/5.8.6/video.js"></script>


</body>
</html>
