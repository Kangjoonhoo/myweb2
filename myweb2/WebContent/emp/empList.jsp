<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>    
<%@ page import = "yong.emp.model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 리스트 보기</title>
</head>
<body>
<h2>모든 사원 내역 보기</h2>
<table border="1" width="450" cellspacing="0">
	<thead>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>E-MAIL</th>
			<th>부서</th>
		</tr>
	</thead>
	
	<tbody>
		<%
			ArrayList<EmpDTO> arr = (ArrayList<EmpDTO>)request.getAttribute("empList");
			if(arr==null || arr.size()==0){
				%>
					<tr>
						<td colspan="4" align="center">등록된 사원이 없습니다.</td>
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
					</tr>		
				<%
				}
			}
		%>
	</tbody>
</table>
</body>
</html>