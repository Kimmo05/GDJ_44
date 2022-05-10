package com.min.edu.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IMemberDao;
import com.min.edu.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements IMemberService {

	
	@Autowired
	private IMemberDao dao;
	
	@Override
	public MemberVo loginMember(Map<String, Object> map) {
		log.info("MemberVo LoginMember");
		return dao.loginMember(map);
	}

}
