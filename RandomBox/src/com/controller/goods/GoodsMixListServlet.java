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

@WebServlet("/GoodsMixListServlet")
public class GoodsMixListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String target="home.jsp";
		List<GoodsDTO> list = (List<GoodsDTO>) session.getAttribute("goodsList");
		Random rand = new Random();
		
		List<GoodsDTO> list16 = new ArrayList<>();

		for (int i = 0; i < 16; i++) {
			int idx = rand.nextInt(list.size());
			list16.add(list.get(idx));
		}
		session.setAttribute("goodsList16", list16);
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
