<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("addr", "서울");

	//response.sendRedirect("testC.jsp");//단순 이동
%>	
<jsp:forward page="testC.jsp"></jsp:forward>
	<h2>testB.jsp</h2>
	
</body>
</html>