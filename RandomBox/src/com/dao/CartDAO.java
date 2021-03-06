package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

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

	/* 장바구니 추가 */
	public int addCart (SqlSession session, CartDTO dto) {
		
		int n = session.insert("addCart", dto);
		return n;
	}

}
