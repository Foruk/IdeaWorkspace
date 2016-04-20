					
			function page(new_page_index,pagination_container)
			{
				var url=window.location.href;
				var action=url.split("/");
				action=action[action.length-1];
				action=action.split("?")[0];
				action=action.split(".")[0];
				var c=parseInt(new_page_index)+1;
				$("#form1").attr("action",action+".action?currentPage="+c);
				$("#form1").submit();
				$("#current").val(new_page_index+1);
				return false;
				
			}
			function deleteUser()
			{
				var userid=new Array();
				var i=0;
				$("input[name='check']:checked").each(function(){
					userid[i]=$(this).val();
					i++;
				});	
				if(userid.length==0)
				{
					var message = "<h3>温馨提示</h3><p><strong>请先选中用户/strong></p><br/>";    
					alertify.alert(message);
					setTimeout(function(){},1000);
				}
				else{
					if(confirm("确定删除吗？"))
					{
					var message = "<h3>温馨提示</h3><p><strong>删除成功.2秒后自动跳转/strong></p><br/>";    
					alertify.alert(message);
					var s="";
					for(var j=0;j<userid.length;j++)
						s+=userid[j]+"|";
					setTimeout(function(){window.location.href="deleteUser.action?id="+s;},2000);
					}
				}				
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
			//閺嶈宓佹稉濠冾偧闁瀚ㄩ惃鍓卆dio闁鑵戦惃鍕拷閿涘矂锟芥稉顓＄箹濞嗭拷
			var ra=$("#radio").val();
			if(ra=="account")
				$("#form1 input[value='account']").attr("checked","checked");
			else if(ra=="nickname")
				$("#form1 input[value='nickname']").attr("checked","checked");
			else
			{}
			if($("#searchtext").val()!="null")
			$("#form1 input[name='searchtext']").val($("#searchtext").val());
			});