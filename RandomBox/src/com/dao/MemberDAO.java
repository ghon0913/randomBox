package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public int insertMember(SqlSession session, MemberDTO dto) {
		
		int n = session.insert("insertMember", dto);
		return n;
	}

}
