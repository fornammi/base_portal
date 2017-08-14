

$(function(){
	$("#btnQuery").button().click(function(){
		queryData();
	});
	$("#btnAdd").button().click(function(){
		addDim();
	});
	$("#btnClose").button().click(function(){
		addDim();
	});
	
});


function queryData(){
	var $form = $("#frmMain");
	var url = $form.attr("action");
	console.log("dim@queryData@url:"+url);
	$.ajax({
		type:"POST",
		url:url+"?method=queryData",
		data:$form.serializeArray(),
		dataType:"html",
		cache:false,
		success:function(data){
			$("#tableData").html(data);
		}
	});
}


function addDim(){
	var table = document.getElementById("dimTable");
	
	var tr = document.createElement("tr");
	tr.name = "nameTr";
	tr.id = "nameTr";
	table.appendChild(tr);
	
	//1.dimName
	var td1 = document.createElement("td");
	tr.append(td1);
	td1.name="td1";
	td1.innerHTML = "<input type='text' name='dimName' maxlength='85' />";
	//2.dimItem
	var td2 = document.createElement("td");
	tr.append(td2);
	td2.name="td2";
	var td2Content = "<select name='dimItemId'>" +
			"<option value=''>---请选择---</option>" +
			"<#list dimItemList as dimItem>" +
			"<option value='${dimItem.dimItemId}'>${dimItem.dimItemDesc}</option>" +
			"</#list>" +
			"</select>";
	td2.innerHTML = td2Content;
	//3.operatorCompare
	var td3 = document.createElement("td");
	tr.append(td3);
	td3.name="td3";
	var td3Content = "<select name='operatorCompare'" +
			"<option value=''>---请选择---</option>" +
			"<#assign mapKeys = operatorCompareMap?keys>" +
			"<#list mapKeys as operator>" +
			"<option value='${operator}'>${operatorCompareMap[operator].desc}</option>" +
			"</#list>" +
			"</select>";
	td3.innerHTML = td3Content;
	
	//4.dimItemValue
	var td4 = document.createElement('td');
	tr.appendChild(td4);
	td4.name="td4";
	td4.innerHTML = "<input type='text' name='dimItemValue' maxlength='128' />";
	
	//5.op
	var td5 = document.createElement('td');
	tr.appendChild(td5);	
	var removebtn = "<a href='javascript:void(0);' onclick='preSaveDim(this);'>保存</a>";
	var removebtn = "<a href='javascript:void(0);' onclick='removeDim(this);'>删除</a>";
	td5.innerHTML = removebtn;
}

function removeDim(link){
	var table = document.getElmentById("dimTable");
	var selectedTr = link.parentElement.parentElment;// 按钮的父节点的父节点是tr
	if(window.confirm("确认删除?")){
		table.removeChild(selectedTr);
	}
}


function preSaveDim(link){
	var selectTr = link.parentElement.parentElment;
	var dimName = selectTr.cell[0].childNodes[0].value;
	console.log("preSaveDim@dimName="+dimName);
}