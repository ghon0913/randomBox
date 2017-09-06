package com.controller.login;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.MemberService;

/**
 * Servlet implementation class FindUserId
 */
@WebServlet("/FindUserId")
public class FindUserId extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		
		HashMap<String,String> map = new HashMap<>();
		map.put("username", username);
		map.put("phone", phone);
		
		String target="findUserIdForm.jsp";
		MemberService service  = new MemberService();
		try {
			
			String userid = service.findUserId(map);
			request.setAttribute("userid", userid);
			System.out.println(userid);
		} catch (MyException e) {
			target = "error.jsp";
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
