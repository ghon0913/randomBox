package com.controller.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class MyPageFrontServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURI =request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		String target = "";
		
		if(command.equals("/userinfo.do")) {
			target="myPage/myPageUserInfo.jsp";
		}
		if(command.equals("/orderinfo.do")) {
			target="myPage/myPageOrderInfo.jsp";
		}
		if(command.equals("/writelist.do")) {
			target = "myPage/myPageWriteList.jsp";
		}
		if(command.equals("")) {
			
		}
		if(command.equals("")) {
			
		}
		if(command.equals("")) {
			
		}
		


		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
