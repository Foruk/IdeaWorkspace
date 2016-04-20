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
	<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script src="js/jquery.min.js"></script>
	<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="news.maincontent"]', {
				cssPath : 'kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		$(function(){
			var id=window.location.href.split('=')[1];
			$("#id").val(id);
		})
	</script>
	<style type="text/css">
	.main{
	position:absolute; //绝对定位
	left:50%; 
	margin-left:25%;
	width:1000px;
	text-align:center; 
	}
	</style>
</head>
<body>
<div class="main">
	<form action="updateNews.action" method="post" enctype="multipart/form-data">
	<input id="id" name="newsid" type="hidden" value="">
	<table >
	<tr>
	<td>标题:</td><td><input type="news.text" name="news.title" value="<s:property value="news.title"/>"></td>
	</tr>
	<tr>
	<tr>
	<td>所属类别:</td>
	<td><s:select name="categoryname" list="categoryList" listValue="name" listKey="name">				            
			</s:select>
	</td>
	</tr>
	<tr>
	<td>图片:</td><td><input type="file" name="photo"> </td>
	</tr>
	<tr>
	<td>视频:</td><td><input type="file" name="video"> </td>
	</tr>
	<tr>
	<tr>
	<td>附件:</td><td><input type="file" name="enclosure"> </td>
	</tr>
	<tr>
	<tr>
	<td>内容</td><td><textarea  name="news.maincontent" cols="100" rows="8" style="width:700px;height:400px;visibility:hidden;">
	<s:property value="news.maincontent"/>
	</textarea></td>
	</tr>
	<tr><td></td><td style="text-align:center;"><input type="submit" value="提交"></td></tr>
	</table>
	</form>
</div>
</body>
</html>
