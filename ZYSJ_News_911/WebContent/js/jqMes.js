$(document).ready(function() {

var btnDelete="<input type='button' value='删除' name='delete'/>";
var btnUpdate="<input type='button' value='修改' name='update'/>";
var btnOK="<input type='button' value='确定' name='ok'/>";
var btnCancel="<input type='button' value='取消' name='cancel'/>";
var txtNum="<input type='text' size=2 value='0' />";

//alert($("input:text[name='jj']").val());

var id;
var name;
var num;
var price;
var ck="<input type='checkbox' name='ck'/>";
//var newTr="<tr><td>"+name+"</td><td>"+$("input:text[name='num']").val()+"</td><td>&yen;"+$("input:text[name='price']").val()+"</td>";
//	newTr+="<td>"+btnDelete+" "+btnUpdate+"</td><td>"+ck+"</td></tr>";
var newTr;
var oldvalue;




$("#order input[name='delete']").live("click",function(){
	if(confirm("确定删除吗？")){
		$(this).closest("tr").remove();
		var tr=$(this).closest("tr");
		$.getJSON("../message/delete.do", {
			"id" : tr.find("td").eq(0).html()
		},
		function(data) {}
		);
		
		checkAll();
	}
	
});




var checkAll=function () {
	$("#checkAll").prop('checked',$(":checkbox:[name=ck]").length==$(":checkbox:[name=ck]:checked").length)
}




$("#order input[name='update']").live("click",function () {
	var tr=$(this).closest("tr");
	oldvalue = tr.find("td").eq(2).html();
	tr.find("td").eq(2).html($(txtNum).attr("value",oldvalue));
	tr.find("td").eq(4).html(btnOK+" "+btnCancel);
});



$("#order input[name='ok']").live("click",function () {
	var tr = $(this).closest("tr");
	var newvalue = tr.find("td input[type = 'text']").val();
	tr.find("td").eq(2).html(newvalue);
	tr.find("td").eq(4).html(btnDelete+" "+btnUpdate);
	

	
	$.getJSON("updateAction", {
		"goods.id" : tr.find("td").eq(0).html(),
		"goods.num" : newvalue,
	},
	function(data) {}
	);
});




$("#order input[name='cancel']").live("click",function () {
	var tr = $(this).closest("tr");
	tr.find("td").eq(2).html(oldvalue);
	tr.find("td").eq(4).html(btnDelete+" "+btnUpdate);
});




$("#checkAll").click(function () {
	$("#order :checkbox[name=ck]").prop("checked",this.checked);
});
$(":checkbox:[name=ck]").live("click",function () {
	checkAll();
})





$("#addbtn").click(function () {
	id+=1;
	name = $("#name").val();
	num = $("#num").val();
	price = $("#price").val();
	newTr="<tr><td>"+id+"</td><td>"+name+"</td><td>"+num+"</td><td>&yen;"+price+"</td>";
	newTr+="<td>"+btnDelete+" "+btnUpdate+"</td><td>"+ck+"</td></tr>";
	$("#order").append($(newTr));
	checkAll();
	
		$.getJSON("addGoodsAction", {
			"goods.name" : $("#name").val(),
			"goods.num" : $("#num").val(),
			"goods.price" : $("#price").val(),
			"goods.typeId" : $("#search_type").val()
		},

		function(data) {}
		);
	
		$("#form1 input").val("");
		
});




$("#deletebtn").click(function () {
	$(":checkbox:[name=ck]:checked").each(function () {
		$(this).closest("tr").remove();
		
		var tr=$(this).closest("tr");
		$.getJSON("../message/delete.do", {
			"id" : tr.find("td").eq(0).html()
		},
		function(data) {}
		);
		
		
		checkAll();
	});
});




//function remove1() {
//    var table = document.getElementById("order"),
//        trs = table.getElementsByTagName("tr");
//           
//    for(var i = trs.length - 1; i > 0; i--) {
//        table.deleteRow(i);
//    }
//}





	//$("#order").remove1();
	//alert("aaaa");
//	$("#order tr:gt(0)").empty();
//	$("#order tr").not(':eq(0)').empty();
	//alert("bbbbb");
	$.getJSON("../message/find2.do",
		function(data) {
		 //var stringData =  JSON.stringify(data);
		//alert(data.message);
			$.each(data, function(i, item) {
				//alert(item.megContent);
			newTr="<tr><td>"+item.messageId+"</td><td>"+item.megContent+"</td><td>"+item.megLike+"</td><td>"+item.time+"</td><td>"+item.userId+"</td><td>"+item.newsId+"</td><td>"+item.videoId+"</td><td>"+item.topicId+"</td>";
			newTr+="<td>"+btnDelete+"</td><td>"+ck+"</td></tr>";
			$("#order").append($(newTr));
			id=item.id;
			});
		
//		for(var i = 0, len = data.length; i < len; i++){
//			alert("1");
//		}
		}

	);






});

