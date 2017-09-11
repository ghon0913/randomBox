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
import com.service.GoodsService;

@WebServlet("/GoodsByCategoryServelt")
public class GoodsByCategoryServelt extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 전체(category = null)인지 아닌지 확인
		String target = "home.jsp";
		List<GoodsDTO> list = null;
		List<GoodsDTO> list16 = new ArrayList<>();
		if (session.getAttribute("goodsList") == null) {
			GoodsService service = new GoodsService();
			
			try {

				list = service.selectAllGoods();
				session.setAttribute("goodsList", list);	
				

			} catch (Exception e) {

			}
		}
		
		Random rand = new Random();
		List<GoodsDTO> tempList = list;
		for (int i = 0; i < 16; i++) {
			int idx = rand.nextInt(tempList.size());
			list16.add(tempList.get(idx));
			tempList.remove(idx);			
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
