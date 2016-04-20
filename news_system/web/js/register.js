$(document).ready(function(){ 	
	$("#form1").validate({
	    rules: {
	    	"user.account": {
		        required: true
		      },
		      "user.password": {
		        required: true,
		        minlength: 6
		      },
		      "user.password2": {
		        required: true,
		        minlength: 6,
		        equalTo:"#password"
		      },
	    },
	    messages: {
	    	"user.account": "请输入您的名字",
	    	"user.password": {
	    	  minlength:"最小6位",
	    	  required:"请输入您的密码"
	      },
	      "user.password2":{
	      equalTo:"两次密码不一致",
	      required:"请确认您的密码",
	      minlength:"最小6位"
	      }          
	    }
	});
})
function checkAccount()
{
	var da=$("#account").val();
	if(da=="")
		{
		alert("不能为空");
		$("#vali").val("false");
		return;
		}
	$.ajax({
		url: "checkAccount.action",     //后台处理程序
	    type: "post",               //数据发送方式  
	    data:{"account":da},
	    success:function(data)
		{						 
			if(data.result=="success") 
				{
				$("#vali").val("true");
				alert("用户名可以使用");
				}
			else if(data.result=="fail")
				{
				$("#vali").val("false")
					alert("用户名已存在");
				}
		},
		error:function()
		{
			alert("请求失败");
		}
	});
}
function check()
{
	if($("#vali").val()=="true")
		return true;
	return false;
}