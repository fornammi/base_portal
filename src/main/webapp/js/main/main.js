
$(function(){
	//启用tabs
	$("#tabNav").tabs();
	$("#tabNav li").bind("click", function(){
		var tabId = $(this).attr("id");
		var url = $(this).attr("src");
		showTab(tabId, url);
	});
});

function addTab(tabId, title, url){
	console.log("nammi@tabId:"+tabId+"@title:"+title+"@url:"+url);
	console.log("test:"+($("#"+tabId).html() == null));
	console.log("test:"+($("#"+tabId).html()));
	if($("#"+tabId).html() == null){
		$("#tabNav").find("ul").append("<li>");
		$("#tabNav").find("ul").append("<a href=" +url+ " target='rightContent'>" +title+ "</a>");
		$("#tabNav").find("ul").append("</li>");
		showTab(tabId, url);
	}
}

function showTab(tabId, url){
	console.log("nammi@showTab@tabId:"+tabId+"@url:"+url);
	console.log("nammi@showTab");
	$("#pageContent").find("iframe").attr("id", tabId).attr("src", url);
}