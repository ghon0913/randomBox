package com.controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.dto.BoardPageDTO;
import com.exception.MyException;
import com.service.BoardService;


@WebServlet("/InquiryListServlet")
public class InquiryListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String curPage = request.getParameter("curPage");
        if(curPage == null) {
               curPage = "1";
        }
        
        String searchCategory = request.getParameter("searchCategory");
        String searchName = request.getParameter("searchName");
        String searchWord = request.getParameter("searchWord");
        
		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCategory", searchCategory);
		searchMap.put("searchName", searchName);
		searchMap.put("searchWord", searchWord);
		
		BoardService service = new BoardService();
		BoardPageDTO dto = new BoardPageDTO();
		
		String target = "inquiry.jsp";
		
		try {
			dto = service.inquiryList(Integer.parseInt(curPage), searchMap);
			request.setAttribute("boardList", dto);
			request.setAttribute("chk_inquiryPage", "inquiryList");
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
