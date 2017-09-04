package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MemberService {

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

	}
	
	public MemberDTO searchMember(HashMap<String,String> map) {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
			dto = dao.searchMember(session, map);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		
		return dto;
	}

}
