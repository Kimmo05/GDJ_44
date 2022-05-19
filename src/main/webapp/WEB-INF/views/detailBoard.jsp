<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세조회 페이지</title>
</head>
<%@ include file="./header.jsp" %>
<body>
<div class="container">
			<h2>게시글 상세</h2>
			<h3>▶ <mark>${vo.seq}</mark>번째 글입니다</h3>
			   <div class="panel panel-default">
			      <div class="panel-heading">제목 : ${vo.title}
				      	<div id="panel-id">
				      	아이디 : ${vo.id}
						작성일 : ${vo.regdate}
								파일명:${fileObj.filename}<br>
		설명:${fileObj.desc}<br>
						</div>
			      </div>
			      <div class="panel-body">내용 : ${vo.content}</div>
			    </div>

			<div>
				<input class="btn btn-primary" type="button" value="삭제" onclick="deleteOne()">
				<input class="btn btn-success" type="button" value="수정" onclick="">
				<input class="btn btn-danger" type="button" value="답글" onclick="answerBoardOne()">
			</div>
	</div>
</body>
</html>