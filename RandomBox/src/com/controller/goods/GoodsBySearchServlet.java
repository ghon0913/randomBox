package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.exception.MyException;
import com.service.GoodsService;

@WebServlet("/GoodsBySearchServlet")
public class GoodsBySearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String searchWord = request.getParameter("searchBar");
		System.out.println(searchWord);
		GoodsService service = new GoodsService();
		String target="goods/goodsBySearch.jsp";
		List<GoodsDTO> list = null;
		try {
			list = service.selectBySearch(searchWord);
			request.setAttribute("search", list);
			System.out.println("11");
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
