$(document).ready(function(){  
	
	$("#download").click(function(){
		
		var param={"videoName":$("#src").attr("src")}
		$.ajax({
			timeout:20000,
			type:"post",
			dataType:"JSON",
			url:"../../user/download.do",
			data:param,
			success:function(data){
				
				alert("删除成功");
				
			}
		});
		
		
		
		
	})
	
	

})
