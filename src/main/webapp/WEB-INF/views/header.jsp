<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"  type="text/css" href="./css/main.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
</head>
<body>
 	<!-- Header -->
				<header id="header">
					<h1 id="logo"><a href="./main.do">Landed</a></h1>
					<nav id="nav">
						<ul>
							<li><a href="./main.do">Home</a></li>
							<li>
								<a href="#">Layouts</a>
								<ul>
									<li><a href="left-sidebar.html">Left Sidebar</a></li>
									<li><a href="right-sidebar.html">Right Sidebar</a></li>
									<li><a href="no-sidebar.html">No Sidebar</a></li>
									<li>
										<a href="#">Submenu</a>
										<ul>
											<li><a href="#">Option 1</a></li>
											<li><a href="#">Option 2</a></li>
											<li><a href="#">Option 3</a></li>
											<li><a href="#">Option 4</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a href="elements.html">Elements&nbsp;</a></li>
								 <c:if test="${mem != null}">
        			  
      	  								<span>${mem.name}님 환영합니다 (${mem.auth == 'ROLE_USER' ? "사용자" : "관리자"})</span>
      	  								<li><a href="./logout.do" class="button primary">로그아웃</a></li>
		 					      </c:if>
		 					      <c:if test="${mem == null}">
									<li><a href="./loginForm.do" class="button primary">Login</a></li>
										<li><a href="#" class="button primary">Sign Up</a></li>
							 </c:if>
						</ul>
					</nav>
				</header>
 
</body>
</html>