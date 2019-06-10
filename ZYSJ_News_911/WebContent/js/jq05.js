$(document).ready(function(){  
	
	$("#download").live("click",function(){
		alert("1111");
		alert("2222");
		
		var param={}
		$.ajax({
			timeout:20000,
			type:"post",
			dataType:"JSON",
			url:"",
			data:param,
			success:function(data){
				alert("下载成功");
				
			}
		});
		
		
		
		
	})
	
	

})
