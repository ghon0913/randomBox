package com.service;

import java.util.HashMap;
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
	
	/* 전체주문시 카트정보 가져오기 */
	public List<CartDTO> cartListForOrder(List<String> num) throws MyException{
		
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO dao = new OrderDAO();
		List<CartDTO> list = null;
		
		try {
			list = dao.cartListForOrder(session, num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("cartListForOrder 실패");
		}finally {
			session.close();
		}
		
		return list;
	}
	
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
	
	/* 전체 주문 정보 저장하고 카드에서 삭제, 수량 감소시키기 */
	public void orderAllDone(List<OrderInfoDTO> orderDTO, List<String> numList, List<String> gCodeList) throws MyException{
		//List<String> gCodeList
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO oDAO = new OrderDAO();
		CartDAO cDAO = new CartDAO();
		
		try {
			int oN = oDAO.orderAllDone(session, orderDTO);
			int cN = cDAO.delAllCart(session, numList);
			int aN = 0;
			
			for (int i = 0; i < gCodeList.size(); i++) {
				String code1 = gCodeList.get(i);
				int result = oDAO.orderAfterAmount(session, code1);
				aN = aN + result;
				
				for (int j = 0; j < gCodeList.size(); j++) {
					if (i == j) continue;
					String code2 = gCodeList.get(j);
					if (code1.equals(code2)) {
						oDAO.orderAfterAmount(session, code1);
						aN = aN + result;
						break;
					}
				}
			}
			System.out.println("$$$$"+oN+"$$$$"+cN+"$$$$"+aN);
			if(oN == orderDTO.size() && cN == numList.size() && aN == gCodeList.size()) {
				System.out.println("$$$$");
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
