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

 
 @WebServlet("/MyPageServlet") 
 public class MyPageServlet extends HttpServlet { 

 
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
 			throws ServletException, IOException { 
 
 
 		HttpSession session = request.getSession(); 
	String target = "LoginFormServlet"; 
		MemberDTO login = (MemberDTO) session.getAttribute("login"); 
 
 
 		MyPageService service = new MyPageService(); 
 		if (login != null) { 
 			target = "myPage1.jsp"; 
 			MemberDTO xxx; 
 			try { 
 				xxx = service.myPageUserInfo(login.getUserid()); 
				session.setAttribute("login", xxx); 
			} catch (MyException e) { 
 				// TODO Auto-generated catch block 
 				e.printStackTrace(); 
 			} 
 			RequestDispatcher dis = request.getRequestDispatcher(target); 
 			dis.forward(request, response); 
 		}else { 
 			response.sendRedirect(target); 
 		} 
 	 

 
 	} 

 
 	/** 
 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
 	 *      response) 
 	 */ 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
 			throws ServletException, IOException { 
		// TODO Auto-generated method stub 
 		doGet(request, response); 
 	} 
 
 
 } 
