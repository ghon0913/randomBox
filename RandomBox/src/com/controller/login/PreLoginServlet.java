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
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
	
		MemberDTO dto = null;
		String sessionId = null;
		MemberService service = new MemberService();
		String target = "LoginServlet";
		
		//처음 진입
		if (obj == null) {
			Cookie[] Cookies = request.getCookies();
			for (Cookie ck : Cookies) {
				
				if (ck.getName().equals("loginCookie1")) {
					
					sessionId = ck.getValue();
					try {
						dto = service.checkSessionId(sessionId);
						if (dto != null) {
							session.setAttribute("login", dto);	
						}
					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
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
