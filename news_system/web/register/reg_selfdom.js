	
	var randomName = '';
	var randomIdcard = '';
	
	$(document).ready(function()
	{
		setPassWordLevel();
		checkInputByAjax();
		submitForm();
		
		document.getElementById('username').focus();
		
		
		if(randomName==''){
			randomName = getRandomName();
		}
		
		if(randomIdcard==''){
			randomIdcard = getRandomIdcard();
		}
		
	});
	
	function checkInputByAjax()
	{
		$('.long_input,.short_input').blur(function(){
			var o = this;
			var	obj = $(this);
			var val= $(this).val().trim();
			
			setInputBackGroundUrl(o,'0'); //设置input输入框的背景
			
			if(val=='' || val==null || val== undefined ){
				return;
			}
		
			$(o).parent().parent().parent().removeClass('li_checked');
		
			
			//右图文字不做ajax验证，验证码这块html元素节点关系和其他选项不同
			if($(o).attr('id')=='validatecode'){
				if(val.trim()!=''){
					$('#validatecodeDivHide').html('&nbsp;').removeClass().addClass('okTxt').show();			
				}else{
					$('#validatecodeDivHide').hide();
				}
				return;
			}else{
				//$(o).parent().parent().next().removeClass().hide(); 	//先隐藏正确或错误的提示信息
			}
			
			
			
			//验证真实姓名->中文
			if($(o).attr('id')=='realname'){
				if(val=='')return;
				if(!checkChineseString(val)){
					return;
				}
			}else if($(o).attr('id')=='userpwd'){
				if($('#userpwd').val().trim()==$('#username').val().trim() && $('#userpwd').val().trim()!=''){
					$('#userpwd').parent().parent().next().html('密码和账号名称不能相同').removeClass().addClass('errorTxt').show();
					return;
				}
			}
			
			
			var reval;
			type = $(this).attr('id');
			var username =$('#username').val().trim();
			var source = $('#source').val().trim();
			
			$.post("/registe/check",{type:type,val:val,reval:reval,username:username,source:source}, function(m){
				
				var arr = m.split("|");
				z=arr[0];
				if(z == 100)
				{
					obj.parent().parent().next().html('&nbsp;').removeClass().addClass('okTxt').show();
				}
				else
				{
					if(z == 121)
		   			{
		   				obj.parent().parent().next().html(v[z]).removeClass().addClass('errorTxt').show();
		   				var recs = arr[1].split(",");
		   				$('#recommendUserName').html("<span class='spanTxt'>&nbsp;</span>　 <span class='id_notice'><p><font color='#eb7a00'>推荐您使用</font></p><p><input type='radio' name='TuiJianName' onclick=\"setUserName('"+recs[0]+"')\" />"+recs[0]+"</p><p><input type='radio' onclick=\"setUserName('"+recs[1]+"')\" name='TuiJianName' />"+recs[1]+"</p></span>");
		   				$('#recommendUserName').show();
		   			}
		   			else if(z==141)
					{
						obj.parent().parent().next().html(v[z]+arr[1]).removeClass().addClass('errorTxt').show();
					}
					else if(z==108)
					{
						obj.parent().parent().next().html(v[z]).removeClass().addClass('errorTxt').show();
					}
					else if(z==111)
					{
						//obj.parent().parent().next().html(v[z]+',例如:'+randomIdcard).removeClass().addClass('errorTxt').show();
						obj.parent().parent().next().html(v[z]).removeClass().addClass('errorTxt').show();
					}
					else
					{
						obj.parent().parent().next().html(v[z]).removeClass().addClass('errorTxt').show();
					}
				}
			});
		});
	}
	
	
	
	//去两边空格  
	String.prototype.trim=function(){  
	    return this.ltrim().rtrim();  
	}  
	//去左边空格  
	String.prototype.ltrim=function(){  
	    return this.replace(/(^\s*)/g,"");  
	}  
	//去右边空格  
	String.prototype.rtrim=function(){  
	    return this.replace(/(\s*$)/g,"");  
	}  
	
	
	function setUserName(strName)
	{
		$('#recommendUserName').hide();
		$('#username').val(strName);
		$('#show_2').html('&nbsp;').removeClass().addClass('okTxt').show();
	}
	
	function setPassWordLevel()
	{
		var ps = new PasswordStrength();
		$('#userpwd').keyup(function(){
			var val2=$('#userpwd').val().trim();
			if(val2=='' || val2==null || val2== undefined ){
				$("#PASS_QD").hide();
				$(".passLi").attr("style","height:40px;");
				return;
			}
			$(".passLi").attr("style","height:60px;");
			//$('#passWordBig').show();
			$("#PASS_QD").show();
			//$(".pass_sm").show();
			
			pwdLevel = ps.getLevel(val2);
			if(pwdLevel<=1){
				$("#PASS_QD").html("密码强度：<img alt='' src='images/register_new/passBar_1.jpg' align='absmiddle'/>　弱");
			}
			else if(pwdLevel==2){
				$("#PASS_QD").html("密码强度：<img alt='' src='images/register_new/passBar_2.jpg' align='absmiddle'/>　中");
			}
			else if(pwdLevel==3){
				$("#PASS_QD").html("密码强度：<img alt='' src='images/register_new/passBar_3.jpg' align='absmiddle'/>　强");
			} 
		});
	}
	
	
	function setInputBackGroundUrl(e,f)
	{
		$(".longInputSpan, .shortInputSpan").removeAttr("style");
		
		if(f=='0'){
			if($(e).parent().attr('class')=='longInputSpan'){
				$(e).parent().attr("style","background:url('images/register_new/input_bg.gif') no-repeat;");	
			}else if($(e).parent().attr('class')=='shortInputSpan'){
				$(e).parent().attr("style","background:url('images/register_new/input_bg_s.gif') no-repeat;");			
			}
		}else if(f=='1'){
			if($(e).parent().attr('class')=='longInputSpan'){
				$(e).parent().attr("style","background:url('images/register_new/input_bg_1.gif') no-repeat;");	
			}else if($(e).parent().attr('class')=='shortInputSpan'){
				$(e).parent().attr("style","background:url('images/register_new/input_bg_s_1.gif') no-repeat;");			
			}	
		}
		
	}
	
	
	function textshow(e,words) 
	{
		setInputBackGroundUrl(e,'1');
		clearText(e,words);
		if(e.id=='username')
			$('#recommendUserName').hide();
	}
	
	
	
	function textshow_other(e) 
	{
		var words='';
		if(e.id=='realname'){
			words = '请输入真实姓名';
		}else if(e.id=='idnum'){
			words = '请输入身份证号码';
		}
		
		setInputBackGroundUrl(e,'1');		
		clearText(e,words);
	}
	
	
	
	function clearText(e,words)
	{
		$(".middle_bg ul li.inputTxt").removeClass("li_checked");
		$(".middle_bg ul li.inputTxt").find(".noticeTxt").hide();	
		$(e).parent().parent().parent().addClass("li_checked");
		
		
		//if(e.id=='username' || e.id=='idnum'){ //添加 “姓名和身份证” 的默认值 
		if(e.id=='username'){
			$(e).parent().parent().next().removeClass().addClass('noticeTxt').addClass('noticeTxt1').html(words).show();
		}else{
			$(e).parent().parent().next().removeClass().addClass('noticeTxt').html(words).show();					
		}
	}
	
	
	
	function checkAllParam()
	{
	    var username = $('#username').val().trim();
		if(username=='' || username==null || username== undefined ){
			$('#username').parent().parent().next().html('请输入通行证名称').removeClass().addClass('errorTxt').show();
			return false;
		}
		var userpwd = $('#userpwd').val().trim();
		if(userpwd=='' || userpwd==null || userpwd== undefined ){
			$('#userpwd').parent().parent().next().html('请输入密码').removeClass().addClass('errorTxt').show();
			return false;
		}
		
		if(userpwd==username){
			$('#userpwd').parent().parent().next().html('密码和账号名称不能相同').removeClass().addClass('errorTxt').show();
			return false;
		}
		
		if(userpwd.length<6 || userpwd.length>16 ){
			$('#userpwd').parent().parent().next().html('密码长度应为6-16').removeClass().addClass('errorTxt').show();
			return false;
		}
		
		var realname = $('#realname').val().trim();
		if(realname=='' || realname==null || realname== undefined ){
			$('#realname').parent().parent().next().html('请输入真实姓名').removeClass().addClass('errorTxt').show();
			return false;
		}
		if(!checkChineseString(realname)){
			return false;
		}
		
		var idnum = $('#idnum').val().trim();
		if(idnum=='' || idnum==null || idnum== undefined ){
			$('#idnum').parent().parent().next().html('请输入身份证号码').removeClass().addClass('errorTxt').show();
			return false;
		}
		var validatecode = $('#validatecode').val().trim();
		if(validatecode=='' || validatecode==null || validatecode== undefined ){
			$('#validatecodeDivHide').html('请输入验证码').removeClass().addClass('errorTxt').show();
			return false;
		}
		
		if ($("#chkagreement").attr('checked') == false)
		{
			alert("请确认您已阅读并同意《巨人用户协议》");
			return false;
		}
		
		
		$('#reuserpwd').val($('#userpwd').val().trim());
		return true;
	}

		
	function submitForm()
	{	
		$('#submitBut').click(function(){
			//测试unbind 【注意如果onclick直接写在html里,unbind是不起作用的。所以把onclick放在ready注册】
			if(checkAllParam()){
				 $('#submitBut').attr('src','images/register_new/jiazai1.gif');
				 send('#f');
			}		
		});
		
	}

	function send(f)
	{
		var options = {
			dataType:"html",
			success: process
		};
		setHiddenValues();
		$(f).ajaxSubmit(options);
	}

	 //获取URL参数
    function getUrlParms()    
    {
		var args=new Object();   
		var query=location.search.substring(1);//获取查询串   
		var pairs=query.split("&");//在逗号处断开   
		for(var i=0;i<pairs.length;i++)
		{   
		    var pos=pairs[i].indexOf('=');//查找name=value   
		    if(pos==-1)continue;//如果没有找到就跳过   
		    var argname=pairs[i].substring(0,pos);//提取name   
		    var value=pairs[i].substring(pos+1);//提取value   
		    args[argname]=unescape(value);//存为属性   
		}
		return args;
    }
    
    
    function setHiddenValues(){
    	var args = getUrlParms();
    	if(args["source"]!=undefined && args["source"]!=''){$('#source').val(args["source"])};
    	if(args["expand"]!=undefined && args["expand"]!=''){$('#expand').val(args["expand"])};
    	if(args["usermark"]!=undefined && args["usermark"]!=''){$('#usermark').val(args["usermark"])};
    	if(args["pwdmark"]!=undefined && args["pwdmark"]!=''){$('#pwdmark').val(args["pwdmark"])};
    	if(args["repwdmark"]!=undefined && args["repwdmark"]!=''){$('#repwdmark').val(args["repwdmark"])};
    	if(args["renamemark"]!=undefined && args["renamemark"]!=''){$('#renamemark').val(args["renamemark"])};
    	if(args["idnummark"]!=undefined && args["idnummark"]!=''){$('#idnummark').val(args["idnummark"])};
    	if(args["valmark"]!=undefined && args["valmark"]!=''){$('#valmark').val(args["valmark"])};
    	if(args["reuserpwd"]!=undefined && args["reuserpwd"]!=''){$('#reuserpwd').val(args["reuserpwd"])};
    	if(args["returnUrl"]!=undefined && args["returnUrl"]!=''){$('#returnUrl').val(args["returnUrl"])};
    	
    	if(document.referrer!=self.location.href)document.getElementById('refurl').value=document.referrer;
  	    document.getElementById('cururl').value=self.location.href;
    }
	
	function process(m) {
		var arr = m.split("|");
		z=arr[0];
		var url =arr[1];
		if ( z == 100 )	
		{
			if (url!=undefined && url!=null && url!=''){
				self.location.href=url;
				return;
			}else{
				location.href='reg_success.jsp';
				return;	
			}
		}
		var o = $('#'+c[z]);
		
		if(z == 121)
		{
			var tv = "该账号已是巨人通行证,您可以<a target=\"_blank\" href=\"http://me.ztgame.com/account_manage/login.jsp\">直接登录</a>或者<a target=\"_blank\" href=\"http://me.ztgame.com/account_manage/find_pwd.jsp?pageId=idSafe_mmzh\">找回密码</a><br/>";
			o.parent().parent().next().html(tv).removeClass().addClass('errorTxt').show();
			/*
			var recs = arr[1].split(",");
		   	$('#recommendUserName').html("<span class='spanTxt'>&nbsp;</span>　 <span class='id_notice'><p><font color='#eb7a00'>推荐您使用</font></p><p><input type='radio' name='TuiJianName' onclick=\"setUserName('"+recs[0]+"')\" />"+recs[0]+"</p><p><input type='radio' onclick=\"setUserName('"+recs[1]+"')\" name='TuiJianName' />"+recs[1]+"</p></span>");
		   	$('#recommendUserName').show();
		   	*/ 
		}
		else if(z==141)
		{
			o.parent().parent().next().html(v[z]+arr[1]).removeClass().addClass('errorTxt').show();
		}
		else if(z==119)
		{
			$('#validatecodeDivHide').html('验证码错误').removeClass().addClass('errorTxt').show();
		}
		else if(z==1190) //刷新该页面，
		{
			window.location.reload();
		}
		else if(z==148)
		{
			$('#validatecodeDivHide').html('验证码失效').removeClass().addClass('errorTxt').show();
		}
		else
		{
			o.parent().parent().next().html(v[z]).removeClass().addClass('errorTxt').show();
		}
		changeImg(); //因为每次失败，验证码都会清空的
		$('#submitBut').attr('src','images/register_new/reg_btn.jpg');
	}
	
	
	function checkChineseString(val)
	{
        var reg = /^[\u0391-\uFFE5]+$/;
        if (val.match(reg)) {
            return true;
        }
        else {
    	$('#realname').parent().parent().next().html('姓名只允许为中文,例如:'+randomName).removeClass().addClass('errorTxt').show();
            return false;
        }
    }
	
	
	function showDiv()
	{
		var xScroll, yScroll;  
		if (window.innerHeight && window.scrollMaxY) {    
			xScroll = window.innerWidth + window.scrollMaxX;  
			yScroll = window.innerHeight + window.scrollMaxY;  
		} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac  
			xScroll = document.body.scrollWidth;  
			yScroll = document.body.scrollHeight;  
		} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari  
			xScroll = document.body.offsetWidth;  
			yScroll = document.body.offsetHeight;  
		}  

		var windowWidth, windowHeight;  
		if (self.innerHeight) { // all except Explorer  
			if(document.documentElement.clientWidth){  
				windowWidth = document.documentElement.clientWidth;   
			} else {  
				windowWidth = self.innerWidth;  
			}  
			windowHeight = self.innerHeight;  
		} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode  
			windowWidth = document.documentElement.clientWidth;  
			windowHeight = document.documentElement.clientHeight;  
		} else if (document.body) { // other Explorers  
			windowWidth = document.body.clientWidth;  
			windowHeight = document.body.clientHeight;  
		}  
	
		var t = (windowHeight - parseInt($(".show_div").height() + 10))/2;
		var l = (xScroll - parseInt($(".show_div").css("width")))/2;
		
		
		$(".show_div").show();
		$("#SHOW_MASK").show();

		$(".show_mask").css({				
			height: (yScroll > windowHeight) ? yScroll : windowHeight
		});

		$(".show_div").css({
			top : t,
			left: l
		});
		
		$(".show_close_btn").click(function(){
			$(".show_div").hide();
			$("#SHOW_MASK").hide();									
		});
		$(".btn_div img").click(function(){
			$(".show_div").hide();
			$("#SHOW_MASK").hide();									
		});
	}
	
	
	
	
	//常量定义..................
	
	v = new Array();
	t = new Array();
	c = new Array();
	v[101] = "请设置通行证名称";
	t[101] = "res_username";
	c[101] = "username";
	
	v[102] = "请输入昵称";
	t[102] = "res_nick";
	c[102] = "";
	
	v[103] = "请输入密码";
	t[103] = "res_pwd";
	c[103] = "userpwd";
	
	v[104] = "两次密码输入的格式不一致";
	t[104] = "res_pwd1";	
	c[104] = "reuserpwd";
	
	v[105] = "请输入电子邮件";
	t[105] = "res_email";
	c[105] = "email";
	
	v[106] = "电子邮件的格式不正确";
	t[106] = "res_email";
	c[106] = "email";
	
	
	
	v[107] = "请输入数字密码";
	t[107] = "res_superpwd";
	c[107] = "superpwd";
	
	
	v[108] = "通行证由数字,字母或下划线组成,并只能以字母或数字开头,字母或数字结尾。";
	t[108] = "res_username";
	c[108] = "username";
	
	v[188] = "系统预留11位纯数字账号作为手机账号,请重新输入您的账号";
	t[188] = "res_username";
	c[188] = "username";
	
	v[199] = "系统错误，请稍候再试";
	t[199] = "res_username";
	c[199] = "username";
	
	v[109] = "数字密码输入不一致";
	t[109] = "res_superpwd1";
	c[109] = "superpwd";
	
	v[110] = "请输入身份证号码";
	t[110] = "res_idnum";
	c[110] = "idnum";
	
	v[111] = "身份证格式错误";
	t[111] = "res_idnum";
	c[111] = "idnum";
	
	v[112] = "请输入真实姓名";
	t[112] = "res_realname";
	c[112] = "realname";
	
	v[113] = "请输入地址";
	t[113] = "res_address";	
	c[113] = "";
	
	v[114] = "请输入邮政编码";
	t[114] = "res_zip";
	c[114] = "";
		
	v[115] = "邮政编码格式错误";
	t[115] = "res_zip";	
	c[115] = "";
	
	v[116] = "请输入电话号码";
	t[116] = "res_tel";	
	c[116] = "";
	
	v[117] = "请输入手机号码";
	t[117] = "res_mp";		
	c[117] = "";
					
	v[118] = "请输入验证码";
	t[118] = "res_validatecode";
	c[118] = "validatecode";
	
	v[119] = "验证码错误";
	t[119] = "res_validatecode";
	c[119] = "validatecode";
		
	v[120] = "请输入生日";
	t[120] = "res_birth";
	c[120] = "";
	
	v[121] = "该账号已是巨人通行证,您可以<a target=\"_blank\" href=\"http://me.ztgame.com/account_manage/login.jsp\">直接登录</a>或者<a target=\"_blank\" href=\"http://me.ztgame.com/account_manage/find_pwd.jsp?pageId=idSafe_mmzh\">找回密码</a>,或选择以下通行证:<br/>";
	t[121] = "res_username";
	c[121] = "username";
	
	v[122] = "昵称包含非法字符";
	t[122] = "res_nick";
	c[122] = "";
	
	v[123] = "数字密码必须是数字";
	t[123] = "res_superpwd";
	c[123] = "superpwd";
	
	v[124] = "真实姓名包含非法字符";
	t[124] = "res_realname";
	c[124] = "realname";
	
	v[125] = "生日格式错误";
	t[125] = "res_sex";
	c[125] = "";
	
	v[126] = "生日格式错误";
	t[126] = "res_birth";
	c[126] = "";
	
	v[127] = "固定联系电话格式错误";
	t[127] = "res_tel";
	c[127] = "";
	
	v[128] = "地址包含非法字符";
	t[128] = "res_address";
	c[128] = "";
	
	v[129] = "移动电话包含非法字符";
	t[129] = "res_mp";
	c[129] = "";
	
	v[130] = "移动电话类型填错";
	t[130] = "res_mp";	
	c[130] = "";
	
	v[131] = "密码由字母，数字或下划线组成";
	t[131] = "res_pwd";
	c[131] = "userpwd";
	
	v[132] = "通行证密码格式错误";
	t[132] = "res_pwd";
	c[132] = "userpwd";
	
	v[133] = "数字密码长度必须为6-8个数字";
	t[133] = "res_superpwd";
	c[133] = "superpwd";
	
	v[134] = "固定电话格式错误";
	t[134] = "res_tel";
	c[134] = "";
	
	v[135] = "请输入区号";
	t[135] = "res_tel";
	c[135] = "";
	
	v[136] = "移动电话格式错误";
	t[136] = "res_mp";
	c[136] = "";
	
	v[137] = "网络连接错误";
	t[137] = "res_comm";
	c[137] = "username";
	
	v[138] = "禁止18周岁以下未成年人注册本游戏";
	t[138] = "res_idnum";	
	c[138] = "idnum";
	
	v[140] = "不能注册ztgame.com或51.com的邮箱";
	t[140] = "res_email";
	c[140] = "email";
			  
	v[141] = "名称中含有不能使用的单词";
	t[141] = "res_username";
	c[141] = "username";
	
	v[142] = "您的出口ip下当天账号注册数超过1000个，请稍候再重新注册";
	t[142] = "res_username";
	c[142] = "username";
	
	v[143] = "请输入通行证确认密码";
	t[143] = "res_pwd1";
	c[143] = "reuserpwd";
	
	v[144] = "请输入数字确认密码";
	t[144] = "res_superpwd1";
	c[144] = "resuperpwd";
	
	v[145] = "巨人通行证必须以字母或数字开头";
	t[145] = "res_username";
	c[145] = "username";
	
	v[146] = "巨人通行证长度必须为6-47个字符";
	t[146] = "res_username";
	c[146] = "username";
	
	v[147] = "通行证密码长度必须为6-16个字符";
	t[147] = "res_pwd";
	c[147] = "userpwd";
			
    v[148] = "验证码失效";
	t[148] = "res_validatecode";
	c[148] = "validatecode";			
	
	v[150] = "您的出口ip下当天账号注册数超过100个，请稍候再重新注册";
	c[150] = "username";
	
	v[151] = "您的出口ip下当月账号注册数超过1000个，请稍候再重新注册";
	c[151] = "username";
	
	v[702] = "请刷新页面,重新注册";
	c[702] = "username";
	
	var nameArray = new Array();
	nameArray[0] = '张三';
	nameArray[1] = '李四';
	nameArray[2] = '王五';
	
	function getRandomName(){
		var r = parseInt(3*Math.random());
		if(r<0 || r>2)r=0;
		return nameArray[r];
	}
	
	function getRandomIdcard(){
		return __Idcard;
	}
	
	
	
	
	