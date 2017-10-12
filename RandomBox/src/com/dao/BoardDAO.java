package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;

public class BoardDAO {

	/* 문의게시판 전체 목록  + 페이징*/	
	public BoardPageDTO inquiryListPage(SqlSession session, int curPage, HashMap<String, String> searchMap) {
		
		BoardPageDTO dto = new BoardPageDTO();
		
		int sIndex = (curPage - 1) * dto.getPerPage();
        int length = dto.getPerPage();
        List<BoardDTO> list =
           session.selectList("inquiryList", searchMap, new RowBounds(sIndex, length));
        int totalCount = session.selectOne("inquiryList_totalCount", searchMap);
        
        //pageDTO에 4개의 저장
        dto.setList(list);
        dto.setCurPage(curPage);
        dto.setTotalCount(totalCount);
        
        return dto;
	}
	
	/* 문의글 작성 */
	public int inquiryWrite(SqlSession session, BoardDTO dto) {
		
		int n = session.insert("inquiryWrite", dto);
		return n;
	}
	
	/* 문의글 자세히보기 */
	public BoardDTO inquiryRetrieve(SqlSession session, int num) {
		
		BoardDTO dto = session.selectOne("inquiryRetrieve", num);
		return dto;
	}
	public int inquiryReadCnt(SqlSession session, int num) {
		
		int n = session.update("inquiryReadCnt", num);
		return n;
	}
	
	/* 문의글 수정하기 */
	public int inquiryUpdate(SqlSession session, BoardDTO dto) {
		
		int n = session.update("inquiryUpdate", dto);
		return n;
	}
	
	/* 문의글 삭제하기 */
	public int inquiryDelete(SqlSession session, int num) {
		
		int n = session.delete("inquiryDelete", num);
		return n;
	}
	
	/* 문의글 작성 -> 카테고리 선택  */
	public List<GoodsDTO> selectCategory(SqlSession session, String gCategory) {
		
		List<GoodsDTO> list = session.selectList("selectCategory", gCategory);
		return list;
	}
	
	/* 후기게시판 전체 목록  + 페이징*/	
	public BoardPageDTO reviewListPage(SqlSession session, int curPage, HashMap<String, String> searchMap) {
		
		BoardPageDTO dto = new BoardPageDTO();
		
		int sIndex = (curPage - 1) * dto.getPerPage();
        int length = dto.getPerPage();
        List<BoardDTO> list =
           session.selectList("reviewList", searchMap, new RowBounds(sIndex, length));
        int totalCount = session.selectOne("reviewList_totalCount", searchMap);
        
        //pageDTO에 4개의 저장
        dto.setList(list);
        dto.setCurPage(curPage);
        dto.setTotalCount(totalCount);
        
        return dto;
	}
	
	/*후기작성 시 상품명 가져오기*/
	public String getGoodsName(SqlSession session, String gCode) {
		System.out.println(">>>>>>>>>>"+gCode);
		return session.selectOne("getGoodsName", gCode);
	}

}
