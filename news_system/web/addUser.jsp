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
		
		function submitForm()
		{
		var message = "<h3>提示信息</h3><p><strong>添加成功。</strong></p><br/>";    
        alertify.alert(message);    
		setTimeout(function(){document.getElementById("form1").submit();},2000);
		}
	</script>
	<style type="text/css">
	.main{
	position:absolute; //绝对定位
	left:50%; 
	margin-left:25%;
	width:1000px;
	text-align:center; 
	}
	.{

	}
	</style>
</head>
<body>
<div class="main">
	<form id="form1" action="saveUser.action" method="post" >
	<table >
	<tr>
	<td>账号:</td><td><input type="text" name="user.account" value=""></td>
	</tr>
	<tr>
	<td>名称:</td><td><input type="text" name="user.nickname"  value=""></td>
	</tr>
	<tr>
	<td>密码:</td><td><input type="password" name="user.password" value=""></td>
	</tr>
	<tr>
	<td>确认密码:</td><td><input type="password" name="password2" value=""></td>
	</tr>
	<tr>
	<td>出生日期:</td><td><input type="text" name="user.birthday" value=""></td>
	</tr>
	<tr>
	<td>性别:</td><td><input checked="checked" type="radio" name="user.gender" value="男"><span>男</span><input type="radio" name="user.gender" value="女"><span>女</span></td>
	</tr>
	<tr>
	<td>地址:</td><td><input type="text" name="user.address" value=""></td>
	</tr>
	<tr>
	<td>身份:</td><td><input checked="checked" type="radio" name="user.jurisdiction" value="普通用户"><span>普通用户</span><input type="radio" name="user.jurisdiction" value="管理员"><span>管理员</span></td>
	</tr>
	<tr><td></td><td style="text-align:center;"><input type="button" value="添加" onclick="submitForm()"></td></tr>
	</table>
	</form>
</div>
</body>
</html>
