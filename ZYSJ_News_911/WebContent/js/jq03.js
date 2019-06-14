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
				url:"../../user/login.do",
				data:param,
				success:function(data){
					
					if(data[0]=="error"){
						alert("账号或密码错误");
						location.href="login.jsp";
						
					}
					else if(data[0]=="suc1"){
						location.href="editor.jsp";
					}
					else{
						location.href="../zhuye.jsp";
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
						location.href="login.jsp";
						
					}
					else if(data[0]=="suc1"){
						location.href="editor.jsp";
					}
					else{
						location.href="../zhuye.jsp";
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
//	还要加一个判断是否为邮箱
	$("#submit").bind("click",function(){
		var var1=$("#username").val();
		var var2=$("#pwd").val();
		var var3=$("#rname").val();
		var var4=$("#phone").val();
		var var5=$("#email").val();
		var var6=$("#code").val();
		var var7=$(".type").val();
		
		if(var1==null||var2==null||var3==null||var4==null||var5==null||var6==null||var7==null){
			alert("不能为空");
			
			$("#username").val(var1);
			$("#pwd").val(var2);
			$("#rname").val(var3);
			$("#phone").val(var4);
			$("#email").val(var5);
			$("#code").val(var6);
			$(".type").val(var7);
		}
		else{
		var param={"username":var1,"password":var2,"realname":var3,"phone":var4,"email":var5,"userType":var7}
		
		
		$.ajax({
			timeout:20000,
			type:"post",
			dataType:"JSON",
			url:"../../user/reg.do",
			data:param,
			success:function(data){
				
				location.href="../zhuye.jsp";
				
				
			}
		});
		}
		
		
		
		
	
		
	})
	
	
	
	
	
	
	
	$("#login1").bind("click",function(){
		 
	alert("123123");
	 
		  
		 
		  var param={"username":$("#username1").val(),
				  
					"password":$("#password").val()
		}
			
		 
			$.ajax({
				timeout:20000,
				type:"post",
				dataType:"JSON",
				url:"../user/login1.do",
				data:param,
				success:function(data){
					if(data[0]=="error"){
						alert("账号或密码错误");
						location.href="login.jsp";
						
					}
					else{
						location.href="manage.jsp";
					}
					
					
				}
			});
	 
	 
	
		
		
	})
	$("#notice").bind("click",function(){
		$(".content").css("visibility","visible");
	})
	$("#can").bind("click",function(){
		$(".content").css("visibility","hidden");
	})
	$("#ok").bind("click",function(){
		
		 
		  
		 
		  var param={"content":$("#content").val()
				  
					
		}
			
		 
			$.ajax({
				timeout:20000,
				type:"post",
				dataType:"JSON",
				url:"../notice/updateNotice.do",
				data:param,
				success:function(data){
					$(".content").css("visibility","hidden");
					alert("修改成功");
					
				}
			});
		
		
	})

})
