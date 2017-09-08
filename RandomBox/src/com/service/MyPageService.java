package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MyPageDAO;
import com.dto.BoardDTO;
import com.dto.MemberDTO;
import com.dto.MyPageBoardPageDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MyPageService {

	public MemberDTO myPageUserInfo(String userid) throws MyException {
		MyPageDAO dao = new MyPageDAO();
		SqlSession session = MybatisTemplate.openSession();
		try {
			MemberDTO dto = dao.myPageUserInfo(session, userid);
			return dto;
		} catch (Exception e) {
			throw new MyException("myPageUserInfo 예외");
		} finally {
			session.close();
		}
	}

	public void updateuserinfo(MemberDTO updto) throws MyException {
		MyPageDAO dao = new MyPageDAO();
		SqlSession session = MybatisTemplate.openSession();
		try {
			int n = dao.updateuserinfo(session, updto);
			if (n == 1) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new MyException("updateuserinfo 예외");
		} finally {
			session.close();
		}
	}

	public List<BoardDTO> myPageBoardList(String userid) throws MyException {
		MyPageDAO dao = new MyPageDAO();
		SqlSession session = MybatisTemplate.openSession();
		List<BoardDTO> bdto = null;
		try {
			bdto = dao.myPageBoardList(session, userid);
		} catch (Exception e) {
			throw new MyException("myPageBoardList 예외");
		} finally {
			session.close();
		}
		return bdto;
	}
	
	public BoardDTO myPageBoardRetrieve(int bnum) throws MyException {
		MyPageDAO dao = new MyPageDAO();
		SqlSession session = MybatisTemplate.openSession();
		BoardDTO bdto = null;
		try {
			bdto = dao.myPageBoardRetrieve(session, bnum);
		} catch (Exception e) {
			throw new MyException("myPageBoardList 예외");
		} finally {
			session.close();
		}
		return bdto;
	}

	public MyPageBoardPageDTO boardpage(HashMap<String, String> map, int curPage) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyPageDAO dao = new MyPageDAO();
		MyPageBoardPageDTO pagedto = null;
		try {
			pagedto = dao.boardpage(session,map,curPage);
			System.out.println(pagedto+"service");
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("boardpage 예외");
		}finally {
			session.close();
		}
		return pagedto;
	}

	

}
