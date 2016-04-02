<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="yong.emp.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% EmpDTO dto = (EmpDTO)request.getAttribute("dto"); %>
<h2><%=dto.getName() %>사원의 정보</h2>
<form name="empUpdate" action="empUpdate.yong">
<input type="hidden" name="idx" value="<%=dto.getIdx()%>">
<ul>
	<li>사원번호 : <%=dto.getIdx() %></li>
	<li>이름 : <input type="text" name="name" value="<%=dto.getName() %>"></li>
	<li>e-mail : <input type="text" name="email" value="<%=dto.getEmail() %>"></li>
	<li>부서 : <input type="text" name="dept" value="<%=dto.getDept() %>"></li>

</ul>
<input type="submit" value="수정하기">
</form>
</body>
</html>