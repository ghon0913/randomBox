package com.controller.member;

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

@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String ox = request.getParameter("ox");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String email = email1 +"@"+ email2;
		String phone = phone1 + phone2 + phone3;
		
		MemberDTO dto = new MemberDTO();
		dto.setOx(ox);
		dto.setUserid(userid);
		dto.setUsername(username);
		dto.setPasswd(passwd);
		dto.setEmail(email);
		dto.setGender(gender);
		dto.setBirthday(birthday);
		dto.setPost1(post1);
		dto.setPost2(post2);
		dto.setPhone(phone);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);

		MemberService service = new MemberService();
		
		String target = "home.jsp";
		
		try {
			service.insertMember(dto);
			request.setAttribute("result", "회원가입이 완료되었습니다.");
		} catch (MyException e) {
			e.printStackTrace();
			target = "error.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
