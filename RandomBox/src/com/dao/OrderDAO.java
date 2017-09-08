package com.dao;

import java.util.List;

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
	
	/* 전체 주문 */
	public List<CartDTO> orderAllConfirm(SqlSession session, List<String> list){
		
		List<CartDTO> dtoList = session.selectList("orderAllConfirm", list);
		return dtoList;
	}
	
	/* 주문한 상품 정보 가져오기 */
	public GoodsDTO goods_orderInfo(SqlSession session, String gCode) {

		GoodsDTO goodsDTO = session.selectOne("goods_orderInfo", gCode);
		return goodsDTO;
	}
	
	/* 전체 주문한 상품 정보 리스트로 받아 가져오기  */
	public List<GoodsDTO> goods_orderInfoAll(SqlSession session, List<String> gCodeList) {

		List<GoodsDTO> goodsDTOList = session.selectList("goods_orderInfoAll", gCodeList);
		return goodsDTOList;
	}
	
	/* 주문정보 저장하기 */
	public int orderDone(SqlSession session, OrderInfoDTO dto) {
		
		int n = session.insert("orderDone", dto);
		return n;
	}
	
	/* 전체 주문 정보 저장하기 */
	public int orderAllDone(SqlSession session, List<OrderInfoDTO> dtoList) {
		
		int n = session.insert("orderAllDone", dtoList);
		return n;
	}
	
	/* amount 감소 */
	public int orderAfterAmount(SqlSession session, String gCode) {
		
		int n = session.update("orderAfterAmount", gCode);
		return n;
	}
	
	/* 전체 주문 리스트 amount 감소 */
	public int orderAfterAmountAll(SqlSession session, List<String> gCodeList) {
		
		int n = session.update("orderAfterAmountAll", gCodeList);
		return n;
	}
}
