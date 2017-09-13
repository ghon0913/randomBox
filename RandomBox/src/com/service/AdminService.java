package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.AdminDAO;
import com.dto.AdminUserInfoPageDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class AdminService {
	
	public List<MemberDTO> userInfo() throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		AdminDAO dao = new AdminDAO();
		List<MemberDTO> list = null;
		try {
			list = dao.userInfo(session);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("userInfo 예외");
		}finally {
			session.close();
		}
		return list;
	}
	
	public AdminUserInfoPageDTO userInfoPage(HashMap<String,String> map, int curPage) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		AdminDAO dao = new AdminDAO();
		AdminUserInfoPageDTO dto = null;
		try {
			dto = dao.userInfoPage(session, map, curPage);
			System.out.println(dto);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("userInfoPage 예회");
		}finally {
			session.close();
		}
		return dto;
	}

}
