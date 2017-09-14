<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Login.do" method="post">
		<input type="text" name="id">
		<input type="password" name="password">
		<input type="submit" value="로그인">
	</form>
	<button onclick="location.href='join.jsp'">회원 가입</button>
	<a href="join.jsp">회원 가입</a>
	${requestScope.msg}
	
	<c:if test="${not empty param.msg }">
		${param.msg} 
	</c:if>
	
	
</body>
</html>