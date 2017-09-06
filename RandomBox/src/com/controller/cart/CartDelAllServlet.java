package com.controller.cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.CartService;

@WebServlet("/CartDelAllServlet")
public class CartDelAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] checks = request.getParameterValues("check");
		for (String string : checks) {
			System.out.println(string+"@@@");
		}
		
		CartService service = new CartService();
		String target = "CartListServlet";
		
		try {
			service.delAllCart(Arrays.asList(checks));
			
		} catch (MyException e) {
			e.printStackTrace();
			target = "error,jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
