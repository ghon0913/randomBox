package com.controller.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CartDTO;
import com.exception.MyException;
import com.service.CartService;

@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCode = request.getParameter("gCode");
		String userId = request.getParameter("userId");
		String gName = request.getParameter("gName");
		String gPrice = request.getParameter("gPrice");
		String gImage = request.getParameter("gImage");
		String gCategory = request.getParameter("gCategory");
		
		CartDTO dto = new CartDTO();
		dto.setgCode(gCode);
		dto.setgImage(gImage);
		dto.setgName("["+gCategory+"] 랜덤박스");
		dto.setgPrice(Integer.parseInt(gPrice));
		dto.setUserId(userId);
		
		CartService service = new CartService();
		String target = "CartListServlet";
		
		try {
			service.addCart(dto);
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
