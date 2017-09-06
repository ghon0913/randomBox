package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.CartDAO;
import com.dto.CartDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class CartService {

	/* 장바구니 리스트 */
	public List<CartDTO> cartList(String userid) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		List<CartDTO> list = null;
		
		try {
			list = dao.cartList(session, userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("cartList 실패");
		}finally {
			session.close();
		}
		
		return list;
	}
	
	/* 개별 삭제 */
	public void delCart(int num) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		
		try {
			int n = dao.delCart(session, num);
			if(n==1) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("delCart 실패");
		}finally {
			session.close();
		}
	}
	
	/* 전체 삭제 */
	public void delAllCart(List<String> list) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		
		try {
			int n = dao.delAllCart(session, list);
			if(n== list.size()) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("delCart 실패");
		}finally {
			session.close();
		}
	}
	
}
