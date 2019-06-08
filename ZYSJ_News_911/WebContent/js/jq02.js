$(document).ready(function(){  
	
	$("#delete").click(function(){
		$(this).parent().parent().remove();
		var param={"id":$(this).parent().siblings().eq(0).html()}
		
		
		$.ajax({
			timeout:20000,
			type:"post",
			dataType:"JSON",
			url:"user/delete.do",
			data:param,
			success:function(data){
				
				alert("删除成功");
				
			}
		});
		
		
		
		
	})
	$("#update").live("click",function(){
		
		 oldvalue=$(this).parent().siblings().eq(1).html();
		var okbtn="<input type='button' id='okbtn' name='okbtn' value='ok' />"
		var canbtn="<input type='button' id='canbtn' name='canbtn' value='cancel' />"
		var edit="<input type='text' id='edit'  />";
		$(this).parent().siblings().eq(1).replaceWith(edit);
		//$(this).parent().prev().val(oldvalue);
		$(this).replaceWith(okbtn+canbtn);
		//$(this).parent().siblings().eq(2).replaceWith(okbtn);
		//$(this).parent().siblings().eq(2).append(canbtn);
	});
	$("#okbtn").live("click",function(){
		
		var newvalue=$("#edit").val();
		
		$(this).parent().siblings().eq(1).replaceWith("<td>"+newvalue+"</td>");;
var param={"name":$(this).parent().siblings().eq(1).html(),
		"id":$(this).parent().siblings().eq(0).html()}
		
		$(this).parent().replaceWith("<td><input  type='button' value='修改' id='update' /></td>");
		
		
		$.ajax({
			timeout:20000,
			type:"post",
			dataType:"JSON",
			url:"user/update.do",
			data:param,
			success:function(data){
				
				alert("修改成功");
				
			}
		});
		
		
	});
	$("#canbtn").live("click",function(){
		$(this).parent().siblings().eq(1).replaceWith("<td>"+oldvalue+"</td>");
		$(this).parent().replaceWith("<td><input  type='button' value='修改' id='update' /></td>");
		
		
	});
	
		

	$("#login").click(function(){
		location.href="../front/user/login.jsp";
		
		
		
		
		
		
	})
	$("#reg").click(function(){
		location.href="../front/user/register.jsp";
		
		
		
		
		
		
	})

})
