package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dao.CartDAO;
import com.dao.OrderDAO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderInfoDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class OrderService {
	
	/* 개별 주문 정보 */
	public CartDTO orderConfirm(int num) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO dao = new OrderDAO();
		CartDTO dto = null;
		
		try {
			dto = dao.orderConfirm(session, num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("orderConfirm 실패");
		}finally {
			session.close();
		}
		
		return dto;
	}// end orderConfirm
	
	/* 주문한 상품 정보 가져오기 */
	public GoodsDTO goods_orderInfo(String gCode) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO dao = new OrderDAO();
		GoodsDTO goodsDTO = null;
		
		try {
			goodsDTO = dao.goods_orderInfo(session, gCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("goods_orderInfo 실패");
		}finally {
			session.close();
		}
		
		return goodsDTO;
	} // end goods_orderInfo
	
	/* 주문 정보 저장하고 카드에서 삭제, 수량 감소시키기 */
	public void orderDone(OrderInfoDTO dto, int num, String gCode) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO oDAO = new OrderDAO();
		CartDAO cDAO = new CartDAO();
		
		try {
			int oN = oDAO.orderDone(session, dto);
			int cN = cDAO.delCart(session, num);
			int aN = oDAO.orderAfterAmount(session, gCode);
			
			if(oN + cN + aN == 3) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new MyException("orderDone 실패");
		}finally {
			session.close();
		}
	}// end orderDone
}
