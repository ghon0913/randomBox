package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.BoardDAO;
import com.dto.AnswerDTO;
import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.dto.GoodsDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class BoardService {
	
	/* 문의게시판 전체 목록 */
	public BoardPageDTO inquiryList(int curPage, HashMap<String, String> searchMap) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		BoardPageDTO dto = new BoardPageDTO();
		
		try {
			dto = dao.inquiryListPage(session, curPage, searchMap);
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
			int n = dao.inquiryReadCnt(session, num);
			if(n==1) session.commit();
			dto = dao.inquiryRetrieve(session, num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("inquiryRetrieve 실패");
		}finally {
			session.close();
		}

		return dto;
	}
	
	/* 문의글 수정하기 */
	public void inquiryUpdate(BoardDTO dto) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		
		try {
			int n = dao.inquiryUpdate(session, dto);
			if(n==1) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("inquiryUpdate 실패");
		}finally {
			session.close();
		}
	}
	
	/* 문의 글 삭제하기 */
	public void inquiryDelete(int num) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		
		try {
			int n = dao.inquiryDelete(session, num);
			if(n==1) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("inquiryDelete 실패");
		}finally {
			session.close();
		}
	}
	
	/* 문의글 작성 -> 카테고리 선택  */
	public List<GoodsDTO> selectCategory(String gCategory) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		List<GoodsDTO> list = null;
		
		try {
			list = dao.selectCategory(session, gCategory);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("selectCategory 실패");
		}finally {
			session.close();
		}
		
		return list;
	}
	
	/* 후기게시판 전체 목록 */
	public BoardPageDTO reviewList(int curPage, HashMap<String, String> searchMap) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		BoardPageDTO dto = new BoardPageDTO();
		
		try {
			dto = dao.reviewListPage(session, curPage, searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("reviewList 실패");
		}finally {
			session.close();
		}
		
		return dto;
	}
	
	/*후기작성 시 상품명 가져오기*/
	public String getGoodsName(String gCode) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		String goodsName = null;
		try {
			goodsName = dao.getGoodsName(session, gCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("getGoodsName 실패");
		}finally {
			session.close();
		}
		
		return goodsName;
	}
	
	/* 후기 글 삭제하기 */
	public void reviewDelete(int num) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		
		try {
			int n = dao.reviewDelete(session, num);
			if(n==1) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("reviewDelete 실패");
		}finally {
			session.close();
		}
	}
	
	/* 후기글 수정하기 */
	public void reviewUpdate(BoardDTO dto) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		
		try {
			int n = dao.reviewUpdate(session, dto);
			if(n==1) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("reviewUpdate 실패");
		}finally {
			session.close();
		}
	}
	
	/* 답변하기 게시판 전체 목록 */
	public BoardPageDTO questionList(int curPage, String gCode) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		BoardPageDTO dto = new BoardPageDTO();
		
		try {
			dto = dao.questionList(session, gCode, curPage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("questionList 실패");
		}finally {
			session.close();
		}
		
		return dto;
	}
	
	/*답변*/
	public void answerWrite(AnswerDTO dto, int boardNum) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		
		try {
			int n = dao.answerWrite(session, dto);
			int n2 = dao.stateUpdate(session, boardNum);
			
			if(n==1 && n2 ==1) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("answerWrite 실패");
		}finally {
			session.close();
		}
	}
	
	/*답변불러오기*/
	public AnswerDTO selectAnswer(int num) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		BoardDAO dao = new BoardDAO();
		AnswerDTO a_dto = null;
		
		try {
			a_dto = dao.selectAnswer(session, num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("selectAnswer 실패");
		}finally {
			session.close();
		}
		
		return a_dto;
	}
}
