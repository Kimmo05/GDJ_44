package com.min.edu;


import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SpringBoardTest {
	
	private final String NS = "com.min.edu.model.mapper.BoardDaoImpl.";

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IBoardDao bDao;

//@Test
	//1) 새글쓰기
	public void insertBoard() {
		Map<String, Object> map = new HashMap<String, Object>();
		log.info("＃＃＃＃＃＃＃＃＃ DEMOBOARD_TEST_01 insertBoard Test 실행 ＃＃＃＃＃＃＃＃＃");
		map.put("id", "DEMO01");
		map.put("title", "DEMO01이 JUnit Test 에서 작성한 글");
		map.put("content", "DEMO01이 JUnit Test 에서 작성한 글 내용");
		log.info("＃＃＃＃＃＃＃＃＃ DEMOBOARD_TEST_01 insertBoard Test  "
				+ "입력된 게시글 정보 :"
				+ " {} ＃＃＃＃＃＃＃＃＃", map);
		System.out.println("새로 작성된 글 : "+map);
	}
	
//	@Test
	//2) 게시글 전체조회(삭제된 글을 사용자, 삭제된 글 관리자)
	public void selectBoardAll() {
		log.info("＃＃＃＃＃＃＃＃＃ DEMOBOARD_TEST_02 selectBoardAll Test 실행 ＃＃＃＃＃＃＃＃＃");
		MemberVo mVo = new MemberVo();
		mVo.setId("DEMO01");
		List<BoardVo> lists = bDao.selectBoardAll(mVo);
		log.info("＃＃＃＃＃＃＃＃＃ DEMOBOARD_TEST_01 selectBoardAll Test  "
				+ "게시글 전체 리스트 :"
				+ " {} ＃＃＃＃＃＃＃＃＃", lists);
		System.out.println("전체 게시글 조회 : "+lists);
	}	
	
	@Test
	public void insertBoardFile() {
		log.info("＃＃＃＃＃＃＃＃＃ DEMOBOARD_TEST_03 insertBoardFile Test 실행 ＃＃＃＃＃＃＃＃＃");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("demoboard_seq", 1);
		map.put("original_file_name", "aa");
		map.put("stored_file_name", "ddd");
		map.put("file_path", "C:\\upload");
//		int n = bDao.insertBoardFile((List<Map<String, Object>>) map);
		log.info("＃＃＃＃＃＃＃＃＃ DEMOBOARD_TEST_03 insertBoardFile Test  "
				+ "게시글 등록시 첨부파일 추가 :"
				+ "INSERT INTO DEMOFILE\r\n"
				+ "(FILE_SEQ, DEMOBOARD_SEQ, ORIGINAL_FILE_NAME, STORED_FILE_NAME, FILE_PATH, REGDATE, DEL_GB)\r\n"
				+ "VALUES(DEMOFILE_FILE_SEQ.NEXTVAL , 1, 'aa', 'ddd', 'C:\\upload', SYSDATE,'N' );\r\n"
				+ ""
				+ " {} ＃＃＃＃＃＃＃＃＃", map);
		sqlSession.insert(NS+"insertBoardFile", map);
//		System.out.println("게시글 입력시 첨부파일 추가 된 개수 : "+n );

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
