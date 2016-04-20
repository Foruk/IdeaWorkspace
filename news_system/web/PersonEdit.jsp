<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script src="js/jquery.min.js"></script>
	<link href="css/PersonEdit.css" rel='stylesheet' type='text/css' />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--webfonts-->
	<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
	<!--//webfonts--
	<!-- 时间控件JS-->
	<script type="text/javascript" src="jedate/jedate.js"></script>
	<script type="text/javascript">
		$(function () {
//			jeDate({
//				dateCell:"#seldate",
//				format:"YYYY年-MM月-DD日",
//				isTime:false,
//				isClear:true, //是否显示清空
//				festival:false, //是否显示节日
//				zIndex:999,  //弹出层的层级高度
//				minDate:"1900-01-1 00:00:00"
//			})
			$("#gender option").each(function(){
				if($(this).val()=='<s:property value="user.gender"/>')
						$(this).attr("selected","selected");
			});
		})
//		function giveDate()
//		{
//			document.getElementById('seldate')[0].value($("#seldate").val());
//			return true;
//		}
	</script>
</head>
<body>
<input  type="hidden" value="<s:property value="user.gender"/>">
<div class="main">
	<div class="social-icons">

		<div class="clear"> </div>
	</div>
	<h1 style="font-size: larger;text-align: center"><strong>编辑个人信息</strong></h1>
	<form action="updateUser.action" method="post">
		<input type="hidden" name="user.userid" value="<s:property value="user.userid"/>">
		<div class="lable">
			<div class="col_1_of_2 span_1_of_2"><input name="user.nickname" type="text" class="text" placeholder="用户名" id="active" value="<s:property value="user.nickname"/>">></div>
			<div class="col_1_of_2 span_1_of_2"><select id="gender" name="user.gender" style="width: 242px;height:52px;position:relative;top:18px;"><option>请选择性别</option><option value="男">男</option><option value="女">女</option></select></div>
			<div class="clear"> </div>
		</div>
		<div class="lable-2">
			<input name="user.password" type="password" class="text" placeholder="密码（空着表示不修改）" >
			<input name="user.password2" type="password" class="text" placeholder="确认密码 ">
		</div>
		<div class="lable-2">
			<%--<input style="cursor:pointer;" id="seldate" type="text" class="text" placeholder="生日" >--%>
			<input style="width: 850px;height:52px;" id="date" type="date" name="user.birthday" value="<s:property value="birthday"/>">
			<input  name="user.address" type="text" class="text" placeholder="地址" value="<s:property value="user.address"/>">
		</div>
		<%--<h3>By creating an account, you agree to our <span class="term"><a href="#">Terms & Conditions</a></span></h3>--%>
		<div class="submit">
			<input type="submit" value="修改" >
		</div>
		<div class="clear"> </div>
	</form>
	<!-----//end-main---->
</div>
<!-----start-copyright---->

<!-----//end-copyright---->
</body>
</html>
