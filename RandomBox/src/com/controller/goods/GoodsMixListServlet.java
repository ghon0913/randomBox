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
		int totalPrice = 0;

		for (int i = 0; i < 16; i++) {
			int idx = rand.nextInt(list.size());
			list16.add(list.get(idx));
			totalPrice += list16.get(i).getgPrice();
		}
		session.setAttribute("goodsList16", list16);
		
		// 최종 랜덤 상품 저장 ******
		int randomGoods_idx = rand.nextInt(list16.size());
		GoodsDTO randomGoods = list16.get(randomGoods_idx);
		
		int resultPrice = (totalPrice / 16)/10*10;
		randomGoods.setgPrice(resultPrice);
		
		session.setAttribute("randomGoods", randomGoods);
		// ******************
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
