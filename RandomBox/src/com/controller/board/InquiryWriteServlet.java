package com.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.exception.MyException;
import com.service.BoardService;

@WebServlet("/InquiryWriteServlet")
public class InquiryWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		String open = request.getParameter("open");
		System.out.println(open+"####");
		
		BoardDTO dto = new BoardDTO();
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setUserId(userId);
		dto.setOpen(open);
		
		BoardService service = new BoardService();
		String target = "InquiryListServlet";
		
		try {
			service.inquiryWrite(dto);
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(target);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
