package com.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.AdminSalesStatusDTO;
import com.dto.AdminUserInfoPageDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.AdminService;

@WebServlet("*.admin")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String target = "admin.jsp";
		AdminService service = new AdminService();

		MemberDTO login = (MemberDTO) session.getAttribute("login");

		if (login == null) {
			response.sendRedirect("LoginFormServlet");
		} else {
			String requestURI = request.getRequestURI();// randombox/XXX.admin
			String contextPath = request.getContextPath();// randombox
			String command = requestURI.substring(contextPath.length());// XXX.admin

			if (command.equals("/first.admin")) {

				RequestDispatcher dis = request.getRequestDispatcher(target);
				dis.forward(request, response);

			} else {
				if (command.equals("/salesStatus.admin")) {
					request.setAttribute("page", "management/salesStatus.jsp");
					
					try {
						List<AdminSalesStatusDTO> list = service.AdminSalesStatus();
						request.setAttribute("slist", list);
					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					RequestDispatcher dis = request.getRequestDispatcher(target);
					dis.forward(request, response);

				} else if (command.equals("/userInfo.admin")) {
					request.setAttribute("page", "management/userInfo.jsp");

					try {

						List<MemberDTO> list = service.userInfo();
						request.setAttribute("member", list);
					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					RequestDispatcher dis = request.getRequestDispatcher(target);
					dis.forward(request, response);

				} else if (command.equals("/userInfoPage.admin")) {

					String curPage = request.getParameter("curPage");
					if (curPage == null) {
						curPage = "1";
					}

					String searchName = request.getParameter("searchName");
					String searchValue = request.getParameter("searchValue");

					HashMap<String, String> map = new HashMap<>();
					map.put("searchName", searchName);
					map.put("searchValue", searchValue);
					map.put("orderStandard", AdminUserInfoPageDTO.getOrderStandard());
					System.out.println(map.get("orderStandard"));

					try {
						AdminUserInfoPageDTO dto = service.userInfoPage(map, Integer.parseInt(curPage));
						request.setAttribute("pagedto", dto);
						request.setAttribute("page", "management/userInfo.jsp");

						System.out.println("servelet++++++++++" + dto);
					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					RequestDispatcher dis = request.getRequestDispatcher(target);
					dis.forward(request, response);

				} else if (command.equals("/userInfoPerpage.admin")) {

					String perCount = request.getParameter("perCount");

					AdminUserInfoPageDTO.setPerCount(Integer.parseInt(perCount));

					String setpercount = "userInfoPage.admin";

					RequestDispatcher dis = request.getRequestDispatcher(setpercount);
					dis.forward(request, response);

				} else if (command.equals("/userInfoOrderStandard.admin")) {
					String orderStandard = request.getParameter("orderStandard");
					System.out.println(orderStandard);
					AdminUserInfoPageDTO.setOrderStandard(orderStandard);
					String setpercount = "userInfoPage.admin";

					RequestDispatcher dis = request.getRequestDispatcher(setpercount);
					dis.forward(request, response);
				} else if (command.equals("/goodsInfo.admin")) {
					request.setAttribute("page", "management/goodsInfo.jsp");

					RequestDispatcher dis = request.getRequestDispatcher(target);
					dis.forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
