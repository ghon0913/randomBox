package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.MemberDTO;
import com.dto.MyPageBoardPageDTO;

public class MyPageDAO {
	//...("com.mybatis.OrderMapper.orderDone",para)...
	
	public MemberDTO myPageUserInfo(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("com.mybatis.MyPageMapper.mypageuserinfo",userid);
		return dto;
	}
	
	public int updateuserinfo(SqlSession session, MemberDTO updto) {
		int n = session.update("com.mybatis.MyPageMapper.updateuserinfo",updto);
		return n;
	}
	
	public List<BoardDTO> myPageBoardList(SqlSession session, String userid) {
		List<BoardDTO> bdto = session.selectList("com.mybatis.MyPageMapper.myPageBoardList",userid);
		return bdto;
	}
	
	public BoardDTO myPageBoardRetrieve(SqlSession session, int bnum) {
		BoardDTO bdto = session.selectOne("com.mybatis.MyPageMapper.myPageBoardRetrieve",bnum);
		return bdto;
	}

	public MyPageBoardPageDTO boardpage(SqlSession session, HashMap<String, String> map, int curPage) {
			// TODO Auto-generated method stub
		
		MyPageBoardPageDTO pagedto = new MyPageBoardPageDTO();
		
		int sIndex = (curPage -1)*MyPageBoardPageDTO.getPerPage();
		int length = MyPageBoardPageDTO.getPerPage();
		
		List<BoardDTO> list = session.selectList("com.mybatis.MyPageMapper.myPageBoardsearch",map, new RowBounds(sIndex,length));
		System.out.println(list+"dao list");
		System.out.println(pagedto.getBlist());
		//pagedto에 저장하기
		int totalPage = 0;
		pagedto.setBlist(list);
		pagedto.setCurPage(curPage);
		if(map.get("searchValue")==null) {
			totalPage = session.selectOne("com.mybatis.MyPageMapper.totalPage",map.get("userId"));
		}else {
			totalPage = session.selectOne("com.mybatis.MyPageMapper.searchPage",map);
		}
		
		pagedto.setTotalPage(totalPage);
		pagedto.setSearchName(map.get("searchName"));
		pagedto.setSearchValue(map.get("searchValue"));
		
		
		
		return pagedto;
	}
}











