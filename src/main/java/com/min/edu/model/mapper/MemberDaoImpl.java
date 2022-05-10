package com.min.edu.model.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.MemberVo;

@Repository
public class MemberDaoImpl implements IMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.edu.model.mapper.MemberDaoImpl.";
	
	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		
		
		return sqlSession.selectOne(NS+"loginMember",map);
	}

}
