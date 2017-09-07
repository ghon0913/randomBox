package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dao.GoodsDAO;
import com.dto.GoodsDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class GoodsService {

	public void insertGoods(GoodsDTO dto) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		GoodsDAO dao = new GoodsDAO();
		try {
			int n = dao.insertGoods(session, dto);
			if (n == 1) {
				session.commit();
			}
		} catch (Exception e) {
			throw new MyException("insertGoods 실패");
		} finally {
			session.close();
		}
	}

}
