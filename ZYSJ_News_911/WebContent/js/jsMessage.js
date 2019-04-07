$(document).ready(function() {
	$("#addMeg").click(function() {
		alert("ddddd");
		$.getJSON("message/insert.do", {
			"megContent" : $("#Megcontent").val()
		}, function(data) {
			alert("评论成功");
		});
	});
});