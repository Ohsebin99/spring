<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>welcome.jsp</h1>

<c:if test="${not empty pageContext.request.userPrincipal}">
	<p>
		<!-- userPrincipal.name: 시큐리티 기능으로 로그인한 아이디를 얻어온다. -->
		${pageContext.request.userPrincipal.name} Log_In
	</p>
</c:if>

<s:authorize ifAnyGranted="ROLE_ADMIN">
	<p><s:authentication property="name"/> Log-In</p>
</s:authorize>

<a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>

</body>
</html>