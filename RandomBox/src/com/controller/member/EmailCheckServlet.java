package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/EmailCheckServlet")
public class EmailCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String mesg = "";
		
		MemberService service = new MemberService();
		boolean ck;
		
		try {
			ck = service.emailCheck(email);

			if(ck) {
				mesg = "이메일 중복";
			}else {
				mesg = "사용가능";
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("mesg", mesg);
		
		RequestDispatcher dis = request.getRequestDispatcher("member/emailCheck.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
