<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>    
<%@ page import = "yong.emp.model.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원 검색 하기</h2>
<table border="1" width="450" cellspacing="0">
	<thead>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>E-MAIL</th>
			<th>부서</th>
			<th>수정</th>
		</tr>
	</thead>
	
	<tbody>
		<%
			ArrayList<EmpDTO> arr = (ArrayList<EmpDTO>)request.getAttribute("empSel");
			if(arr==null || arr.size()==0){
				%>
					<tr>
						<td colspan="5" align="center">등록된 사원이 없습니다.</td>
					</tr>
				<%
			}else{
				for(int i=0;i<arr.size();i++){
					
				%>
					<tr>
						<td><%=arr.get(i).getIdx() %></td>
						<td><%=arr.get(i).getName() %></td>
						<td><%=arr.get(i).getEmail() %></td>
						<td><%=arr.get(i).getDept() %></td>
						<td><a href="empUpdate.yong?idx=<%=arr.get(i).getIdx() %>">정보 수정</a></td>
					</tr>		
				<%
				}
			}
		%>
	</tbody>
</table>
</body>
</html>