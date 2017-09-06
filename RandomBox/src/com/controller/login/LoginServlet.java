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
import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String target = "";
		// if (session.getAttribute("login") != null) {
		// session.removeAttribute("login");
		// }
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		boolean isChecked = false;

		if (request.getParameter("autoLogin") != null) {
			isChecked = true;
		}
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);

		MemberService service = new MemberService();
		MemberDTO dto = null;
		try {

			dto = service.searchMember(map);

		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if (dto == null) {
			target = "error.jsp";
			request.setAttribute("error", "아이디/비번 확인하세요");
		} else {

			target = "home.jsp";
			session.setAttribute("login", dto);
			request.setAttribute("login", "로그인 성공");

			if (isChecked) {
				System.out.println(1111);
				HashMap<String, String> map2 = new HashMap<>();
				map2.put("userid", userid);
				map2.put("cookieId", session.getId());
				try {
					System.out.println(2222);
					service.updateCookieId(map2);
					System.out.println(3333);
					Cookie cookie = new Cookie("cookieId", session.getId());
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 24 * 7);

					response.addCookie(cookie);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Cookie cookies[] = request.getCookies();

				for (int i = 0; i < cookies.length; i++) {
					cookies[i].setMaxAge(0);
					cookies[i].setPath("/");
					response.addCookie(cookies[i]);
				}
			}
		}

		System.out.println(4444);
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
