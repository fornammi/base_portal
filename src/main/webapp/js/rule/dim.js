

$(function(){
	$("#btnQuery").button().click(cuntion(){
		queryData();
	});
	$("#btnAdd").button().click(cuntion(){
		addDim();
	});
});


function queryData(){
	$form = $("#frmMain");
	var url = $form.attr("action");
	$.ajax({
		type:"POST",
		url:url+"&method=queryData",
		data:$form.serializeArray(),
		dataType:"html",
		cache:false,
		success:function(data){
			$("#tableData").html(data);
		}
	});
}


function addDim(){
	
}