<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원관리 프로그램</h2>
<form name="empAdd" action="empAdd.yong">
	<fieldset>
		<legend>사원등록</legend>
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="text" name="email"><br>
		부서 : <input type="text" name="dept"><br>
		<input type="submit" value="사원등록"> <input type="reset" value="다시작성">
	</fieldset>
</form>
<!-- 사원 삭제 -->
<form name="empDel" action="empDel.yong">
	<fieldset>
		<legend>사원삭제</legend>
		이름 : <input type="text" name="name"><br>
		<input type="submit" value="삭제"> <input type="reset" value="다시작성">
	</fieldset>
</form>
<hr>

<!--  -->
<h3><a href="empList.yong">모든 사원 내역보기</a></h3>
<!-- 사원검색하기 -->
<form name="empUpdateForm" action="empUpdateForm.yong">
	<fieldset>
		<legend>사원수정</legend>
		사원번호 : <input type="text" name="idx">
		<input type="submit" value="사원검색">
	</fieldset>
</form>
</body>
</html>