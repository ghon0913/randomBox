package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	/* 회원가입*/
	public int insertMember(SqlSession session, MemberDTO dto) {
		
		int n = session.insert("insertMember", dto);
		return n;

	}// end insertMember
	
	/* 아이디 중복 체크 */
	public boolean idCheck(SqlSession session, String userid) {
		
		String id = session.selectOne("idCheck", userid);
		boolean ck;
		
		if(id!=null) {
			ck = true;
		}else {
			ck = false;
		}
		return ck;
	}// end idCheck

	/* 이메일 중복 체크 */
	public boolean emailCheck(SqlSession session, String email) {
		
		String e = session.selectOne("emailCheck", email);
		boolean ck;
		
		if(e!=null) {
			ck = true;
		}else {
			ck = false;
		}
		return ck;
	}// end emailCheck
	
	public MemberDTO searchMember(SqlSession session, HashMap<String, String> map) {
		
		MemberDTO dto = session.selectOne("searchMember",map);
		return dto;
	}


}
