package com.controller.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThrowMyPagekindServlet")
public class ThrowMyPagekindServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String kind = request.getParameter("kind");
		System.out.println(kind);
		
		
		String target = "";
		
		if ("userinfo".equals(kind)) {
			System.out.println("ㅎㅎㅎㅎ");
			target = "member/myPageUserInfo.jsp";
		} else if ("orderinfo".equals(kind)) {
			target = "member/myPageOrderInfo.jsp";
		} else if ("writelist".equals(kind)) {
			target = "member/myPageWriteList.jsp";
		}
		request.setAttribute("kind", target);
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
