/*获取到Url里面的参数*/
(function ($) {
  $.getUrlParam = function (name) {
   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
   var r = window.location.search.substr(1).match(reg);
   if (r != null) return unescape(r[2]); return null;
  }
 })(jQuery);
var name = $.getUrlParam('fname');
alert(name+"111");
window.onload = function(){
	alert(name+"111");
	$("#vi").append("<source  src='"+name+"' type='video/mp4' />");
	//$("source").prop("src", "file/"+name);
	
}

