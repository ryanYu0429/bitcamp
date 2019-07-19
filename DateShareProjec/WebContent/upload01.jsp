<%@page import="dateShare.service.activity.NotMatchUserException"%>
<%@page import="dateShare.service.activity.ActivityNotFoundException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dateShare.service.activity.DeleteActivityService2"%>
<%@page import="dateShare.Model.Activity"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="dateShare.service.activity.WriteActivityService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="activity" class="dateShare.Model.Activity" />
<jsp:setProperty property="*" name="activity" />


<%
	int a_num = Integer.parseInt(request.getParameter("a_num"));
	int u_num = Integer.parseInt(request.getParameter("u_num"));

	// 서비스 객체 생성 
	DeleteActivityService2 serviceD = DeleteActivityService2.getInstance();

	int resultCnt = 0; // 몇개행 되었나 체크하려고
	boolean chk = false; // 오류발생했는지 확인하려고 정상처리 되었나 오류발생했나
	String msg = ""; // 예외발생시 메시지 담아서 처리하고싶음.

	try {
		resultCnt = serviceD.deleteMessage(a_num, u_num);
		chk = true; // 정상처리되었으면
	} catch (SQLException e) {
		msg = e.getMessage();
	} catch (ActivityNotFoundException e) {
		msg = e.getMessage();
	} catch (NotMatchUserException e) {
		msg = e.getMessage();
	}
%>




<%
	String a_title = "";
	String a_path = "";
	int a_star = 0;
	String a_content = "";
	String saveFileName = "";
	String uploadPath = "/images";
	String dir = request.getSession().getServletContext().getRealPath(uploadPath);
	String fileDBPath = "";

	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (isMultipart) {

		DiskFileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upload = new ServletFileUpload(factory);

		List<FileItem> files = upload.parseRequest(request);

		Iterator<FileItem> itr = files.iterator();

		while (itr.hasNext()) {
			FileItem file = itr.next();

			if (file.isFormField()) {
		// 타입이 파일이 아닌경우
				if (file.getFieldName().equals("a_title")) {
					a_title = file.getString("utf-8");
				} else if (file.getFieldName().equals("a_star")) {
					a_star = Integer.parseInt(file.getString("utf-8"));
				} else if (file.getFieldName().equals("a_content")) {
					a_content = file.getString("utf-8");
				}
			} else {
				//(2) 파일형식인 경우 --> 파일 경로 분기처리 : 1. 파일이 있는 경우 2. 파일이 없는 경우
				if (file.getFieldName().equals("a_path")) {
					a_path = file.getName();

					saveFileName = System.nanoTime() + "_" + a_path;
					file.write(new File(dir, saveFileName));

					fileDBPath = "../images/" + saveFileName;

					if (a_path.equals(null) || a_path.equals("")) {
						fileDBPath = "../images/noImg.png";
					}
				}
			}
		}

	}

	Activity actFile = new Activity(a_title, a_content, fileDBPath, a_star);

	WriteActivityService service = WriteActivityService.getInstance();
	int cnt = service.write(actFile);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
	<%-- <%= actFile.getA_title() %>
	<%= cnt %> --%>
		<%= cnt > 0 ? "게시글을 수정했습니다" : "게시글 수정 실패" %>
	</h1>
	<a href="activityList.jsp">목록보기</a>
</body>
</html>