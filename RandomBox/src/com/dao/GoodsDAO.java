package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {

	public int insertGoods(SqlSession session, GoodsDTO dto) {
		int n = session.insert("insertGoods",dto);
		return n;
		
	}
	
	public List<GoodsDTO> selectAllGoods(SqlSession session){
		List<GoodsDTO> list = session.selectList("selectAllGoods");
		return list;
	}
	
	public List<GoodsDTO> selectByCategory(SqlSession session, String gCategory){
		List<GoodsDTO> list = session.selectList("selectByCategory", gCategory);
		return list;
	}
	
	public List<GoodsDTO> selectBySearch(SqlSession session, String searchWord){
		List<GoodsDTO> list = session.selectList("selectBySearch", searchWord);
		return list;
	}
}
