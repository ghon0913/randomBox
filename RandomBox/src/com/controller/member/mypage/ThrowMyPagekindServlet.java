package com.controller.member.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/ThrowMyPagekindServlet")
public class ThrowMyPagekindServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String kind = request.getParameter("kind");
		
		String target = "error.jsp";
		
		if ("userinfo".equals(kind)) {
			target = "myPageUserInfo.jsp";
		} else if ("orderinfo".equals(kind)) {
			target = "myPageOrderInfo.jsp";
		} else if ("writelist".equals(kind)) {
			target = "myPageWriteList.jsp";
		}
		
		response.sendRedirect(target);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
