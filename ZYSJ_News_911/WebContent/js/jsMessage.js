$(document).ready(function() {

	var id="22";
	

		$("#addLike").toggle(function(){$.getJSON("message/addLike.do", {
		"id" : id
	}, function(data) {
		//alert("删除成功"); 
	}) },function(){$.getJSON("message/subLike.do", {
		"id" : id
	}, function(data) {
		//alert("删除成功"); 
	}) });
	
		
		
});