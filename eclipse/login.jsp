<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>





<%
	String clk = request.getParameter("save");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	boolean chk = false;

	if (id.equals(pw)) {
		// 쿠키 생성 : 사용자 데이터를 저장
		// LOGIN/ID ==> 식별자 /// 이 식별자 안에있는 각각의 SUCCESS/id 값을 확인하기 위한 식별자.
/* 		Cookie c1 = CookieBox.createCookie("LOGIN", "SUCCESS", -1);
		response.addCookie(c1);

		Cookie c2 = CookieBox.createCookie("ID", id, -1);
		response.addCookie(c2);

		chk = true;
*/
		
			if (clk != null){
				Cookie c1 = CookieBox.createCookie("LOGIN", "SUCCESS", 60*60*24);
				response.addCookie(c1);

				Cookie c2 = CookieBox.createCookie("ID", id, 60*60*24);
				response.addCookie(c2);

				chk = true;	
			
%>
			<script> alert("아이디 저장됨");</script>
<%
		} else if (clk == null){
			Cookie c1 = CookieBox.createCookie("LOGIN", "SUCCESS", -1);
			response.addCookie(c1);

			Cookie c2 = CookieBox.createCookie("ID", id, -1);
			response.addCookie(c2);

			chk = true;
%>
			<script> alert("저장 없이 로그인");</script>
<%
		}
		
	}
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

<script>

</script>
	<%if (chk) {
				out.println("<h1>로그인 되었습니다.</h1>");
				out.println("<a href=\"loginCheck.jsp\">loginCheck</a>");
			} else {
				out.println("<script>alert(\'로그인 실패\'); history.go(-1); </script>");
			}%>
		

</body>
</html>