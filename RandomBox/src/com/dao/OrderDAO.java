package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderInfoDTO;

public class OrderDAO {
	
	/* 개별 주문 */
	public CartDTO orderConfirm(SqlSession session, int num){
		
		CartDTO dto = session.selectOne("orderConfirm", num);
		return dto;
	}
	
	/* 주문한 상품 정보 가져오기 */
	public GoodsDTO goods_orderInfo(SqlSession session, String gCode) {

		GoodsDTO goodsDTO = session.selectOne("goods_orderInfo", gCode);
		return goodsDTO;
	}
	
	/* 주문정보 저장하기 */
	public int orderDone(SqlSession session, OrderInfoDTO dto) {
		
		int n = session.insert("orderDone", dto);
		return n;
	}
	
	/* amount 감소 */
	public int orderAfterAmount(SqlSession session, String gCode) {
		
		int n = session.update("orderAfterAmount", gCode);
		return n;
	}
}
