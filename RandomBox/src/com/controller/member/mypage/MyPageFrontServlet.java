package com.controller.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MyPageService;

@WebServlet("*.do")
public class MyPageFrontServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		System.out.println(userid);
		
		String requestURI =request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		String target = "";
		MyPageService mservice = new MyPageService();
		
		if(command.equals("/userinfo.do")) {

			try {
				MemberDTO dto = mservice.myPageUserInfo(userid);
				request.setAttribute("dto", dto);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
			target="myPage/myPageUserInfo.jsp";
		}
		if(command.equals("/orderinfo.do")) {
			target="myPage/myPageOrderInfo.jsp";
		}
		if(command.equals("/writelist.do")) {
			target = "myPage/myPageWriteList.jsp";
		}
		if(command.equals("/sellinfo.do")) {
			target = "myPage/myPageSellInfo.jsp";
			
		}
		if(command.equals("/goodsinfo.do")) {
			target = "myPage/myPageGoodsInfo.jsp";
			
		}
		if(command.equals("/userinfoupdate.do")) {
			System.out.println("userinfoupdate");
			String passwd = request.getParameter("passwd");
			MemberDTO dto = new MemberDTO();
			dto.setPasswd(passwd);
			
			try {
				mservice.updateuserinfo(dto);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
