$(document).ready(function(){ 
	
	 $("#quit").live("click",function(){
			location.href="../user/quit.do";
			
			
		})

	
	
	$("#editMes").bind("click",function(){
		$("body").append("<div>" +
				"<input id='userName' />" +
				"<input id='password' type='password' />" +
				"<input id='userRealName' />" +
				"<input id='phone' />" +
				"<input id='email' />" +
				"<input id='edit' type='button' />" +
				"</div>");
		
	})
	$("#edit").live("click",function(){
		var param={"userName":$("#userName"),
				"password":$("#password"),
				"userRealName":$("#userRealName"),
				"phone":$("#phone"),
				"email":$("#email")
		}
		
		
		$.ajax({
			timeout:20000,
			type:"post",
			dataType:"JSON",
			url:"../../user/edit.do",
			data:param,
			success:function(data){
				
				alert("修改成功");
				
			}
		});
		
		
	})
	
	

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


