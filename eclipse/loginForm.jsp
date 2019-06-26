<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	Cookie[] cookies = request.getCookies();
 	// 일부로 배열을 공부하기위하여 써본것입니다.ㅎㅎ
 	%> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
</style>
</head>
<body>
	<h1>로그인</h1>
	
	<hr>
	<form action="login.jsp" method="post">
	<table>
		<tr>
			<td>아이디 </td>
			<td><input type="text" name="id" 
		
			
			<%
				if(cookies != null && cookies.length > 0) {
					for(int i = 0; i < cookies.length; i++){
				
			%> 
			value= <%=cookies[1].getValue()  %>
			<%
					}
				}
			%>
			>
			</td>
		</tr>
		<tr>
			<td>비밀번호 </td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan = "2"> 아이디 저장해서 사용 <input type="checkbox" name="save"></td>
		</tr>
		<tr>
			<td colspan = "2"><input type="submit" value="로그인"></td>
		</tr>
	</table>
	
	</form>
	
	<br>
	<a href="loginCheck.jsp">loginCheck</a>
	
</body>
</html>