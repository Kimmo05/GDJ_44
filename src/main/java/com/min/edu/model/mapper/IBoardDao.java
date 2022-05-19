package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;

public interface IBoardDao {
	
	//1) 전체글보기
	public List<BoardVo> selectBoardAll(MemberVo mVo);
	
	//2-1) 상세글보기
	public BoardVo selectBoardDetail(String seq);
	//2-2) 조회수
	public int updateReadcount(String seq);
	
	//3) 게시글 새로 등록
//	public int insertBoardRoot(BoardVo bVo);
	//----------------------------따라해보기--------------------
	//3) 게시글 새로 등록
	public void write(BoardVo bVo);
//3-1) 첨부파일 추가
	public void insertFile(Map<String, Object> map) throws Exception;
	
}
