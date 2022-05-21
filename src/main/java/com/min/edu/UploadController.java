package com.min.edu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.min.edu.vo.FileVo;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Slf4j
@Controller
public class UploadController {
	
	
	@RequestMapping(value="/uploadForm.do" ,method=RequestMethod.GET)
	public String uploadAjax() {
		log.info("upload Form");
		
		return "uploadForm";
	}
	
	 @PostMapping(value="/uploadAjaxAction.do" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 @ResponseBody
	 public ResponseEntity<List<FileVo>> uploadFormPost(MultipartFile[] uploadFile) {
		 List<FileVo> list = new ArrayList<>();
		 String uploadFolder = "C:\\upload";

			String uploadFolderPath = getFolder();
		 File uploadPath = new File(uploadFolder, uploadFolderPath);
		 // make folder --------
		 log.info("upload path: " + uploadPath);
		
		 if (uploadPath.exists() == false) {
		 uploadPath.mkdirs();
		 }
		 // make yyyy/MM/dd folder
			for (MultipartFile multipartFile : uploadFile) {
				FileVo fVo = new FileVo();
				
				String uploadFileName = multipartFile.getOriginalFilename();
				log.info("-------------------------------------");
				log.info("Upload File Name: " + multipartFile.getOriginalFilename());
				log.info("Upload File Size: " + multipartFile.getSize());
				
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
						log.info("only file name: " + uploadFileName);
				fVo.setOriginal_file_name(uploadFileName);
				 UUID uuid = UUID.randomUUID();	
				 uploadFileName = uuid.toString() + "_" + uploadFileName;
			

				try {
					File saveFile = new File(uploadPath, uploadFileName);
					multipartFile.transferTo(saveFile);
					fVo.setStored_file_name(uuid.toString());
					fVo.setFile_path(uploadFolderPath);
					 // check image type file
					 if (checkImageType(saveFile)) {
					//원본파일은 그대로 저장되고, 파일이름이 s_로 시작하는 섬네일 파일이 생성되는 것을 볼 수 있다.
						 //반면에 일반 파일의 경우는 그냥 파일만 업로드 되는 것을 볼 수 있습니다.
						fVo.setFile_type(true);
					 FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" +
					 uploadFileName));
					
					 //뒤에 사이즈에 대한 부분을 파라미터로 width와 height를 지정할 수 있습니다.
					 Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100,
					 100);
					
					 thumbnail.close();
					 }
					 //add to List
					 list.add(fVo);
				} catch (Exception e) {
					log.error(e.getMessage());
				} // end catch
			} // end for
			return new ResponseEntity<>(list, HttpStatus.OK);
	 		}
	 //날짜별로 폴더를 생성해줌
	 private String getFolder() {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date date = new Date();

			String str = sdf.format(date);

			return str.replace("-", File.separator);
		}
	 	//이미지파일의 판단을 해줌
		private boolean checkImageType(File file) {

			try {
				String contentType = Files.probeContentType(file.toPath());

				return contentType.startsWith("image");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return false;
		}
	 
		@GetMapping("/display.do")	
		@ResponseBody
		public ResponseEntity<byte[]> getFile(String fileName) {

			log.info("fileName: " + fileName);

			File file = new File("c:\\upload\\" + fileName);
			
			log.info("file: " + file);

			ResponseEntity<byte[]> result = null;

			try {
				HttpHeaders header = new HttpHeaders();

				header.add("Content-Type", Files.probeContentType(file.toPath()));
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	 
}
