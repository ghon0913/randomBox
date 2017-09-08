package com.controller.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.dto.OrderInfoDTO;
import com.exception.MyException;
import com.service.OrderService;

@WebServlet("/OrderAllDoneServlet")
public class OrderAllDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String [] numList = request.getParameterValues("num");
		String userId = request.getParameter("userId");
		String orderName = request.getParameter("orderName");
		String phone = request.getParameter("phone");
		String eMail = request.getParameter("eMail");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String payMethod = request.getParameter("payMethod");
		String gPrice = request.getParameter("gPrice");
		String [] gCodeList = request.getParameterValues("gCode");
		
		String target = "orderAllDone.jsp";
		
		// GoodsDTO 가져오기
		OrderService o_service = new OrderService();
		List<GoodsDTO> goodsDTOList = null;
		try {
			goodsDTOList = o_service.goods_orderInfoAll(Arrays.asList(gCodeList));
		} catch (MyException e) {
			e.printStackTrace();
			target = "error.jsp";
		}
		
		List<OrderInfoDTO> orderDTOList = new ArrayList<>();
		
		for (GoodsDTO GoodsDTO : goodsDTOList) {
			
			//for (OrderInfoDTO orderInfoDTO : orderDTOList) {
			OrderInfoDTO orderInfoDTO = new OrderInfoDTO(); 
				orderInfoDTO.setUserId(userId);
				orderInfoDTO.setOrderName(orderName);
				orderInfoDTO.setPhone(phone);
				orderInfoDTO.seteMail(eMail);
				orderInfoDTO.setPost1(post1);
				orderInfoDTO.setPost2(post2);
				orderInfoDTO.setAddr1(addr1);
				orderInfoDTO.setAddr2(addr2);
				orderInfoDTO.setPayMethod(payMethod);
				orderInfoDTO.setgPrice(Integer.parseInt(gPrice));
				orderInfoDTO.setgCode(GoodsDTO.getgCode());
				orderInfoDTO.setgName(GoodsDTO.getgName());
				orderInfoDTO.setgImage(GoodsDTO.getgImage());
				orderInfoDTO.setSellerId(GoodsDTO.getSellerId());
			//}
				orderDTOList.add(orderInfoDTO);
		}

		/* *********************************** orderDTO 저장 끝 */
		
		try {
			o_service.orderAllDone(orderDTOList, Arrays.asList(numList), Arrays.asList(gCodeList));
			request.setAttribute("orderList", orderDTOList);
		} catch (MyException e) {
			e.printStackTrace();
			target = "error.jsp";
		}

		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
