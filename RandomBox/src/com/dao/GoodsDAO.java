package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {

	public int insertGoods(SqlSession session, GoodsDTO dto) {
		int n = session.insert("insertGoods",dto);
		return n;
		
	}
}
