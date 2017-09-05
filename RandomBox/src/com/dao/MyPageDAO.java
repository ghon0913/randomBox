package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MyPageDAO {
	//...("com.mybatis.OrderMapper.orderDone",para)...
	
	public MemberDTO myPageUserInfo(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("com.mybatis.MyPageMapper.mypageuserinfo",userid);
		return dto;
	}
	
	public int updateuserinfo(SqlSession session, MemberDTO dto) {
		int n = session.update("com.mybatis.MyPageMapper.updateuserinfo",dto);
		return n;
	}
}
