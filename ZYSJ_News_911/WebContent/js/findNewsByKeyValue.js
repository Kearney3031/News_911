$(document).ready(function(){
	$("#mysubmit").click(function(){
			var url="/news/showNewsByKey.do";
			var keyValue=$("#findNewsByKeyValue").val();
		    var args={"keyValue":keyValue};
		 
		    $.post(url,args,function(data){
			    var result ="";
					result+="<tr>";
					result+="<td>"+data.newsTitle+"</td>";
					result+="<td>"+data.newsContent+"</td>";
					result+="</tr>";
			   $("#pfjtbody").html(result);
			});
		})
		return false;
	});