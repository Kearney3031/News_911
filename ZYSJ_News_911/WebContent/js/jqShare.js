$(document).ready(function(){  
	var title=null;
	var url=null;
	var picurl=null;
	
//分享到新浪微博
function shareToXl(title,url,picurl){
var sharesinastring='http://v.t.sina.com.cn/share/share.php?title='+title+'&url='+url+'&content=utf-8&sourceUrl='+url+'&pic='+picurl;
window.open(sharesinastring,'newwindow','height=400,width=400,top=100,left=100');
}

//分享到qq空间
function shareToQq(title,url,picurl){
var shareqqzonestring='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?summary='+title+'&url='+url+'&pics='+picurl;
window.open(shareqqzonestring,'newwindow','height=400,width=400,top=100,left=100');
}
function subinfo(){
shareToQq("测试标题","www.baidu.com","http://aladdin-vray.oss-cn-beijing.aliyuncs.com/Other/80de988c-ad11-449b-af48-b5341c957668.jpg");
}



$("#shareToQQ").click(function(){
	url = window.location.href;
	title = document.title;
	alert(title);
	shareToQq(title,url,picurl);
});
$("#shareToXl").click(function(){
	url = window.location.href;
	title = document.title;
	//alert(title);
	shareToXl(title,url,picurl);
});




var v = false;
//var param={"userId":${user.userId},"newsId":${news.newsId}};
$( "#collect").click( function() {
	alert("aaaaa");
    if( v ) {    
        $( this ).html( "收藏该文章" );
    	$.ajax({
		timeout:20000,
		type:"post",
		dataType:"JSON",
		url:"user/deleteUserCollectNews.do",
		//data:param,
		success:function(data){
			
		}
	});
    	alert("取消收藏成功！");
        v = false; //由于文字已更改，所以我们要改变变量的值
    } else {
        $( this ).html( "取消收藏" );
        $.ajax({
    		timeout:20000,
    		type:"post",
    		dataType:"JSON",
    		url:"user/addUserCollectNews.do",
    		//data:param,
    		success:function(data){
    		}
    	});
        alert("收藏成功！");
        v = true;
    }
} );
});