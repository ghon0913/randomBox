package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.MemberDTO;

public class MyPageDAO {
	//...("com.mybatis.OrderMapper.orderDone",para)...
	
	public MemberDTO myPageUserInfo(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("com.mybatis.MyPageMapper.mypageuserinfo",userid);
		return dto;
	}
	
	public int updateuserinfo(SqlSession session, MemberDTO dto) {
		int n = session.update("com.mybatis.MyPageMapper.updateuserinfo",dto);
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
}
