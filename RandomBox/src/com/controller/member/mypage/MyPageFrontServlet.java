package com.controller.member.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.BoardDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MyPageService;

@WebServlet("*.do")
public class MyPageFrontServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.세션받기
		HttpSession session = request.getSession();
		// 2.target초기화
		String target = "myPage1.jsp";
		// 3.login세션확인
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		System.out.println(login);

		if (login == null) {
			response.sendRedirect("LoginFormServlet");
		} else {

			// .do로 받는거 구분하려고 substring하기
			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = requestURI.substring(contextPath.length());
			// 서비스초기화
			MyPageService service = new MyPageService();
			try {
				MemberDTO xxx = service.myPageUserInfo(login.getUserid());
				request.setAttribute("mdto", xxx);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 어떤 .do로 왔는지 구분
			if (command.equals("/userinfo.do")) {
				request.setAttribute("page", "myPage/myPageUserInfo.jsp");

			} else if (command.equals("/orderinfo.do")) {

				request.setAttribute("page", "myPage/myPageorderinfo.jsp");

			} else if (command.equals("/myboard.do")) {

				List<BoardDTO> bdto;
				try {
					bdto = service.myPageBoardList(login.getUserid());
					request.setAttribute("page", "myPage/myPageBoardList.jsp");
					request.setAttribute("bdto", bdto);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/BoardRetrieve.do")) {

				BoardDTO bndto;
				List<BoardDTO> bdto;
				try {
					String bnum = request.getParameter("bnum");
					bndto = service.myPageBoardRetrieve(Integer.parseInt(bnum));
					bdto = service.myPageBoardList(login.getUserid());
					
					request.setAttribute("page", "myPage/myPageBoardRetrieve.jsp");
					request.setAttribute("bndto", bndto);
					request.setAttribute("bdto", bdto);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/sellinfo.do")) {

				request.setAttribute("page", "myPage/myPageSellInfo.jsp");

			} else if (command.equals("/goodsinfo.do")) {

				request.setAttribute("page", "myPage/myPageGoodsInfo.jsp");

			} else if (command.equals("/userinfoupdate.do")) {

				String passwd = request.getParameter("passwd");
				MemberDTO dto = new MemberDTO();
				dto.setPasswd(passwd);

				try {
					service.updateuserinfo(dto);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			RequestDispatcher dis = request.getRequestDispatcher(target);
			dis.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
