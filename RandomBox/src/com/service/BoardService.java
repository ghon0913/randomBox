package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class BoardService {
	
	/* 문의게시판 전체 목록 */
	public BoardPageDTO inquiryList(int curPage) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		BoardPageDTO dto = new BoardPageDTO();
		
		try {
			dto = dao.inquiryListPage(session, curPage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("inquiryList 실패");
		}finally {
			session.close();
		}
		
		return dto;
	}
	
	/* 문의 글 작성 */
	public void inquiryWrite(BoardDTO dto) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		
		try {
			int n = dao.inquiryWrite(session, dto);
			if(n == 1) session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			throw new MyException("inquiryWrite 실패");
		}finally {
			session.close();
		}
	}
	
	/* 문의글 자세히 보기 */
	public BoardDTO inquiryRetrieve(int num) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = null;
		
		try {
			dto = dao.inquiryRetrieve(session, num);
			int n = dao.inquiryReadCnt(session, num);
			if(n==1) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("inquiryRetrieve 실패");
		}finally {
			session.close();
		}

		return dto;
	}
}
