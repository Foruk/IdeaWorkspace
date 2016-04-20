$(function() {
	haveImg();
	haveVideo();
	haveLogin();
})
$(document).ready(function() {
	loadmore();
})
function haveVideo()
{
	$("#content").html($("#text").val());
	if ($("#newsvideo").val() == "" || $("#newsvideo").val() == "null") {
		$("#video").html("暂无视频");
	} else {
		var type = getType();
		$("#source").attr("type", "video/" + type);
	}
}
function haveImg()
{
	if ($("#newsimg").val() == "" || $("#newsimg").val() == "null") {
		$("#img").html("暂无图片");
	}
}
function haveLogin() {
	if ($("#account").val() != "null" && $("#account").val() != "") {
		$("#loginbtn").css("display", "none");
		$("#submitbtn").css("display", "inline");
	}
	else
	{
		$("#loginbtn").css("display","inline");
		$("#submitbtn").css("display", "none");
	}
}
function getType() {
	if ($("#newsvideo").val() == "")
		return "";
	var file = $("#newsvideo").val();
	var strFileName = file.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi, "$1"); //正则表达式获取文件名，不带后缀
	var FileExt = file.replace(/.+\./, ""); //正则表达式获取后缀
	return FileExt;
}
function download()
{
	if($("#newsenc").val()== "" || $("#newsenc").val() == "null")
	{
		alert("暂无附件");
		return;
	}
	window.location.href="download.action?newsid="+$("#newsid").val();
}
function publish() {
	// $("#cForm").attr("action","publishComment.action?newsid="+$("#newsid").val());
	// $("#cForm").submit();
	$.ajax({
		url: "publishComment.action",     //后台处理程序
		type: "post",               //数据发送方式
		data:{"newsid":$("#newsid").val(),"comment.message":$("#comment").val()},
		async:false,
		success:function(result)
		{
			if(result.msg=="success")
				alert("发表成功");
			else
				alert("发表失败");
		},
		error:function()
		{
			alert("发表失败");
		}
	});

	loadmore();
}
function showComment() {
	$.ajax({
		url: "AllComment.action",     //后台处理程序
		type: "post",               //数据发送方式
		data:{"newsid":$("#newsid").val()},
		dataType:"json",
		async:false,
		success:function(data)
		{
			//var d=eval("("+data+")");
			$("#comment_ul").html(getComment(data.result));
		}
	});
}
function getComment(result) {
	var list="";
	for (var i=0;i<result.length;i++)
	{
		list+="<li>";
	list+="		<div class='li_left'>";
	list+="			<img style='width: 40px;height: 40px;' src='images/bg.jpg'>";
	list+="			</div>";
	list+="			<div class='li_right'>";
	list+="			<div class='li_header'>";
	list+="			<strong style='color: #379BE9;margin-right: 10px;'>"+result[i].userName+"</strong><span style='color: #999'>"+result[i].time+"</span>";
	list+="		</div>";
	list+="		<div class='li_content'>";
	list+="			<p>"+result[i].message+"</p>";
	list+="			</div>";
	list+="			</div>";
	list+="	</li>";
	}
	return list;
}
function loadmore()
{
	$("#loadbtn").css("display","none");
	$("#loadimg").css("display","block");
	var length=$("#comment_ul li").length;
	$.ajax({
		url: "loadComment.action",     //后台处理程序
		type: "post",               //数据发送方式
		data:{"newsid":$("#newsid").val(),"commentLength":length},
		dataType:"json",
		success:function(data)
		{
			if(data.isSucc=="T")
			{
				$("#comment_ul").append(getComment(data.result));
				$("#loadbtn").css("display","block");
			}
			else 
			{
				$("#msg").css("display","block");
				$("#msg").html(data.result);
			}
			$("#loadimg").css("display","none");
		}
	});
}