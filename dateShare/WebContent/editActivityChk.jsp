<%@page import="dateShare.service.activity.EditActivityService"%>
<%@page import="dateShare.service.activity.NotMatchUserException"%>
<%@page import="dateShare.service.activity.ActivityNotFoundException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dateShare.service.activity.DeleteActivityService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int a_num = Integer.parseInt(request.getParameter("a_num"));
	int u_num = Integer.parseInt(request.getParameter("u_num"));

	// 서비스 객체 생성 
	EditActivityService service = EditActivityService.getInstance();

	boolean chk = false; // 오류발생했는지 확인하려고 정상처리 되었나 오류발생했나
	String msg = ""; // 예외발생시 메시지 담아서 처리하고싶음.

	try {
		chk = service.editMessageChk(a_num, u_num);
	} catch (SQLException e) {
		msg = e.getMessage();
	} catch (ActivityNotFoundException e) {
		msg = e.getMessage();
	} catch (NotMatchUserException e) {
		msg = e.getMessage();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DATE SHARE</title>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<style></style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="wrap">
		<div id="main_wrap">
			<div id="header">
				<%@include file="../frame/my.jsp"%>
				<%@include file="../frame/header.jsp"%>
			</div>
			<div id="nav">
				<%@include file="../frame/nav.jsp"%>
			</div>
			<div id="content">
				<h1>

					<%
						if (chk) {
							response.sendRedirect("editActivityForm.jsp?a_num="+a_num);
					%>

					<%
						} else {
					%>

					<%=msg%>

					<%
						}
					%>
				</h1>
				<a href="activityList.jsp">리스트</a>
			</div>
			<div id="footer">
				<%@include file="../frame/footer.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>