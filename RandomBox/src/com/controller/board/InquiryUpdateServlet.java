package com.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.exception.MyException;
import com.service.BoardService;

@WebServlet("/InquiryUpdateServlet")
public class InquiryUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String num = request.getParameter("num");
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setCategory(category);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardService service = new BoardService();
		String target = "InquiryListServlet";
		
		try {
			service.inquiryUpdate(dto);
		} catch (MyException e) {
			e.printStackTrace();
			target = "error.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
