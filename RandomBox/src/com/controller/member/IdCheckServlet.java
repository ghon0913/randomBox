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

@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String mesg = "사용가능";
		
		MemberService service = new MemberService();
		String idck;
		
		try {
			idck = service.idCheck(userid);
			System.out.println(idck);
/*			
			if(idck = ) {
				mesg = "아이디 중복";
			}*/
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("mesg", mesg);
		
		RequestDispatcher dis = request.getRequestDispatcher("member/idCheck.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
