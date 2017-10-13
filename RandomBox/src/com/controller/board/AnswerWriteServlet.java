package com.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BoardDAO;
import com.dto.AnswerDTO;
import com.dto.BoardDTO;
import com.exception.MyException;
import com.service.BoardService;

@WebServlet("/AnswerWriteServlet")
public class AnswerWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String boardNum = request.getParameter("boardNum");
		String userId = request.getParameter("userId");
		String sellerId = request.getParameter("sellerId");
		String answer = request.getParameter("answer");
		
		AnswerDTO dto = new AnswerDTO();
		dto.setUserId(userId);
		dto.setAnswer(answer);
		dto.setBoardNum(Integer.parseInt(boardNum));
		dto.setSellerId(sellerId);
		
		BoardService service = new BoardService();
		String target = "InquiryListServlet";
		
		try {
			service.answerWrite(dto, Integer.parseInt(boardNum));
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
