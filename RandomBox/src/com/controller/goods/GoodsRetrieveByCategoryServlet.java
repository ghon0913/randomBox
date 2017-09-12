package com.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GoodsRetrieveServlet
 */
@WebServlet("/GoodsRetrieveByCategoryServlet")
public class GoodsRetrieveByCategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String gCategory = request.getParameter("category");
		request.setAttribute("category", gCategory);
		String listByCategory = "listBy"+gCategory;
		
		request.setAttribute("isCategory", session.getAttribute(listByCategory));
		request.setAttribute("retrieve", "retrieve");
		
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
