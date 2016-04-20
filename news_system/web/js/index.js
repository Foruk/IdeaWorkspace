function checkLogin(flag)
			{
				if($("#user").html()=="")
				{
					var message = "<h3>温馨提示</h3><p><strong>请先登录/strong></p><br/>";    
        			alertify.alert(message);
				}
				else
				{
					if(flag=="fabu")
						window.location.href="AllCategory.action";
					else if(flag=="manage")
						window.location.href="userEdit.action?userid="+$("#userid").val()+"&editflag=2";
					else
						window.location.href="myNewsList.action";
				}
			}
function deleteNews(id)
{
	if(confirm("确定删除吗？"))
	{
	var message = "<h3>温馨提示</h3><p><strong>删除成功.2秒后自动跳转/strong></p><br/>";    
	alertify.alert(message);
	setTimeout(function(){window.location.href="deleteNews.action?newsid="+id;},2000);
	}
}
function getAction(url)
{
	var action=url.split("/");
	action=action[action.length-1];
	action=action.split("?")[0];
	action=action.split(".")[0];
	return action;
}
function page(new_page_index,pagination_container)
{
	var action=getAction(window.location.href);
	var c=parseInt(new_page_index)+1;
	$("#form1").attr("action",action+".action?currentPage="+c);
	$("#form1").submit();
	$("#current").val(new_page_index+1);
	return false;
	
}
			
$(function(){
	$("#pagination").pagination(parseInt($("#totalrows").val()),{
	items_per_page:parseInt($("#pagesize").val()),
	current_page:parseInt($("#current").val())-1,
	callback:page
	});
	if($("#account").val()!="null"&&$("#account").val()!="")
	{
		$("#user").html($("#account").val());
		$("#loginbtn").html("注销");
		$("#loginbtn").attr("href","loginout.action");
	}
	else
	{
		$("#user").html("");
		$("#loginbtn").html("登录");
		$("#loginbtn").attr("href","login.jsp");
	}
	});
$(function(){
//閺堫亞娅ヨぐ锟界拋鐬杁it閹稿鎸抽梾鎰
	var action=getAction(window.location.href);
	if(action!="myNewsList")
		$("#owner").val("");
	$("a[name='edit_a']").css("display","none");
	$("a[name='delete_a']").css("display","none");
	//只有管理员才能看用户列表
	$("#userList").css("display","none");
	//只有自己能修改自己发布的新闻
	if($("#owner").val()=="owner")
	{
		$("a[name='edit_a']").css("display","block");
		$("a[name='delete_a']").css("display","block");
	}
	//管理员可以删除所有新闻
	if($("#account").val()=="admin")
	{
		$("a[name='delete_a']").css("display","block");
		$("#userList").css("display","block");
	}
		
	//閺嶈宓佹稉濠冾偧闁瀚ㄩ惃鍓卆dio闁鑵戦惃鍕拷閿涘矂锟芥稉顓＄箹濞嗭拷
	var ra=$("#radio").val();
	if(ra=="title")
		$("#form1 input[value='title']").attr("checked","checked");
	else if(ra=="publisher")
		$("#form1 input[value='publisher']").attr("checked","checked");
	else if(ra=="category")
		$("#form1 input[value='category']").attr("checked","checked");
	else
	{}
	if($("#searchtext").val()!="null")
	$("#form1 input[name='searchtext']").val($("#searchtext").val());
});