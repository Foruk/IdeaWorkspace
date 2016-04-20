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
    <link rel="stylesheet" href="css/alertify.css" />
	<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.alertify.js"></script>
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
	function submitForm() {
	if (!checkVideo())
		return;
	var message = "<h3>提示信息</h3><p><strong>发布成功。</strong></p><br/>";
	alertify.alert(message);
	setTimeout(function() {
		document.getElementById("form1").submit();
	}, 2000);
}
function checkVideo() {
	if($("#video").val()=="")
		return true;
	var file = $("#video").val();
	var strFileName=file.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");  //正则表达式获取文件名，不带后缀
	var FileExt=file.replace(/.+\./,"");   //正则表达式获取后缀
	if(FileExt!="mp4")
		{
		alert("please select mp4 video!");
		return false;
		}
	else
		return true;
}
	</script>Q
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
	<form id="form1" action="saveNews.action" method="post" enctype="multipart/form-data">
	<table >
	<tr>
	<td>标题:</td><td><input type="text" name="news.title" value=""></td>
	</tr>
	<tr><td>类别：</td>
		<td><s:select name="categoryname" list="categoryList" listValue="name" listKey="name">				            
			</s:select>
		</td>
	</tr>
	<tr>
	<td>图片:</td><td><input type="file" name="photo"> </td>
	</tr>
	<tr>
	<td>视频:</td><td><input type="file" id="video" name="video"> </td>
	</tr>
	<tr>
	<td>附件:</td><td><input type="file" name="enclosure"> </td>
	</tr>
	<tr>
	<td>内容</td><td><textarea  name="news.maincontent" cols="100" rows="8" style="width:700px;height:400px;visibility:hidden;">
	</textarea></td>
	</tr>
	<tr><td></td><td style="text-align:center;"><input type="button" value="发布" onclick="submitForm()"></td></tr>
	</table>
	</form>
</div>
</body>
</html>
