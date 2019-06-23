$(document).ready(function(){ 
	
	 $("#quit").live("click",function(){
			location.href="../user/quit.do";
			
			
			
		})

	
	
//	$("#editMes").bind("click",function(){
//		$("body").append("<div>" +
//				"<input id='userRealName' />" +
//				"<input id='edit' type='button' value='确定'/>" +
//				"</div>");
//		
//	})
//	$("#editMes1").bind("click",function(){
//		$("body").append("<div>" +
//				"<input id='phone' />" +
//				"<input id='edit1' type='button' value='确定' />" +
//				"</div>");
//		
//	})
//	$("#edit").live("click",function(){
//		var param={
//				"userRealName":$("#userRealName"),
//				"temp":0
//		}
//		
////		
////		$.ajax({
////			timeout:20000,
////			type:"post",
////			dataType:"JSON",
////			url:"../../user/edit.do",
////			data:param,
////			success:function(data){
////				
////				alert("修改成功");
//////				location.href="myInformation.jsp";
////				
////			}
////		});
//		
//		
//	})
//	$("#edit1").live("click",function(){
//		alert("1111");
//		var param={
//				"phone":$("#phone"),
//				"temp":"1"
//		}
//		alert("2222");
//		
////		$.ajax({
////			timeout:20000,
////			type:"post",
////			dataType:"JSON",
////			url:"../user/edit.do",
////			data:param,
////			success:function(data){
////				
////				alert("修改成功");
//////				location.href="myInformation.jsp";
////				
////			}
////		});
//		 $.getJSON("../user/edit.do",param,function(result){
//		 alert("修改成功");
//		 });
//		 
//		
//		
//	})
	
	

})

	function disp_prompt(){ var  name=prompt("请输入您对本平台不满意的地方",""); 
	
	var param={"feedbackContent":name}
	
	
	$.ajax({
		timeout:20000,
		type:"post",
		dataType:"JSON",
		url:"../user/feedback.do",
		data:param,
		success:function(data){
			
			alert("反馈成功");
			
		}
	});
	
	}


