package com.min.edu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IBoardrDao;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements IBoardService{

	@Autowired
	private IBoardrDao bdao;
	


	@Override
	public List<BoardVo> selectBoardAll(MemberVo mVo) {
		log.info("BoardServiceImpl : selectBoardAll 전체 조회 ");
		return bdao.selectBoardAll(mVo);
	}

	@Override
	public BoardVo selectBoardDetail(String seq) {
		log.info("BoardServiceImpl : selectBoardDetail 상세 조회 : {}", seq);
		bdao.updateReadcount(seq);
		return bdao.selectBoardDetail(seq);
	}
	/*
	 * 페이징 처리
	 */
	@Override
	public List<BoardVo> adminBoardListRow(RowNumVo vo) {
		log.info("BoardServiceImpl adminBoardListRow");
		return bdao.adminBoardListRow(vo);
	}

	@Override
	public int adminBoardListTotal() {
		log.info("BoardServiceImpl adminBoardListTotal");
		return bdao.adminBoardListTotal();
	}

	@Override
	public List<BoardVo> userBoardListRow(RowNumVo vo) {
		log.info("BoardServiceImpl userBoardListRow");
		return bdao.userBoardListRow(vo);
	}

	@Override
	public int userBoardListTotal() {
		log.info("BoardServiceImpl userBoardListTotal");
		return bdao.userBoardListTotal();
	}
}
