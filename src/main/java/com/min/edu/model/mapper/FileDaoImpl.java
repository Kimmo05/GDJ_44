//package com.min.edu.model.mapper;
//
//import java.util.Map;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.min.edu.vo.FileVo;
//
//@Repository
//public class FileDaoImpl implements IFileDao{
//
//	@Autowired
//	private SqlSessionTemplate sqlSession;
//	
//	private final String NS = "com.min.edu.model.mapper.FileDaoImpl.";
//	
//	@Override
//	public int insertBoardFile(FileVo fVo) {
//		// TODO Auto-generated method stub
//		return  sqlSession.insert(NS+"insertBoardFile",fVo);
//	}
//	
//}
