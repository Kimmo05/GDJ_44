package com.min.edu.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	private IMemberDao dao;
	
	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		log.info("MemberVo loginMember");
		return dao.loginMember(map);
	}

	@Override
	public MemberVo loginTra(Map<String, Object> map) {
		log.info("MemberVo loginTra");
		return dao.loginTra(map);
	}

	@Override
	public int traSignUp(Map<String, Object> map) {
		log.info("MemberVo traSignUp");
		return dao.traSignUp(map);
	}

	@Override
	public MemberVo loginIns(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.loginIns(map);
	}

	@Override
	public int InsSignUp(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.InsSignUp(map);
	}


}
