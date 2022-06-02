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
public class SpringMemberTest {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IMemberDao mDao;

//@Test
	//1) 로그인(아이디,비밀번호,사용여부N) 
	public void loginMember() {
		Map<String, Object> map = new HashMap<String, Object>();
		log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 loginMember Test 실행 ＃＃＃＃＃＃＃＃＃");
		map.put("id", "DEMO01");
		map.put("pw", "1234");
		MemberVo loginVo = mDao.loginMember(map);
		log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 loginMember Test  "
				+ "로그인한 회원 정보 :"
				+ " {} ＃＃＃＃＃＃＃＃＃", loginVo);
		System.out.println("로그인한 회원정보 : "+loginVo);
	}
	
	//@Test
		//1)일반회원 로그인(아이디,비밀번호,사용여부N) 
		public void loginTra() {
			Map<String, Object> map = new HashMap<String, Object>();
			log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 loginMember Test 실행 ＃＃＃＃＃＃＃＃＃");
			map.put("id", "admin");
			map.put("pw", "1234");
			MemberVo loginVo = mDao.loginTra(map);
			log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 loginMember Test  "
					+ "로그인한 회원 정보 :"
					+ " {} ＃＃＃＃＃＃＃＃＃", loginVo);
			System.out.println("로그인한 회원정보 : "+loginVo);
		}
	
	@Test
		//2)일반회원 회원가입
	    public void traSignUp() {
		log.info("MemberTest traSignUp");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id","test03");
		map.put("pw","1234");
		map.put("name","test");
		map.put("email","test@naver.com");
		map.put("phone","test");
		map.put("birth","test");
		map.put("profile","test");
		int n = mDao.traSignUp(map);
		log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 traSigntra Test  "
				+ "회원가입 성공 :"
				+ " {} ＃＃＃＃＃＃＃＃＃", n);
	}
	
	//@Test
	//3) 회원가입
	public void signupMember() {
		log.info("MemberTest insertMemberTest");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id","GD300");
		map.put("pw","1234");
//		int n = mDao.signupMember(map);
//		System.out.println("회원가입된 회원 : "+n);
	}


	//@Test
	//5) 비밀번호 확인(아이디 입력받아서 확인) //다시
	public void memberPwCheck() {
		String id = "GD002";
//		int n = mDao.memberPwCheck(id);
//		System.out.println("입력받은 아이디 : "+ id +"비밀번호 체크된 회원 수 : "+ n);
	}
	
	//@Test
	//6) 새글쓰기
	public void insertBoard() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "GD004");
		map.put("title", "GD004가 작성한 글");
		map.put("content", "GD004가 작성한 글입니다");
		
		System.out.println("새로 작성된 글 : "+map);
	}
	
	//@Test
	//7) 답글(업데이트)
	public void replyUpdate() {
//		int n = bDao.replyUpdate("41");
//		System.out.println("업데이트 : "+n);
	}
	//@Test
	//7) 답글(새글입력)
	public void replyInsert() {
//		BoardVo vo = new BoardVo(2, "GD001","GD006이 작성한 글", "GD006이 작성한 글입니다", 0, 0, 1, 0, "N", "");
//		int n = bDao.replyInsert(vo);
//		System.out.println("입력된 새 답글 : " + vo);
	}
	
	//@Test
	//8) 상세글보기
	public void getOneBoard() {
//		BoardVo vo =  bDao.getOneBoard("24");
//		System.out.println("상세조회한 글의 정보" + vo);
	}
	
	//@Test
	//9) 조회수
	public void updateView() {
//		int n = bDao.updateView("2");
//		System.out.println("업데이트된 조회수 : " + n);
	}
	
	//@Test
	//10) 글 수정(제목,내용)
	public void  modifyBoard() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "GD008");
		map.put("title", "GD008이 수정한 글");
		map.put("content", "GD008이 수정한 글입니다");
		map.put("seq", "25");
//		int n = bDao.modifyBoard(map);
		System.out.println("새로 작성된 글 : "+map); 
	}
	
	//@Test
	//11) 글 삭제(삭제여부 변경)
	public void restoreDelflag() {
//		int cnt = bDao.restoreDelflag("2");
//		System.out.println(cnt);
	}
	//@Test
	//11) 글 삭제(다중삭제)
	public void multiDelete() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] seq = {"48","49"};
		map.put("seqs", seq);
//		bDao.multiDelete(map);
		System.out.println("다중삭제된 글 : "+map);
	}
	//@Test
	//11) 글 삭제(DYNAMIC)
	public void dynamicDelete() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		String[] seq = {"2","3"};
		map.put("seqs", seq);
//		bDao.multiDelete(map);
		System.out.println("다이나믹 쿼리를 이용해 삭제한 글 : "+map);
	}
	//@Test
	//12) 글 삭제(DB삭제, "       ,          ")
	public void deleteBoard() {
//		int n = bDao.deleteBoard("3");
//		System.out.println("삭제된 게시글 번호 : "+n);
	}
	//@Test
	//13) 하위 삭제 대상 찾기
	public void findChildren() {
//		List<BoardVo> lists = bDao.findChildren("1");
//		System.out.println("REFER에 해당하는 하위 삭제 대상 리스트 : "+lists);
	}
	//@Test
	//14) 게시글 전체조회(삭제된 글을 사용자, 삭제된 글 관리자)
	public void selectAllBoard() {
//		List<BoardVo> lists = bDao.selectAllBoard();
//		System.out.println("전체 게시글 조회 : "+lists);
	}
//	@Test
	//15) 게시글 페이징 + 전체글조회 (사용자, 관리자)
	public void userboardPaging() {
//		logger.info("IBoardDao userboardPaging");
//		RowNumVo vo = new RowNumVo();
//		List<BoardVo> lists = sqlSession.selectList("com.min.edu.model.mapper.BoardDaoImpl.userboardPaging",vo);
//		System.out.println(lists);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
