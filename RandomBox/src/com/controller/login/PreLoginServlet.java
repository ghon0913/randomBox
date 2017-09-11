package com.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/PreLoginServlet")
public class PreLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cookieId = "";
		String target = "GoodsListServlet";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookieId")) {
					cookieId = cookies[i].getValue();
					
				}
			}
			System.out.println(cookieId);
			if (cookieId.equals("")) {
			} else {
				MemberService service = new MemberService();
				MemberDTO dto = null;
				try {
					dto = service.checkCookieId(cookieId);
					HttpSession session = request.getSession();

					session.setAttribute("login", dto);		
				} catch (MyException e) {
					e.printStackTrace();
				}
			}
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
