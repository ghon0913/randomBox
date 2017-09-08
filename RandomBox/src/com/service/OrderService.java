package com.service;

import java.util.List;

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
	
	/* 전체 주문 정보 */
	public List<CartDTO> orderAllConfirm(List<String> list) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO dao = new OrderDAO();
		List<CartDTO> dtoList = null;
		
		try {
			dtoList = dao.orderAllConfirm(session, list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("orderAllConfirm 실패");
		}finally {
			session.close();
		}
		
		return dtoList;
	}// end orderAllConfirm
	
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
	
	/* 주문한 상품 정보 가져오기 */
	public List<GoodsDTO> goods_orderInfoAll(List<String> gCodeList) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO dao = new OrderDAO();
		List<GoodsDTO> goodsDTOList = null;
		
		try {
			goodsDTOList = dao.goods_orderInfoAll(session, gCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("goods_orderInfo 실패");
		}finally {
			session.close();
		}
		
		return goodsDTOList;
	} // end goods_orderInfoAll
	
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
	
	/* 주문 정보 저장하고 카드에서 삭제, 수량 감소시키기 */
	public void orderAllDone(List<OrderInfoDTO> orderDTO, List<String> numList, List<String> gCodeList) throws MyException{
		//List<String> gCodeList
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO oDAO = new OrderDAO();
		CartDAO cDAO = new CartDAO();
		
		try {
			int oN = oDAO.orderAllDone(session, orderDTO);
			int cN = cDAO.delAllCart(session, numList);
			int aN = oDAO.orderAfterAmountAll(session, gCodeList);
			
			if(oN == orderDTO.size() && cN == numList.size() && aN == gCodeList.size()) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new MyException("orderAllDone 실패");
		}finally {
			session.close();
		}
	}// end orderDone
}
