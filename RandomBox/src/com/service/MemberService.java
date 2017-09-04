package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MemberService {

	/* 회원가입 */
	public void insertMember(MemberDTO dto) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		try {
			int n = dao.insertMember(session, dto);
			if (n == 1) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("insertMember 실패");
		} finally {
			session.close();
		}

	}// end insertMember
	
	/* 아이디 체크 */
	public String idCheck(String userid) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		String id;
		
		try {
			id = dao.idCheck(session, userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("idCheck 실패");
		} finally {
			session.close();
		}
		
		return id;
	}// end idCheck

}
