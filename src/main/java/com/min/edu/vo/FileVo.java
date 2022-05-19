package com.min.edu.vo;


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
public class FileVo {
	
	/*
	 * file_seq : 파일 번호
	 * demoboard_seq : 글 번호
	 * original_file_name : 원본 파일 이름
	 * stored_file_name : db에 저장되는 파일 이름
	 * file_path : 저장되는 파일경로
	 * file_type : 이미지 판단 여부
	 * regdate : 저장되는 날짜
	 */
private int file_seq;
private int demoboard_seq;
private String original_file_name;
private String stored_file_name;
private String file_path;
private String file_type;
private String regdate;

}
