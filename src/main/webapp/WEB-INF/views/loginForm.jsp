<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function loginCheck(){
		console.log('로그인 작동');
		var id = document.getElementById('inputId');
		var pw = document.getElementById('inputPw');
		console.log(id.value, pw.value);
		
		var frm = document.forms[0];
		frm.action = "./login.do";
		console.log(frm);
		
		// 유효성 검사 후 Ajax 로그인
		if(id.value == "" || id.value.trim() == ""){
			id.value = "";
			id.focus();
			swal("로그인", "아이디를 입력해주세요");
		}else if(pw.value == "" || pw.value.trim() == ""){
			pw.value = "";
			pw.focus();
			swal("로그인", "비밀번호를 입력해주세요");
		}else{
			$.ajax({
// 				url:"./loginCheckText.do", // 반환되는 값을 Text 로 처리
				url:"./loginCheckMap.do", // 반환되는 값을 Map(JSON) 으로 처리
				method:"post",
				data:"id=" + id.value + "&pw=" + pw.value,
				success:function(msg){
					console.log(msg, typeof msg); // 형태 확인
					console.log(msg.isc);
					if(msg.isc == "성공"){
						console.log(msg.isc);
						frm.submit();
					}else{
						swal("로그인", "해당 사용자는 존재하지 않습니다");
					}
				},
				error:function(){
					swal("로그인","로그인에 장애가 발생");
				}
			})
		}
	}
</script>
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
								<form method="post" action="./login.do">
									<div class="row gtr-uniform gtr-50">
										<div class="col-6 col-12">
											<input type="text" name="id" id="inputId"  placeholder="id" />
										</div>
										<div class="col-6 col-12">
											<input type="text" name="pw" id="inputPw"  placeholder="pw" />
										</div>
										
										<div class="col-12">
											<ul class="actions">
												<li><input type="submit" value="Login" class="primary" placeholder="Login" onclick="loginCheck()"/></li>
												<li><input type="reset" value="Reset" /></li>
												<li> <input type="button" id="signup" value="Sign-Up"></li>
											


											</ul>
										</div>
									</div>
								</form>
							</section>
							<div id="naver_id_login" style="text-align:center"><a href="${url}">
								<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/>
								</a>
								</div>
								
			  </div>
			</div>
							
		<!-- footer 부분 -->					
</div>
<script type="text/javascript">
  	function enterKey(){
  		if(window.event.keyCode == 13){
  			loginCheck();
  		}
  	}
  	
  	window.onload = function(){
  		document.getElementById('signup').onclick = function(){
  			console.log("회원가입 버튼 click");
  			location.href = "./signupForm.do";
  		}
  	}
  </script>
</body>
</html>