<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="com.min.edu.vo.*"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 50px;
}
</style>

</head>
<body>
<!-- page-wrapper Start-->
    <div class="page-wrapper" id="pageWrapper">
      <!-- Page Body Start-->
      <div class="page-body-wrapper horizontal-menu">
		<%@ include file="./header.jsp"  %>
		
 <div class="page-body">
 
 

<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
		
		
	</div>

<div class='uploadResult'>
		<ul>

		</ul>
	</div>


	<button id='uploadBtn'>Upload</button>



 
          </div>
        	<%@ include file="./footer.jsp"  %>
		</div>
	</div>
<script>
var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
var maxSize = 5242880; //5MB

function checkExtension(fileName, fileSize) {

	if (fileSize >= maxSize  ) {
		alert("파일 사이즈 초과");
		return false;
	}

	if (regex.test(fileName)) {
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	return true;
}

	var cloneObj = $(".uploadDiv").clone();
	 $("#uploadBtn").on("click", function(e){

	 var formData = new FormData();
	
	 var inputFile = $("input[name='uploadFile']");
	
	 var files = inputFile[0].files;
	
	 console.log(files);
	
	 //add filedate to formdata
	 for(var i = 0; i < files.length; i++){

			if (!checkExtension(files[i].name, files[i].size)) {
				return false;
			}
	
	 formData.append("uploadFile", files[i]);
	 
	 }
	 $.ajax({
			url : './uploadAjaxAction.do',
			processData : false,
			contentType : false,
			data : formData,
			type : 'POST',
			dataType : 'json',
			success : function(result) {

				console.log(result);

 				showUploadedFile(result);

				$(".uploadDiv").html(cloneObj.html());

			}
		}); //$.ajax

	});
	 
	 var uploadResult = $(".uploadResult ul");
	 function showUploadedFile(uploadResultArr){
		    
		    var str = "";
		    
		    $(uploadResultArr).each(function(i, obj){
		      
		      if(!obj.file_type){
		        str += "<li><img src='./resources/img/attach.png'>"+obj.original_file_name+"</li>";
		      }else{
		        //str += "<li>"+ obj.fileName+"</li>";
		        
		        var fileCallPath =  encodeURIComponent( obj.file_path+ "/s_"+obj.stored_file_name+"_"+obj.original_file_name);
		        
		        str += "<li><img src='./display.do?fileName="+fileCallPath+"'><li>";
		      }
		    });
		    
		    uploadResult.append(str);
		  }
	 
	 
	  		
</script>

</body>
</html>