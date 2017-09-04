package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	/* 회원가입*/
	public int insertMember(SqlSession session, MemberDTO dto) {
		
		int n = session.insert("insertMember", dto);
		return n;
	}// end insertMember
	
	/* 아이디 중복 체크 */
	public String idCheck(SqlSession session, String userid) {
		
		String id = session.selectOne("idCheck", userid);
		boolean ck = false;
		
		if(id!=null) {
			//ck = 
		}
		return id;
	}// end idCheck

}
