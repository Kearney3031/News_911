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
function editMes(){ var  userRealName=prompt("请输入你想要修改的用户名",""); 

var param={
		"userRealName":userRealName,
		"temp":"0"
}
$.ajax({
	timeout:20000,
	type:"post",
	dataType:"JSON",
	url:"../../user/edit.do",
	data:param,
	success:function(data){
		
		alert("修改成功");
		location.href="myInformation.jsp";
	}
});

}
function editMes1(){ var  phone=prompt("请输入你想要修改的手机号",""); 

var param={
		"phone":phone,
		"temp":"1"
}


$.ajax({
	timeout:20000,
	type:"post",
	dataType:"JSON",
	url:"../../user/edit.do",
	data:param,
	success:function(data){
		
		alert("修改成功");
		location.href="myInformation.jsp";
	}
});

}



