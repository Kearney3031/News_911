$(document).ready(function(){  
	alert("1111111");
	var code="";
	$("#login").bind("click",function(){
		 
	 var username=$("#username1").val();
	 if(username.indexOf("@qq.com")>0||username.indexOf("@126.com")>0||username.indexOf("@163.com")>0){
		 alert(123);
			var param={"email":$("#username1").val(),
					
						"password":$("#password").val()
			}
			
			
			$.ajax({
				timeout:20000,
				type:"post",
				dataType:"JSON",
				url:"user/login.do",
				data:param,
				success:function(data){
					
					if(data[0]=="error"){
						alert("账号或密码错误");
						location.href="../../front/user/login.jsp";
						
					}
					else{
						location.href="../../front/user/index.jsp";
					}
					
					
				}
			});
	 }
	  else {
		  alert(123456);
		 
		  var param={"username":$("#username1").val(),
				  
					"password":$("#password").val()
		}
			
		 
			$.ajax({
				timeout:20000,
				type:"post",
				dataType:"JSON",
				url:"../../user/login.do",
				data:param,
				success:function(data){
					if(data[0]=="error"){
						alert("账号或密码错误");
						location.href="../../front/user/login.jsp";
						
					}
					else{
						location.href="../../front/user/index.jsp";
					}
					
					
				}
			});
	 }
	 
	
		
		
	})
	
	$("#username").change(function(){
		var reg = /^[0-9a-zA-Z]+$/

			var str = $(this).val();
		if(!reg.test(str)){
			$(this).val("");
			alert("用户名只能包括字母或者数字")

			}
		
	})
	$("#sendmail").bind("click",function(){

		alert("1111");
		var param={"email":$("#email").val()}
		alert($("#email").val())
		
		$.ajax({
			timeout:20000,
			type:"post",
			dataType:"JSON",
			url:"../../user/sendmail.do",
			data:param,
			success:function(data){
				alert(data[0]);
				code=data[0];
				
				
				
			}
		});
		
		
		
		
	
		
	})
	$("#code").change(function(){
		alert("11111")
		if($(this).val()==code){
			
		}
		else{
			$(this).val("");
			alert("验证码输入错误");
		}
		
		
	})

})
