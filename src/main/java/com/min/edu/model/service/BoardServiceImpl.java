
package com.min.edu.model.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.min.edu.model.mapper.IBoardDao;
//import com.min.edu.model.mapper.IFileDao;
import com.min.edu.util.FileUtils;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.FileVo;
import com.min.edu.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements IBoardService{

	@Autowired
	private IBoardDao bDao;
//	@Autowired
//	private IFileDao fDao;
	@Autowired
	private FileUtils fileUtils;

	@Override
	public List<BoardVo> selectBoardAll(MemberVo mVo) {
		log.info("BoardServiceImpl : selectBoardAll 전체 조회 ");
		return bDao.selectBoardAll(mVo);
	}

	@Override
	public BoardVo selectBoardDetail(String seq) {
		log.info("BoardServiceImpl : selectBoardDetail 상세 조회 : {}", seq);
		bDao.updateReadcount(seq);
		return bDao.selectBoardDetail(seq);
	}

//	@Override
//	public boolean insertBoardRootFile(BoardVo bVo, FileVo fVo) {
//		log.info("BoardServiceImpl : insertBoardRoot 새로 등록 : {}", bVo);
//		int n = bDao.insertBoardRoot(bVo);
//		log.info("BoardServiceImpl : insertBoardFile 새로 등록 : {}", fVo);
//		int m = fDao.insertBoardFile(fVo);
//		return (n+m)>0? true:false;
//	}

	@Override
	public void write(BoardVo bVo, MultipartHttpServletRequest mpRequest) throws Exception {
		bDao.write(bVo);
		
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(bVo, mpRequest);
		int size = list.size();
		for(int i=0; i<size; i++) {
			bDao.write((BoardVo) list.get(i));
		}
		
	}




}
