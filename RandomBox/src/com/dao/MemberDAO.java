package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public int insertMember(SqlSession session, MemberDTO dto) {
		
		int n = session.insert("insertMember", dto);
		return n;
	}
	
	public MemberDTO searchMember(SqlSession session, HashMap map) {
		
		MemberDTO dto = session.selectOne("searchMember",map);
		return dto;
	}

}
