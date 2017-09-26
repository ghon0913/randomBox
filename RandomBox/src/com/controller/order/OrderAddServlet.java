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
import com.service.MyPageService;
import com.service.OrderService;

@WebServlet("/OrderAddServlet")
public class OrderAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCode = request.getParameter("gCode");
		String userId = request.getParameter("userId");
		String gName = request.getParameter("gName");
		String gPrice = request.getParameter("gPrice");
		String gImage = request.getParameter("gImage");
		
		CartDTO c_dto = new CartDTO();
		c_dto.setgCode(gCode);
		c_dto.setgImage(gImage);
		c_dto.setgName(gName);
		c_dto.setgPrice(Integer.parseInt(gPrice));
		c_dto.setUserId(userId);
		
		MyPageService m_service = new MyPageService();
		String target = "order.jsp";
		
		try {
			MemberDTO m_dto = m_service.myPageUserInfo(userId);
			request.setAttribute("cDTO", c_dto);
			request.setAttribute("mDTO", m_dto);
			request.setAttribute("chk_orderPage", "orderConfirm");
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
