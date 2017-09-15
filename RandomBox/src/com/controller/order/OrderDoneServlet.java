package com.controller.order;

import java.io.IOException;

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

@WebServlet("/OrderDoneServlet")
public class OrderDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		String userId = request.getParameter("userId");
		String orderName = request.getParameter("orderName");
		String phone = request.getParameter("phone");
		String eMail = request.getParameter("eMail");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String payMethod = request.getParameter("payMethod");
		String gCode = request.getParameter("gCode");
		String gPrice = request.getParameter("gPrice");
		
		OrderInfoDTO orderDTO = new OrderInfoDTO();
		orderDTO.setUserId(userId);
		orderDTO.setOrderName(orderName);
		orderDTO.setPhone(phone);
		orderDTO.seteMail(eMail);
		orderDTO.setPost1(post1);
		orderDTO.setPost2(post2);
		orderDTO.setAddr1(addr1);
		orderDTO.setAddr2(addr2);
		orderDTO.setPayMethod(payMethod);
		orderDTO.setgPrice(Integer.parseInt(gPrice));

		OrderService service = new OrderService();
		GoodsDTO goodsDTO = null;
		String target = "order.jsp";
		
		try {
			goodsDTO = service.goods_orderInfo(gCode);
		} catch (MyException e) {
			e.printStackTrace();
			target = "error.jsp";
		}
		
		orderDTO.setgCode(goodsDTO.getgCode());
		orderDTO.setgName(goodsDTO.getgName());
		orderDTO.setgImage(goodsDTO.getgImage());
		orderDTO.setSellerId(goodsDTO.getSellerId());
		
		/* *********************************** orderDTO 저장 끝*/
		
		try {
			service.orderDone(orderDTO, Integer.parseInt(num), gCode);
			request.setAttribute("orderDTO", orderDTO);
			request.setAttribute("chk_orderPage", "orderDone");
		} catch (NumberFormatException | MyException e) {
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