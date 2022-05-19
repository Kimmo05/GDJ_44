package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.FileVo;
import com.min.edu.vo.MemberVo;

public interface IBoardService{
	//1) 전체글보기
	public List<BoardVo> selectBoardAll(MemberVo mVo);
	
	//2-1) 상세글보기
	public BoardVo selectBoardDetail(String seq);

	//3) 게시글+첨부파일 새로 등록
//	public boolean insertBoardRootFile(BoardVo bVo, FileVo fVo) ;
	//3-1) 게시글 새로 등록시 첨부파일 추가
//		public int insertBoardFile(List<Map<String, Object>> map);
//	public boolean insertBoardFile(Map<String, Object> map) ;
	//간편 따라하기
	public void write(BoardVo bVo, MultipartHttpServletRequest mpRequest) throws Exception;
		
}
