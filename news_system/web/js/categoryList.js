				
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
			function edit(name)
			{
				$("input[value='"+name+"']").removeAttr("disabled");	
				$("input[value='"+name+"']").removeAttr("style");
			}
			function sub(t,id)
			{
				/*var message = "<h3>温馨提示</h3><p><strong>修改成功/strong></p><br/>";    
				alertify.alert(message);
				setTimeout(function(){},1000);
				var form=t.parentNode.parentNode;
				t.submit();*/
				var name=t.parentNode.previousSibling.previousSibling.childNodes[0].value;
				var Id=id;
				var message = "<h3>温馨提示</h3><p><strong>修改成功/strong></p><br/>";    
				alertify.alert(message);
				setTimeout(function(){},2000);
				window.location.href="updateCategory.action?categoryid="+Id+"&name="+name;
			}
			function add()
			{
				var message = "<h3>Prompt Dialog</h3><p>Please enter a value over here.</p><br/>";  
				  
		        alertify.prompt(message, function (e, str) {  
		            if(e) {  
		                //alertify.success("You typed <strong>"+str+"</strong>");    
		            	window.location.href="addCategory.action?name="+str;
		            } else {  
		                //alertify.error("You clicked <strong>Cancel</strong>");  
		            }  
		        }, "输入类别名");   
			}
			function deleteCategory()
			{
				var id=new Array();
				var i=0;
				$("input[name='check']:checked").each(function(){
					id[i]=$(this).val();
					i++;
				});	
				if(id.length==0)
				{
					var message = "<h3>温馨提示</h3><p><strong>请先选中/strong></p><br/>";    
					alertify.alert(message);
					setTimeout(function(){},1000);
				}
				else{
					if(confirm("确定删除吗？"))
					{
					var message = "<h3>温馨提示</h3><p><strong>删除成功.2秒后自动跳转/strong></p><br/>";    
					alertify.alert(message);
					var s="";
					for(var j=0;j<id.length;j++)
						s+=id[j]+"|";
					setTimeout(function(){window.location.href="deleteCategory.action?categoryid="+s;},2000);
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
			
			
			//管理员可以编辑用户
			if($("#account").val()=="admin")
			{
				$("#userList").show();
			}
			else
				$("#userList").hide();
			
			
			if($("#account").val()=="admin")
			{
				$("#delbtn").show();
			}
			else
				$("#delbtn").hide();
			
			if($("#account").val()=="admin")
				{
					$("table th[name='save_th']").show();
					$("table td[name='save_td']").show();
					$("table th[name='del_th']").show();
					$("table td[name='del_td']").show();
				}
			else				
				{
				$("table th[name='save_th']").hide();
				$("table td[name='save_td']").hide();
				$("table th[name='del_th']").hide();
				$("table td[name='del_td']").hide();
				}
			if($("#account").val()!=""&&$("#account").val()!="null")
				{
				$("table th[name='edit_th']").show();
				$("table td[name='edit_td']").show();
				}
			else
				{
				$("table th[name='edit_th']").hide();
				$("table td[name='edit_td']").hide();
				}
			});