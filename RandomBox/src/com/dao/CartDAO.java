package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {

	/* 장바구니 리스트 */
	public List<CartDTO> cartList(SqlSession session, String userid){
		
		List<CartDTO> list = session.selectList("cartList", userid);
		return list;
	}
	
	/* 개별 삭제 */
	public int delCart (SqlSession session, int num) {
		
		int n = session.delete("delCart", num);
		return n;
	}
	
	/* 전체 삭제 */
	public int delAllCart (SqlSession session, List<String> list) {
		
		int n = session.delete("delAllCart", list);
		return n;
	}
	
	/* 개별 주문 */
	public CartDTO orderConfirm(SqlSession session, int num){
		
		CartDTO dto = session.selectOne("orderConfirm", num);
		return dto;
	}
	
}
