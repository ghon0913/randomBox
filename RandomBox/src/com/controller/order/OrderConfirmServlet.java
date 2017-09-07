package com.controller.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.CartService;
import com.service.MemberService;
import com.service.MyPageService;
import com.service.OrderService;

@WebServlet("/OrderConfirmServlet")
public class OrderConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String num = request.getParameter("num");
		String userid = request.getParameter("userid");
		
		OrderService o_service = new OrderService();
		MyPageService m_service = new MyPageService();
		
		String target = "orderConfirm.jsp";
		
		try {
			CartDTO c_dto = o_service.orderConfirm(Integer.parseInt(num));
			MemberDTO m_dto = m_service.myPageUserInfo(userid);
			request.setAttribute("cDTO", c_dto);
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
