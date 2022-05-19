//package com.min.edu;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Map;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttribute;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.util.WebUtils;
//
//import com.min.edu.model.service.IBoardService;
//import com.min.edu.vo.FileVo;
//import com.min.edu.vo.MemberVo;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Controller
//public class FileUploadController {
//	
//
//	@Autowired
//	private IBoardService iService;
//	
//	
//	@RequestMapping(value="/uploadForm.do", method = RequestMethod.GET)
//	public String uploadForm() {
//		log.info("********* Welcome FileUpload_Controller fileUploadController! 파일 업로드 Form으로 이동 *********");
//		return "uploadForm";
//	}
//	
//	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
//	public String fileUpload(@RequestParam Map<String, Object> map, FileVo filevo,
//			HttpSession session,@SessionAttribute("mem") MemberVo mVo,HttpServletResponse response,HttpServletRequest request,Model model, BindingResult result) throws Exception {
//   	
//        log.info("********* Board_Controller 새글 입력 insertBoardRoot *********", map);
//		
//		   //파일 받아 옴 
//	      MultipartFile file = filevo.getFile();
//	      System.out.println("***** MultipartFile file *****"+file);
//		String fileName = file.getOriginalFilename(); 
//		System.out.println("***** fileName *****"+fileName);
//	      String originalFileExtension = fileName.substring(fileName.lastIndexOf("."));
//	      //storedFileName 에 serialNumber+originalFileExtension을 저장해줌 (db에 저장되는 파일 이름)
//	      String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension; 
//	     FileVo fileObj = new FileVo();
//	     fileObj.setOriginal_file_name(fileName);
//	     
//	      
//	    //파일을 서버에 IO로 업로드 (절대경로/상대경로)
//			InputStream inputStream = null;
//			OutputStream outputStream = null;
//			String path = "";
//			
//			try {
//				//1) 파일을 읽고
//				inputStream = file.getInputStream();
//				
//				//2) 저장위치를 만든다. 
//				//WebUtils.getRealPath가 실제 경로를 만들어준다.
//				path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage"); //상대경로 
////				path = "C:\\eclipse_web_2020_09\\workspace_web_202009\\20220508_DemoProject\\src\\main\\webapp\\storage"; //절대경로
////				System.out.println(request.getSession().getServletContext());
//				System.out.println("실제 저장될 업로드 경로 : "+path);
//				//3) 만약 저장위치가 없다면 생성한다 
//				//mkdir()로 디렉토리를 만들어준다.
//				File storage = new File(path);
//				if(!storage.exists()) {
//					storage.mkdir(); 
//				}
//				
//				//4) 저장할 파일이 없다면 만들어주고 , 있다면 override(이름이 똑같다면 그대로 파일이 엎어쓰기됨)
//				File newFile = new File(path+"/"+fileName);
//				if(newFile.exists()) {
//					newFile.createNewFile();
//				}
//				
//			//5) 파일을 쓸 위치를 지정해 줌
//			outputStream = new FileOutputStream(newFile);
//			//6) 파일을 대상에 읽고 써줌
//			int read = 0;
//			byte[] b=new byte[(int) file.getSize()]; // 파일 사이즈만큼 크기를 만들어줌 
//			while ((read = inputStream.read(b))!= -1) {
//				outputStream.write(b, 0, read);  //b를 0부터 read만큼
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				inputStream.close();
//				outputStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	      map.put("id", mVo.getId());
////	      boolean n = iService.insertBoardRoot(map);
//	     
//	      map.put("original_file_name", fileName);
//	      map.put("stored_file_name", storedFileName);
//	      map.put("file_path", path);
////	      boolean m = iService.insertBoardFile(map);
//	      
//	      model.addAttribute("fileObj", fileObj);
//	      model.addAttribute("path",path);
//	      return "redirect:/boardList.do";
//	}
//	
//
//}
