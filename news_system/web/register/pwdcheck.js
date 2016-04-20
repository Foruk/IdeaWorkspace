
function PasswordStrength()
{	
	this.minLen = 4;
	this.maxLen = 10;
	this.pwdCharSet="A-Za-z0-9";
	this.caseInsensitive=false;
	this.Description="";
	this.userName="";
	this.applyRulesDesc=new Array();
	this.errorId="0";
}

PasswordStrength.prototype.$ = function(s) {
	return document.getElementById(s);
}

PasswordStrength.prototype.setMinLen = function(n){
	if(isNaN(n))
	{
		return ;
	}
	n = Number(n);
	if(n>1)
	{
		this.minLen = n;
	}
}
PasswordStrength.prototype.setMaxLen = function(n){
	if(isNaN(n))
	{
		return ;
	}
	n = Number(n);
	if(n >=this.minLen)
	{
		this.maxLen = n;
	}
}
PasswordStrength.prototype.setPwdCharSet = function(s){
	this.pwdCharSet=s;
}
PasswordStrength.prototype.getDescription =function() {
	return this.Description;
}
//大小写敏感
PasswordStrength.prototype.setCaseInsensitive = function(s){
	this.caseInsensitive=s;
}
PasswordStrength.prototype.setUserName = function(s) {
	this.userName=s;
}
PasswordStrength.prototype.getApplyRulesDesc =function () {
	return this.applyRulesDesc;
}
PasswordStrength.prototype.getErrorId = function (){
	return this.errorId;
}

//检查密码的长度和字符是否满足
PasswordStrength.prototype.checkPwd = function(s) {
	var lvRegExp=new RegExp("^["+this.pwdCharSet+"]{"+this.minLen+","+this.maxLen+"}$",this.caseInsensitive?"":"i");
	return lvRegExp.test(s);
}
//检查密码是否是社会工程字典中的密码
PasswordStrength.prototype.checkDict = function(s) {
	var lvDicts=new Array("shanda","asdfg","asdfgh","qwert","qwerty","zxcvb","zxcvbn",
												"Password","Passwd","Woaini","Iloveyou","Woaiwojia","521521","5201314","7758521","1314520","1314521",
												"520520","201314","211314","7758258","147258369","159357",
												"test","snda","12345","123456","1234567","12345678","123456789","asdf","qwer","zxcv","654321","123123",
												"123321","123abc");
    var lvDicts=new Array();
	if(this.caseInsensitive==false)
	{
		s=s.toUpperCase();
	}
	for(var i=0;i<lvDicts.length;i++)
	{
		if(s==(this.caseInsensitive?lvDicts[i]:lvDicts[i].toUpperCase()))
		{
			return s;
		}
  }									 
  return "";
}
PasswordStrength.prototype.getLevel = function(s)
{
	this.applyRulesDesc=new Array();
	//this.errorId="0";
	
		
			
			/*if(this.caseInsensitive==false)
			{
				lvUserName=lvUserName.toUpperCase();
				lvPwd=lvPwd.toUpperCase();
            }*/
			/*if(lvUserName==lvPwd)
			{
					this.errorId="3";
					this.applyRulesDesc.push("规则 2:	密码与用户名相同");
					//this.Description="密码与用户名相同";
					this.Description="对不起，请勿使用与用户名相同的密码";
					return 0;
			}*/
			var ls = 0;
			if( (this.caseInsensitive? s.match(/[a-z]/g): s.match(/[a-z]/ig)))
			{
			    this.applyRulesDesc.push("规则 4: 密码包含字母,权重加1");
			    ls++;
            }
			if (s.match("[0-9]","ig"))
			{
				this.applyRulesDesc.push("规则 5: 密码含有数字,权重加1");
				ls++;
			}
			if (s.length < 6 && ls > 1)
			{
				this.applyRulesDesc.push("规则 7: 密码长度小于6且权重大于1,权重减1");
				ls--;
			}	
			if (s.length >= 8 && ls == 2)
			{
				this.applyRulesDesc.push("规则 8: 密码长度大于等于8且权重等于2,权重加1");
				ls++;
			}
			if (ls > 1 && !this.samePwd(s))
			{
				this.applyRulesDesc.push("规则 9: 连续重复的数字/字母,权重减1");
				ls--;
			}
			if (ls > 1 && !this.increasePwd(s) )
			{
				this.applyRulesDesc.push("规则 12: 连续递增的数字（仅仅是数字）长度占到总密码长度的50%以上,权重减1");
				ls--;
			}
			if (ls > 1 && !this.descendingPwd(s))
			{
				this.applyRulesDesc.push("规则 12: 连续递减的数字（仅仅是数字）长度占到总密码长度的50%以上,权重减1");
				ls--;
			}
			if(ls==1 && this.checkDigitial(s)) //连续/重复数字   权重－1
			{
				//this.errorId="4"
				this.applyRulesDesc.push("规则 10: 当密码中全是连续/重复的数字,权重减1");
				//this.Description="密码为连续或重复的数字";
				//this.Description="对不起，请不要将连续或重复的数字作为密码";
				ls--;
			}
			if(ls==1 && this.checkCharLetter(s))	//连续/重复字母 权重－1
			{
				//this.errorId="5"
				this.applyRulesDesc.push("规则 10: 当密码中全是连续/重复的字母,权重减1");
				//this.Description="密码为连续或重复的字母";
				//this.Description="对不起，请不要以连续或重复的字母作为密码";
				ls--;
			}
			if(ls>1 && this.checkDigitialCharLetters(s)) //密码包含字母和数字，且字母和数字皆连续，权重-1
			{
				this.applyRulesDesc.push("规则 11: 密码包含字母和数字，且字母和数字皆连续,权重减1");
				ls--;
			}
			if(ls==2 && this.checkCharLetterCounts(s,1))	//一个字母和数字组合情况，权重－1
			{
				this.applyRulesDesc.push("规则 14: 权重为2，只有一种字母与数字组合,权重减1");
				ls--;
			}
			if(ls==3 && this.checkCharLetterCounts(s,2)) //小于等于2个字母和数字组合情况，权重-1
			{
				this.applyRulesDesc.push("规则 14: 权重为3，只有一种或二种字母与数字组合,权重减1");
				ls--;
		    }
			return ls;
}
 	  
	
	

PasswordStrength.prototype.checkCharLetterCounts = function(p,pvCounts) {
	var s=p.toUpperCase();
	if(this.caseInsensitive)
	{
		s=p;
  }
  var lvRegExp=new RegExp("^[A-Za-z]$","");
  var lvLastChar="";
  var lvCharCounts=0;
  for(var i=0;i<s.length;i++)
  {
  	var c=s.substring(i,i+1);
  	if(lvRegExp.test(c))
  	{
  		if(lvLastChar.indexOf(c)==-1)
  		{
  			lvCharCounts++;
  			lvLastChar=lvLastChar+c;
  		}
  	}
  }  
  return (lvCharCounts<=pvCounts);
}
PasswordStrength.prototype.convertCharLetterInt= function(p){
	var s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	for(var i=0;i<s.length;i++)
	{
		if(s.substring(i,i+1)== (this.caseInsensitive?p:p.toUpperCase()))
		{
			return i;
		}
	}
	return -1;
}
PasswordStrength.prototype.checkDigitialCharLetters = function(p){
	var s=p.toUpperCase();
	if(this.caseInsensitive)
	{
		s=p;
  }
  var c=s.substring(0,1);
  var lvRegExp=new RegExp("^[0-9]$","");
  var lvDigitialChar="";
  var lvCharLetter="";
  var lvNeedChecking=true;
  if(lvRegExp.test(c)) //数字开始
  {
  	lvDigitialChar=c;
  	var lvDigitialing=true;
  	for(var i=1;i<s.length;i++)
  	{
  		c=s.substring(i,i+1);
  		if(lvDigitialing)
  		{
	  		if(lvRegExp.test(c))
	  		{
	  			lvDigitialChar=lvDigitialChar+c;
	  		}
	  		else
	  		{
	  			lvDigitialing=false;
	  		}
  		}
  		else
 			{
 				if(lvRegExp.test(c))
 				{
 					lvNeedChecking=false;
 					break;
 				}
 			}
    }
    if(lvNeedChecking)
    {
    	lvCharLetter=s.substring(lvDigitialChar.length,s.length);
    }  	
  }  
  else //字符开始
 	{
 		lvCharLetter=c;
 		var lvCharLettering=true;
 		for(var i=1;i<s.length;i++)
 		{
 			c=s.substring(i,i+1);
 			if(lvCharLettering)
 			{
 					if(lvRegExp.test(c)==false)
 					{
 							lvCharLetter=lvCharLetter+c;
 					}			
 					else
 					{
 							lvCharLettering=false;
 					}
 		  }
 		  else
 		  {
 		  	if(lvRegExp.test(c)==false)
 		  	{
 		  		lvNeedChecking=false;
 		  		break;
 		  	}
 		  }
 		}
 		if(lvNeedChecking)
 		{
 			lvDigitialChar=s.substring(lvCharLetter.length,s.length);
 	  }	
 	}
 	return (lvNeedChecking && this.checkDigitial(lvDigitialChar) && this.checkCharLetter(lvCharLetter));
}
PasswordStrength.prototype.checkCharLetter= function(p){
	var s=p.toUpperCase();
	if(this.caseInsensitive)
	{
		s=p;
  }	
	var lvLastChar=s.substring(0,1);
	var lvLetterDiff=0;
	if(isNaN(lvLastChar))
	{
			for(var i=1;i<s.length;i++)
			{
				var c=s.substring(i,i+1);
				if(isNaN(c))
				{
					if(i==1)
					{
						lvLetterDiff=this.convertCharLetterInt(c)-this.convertCharLetterInt(lvLastChar);
						if(lvLetterDiff!=0 && lvLetterDiff!=1 && lvLetterDiff!=-1)
						{
							return false;	
						}			
					}
					else
					{
						if((this.convertCharLetterInt(c)-this.convertCharLetterInt(lvLastChar))!=lvLetterDiff)
						{
							return false;	
						}			
						
					}
					lvLastChar=c;				
				}
				else
				{
					return false;
				}			
			}
			return true;			
	}
	else
	{
		return false;
	}
}
PasswordStrength.prototype.checkDigitial = function(s){
	var lvLastChar=s.substring(0,1);
	var lvDigitialDiff=0;
	if(isNaN(lvLastChar)==true)
	{
		return false;
  }	
	for(var i=1;i<s.length;i++)
	{
		var c=s.substring(i,i+1);
		if(isNaN(c)==false)
		{
			if(i==1)
			{
				lvDigitialDiff=parseInt(c)-parseInt(lvLastChar);
				if(lvDigitialDiff!=0 && lvDigitialDiff!=1 && lvDigitialDiff!=-1)
				{
					return false;	
				}			
			}
			else
			{
				if((parseInt(c)-parseInt(lvLastChar))!=lvDigitialDiff)
				{
					return false;	
				}			
			}
			lvLastChar=c;				
		}
		else
		{
			return false;
		}			
	}	
	return true;
}
PasswordStrength.prototype.samePwd = function(s)
{
	if(this.caseInsensitive==false)
	{
		s=s.toUpperCase();
	}
	var errorLength = 0;
	var tmpLength = 1;
	var i = 0;
	for(i=1;i<s.length;i++)
	{
		if(!isNaN(s.substr(i,1)) && !isNaN(s.substr(i-1,1)))
		{
		    if(s.substr(i,1) == s.substr(i-1,1))
		    {
			    tmpLength++;	
		    }
		    else
		    {
			    tmpLength = 1;
		    }
		    if(tmpLength > errorLength)
		    {
			    errorLength = tmpLength;
		    }
		}
	}
	if(errorLength>=(s.length/2))
	{
		return false;
	}
	else
	{
		return true;
	}
}
PasswordStrength.prototype.increasePwd = function(s)
{
	var errorLength = 0;
	var tmpLength = 1;
	var i = 0;
	for(i=1;i<s.length;i++)
	{
		if(!isNaN(s.substr(i,1)) && !isNaN(s.substr(i-1,1)))
		{
			if(Number(s.substr(i,1)) == Number(s.substr(i-1,1)) + 1)
			{
				tmpLength++;	
			}
			else
			{
				tmpLength = 1;
			}
			if(tmpLength > errorLength)
			{
				errorLength = tmpLength;
			}
		}
	}
	if(errorLength>=(s.length/2))
	{
		return false;
	}
	else
	{
		return true;
	}
}
PasswordStrength.prototype.descendingPwd = function(s)
{
	var errorLength = 0;
	var tmpLength = 1;
	var i = 0;
	for(i=1;i<s.length;i++)
	{
		if(!isNaN(s.substr(i,1)) && !isNaN(s.substr(i-1,1)))
		{
			if(Number(s.substr(i,1)) == Number(s.substr(i-1,1)) - 1)
			{
				tmpLength++;	
			}
			else
			{
				tmpLength = 1;
			}
			if(tmpLength > errorLength)
			{
				errorLength = tmpLength;
			}
		}
	}
	if(errorLength>=(s.length/2))
	{
		return false;
	}
	else
	{
		return true;
	}
}