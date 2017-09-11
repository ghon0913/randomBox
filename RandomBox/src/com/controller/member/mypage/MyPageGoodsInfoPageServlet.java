package com.controller.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsPageDTO;
import com.dto.MyPageBoardPageDTO;

@WebServlet("/MyPageGoodsInfoPageServlet")
public class MyPageGoodsInfoPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String perPage = request.getParameter("perpage");

			GoodsPageDTO.setPerPage(Integer.parseInt(perPage));
			
			String page = "goodsinfo.do";
			RequestDispatcher p = request.getRequestDispatcher(page);
			p.forward(request, response);
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
