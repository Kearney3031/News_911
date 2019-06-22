$(document).ready(function(){
	$(".typeBrowse").click(function(){
			var url=this.href;//参数id就传递当前链接中携带的id
		    var args={"time":new Date()};
		    $.post(url,args,function(data){
			    var result ="";
				for(var i = 0 ;i<data.length;i++){
					result+="<tr>";
					result+="<td>"+data[i].newsTitle+"</td>";
					result+="</tr>";
				}
			   $("#pfjthead").html(result);
			});
		})
		return false;
	});