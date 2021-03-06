package com.service;

import java.util.List;

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

	public List<GoodsDTO> selectAllGoods() throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		GoodsDAO dao = new GoodsDAO();

		List<GoodsDTO> list = null;
		try {
			list = dao.selectAllGoods(session);
		} catch (Exception e) {
			throw new MyException("selectAllGoods 실패");
		} finally {
			session.close();
		}
		return list;

	}
	
	public List<GoodsDTO> selectByCategory(String gCategory) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		GoodsDAO dao = new GoodsDAO();

		List<GoodsDTO> list = null;
		try {
			list = dao.selectByCategory(session, gCategory);
		} catch (Exception e) {
			throw new MyException("selectByCategory 실패");
		} finally {
			session.close();
		}
		return list;

	}
	
	public List<GoodsDTO> selectBySearch(String searchWord) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		GoodsDAO dao = new GoodsDAO();

		List<GoodsDTO> list = null;
		try {
			list = dao.selectBySearch(session, searchWord);
		} catch (Exception e) {
			throw new MyException("selectBySearch 실패");
		} finally {
			session.close();
		}
		return list;

	}
	
	public List<String> selectgName(List<String> gCodeList){
		
		SqlSession session = MybatisTemplate.openSession();
		GoodsDAO dao = new GoodsDAO();
		
		List<String> list = dao.selectgName(session, gCodeList);
		return list;
	}

}
