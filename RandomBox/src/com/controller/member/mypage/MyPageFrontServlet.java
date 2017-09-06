package com.controller.member.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MyPageService;

@WebServlet("*.do")
public class MyPageFrontServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		//session받자
		MemberDTO logindto = (MemberDTO)session.getAttribute("login");
		//session에 저장된 login하고 mypage를 눌렀을때 넘어오는 login
		String target = null;
		MyPageService service = new MyPageService();
		String user ;
		
		if (logindto != null) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
			target = "myPage1.jsp";
			System.out.println("front servlet"+logindto);
			try {
				//user = (service.
				//userid로주고 userdto로받음
			
				//session.setAttribute("login", user);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			target="LoginFormServlet";
		}


		MemberDTO loginuser = (MemberDTO) session.getAttribute("login");


		if (loginuser != null) {

			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = requestURI.substring(contextPath.length());

			MyPageService mservice = new MyPageService();

			if (command.equals("/userinfo.do")) {
				try {
					MemberDTO userdto = mservice.myPageUserInfo(userid);
					request.setAttribute("dto", dto);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				target = "myPage/myPageUserInfo.jsp";
			}

			if (command.equals("/orderinfo.do")) {
				target = "myPage/myPageOrderInfo.jsp";
			}

			if (command.equals("/writelist.do")) {
				target = "myPage/myPageWriteList.jsp";
			}

			if (command.equals("/sellinfo.do")) {
				target = "myPage/myPageSellInfo.jsp";
			}

			if (command.equals("/goodsinfo.do")) {
				target = "myPage/myPageGoodsInfo.jsp";
			}

			if (command.equals("/userinfoupdate.do")) {
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

		} else {
			target = "MyPageServlet";
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
