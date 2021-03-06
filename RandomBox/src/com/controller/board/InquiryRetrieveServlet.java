package com.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AnswerDTO;
import com.dto.BoardDTO;
import com.exception.MyException;
import com.service.BoardService;

@WebServlet("/InquiryRetrieveServlet")
public class InquiryRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		
		BoardService service = new BoardService();
		String target = "inquiry.jsp";
		BoardDTO dto = null;
		AnswerDTO a_dto = null;
		
		try {
			dto = service.inquiryRetrieve(Integer.parseInt(num));
			request.setAttribute("retrieveDTO", dto);
			request.setAttribute("chk_inquiryPage", "inquiryRetrieve");
			
			if(dto.getState().equals("답변완료")) {
				a_dto = service.selectAnswer(Integer.parseInt(num));
				request.setAttribute("answerDTO", a_dto);
			}
			
		} catch (NumberFormatException | MyException e) {
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