//$(document).ready(function() {
//	alert("aaaaa");
//	var now= "ddd";
//	$.getJSON("message/find2.do", function(data) {
//		alert("ddddd");
////		var str = JSON.stringify(data)  
////		alert(str);
//        $.each(data,function(i,item){
//	        	
//	        	alert(item.megContent);
//	        	oHtml = '<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="images/header-img-comment_03.png" alt=""></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name">David Beckham : </a> <span class="my-pl-con">&nbsp;'
//	   			 + item.megContent +'</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'
//	   			 +now+'</span> <div class="date-dz-right pull-right comment-pl-block"><a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';
//	        	 if(item.megContent.replace(/(^\s*)|(\s*$)/g, "") != ''){
//	 	        	$('.commentAll').parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
//	 	        	$('.commentAll').siblings('.flex-text-wrap').find('.comment-input').prop('value','').siblings('pre').find('span').text('');
//	 	        }
//		});
//	});
//	
//});