package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;
import com.min.edu.vo.RowNumVo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository
public class BoardDaoImpl implements IBoardrDao{
		
		@Autowired
		private SqlSessionTemplate sqlSession;
		
		private final String NS = "com.min.edu.model.mapper.BoardDaoImpl.";

		@Override
		public List<BoardVo> selectBoardAll(MemberVo mVo) {
			return sqlSession.selectList(NS+"selectBoardAll",mVo);
		}

		@Override
		public BoardVo selectBoardDetail(String seq) {
			return sqlSession.selectOne(NS+"selectBoardDetail",seq);
		}

		@Override
		public int updateReadcount(String seq) {
			return sqlSession.update(NS+"updateReadcount",seq);
		}
		/*
		 * 페이징 처리
		 */
		@Override
		public List<BoardVo> adminBoardListRow(RowNumVo vo) {
			return sqlSession.selectList(NS+"adminBoardListRow", vo);
		}
		
		@Override
		public int adminBoardListTotal() {
			return sqlSession.selectOne(NS+"adminBoardListTotal");
		}
		
		@Override
		public List<BoardVo> userBoardListRow(RowNumVo vo) {
			// TODO Auto-generated method stub
			return sqlSession.selectList(NS+"userBoardListRow", vo);
		}
		
		@Override
		public int userBoardListTotal() {
			return sqlSession.selectOne(NS+"userBoardListTotal");
		}
}
