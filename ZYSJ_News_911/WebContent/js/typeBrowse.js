/*$(document).ready(function(){
		var url="${pageContext.request.contextPath }/type/showAllTypeToFront";
		var args={"time":new Date()};
		$.post(url,args,function(data){
		    var result = "";
		    result+="<tr>";
			for(var i = 0 ;i<data.length;i++){
				result+="<td>"+"<a href="${pageContext.request.contextPath }/news/showNewsByType?typeId=${data[i].typeId}">"+data[i].typeName+"</a>"+"</td>";
			}
			result+="</tr>";
		   $("#mytbody").html(result);
		});
    
  });
	*/