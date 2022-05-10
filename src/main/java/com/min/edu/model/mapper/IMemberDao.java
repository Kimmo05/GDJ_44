package com.min.edu.model.mapper;

import java.util.Map;

import com.min.edu.vo.MemberVo;

public interface IMemberDao {

	public MemberVo loginMember(Map<String, Object> map);
}
