<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<nav id="menu">
				<ul class="links">
					<li>
						<c:if test="${loginInfo eq null}">
						<a href="<c:url value='' />">LOGIN </a>
					</c:if>
					<c:if test="${loginInfo ne null}">
						<a href="<c:url value='/member/logout' />">LOGOUT</a>
						</c:if>
							</li>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="<c:url value='http://ec2-13-209-47-124.ap-northeast-2.compute.amazonaws.com:8080/EvClient/eventPage.jsp' />">이벤트</a></li>
		<li><a href="<c:url value='/mainList.jsp' />">공연/전시 소개</a></li>
		<li><a href="<c:url value='/listView.jsp' />">공연/전시 추천</a></li>
		<li><a href="<c:url value='http://ec2-15-164-162-21.ap-northeast-2.compute.amazonaws.com:8080/cultureforkReview/review.jsp'/>">공연/전시 후기</a></li>
		<li><a href="<c:url value='/member/logout.do' />">LOGOUT</a></li>
				</ul>
			</nav>