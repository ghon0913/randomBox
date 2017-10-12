package com.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.OrderInfoDTO;
import com.exception.MyException;
import com.service.BoardService;

@WebServlet("/ReviewFormServlet")
public class ReviewFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCode = request.getParameter("gCode");
		String gName = request.getParameter("gName");
		String target = "review.jsp";
		
		BoardService service = new BoardService();
		String goodsName = null;
		try {
			goodsName = service.getGoodsName(gCode);
		} catch (NumberFormatException | MyException e) {
			e.printStackTrace();
			target = "error.jsp";
		}
		
		request.setAttribute("gName", gName);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("chk_reviewPage", "reviewForm");
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
