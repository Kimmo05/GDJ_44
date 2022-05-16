package com.min.edu.model.service;

import java.util.List;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

public interface IBoardService {

	//1) 전체글보기
	public List<BoardVo> selectBoardAll(MemberVo mVo);
	
	//2-1) 상세글보기
	public BoardVo selectBoardDetail(String seq);
	
	/*
	 * 페이징 처리
	 */
	public List<BoardVo> adminBoardListRow(RowNumVo vo);
	public int adminBoardListTotal();
	public List<BoardVo> userBoardListRow(RowNumVo vo);
	public int userBoardListTotal();
	
}
