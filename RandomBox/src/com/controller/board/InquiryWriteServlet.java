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
		
		String s_question = request.getParameter("select_question");
		String userId = request.getParameter("userid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("select_category");
		String open = request.getParameter("open");
		String gCode = request.getParameter("gCode");

		if(s_question.equals("q_admin")) {
			category = "관리자질문";
			gCode = "admin";
		}
		
		BoardDTO dto = new BoardDTO();
		dto.setCategory(category);
		dto.setContent(content);
		dto.setTitle(title);
		dto.setUserId(userId);
		dto.setOpen(open);
		dto.setgCode(gCode);
		
		System.out.println("%%%%%%%"+dto.getgCode());
		
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
