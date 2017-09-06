package com.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/FindPasswdServlet")
public class FindPasswdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		MemberDTO dto = null;
	
		String target="sendMail.jsp";
		MemberService service  = new MemberService();
		try {
			
			dto = service.findPasswd(userid);
			
			String passwd = dto.getPasswd();
			String email = dto.getEmail();
			
			System.out.println(email);
			System.out.println(passwd);
			
			request.setAttribute("passwd", passwd);
			request.setAttribute("email", email);

		} catch (MyException e) {
			target = "error.jsp";
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
