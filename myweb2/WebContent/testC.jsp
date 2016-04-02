<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>testC.jsp</h2>
	<%
		String name = request.getParameter("name");
		String addr = (String)request.getAttribute("addr");
	%>
	<h3>넘어온 이름 : <%=name %></h3>
	<h3>넘어온 주소 : <%=addr %></h3>
</body>
</html>