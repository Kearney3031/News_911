$(document).ready(function(){  
	
	$("#download").click(function(){
		alert("1111");
		var param={"filename":$("#src").attr("src")}
		$.ajax({
			timeout:20000,
			type:"post",
			dataType:"JSON",
			url:"../../video/download.do",
			data:param,
			success:function(data){
				
				
			}
		});
		
		
		
		
	})
	
	

})
