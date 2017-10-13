package com.controller.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderInfoDTO;
import com.exception.MyException;
import com.service.CartService;
import com.service.OrderService;

@WebServlet("/OrderAllDoneServlet")
public class OrderAllDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] numList = request.getParameterValues("num"); // cartNum
		String userId = request.getParameter("userId");
		String orderName = request.getParameter("orderName");
		String phone = request.getParameter("phone");
		String eMail = request.getParameter("eMail");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String payMethod = request.getParameter("payMethod");
		String[] gCodeList = request.getParameterValues("gCode");
		
		String target = "order.jsp";

		OrderService o_service = new OrderService();
		List<CartDTO> cartDTOList = null;

		// CartDTO 가져와서 배송정보랑 함께 orderInfoDTO에 저장 
		try {
			cartDTOList = o_service.cartListForOrder(Arrays.asList(numList));
		} catch (MyException e) {
			e.printStackTrace();
			target = "error.jsp";
		}

		List<OrderInfoDTO> orderDTOList = new ArrayList<>();

		for (CartDTO cartDTO : cartDTOList) {

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
				orderInfoDTO.setgCode(cartDTO.getgCode());
				orderInfoDTO.setgName(cartDTO.getgName());
				orderInfoDTO.setgPrice(cartDTO.getgPrice());
				orderInfoDTO.setgImage(cartDTO.getgImage());
				orderInfoDTO.setSellerId(cartDTO.getSellerId());
			orderDTOList.add(orderInfoDTO);
		}
/* **************************************************************************** orderDTO 저장 끝 */	
		
		try {
			o_service.orderAllDone(orderDTOList, Arrays.asList(numList), Arrays.asList(gCodeList));
			request.setAttribute("orderList", orderDTOList);
			request.setAttribute("chk_orderPage", "orderAllDone");
		} catch (MyException e) {
			e.printStackTrace();
			target = "error.jsp";
		}

		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}