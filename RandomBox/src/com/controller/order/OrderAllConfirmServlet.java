package com.controller.order;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderInfoDTO;
import com.exception.MyException;
import com.service.MyPageService;
import com.service.OrderService;

@WebServlet("/OrderAllConfirmServlet")
public class OrderAllConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] nums = request.getParameterValues("check");
		String userId = request.getParameter("userid");
		
		String target = "orderAllConfirm.jsp";
		
		OrderService o_service = new OrderService();
		MyPageService m_service = new MyPageService();
		
		try {
			List<CartDTO> o_list = o_service.orderAllConfirm(Arrays.asList(nums));
			MemberDTO m_dto = m_service.myPageUserInfo(userId);
			request.setAttribute("orderList", o_list);
			request.setAttribute("mDTO", m_dto);

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
