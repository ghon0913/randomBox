package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dao.MyPageDAO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MyPageService {
	
	public MemberDTO myPageUserInfo(String userid) throws MyException{
		MyPageDAO dao = new MyPageDAO();
		SqlSession session = MybatisTemplate.openSession();
		try {
		MemberDTO dto = dao.myPageUserInfo(session, userid);
		return dto ;
		}catch(Exception e) {
			throw new MyException("myPageUserInfo 예외");
		}finally {
			session.close();
		}
	}
	
	public void updateuserinfo(MemberDTO dto) throws MyException{
		MyPageDAO dao = new MyPageDAO();
		SqlSession session = MybatisTemplate.openSession();
		try {
			int n = dao.updateuserinfo(session, dto);
			if(n==1) {
				session.commit();
			}
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new MyException("updateuserinfo 예외");
		}finally {
			session.close();
		}
	}
	


}


