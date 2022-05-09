<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div id="page-wrapper">
<%@ include file="./header.jsp" %>
	<!-- Main -->
				<div id="main" class="wrapper style1">
					<div class="container">

	<!-- Form -->
							<section>
								<h2 style="font-weight: bold;">LOG - IN</h2>
								<form method="post" action="#">
									<div class="row gtr-uniform gtr-50">
										<div class="col-6 col-12">
											<input type="text" name="name" id="name" value="" placeholder="Name" />
										</div>
										<div class="col-6 col-12">
											<input type="email" name="email" id="email" value="" placeholder="Email" />
										</div>
										
										<div class="col-12">
											<ul class="actions">
												<li><input type="submit" value="Login" class="primary" placeholder="Login"/></li>
												<li><input type="reset" value="Reset" /></li>
											</ul>
										</div>
									</div>
								</form>
							</section>
			  </div>
			</div>
							
		<!-- footer 부분 -->					
</div>
</body>
</html>