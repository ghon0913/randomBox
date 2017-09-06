package com.service;

import java.util.HashMap;

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
	public boolean idCheck(String userid) throws MyException {

		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		boolean ck;

		try {
			ck = dao.idCheck(session, userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("idCheck 실패");
		} finally {
			session.close();
		}

		return ck;
	}// end idCheck
	
	/* 아이디 체크 */
	public boolean emailCheck(String email) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		boolean ck;
		
		try {
			ck = dao.emailCheck(session, email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("emailCheck 실패");
		} finally {
			session.close();
		}
		
		return ck;
	}// end emailCheck
	


	/* 로그인 */
	public MemberDTO searchMember(HashMap<String, String> map) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
			dto = dao.searchMember(session, map);
		} catch (Exception e) {
			throw new MyException("searchMember 실패");
		} finally {
			session.close();
		}

		return dto;
	}

	/* 쿠키아이디 추가 */
	public void updateCookieId(HashMap<String, String> map) throws MyException {

		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		try {
			int n = dao.updateCookieId(session, map);
			if(n==1) {
				session.commit();
			}
			
		} catch (Exception e) {
			throw new MyException("updateCookieId 실패");
		} finally {
			session.close();
		}

	}

	/* 세션아이디 체크 */
	public MemberDTO checkCookieId(String cookieId) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
			dto = dao.checkCookieId(session, cookieId);
		} catch (Exception e) {
			throw new MyException("checkCookieId");
		} finally {
			session.close();
		}
		return dto;
	}
	
	/* 아이디 찾기 */
	public String findUserId(HashMap<String,String> map) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		String userid = null;
		try {
			userid = dao.findUserId(session, map);
		} catch (Exception e) {
			throw new MyException("findUserId 실패");
		} finally {
			session.close();
		}
		return userid;
	}
	
	/* 비밀번호 찾기 */
	public MemberDTO findPasswd(String userid) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
			dto = dao.findPasswd(session, userid);
		} catch (Exception e) {
			throw new MyException("findPasswd 실패");
		} finally {
			session.close();
		}
		return dto;
	}
	
}
