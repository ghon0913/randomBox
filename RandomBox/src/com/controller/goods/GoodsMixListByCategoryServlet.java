package com.controller.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;

@WebServlet("/GoodsMixListByCategoryServlet")
public class GoodsMixListByCategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String target="home.jsp";
		String gCategory = request.getParameter("category");
		System.out.println(gCategory);
		List<GoodsDTO> list = (List<GoodsDTO>) session.getAttribute(gCategory);
		System.out.println(list);
		Random rand = new Random();
		
		List<GoodsDTO> listByCategory16 = new ArrayList<>();

		for (int i = 0; i < 16; i++) {
			int idx = rand.nextInt(list.size());
			listByCategory16.add(list.get(idx));
		}
		String listByCategory = "listBy"+gCategory;
		System.out.println("전"+session.getAttribute(listByCategory));
		session.setAttribute(listByCategory, listByCategory16);
		System.out.println("후"+session.getAttribute(listByCategory));
		System.out.println(listByCategory);
		
		request.setAttribute("isCategory", session.getAttribute(listByCategory));
		request.setAttribute("gCategory", gCategory);
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
