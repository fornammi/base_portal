<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.util.*" pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<!-- 访问项目后，会自动跳转到该url -->
<meta http-equiv="refresh"
	content="0;URL=<%=root%>/login/toLoginPage.htm"
	content="text/html; charset=utf-8">
</head>
<body>
Welcome...
</body>
</html>
