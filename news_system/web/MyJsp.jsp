<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 
	jplayer所需要
	 -->
	 <link rel="stylesheet" href="css/jplayer.blue.monday.css" type="text/css" media="all" /> 
	<link rel="stylesheet" href="css/main.css" type="text/css" media="all" /> 
	<script src="js/jquery.min.js" type="text/javascript"></script> 
	<script src="js/jquery.jplayer.min.js" type="text/javascript"></script> 
	<script src="js/newsVideo.js" type="text/javascript"></script> 
  </head>
  
  <body>
   <form action="test.action" method="post" enctype="multipart/form-data">
   <input type="file" name="video">
   <input type="submit">
   <select name="asd"><option>asd</option></select>
   </form>
   
   
   
   <div class="players"> 
            <h2>Video player</h2> 
            <div class="jp-video jp-video-270p"> 
                <div class="jp-type-single"> 
                    <div id="jquery_jplayer_2" class="jp-jplayer"></div> 
                    <div id="jp_interface_2" class="jp-interface"> 
                        <div class="jp-video-play"></div> 
                        <ul class="jp-controls"> 
                            <li><a href="#" class="jp-play" tabindex="1">play</a></li> 
                            <li><a href="#" class="jp-pause" tabindex="1">pause</a></li> 
                            <li><a href="#" class="jp-stop" tabindex="1">stop</a></li> 
                            <li><a href="#" class="jp-mute" tabindex="1">mute</a></li> 
                            <li><a href="#" class="jp-unmute" tabindex="1">unmute</a></li> 
                        </ul> 
                        <div class="jp-progress"> 
                            <div class="jp-seek-bar"> 
                                <div class="jp-play-bar"></div> 
                            </div> 
                        </div> 
                        <div class="jp-volume-bar"> 
                            <div class="jp-volume-bar-value"></div> 
                        </div> 
                        <div class="jp-current-time"></div> 
                        <div class="jp-duration"></div> 
                    </div> 
                    <div id="jp_playlist_2" class="jp-playlist"> 
                        <ul> 
                            <li>Tokyo weather</li> 
                        </ul> 
                    </div> 
                </div> 
            </div> 
        </div> 
  </body>
</html>
