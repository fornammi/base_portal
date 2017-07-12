$(function(){
	setDialog();
	//进入页面，焦点在用户名文本框上
	$("#loginCode").focus();
	
	//绑定事件
});

/**
 * Ajax执行登录操作
 * @return
 */
function checkLogin() {
	var loginCode = $("#loginCode").val();
	if(""==loginCode){
		alert("用户名不能为空");
		return false;
	}
	var password = $("#password").val();
	if(""==password){
		alert("密码不能为空");
		return false;
	}
	$("#login_msg").html("登录中，请稍后...");
	return true;
}

/**
 * 执行reset操作
 */
function doReset(){
	$("#loginCode").val("");
	$("#password").val("");
	$("#login_msg").html("&nbsp;");
}


/**--------------操作弹出框------------------**/
//设置弹出框的属性
function setDialog(){
	$('#loginDiv').dialog({
		title : '用户登录',
		modal: true,         //模式窗口：窗口背景不可操作
		collapsible : true,  //可折叠，点击窗口右上角折叠图标将内容折叠起来
		resizable : true,    //可拖动边框大小
		closable : false     //不提供关闭窗口按钮
	});
}