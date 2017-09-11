package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.dto.CartDTO;

public class BoardDAO {

	/* 문의게시판 전체 목록  + 페이징*/	
	public BoardPageDTO inquiryListPage(SqlSession session, int curPage) {
		
		BoardPageDTO dto = new BoardPageDTO();
		
		int sIndex = (curPage - 1) * dto.getPerPage();
        int length = dto.getPerPage();
        List<BoardDTO> list =
           session.selectList("inquiryList", null, new RowBounds(sIndex, length));
        int totalCount = session.selectOne("inquiryList_totalCount");
        
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
	
}
