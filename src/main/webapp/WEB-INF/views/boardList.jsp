<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>

 
<body >
<div id="page-wrapper">
<%@ include file="./header.jsp" %>





</div>
<h1>
	Hello world!  
	<c:if test="${result != null}">
<h2> 네이버 아이디 로그인 성공하셨습니다!! </h2>
<h3>'${result}' 님 환영합니다! </h3>
${sessionId} <br>

${sessionId.name }
<h3><a href="./logout.do">로그아웃</a></h3>
</c:if>

</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
