var jsZtgameComHttpProtocol="https:"==document.location.protocol?"https://":"http://";var jsZtgameComUrlAddr=jsZtgameComHttpProtocol+"js.ztgame.com";var jsZtgameComeIsJumpValue="jsjump";var jsZtgameComNoSourceUrlTag="nosource";var jsZtgameComSiteTitle="";var jsZtgameComUrlAddrgametype="";var jsZtgameComUrlAddrdomain=document.domain;var jsZtgameComScreenSize=window.screen.width+"*"+window.screen.height;var _jsZtgameComTracePageID="jslog-trace-id";function setCookieOnJsZtgameCom(sName,sValue,sExpires){if(sExpires==undefined){date=new Date;date.setTime(date.getTime()+300*24*60*60*1000);sExpires=date.toGMTString()}document.cookie=sName+"="+escape(sValue)+"; expires="+sExpires+";domain=.ztgame.com;path=/"}function createSWFonJsZtgameCom(strName,strUrl){var idName=strName+"_flash_contents";var f=document.getElementById(idName);if(f==null){var divSwf=document.createElement("div");divSwf.id=idName;divSwf.style.height="0px";divSwf.style.width="0px";divSwf.style.fontSize="0px";document.body.appendChild(divSwf);f=document.getElementById(idName)}f.innerHTML="";f.innerHTML='<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="0" height="0" id="stat"><param name="movie" value="'+strUrl+'" /> <param name="quality" value="high" /><param name="bgcolor" value="#ffffff" /><param name="allowScriptAccess" value="sameDomain" /><param name="allowFullScreen" value="true" /><object type="application/x-shockwave-flash" data="'+strUrl+'" width="0" height="0"><param name="quality" value="high" /><param name="bgcolor" value="#ffffff" /><param name="allowScriptAccess" value="sameDomain" /><param name="allowFullScreen" value="true" />'+" </object> </object>"}function getArgsJSztgameCom(){var aryParam=document.getElementsByTagName("script");var aryResult={};var intLength=aryParam.length-1;var currentScript=null;for(var i=0;i<aryParam.length;i++){if(aryParam[i].src.search(/js\.ztgame\.com\/stat\.js/)>=0){currentScript=aryParam[i];break}}if(currentScript==null||currentScript.src.indexOf("?")<0){return null}var arySrc=currentScript.src.split("?");if(arySrc.length<2){return null}var aryParam=arySrc[1].split("&");if(aryParam.length>0){for(var i=0;i<aryParam.length;i++){var data=aryParam[i].split("=");aryResult[data[0]]=data[1]}}return aryResult}function getQueryStringOnJsZtgameCom(name){var objReg=new RegExp("(^|&)"+name+"=([^&]*)(&|$)","i");var aryRes=window.location.search.substr(1).match(objReg);if(aryRes!=null){return unescape(aryRes[2])}return null}function getUrlADonJsZtgameCom(){var adID=getQueryStringOnJsZtgameCom("ad");if(adID!=null){return adID}else{return 0}}function getCookieOnJsZtgameCom(cookie_name){var allcookies=document.cookie;var cookie_pos=allcookies.indexOf(cookie_name);if(cookie_pos!=-1){cookie_pos+=cookie_name.length+1;var cookie_end=allcookies.indexOf(";",cookie_pos);if(cookie_end==-1){cookie_end=allcookies.length}var value=unescape(allcookies.substring(cookie_pos,cookie_end))}return value}function CookieIsEnableJSztgameCom(){var result=0;setCookieOnJsZtgameCom("check_cookie_jsztgamecom","123");var cookieVal=getCookieOnJsZtgameCom("check_cookie_jsztgamecom");if(navigator.cookieEnabled&&cookieVal=="123"){result=1}return result}function getFlashVersionJsZtgame(){var h=navigator;if(h.plugins&&h.mimeTypes.length){var b=h.plugins["Shockwave Flash"];if(b&&b.description){return b.description.replace(/([a-zA-Z]|\s)+/,"").replace(/(\s)+r/,".")+".0"}return 0}else{if(window.ActiveXObject&&!window.opera){for(var d=10;d>=2;d--){try{var g=new ActiveXObject("ShockwaveFlash.ShockwaveFlash."+d);if(g){return d+".0.0";break}}catch(f){return 0}}}return 0}}var objOnClickImgJsZtgameComStat=new Image;objOnClickImgJsZtgameComStat.id="js_ztgame_com_stat_js_img_onclick_20130718";objOnClickImgJsZtgameComStat.height=0;objOnClickImgJsZtgameComStat.width=0;var postUrlToJsZtgameComStat="";function traceActionInJsZtgameComStat(tagObject,tagName,eventType){var attribute="";try{tagObject=tagObject.srcElement?tagObject.srcElement:tagObject;switch(tagName){case"a":attribute=tagName+"**~"+tagObject.id+"**~"+tagObject.name+"**~"+tagObject.style.cssText+"**~"+tagObject.title+"**~"+tagObject.className+"**~"+tagObject.innerHTML+"**~"+tagObject.href;objOnClickImgJsZtgameComStat.src=postUrlToJsZtgameComStat+"&actiontype="+eventType+"&elementmark="+encodeURIComponent(attribute)+"&r="+Math.random();break;case"div":case"span":attribute=tagName+"**~"+tagObject.getAttribute(_jsZtgameComTracePageID);objOnClickImgJsZtgameComStat.src=postUrlToJsZtgameComStat+"&actiontype="+eventType+"&elementmark="+encodeURIComponent(attribute)+"&r="+Math.random();break;case"select":attribute=tagName+"**~"+tagObject.id+"**~"+tagObject.name+"**~"+tagObject.style.cssText+"**~"+tagObject.className;objOnClickImgJsZtgameComStat.src=postUrlToJsZtgameComStat+"&actiontype="+eventType+"&elementmark="+encodeURIComponent(attribute)+"&r="+Math.random();break;case"input":attribute=tagName+"**~"+tagObject.id+"**~"+tagObject.name+"**~"+tagObject.value+"**~"+tagObject.style.cssText+"**~"+tagObject.className+"**~"+tagObject.type;objOnClickImgJsZtgameComStat.src=postUrlToJsZtgameComStat+"&actiontype="+eventType+"&elementmark="+encodeURIComponent(attribute)+"&r="+Math.random();break;case"button":attribute=tagName+"**~"+tagObject.id+"**~"+tagObject.name+"**~"+tagObject.value+"**~"+tagObject.style.cssText+"**~"+tagObject.className+"**~"+tagObject.innerHTML;objOnClickImgJsZtgameComStat.src=postUrlToJsZtgameComStat+"&actiontype="+eventType+"&elementmark="+encodeURIComponent(attribute)+"&r="+Math.random();break;case"object":attribute=tagName+"**~"+tagObject.id+"**~"+tagObject.name+"**~"+tagObject.type+"**~"+tagObject.data;objOnClickImgJsZtgameComStat.src=postUrlToJsZtgameComStat+"&actiontype="+eventType+"&elementmark="+encodeURIComponent(attribute)+"&r="+Math.random();break;case"embed":attribute=tagName+"**~"+tagObject.id+"**~"+tagObject.name+"**~"+tagObject.type+"**~"+tagObject.src;objOnClickImgJsZtgameComStat.src=postUrlToJsZtgameComStat+"&actiontype="+eventType+"&elementmark="+encodeURIComponent(attribute)+"&r="+Math.random();break;case"img":attribute=tagName+"**~"+tagObject.id+"**~"+tagObject.name+"**~"+tagObject.style.cssText+"**~"+tagObject.className+"**~"+tagObject.src;objOnClickImgJsZtgameComStat.src=postUrlToJsZtgameComStat+"&actiontype="+eventType+"&elementmark="+encodeURIComponent(attribute)+"&r="+Math.random();break}}catch(e){}}function initTraceActionJsZtgameComStat(){var tagA=document.getElementsByTagName("a");var checkBrows=window.addEventListener;var checkAttr=null;if(tagA.length>0){for(var i=0;i<tagA.length;i++){if(checkBrows){tagA[i].addEventListener("click",function(){traceActionInJsZtgameComStat(this,"a","onclick")},false)}else{tagA[i].attachEvent("onclick",function(){traceActionInJsZtgameComStat(event,"a","onclick")})}}}var tagDIV=document.getElementsByTagName("div");if(tagDIV.length>0){for(var i=0;i<tagDIV.length;i++){checkAttr=tagDIV[i].getAttribute(_jsZtgameComTracePageID);if(checkAttr!=null){if(checkBrows){tagDIV[i].addEventListener("click",function(){traceActionInJsZtgameComStat(this,"div","onclick")},false)}else{tagDIV[i].attachEvent("onclick",function(){traceActionInJsZtgameComStat(event,"div","onclick")})}}}}var tagSPAN=document.getElementsByTagName("span");if(tagSPAN.length>0){for(var i=0;i<tagSPAN.length;i++){checkAttr=tagSPAN[i].getAttribute(_jsZtgameComTracePageID);if(checkAttr!=null){if(checkBrows){tagSPAN[i].addEventListener("click",function(){traceActionInJsZtgameComStat(this,"span","onclick")},false)}else{tagSPAN[i].attachEvent("onclick",function(){traceActionInJsZtgameComStat(event,"span","onclick")})}}}}var tagBut=document.getElementsByTagName("button");if(tagBut.length>0){for(var i=0;i<tagBut.length;i++){if(checkBrows){tagBut[i].addEventListener("click",function(){traceActionInJsZtgameComStat(this,"button","onclick")},false)}else{tagBut[i].attachEvent("onclick",function(){traceActionInJsZtgameComStat(event,"button","onclick")})}}}var tagselect=document.getElementsByTagName("select");if(tagselect.length>0){for(var i=0;i<tagselect.length;i++){if(checkBrows){tagselect[i].addEventListener("change",function(){traceActionInJsZtgameComStat(this,"select","onchange")},false)}else{tagselect[i].attachEvent("onchange",function(){traceActionInJsZtgameComStat(event,"select","onchange")})}}}var taginput=document.getElementsByTagName("input");if(taginput.length>0){for(var i=0;i<taginput.length;i++){if(checkBrows){taginput[i].addEventListener("click",function(){this.focus()},false);taginput[i].addEventListener("focus",function(){traceActionInJsZtgameComStat(this,"input","onfocus")},false)}else{taginput[i].attachEvent("onfocus",function(){traceActionInJsZtgameComStat(event,"input","onfocus")})}}}var tagimg=document.getElementsByTagName("img");if(tagimg.length>0){for(var i=0;i<tagimg.length;i++){if(checkBrows){tagimg[i].addEventListener("click",function(){traceActionInJsZtgameComStat(this,"img","onclick")},false)}else{tagimg[i].attachEvent("onclick",function(){traceActionInJsZtgameComStat(event,"img","onclick")})}}}}var jsZtgameComFlaseVer=getFlashVersionJsZtgame();var arrjsZtgameComFlaseVer=new Array;if(jsZtgameComFlaseVer!=0){arrjsZtgameComFlaseVer=jsZtgameComFlaseVer.split(".")}var jsZtgameComPageClickImgObject=new Image;jsZtgameComPageClickImgObject.id="js_ztgame_com_stat_js_img_20120425";jsZtgameComPageClickImgObject.height=0;jsZtgameComPageClickImgObject.width=0;function writeStatLogsJsZtgameCom(strName,strFlashUrl,strHtmlUrl){jsZtgameComPageClickImgObject.src=strHtmlUrl}function onClickStatToJsZtgameCom(name,title){var preurl=encodeURIComponent(window.location.href);if(jsZtgameComUrlAddrJsType==2){document.domain="ztgame.com";preurl=encodeURIComponent(window.top.location.href)}var noSourceUrl=getQueryStringOnJsZtgameCom(jsZtgameComNoSourceUrlTag);if(noSourceUrl!=null&&noSourceUrl!=""){preurl=encodeURIComponent(noSourceUrl)}var url=jsZtgameComUrlAddr+"/click_stat.php?title="+jsZtgameComSiteTitle+"&preurl="+preurl+"&cururl="+name+"&userAgent="+encodeURIComponent(navigator.userAgent)+"&gametype="+jsZtgameComUrlAddrgametype+"&domain="+jsZtgameComUrlAddrdomain+"&other="+title+"&supportcookie="+CookieIsEnableJSztgameCom()+"&screen="+jsZtgameComScreenSize+"&"+Math.random();var jsZtgameComFlashStatUrl=jsZtgameComUrlAddr+"/stat.swf?ad="+getUrlADonJsZtgameCom()+"&jump="+encodeURIComponent(url);writeStatLogsJsZtgameCom("onclick_stat_js_ztgame_com",jsZtgameComFlashStatUrl,url);return}var jsZtgameComIsWriteLog=getQueryStringOnJsZtgameCom("from");if(jsZtgameComIsWriteLog!=jsZtgameComeIsJumpValue){var jsZtgameComUrlAddrother="";var jsZtgameComUrlAddrJsType="";var jsZtgameComJumpUrlAddr="";try{jsZtgameComUrlAddrgametype=getArgsJSztgameCom()["gametype"];jsZtgameComUrlAddrother=getArgsJSztgameCom()["other"];jsZtgameComUrlAddrJsType=Number(getArgsJSztgameCom()["jstype"]);jsZtgameComJumpUrlAddr=decodeURIComponent(getArgsJSztgameCom()["jumpurl"]);jsZtgameComSiteTitle=document.getElementById("title123").value}catch(e){jsZtgameComSiteTitle=encodeURIComponent(document.title)}var jsZtgameComReferer=document.referrer;var jsZtgameComeCookieName="JS_ZTGAME_COM_JUMP_"+jsZtgameComUrlAddrgametype;jsZtgameComFlaseVer=encodeURIComponent(jsZtgameComFlaseVer);var jsZtgameComCurrentUrl=window.location.href;var noSourceUrlOnJsZtgameCom=getQueryStringOnJsZtgameCom(jsZtgameComNoSourceUrlTag);if(noSourceUrlOnJsZtgameCom!=null&&noSourceUrlOnJsZtgameCom!=""){jsZtgameComReferer=encodeURIComponent(noSourceUrlOnJsZtgameCom)}var boolIsJumpOnjsZtgameCom=false;if(jsZtgameComJumpUrlAddr!="undefined"&&jsZtgameComJumpUrlAddr!=""&&jsZtgameComJumpUrlAddr!=null){var jsZtgameCom_cookie_val=getCookieOnJsZtgameCom(jsZtgameComeCookieName);if(jsZtgameCom_cookie_val=="undefined"||jsZtgameCom_cookie_val==""||jsZtgameCom_cookie_val==null){boolIsJumpOnjsZtgameCom=true;jsZtgameComCurrentUrl=jsZtgameComHttpProtocol+window.location.host+"/"+jsZtgameComJumpUrlAddr+window.location.search;setCookieOnJsZtgameCom(jsZtgameComeCookieName,window.location.host)}}if(jsZtgameComUrlAddrJsType!=2){var jsZtgameComeSwfParamUrl=jsZtgameComUrlAddr+"/stat.php?flashver="+jsZtgameComFlaseVer+"&title="+jsZtgameComSiteTitle+"&preurl="+encodeURIComponent(jsZtgameComReferer)+"&cururl="+encodeURIComponent(jsZtgameComCurrentUrl)+"&userAgent="+encodeURIComponent(navigator.userAgent)+"&gametype="+jsZtgameComUrlAddrgametype+"&domain="+jsZtgameComUrlAddrdomain+"&other="+jsZtgameComUrlAddrother+"&supportcookie="+CookieIsEnableJSztgameCom()+"&screen="+jsZtgameComScreenSize+"&"+Math.random();var jsZtgameComFlashStatUrl=jsZtgameComUrlAddr+"/stat.swf?ad="+getUrlADonJsZtgameCom()+"&jump="+encodeURIComponent(jsZtgameComeSwfParamUrl);writeStatLogsJsZtgameCom("stat_js_ztgame_com",jsZtgameComFlashStatUrl,jsZtgameComeSwfParamUrl)}if(boolIsJumpOnjsZtgameCom){window.location.href=jsZtgameComJumpUrlAddr}try{var jsZtgameComUrlAddrTraceActionType=parseInt(getArgsJSztgameCom()["eletype"]);if(jsZtgameComUrlAddrTraceActionType==2){postUrlToJsZtgameComStat=jsZtgameComUrlAddr+"/stat.php?flashver="+jsZtgameComFlaseVer+"&title="+jsZtgameComSiteTitle+"&preurl="+encodeURIComponent(jsZtgameComReferer)+"&cururl="+encodeURIComponent(jsZtgameComCurrentUrl)+"&userAgent="+encodeURIComponent(navigator.userAgent)+"&gametype="+jsZtgameComUrlAddrgametype+"&domain="+jsZtgameComUrlAddrdomain+"&other="+jsZtgameComUrlAddrother+"&supportcookie="+CookieIsEnableJSztgameCom()+"&screen="+jsZtgameComScreenSize;initTraceActionJsZtgameComStat()}}catch(e){}};