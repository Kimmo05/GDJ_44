package com.min.edu.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardVo {

	private int seq;
	private String id;
	private String title;
	private String content;
	private int step;
	private int depth;
	private int refer;
	private int readcount;
	private String delflag;
	private String regdate;
	
	private List<FileVo> fileList;

}
