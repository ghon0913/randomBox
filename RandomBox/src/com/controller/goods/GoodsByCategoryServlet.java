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
import com.exception.MyException;
import com.service.GoodsService;

@WebServlet("/GoodsByCategoryServlet")
public class GoodsByCategoryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String gCategory = request.getParameter("category");
		request.setAttribute("gCategory", gCategory);
		String listByCategory = "listBy"+gCategory;
		String target = "home.jsp";
		List<GoodsDTO> tempList = null;
		List<GoodsDTO> listByCategory16 = new ArrayList<>();
		Random rand = new Random();
		if (session.getAttribute(gCategory) == null) {

			GoodsService service = new GoodsService();
			List<GoodsDTO> list = null;
			try {

				list = service.selectByCategory(gCategory);
				session.setAttribute(gCategory, list);
				tempList = list;
				for (int i = 0; i < 16; i++) {
					int idx = rand.nextInt(tempList.size());
					listByCategory16.add(tempList.get(idx));
				}
				session.setAttribute(listByCategory, listByCategory16);

			} catch (MyException e) {

				e.printStackTrace();
			}
		} 

		request.setAttribute("isCategory", session.getAttribute(listByCategory));
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
