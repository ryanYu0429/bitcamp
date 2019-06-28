<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String saved;
	CookieBox cookie = new CookieBox(request);

	if (cookie.exists("saveId")) {
		 saved = cookie.getValue("saveId");

	} else {

		saved = "";
	}
%>
<c:if test="${saved != null}">
	<c:set value="${saved}" var="sId" />
</c:if>


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
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=saved %>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">아이디 저장해서 사용 <input type="checkbox"
					name="saveId"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>

	</form>

	<br>
	<a href="loginCheck.jsp">loginCheck</a>

</body>
</html>