package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.AdminUserInfoPageDTO;
import com.dto.BoardDTO;
import com.dto.MemberDTO;
import com.dto.MyPageBoardPageDTO;

public class AdminDAO {
	
	public List<MemberDTO> userInfo(SqlSession session){
		List<MemberDTO> list = session.selectList("com.mybatis.AdminMapper.userInfo");
		return list;
	}
	
	public AdminUserInfoPageDTO userInfoPage(SqlSession session, HashMap<String,String> map, int curPage) {
		
		AdminUserInfoPageDTO dto = new AdminUserInfoPageDTO();
		
		int sIndex = (curPage - 1) * AdminUserInfoPageDTO.getPerCount();
		int length = AdminUserInfoPageDTO.getPerCount();

		List<MemberDTO> list = session.selectList("com.mybatis.AdminMapper.userInfoPage",map,
				new RowBounds(sIndex, length));
		
		
		//pagedto에 저장

		int totalPage = 0;
		if (map.get("searchValue") == null) {
			totalPage = session.selectOne("com.mybatis.AdminMapper.userInfototalPage");
		} else {
			totalPage = session.selectOne("com.mybatis.AdminMapper.userInfoSearchPage", map);
		}
		dto.setTotalPage(totalPage);
		
		dto.setMlist(list);
		dto.setCurPage(curPage);
		dto.setSearchName(map.get("searchName"));
		dto.setSearchValue(map.get("searchValue"));
		
		return dto;
		
	}
	
	public void AdminSalesStatus(SqlSession session) {
		
	
	}

}
