$(document).ready(function(){
	
	$(".deleteType").click(function(){
		var typeName=$(this).next(":hidden").val();//取到当前元素的下一个隐藏域的值
		var flag=confirm("确定要删除"+typeName+"的信息吗？");
		if(flag){
			$tr=$(this).parent().parent();
			var url=this.href;//参数id就传递当前链接中携带的id
		    var args={"time":new Date()};
			$.post(url,args,function(data){//data为执行控制器中的deleteType方法后的结果
				if(data==1){
					alert("删除成功！");
					$tr.remove();//删除当前行
				}else{
					alert("删除失败！");
				}
			})
		} 
		return false;
	})
	

});