package com.min.edu.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.min.edu.vo.BoardVo;

@Component
public class FileUtils {
	
	private static final String filePath = "C:\\upload\\tmp\\";  //파일이 저장될 위치를 지정
	
	public List<Map<String, Object>> parseInsertFileInfo(BoardVo bVo, MultipartHttpServletRequest mpRequest) throws Exception, IOException{
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int seq = bVo.getSeq();
		
		File file = new File(filePath);
		if(file.exists()==false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString()+originalFileExtension;
				
				file = new File(filePath+storedFileName);
				multipartFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("demoboard_seq", seq);
				listMap.put("original_file_name", originalFileName);
				listMap.put("stored_file_name", storedFileName);
				listMap.put("file_path", filePath);
				list.add(listMap);
				}
			
		}
		return list;
		
	}

	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
