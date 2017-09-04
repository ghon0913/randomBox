package com.controller.login;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String target = "";
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String autoLogin = request.getParameter("autoLogin");

		System.out.println(autoLogin);
		System.out.println(userid);
		System.out.println(passwd);
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);

		MemberService service = new MemberService();
		MemberDTO dto = service.searchMember(map);
		if (dto != null) {
			session.setAttribute("login", dto);
			if(autoLogin.equals("on")) {
				dto.setCookie("y");
			}else {
				dto.setCookie("n");
			}
			target = "home.jsp";

			if (dto.getCookie().equals("y")) {
				Cookie cookie = new Cookie("loginCookie", session.getId());
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 7);

				response.addCookie(cookie);
			}
		} else {
			target = "home.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
