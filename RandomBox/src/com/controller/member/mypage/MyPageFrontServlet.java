package com.controller.member.mypage;

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

import com.dto.BoardDTO;
import com.dto.GoodsDTO;
import com.dto.GoodsPageDTO;
import com.dto.MemberDTO;
import com.dto.MyPageBoardPageDTO;
import com.dto.OrderInfoDTO;
import com.dto.OrderInfoPageDTO;
import com.dto.SalesStatusDTO;
import com.exception.MyException;
import com.service.MyPageService;
import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("*.do")
public class MyPageFrontServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션받기
		HttpSession session = request.getSession();
		// target초기화
		String target = "myPage1.jsp";
		// login세션확인
		MemberDTO login = (MemberDTO) session.getAttribute("login");

		// login 세션 없을경우 loginform으로 redirect
		if (login == null) {
			response.sendRedirect("LoginFormServlet");
		} else {

			// .do로 받는거 구분하려고 substring하기
			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = requestURI.substring(contextPath.length());

			// 서비스선언
			MyPageService service = new MyPageService();

			try {
				MemberDTO xxx = service.myPageUserInfo(login.getUserid());
				request.setAttribute("mdto", xxx);// login세션의 memberdto 를 mdto에 저장
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 어떤 .do로 왔는지 구분
			if (command.equals("/userinfo.do")) {
				request.setAttribute("page", "myPage/myPageUserInfo.jsp");

			} else if (command.equals("/userinfoupdate.do")) {
				String passwd = request.getParameter("passwd");
				String phoneNumber = request.getParameter("phoneNumber");
				String post1 = request.getParameter("post1");
				String post2 = request.getParameter("post2");
				String addr1 = request.getParameter("addr1");
				String addr2 = request.getParameter("addr2");

				login.setPasswd(passwd);
				login.setAddr1(addr1);
				login.setAddr2(addr2);
				login.setPost1(post1);
				login.setPost2(post2);
				login.setPhone(phoneNumber);
				try {
					service.updateuserinfo(login);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("page", "myPage/myPageUserInfo.jsp");

			}
			/*
			 * else if (command.equals("/myboard.do")) {
			 * 
			 * List<BoardDTO> bdto; try { bdto = service.myPageBoardList(login.getUserid());
			 * request.setAttribute("page", "myPage/myPageBoardList.jsp");
			 * request.setAttribute("bdto", bdto); } catch (MyException e) {
			 * e.printStackTrace(); } }
			 */ else if (command.equals("/searchmyboard.do")) {

				String curPage = request.getParameter("curPage");
				if (curPage == null) {
					curPage = "1";
				}
				String searchName = request.getParameter("searchName");
				String searchValue = request.getParameter("searchValue");

				HashMap<String, String> map = new HashMap();
				map.put("searchName", searchName);
				map.put("searchValue", searchValue);
				map.put("userId", login.getUserid());

				try {
					MyPageBoardPageDTO pagedto = service.boardpage(map, Integer.parseInt(curPage));
					request.setAttribute("pagedto", pagedto);
					request.setAttribute("page", "myPage/myPageBoardList.jsp");

				} catch (NumberFormatException | MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * 기존 페이지 전체출력 페이징 ㄴㄴ
				 * 
				 * List<BoardDTO> bdto; try { bdto = service.myPageBoardList(login.getUserid());
				 * request.setAttribute("page", "myPage/myPageBoardList.jsp");
				 * request.setAttribute("bdto", bdto); } catch (MyException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
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

			} else if (command.equals("/boardupdate.do")) {

				String dto = request.getParameter("retrievedto");
				String num = request.getParameter("num");
				String content = request.getParameter("content");

				HashMap<String, Object> map = new HashMap<>();
				map.put("num", Integer.parseInt(num));
				map.put("content", content);

				try {
					service.myPageboardupdate(map);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/orderinfo.do")) {

				request.setAttribute("page", "myPage/myPageOrderInfo.jsp");

				try {
					List<OrderInfoDTO> orderdto = service.myPageOrderInfo(login.getUserid());
					request.setAttribute("orderdto", orderdto);

				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/orderinfopage.do")) {

				String curPage = request.getParameter("curPage");
				if (curPage == null) {
					curPage = "1";
				}

				String startdate = request.getParameter("startdate");
				String finaldate = request.getParameter("finaldate");

				
				HashMap<String, String> map = new HashMap();
				map.put("startdate", startdate);
				System.out.println(">>>>>>>>>>>>>>>>>>" + startdate);
				map.put("finaldate", finaldate);
				map.put("userId", login.getUserid());

				try {
					OrderInfoPageDTO pagedto = service.myPageOrderInfoPage(map, Integer.parseInt(curPage));
					request.setAttribute("pagedto", pagedto);
					request.setAttribute("page", "myPage/myPageOrderInfo.jsp");

				} catch (NumberFormatException | MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/orderinforetrieve.do")) {

				request.setAttribute("page", "myPage/myPageOrderInfo.jsp");
				target = "myPage/myPageOrderInfoRetrieve.jsp";
				String num = request.getParameter("num");

				try {
					OrderInfoDTO orderretrieve = service.orderinforetrieve(Integer.parseInt(num));
					request.setAttribute("orderretrieve", orderretrieve);
					System.out.println(orderretrieve);
				} catch (NumberFormatException | MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/goodsinfo.do")) {
				String curPage = request.getParameter("curPage");
				if (curPage == null) {
					curPage = "1";
				}

				String searchName = request.getParameter("searchName");
				String searchValue = request.getParameter("searchValue");

				HashMap<String, String> map = new HashMap();
				map.put("searchName", searchName);
				map.put("searchValue", searchValue);
				map.put("userId", login.getUserid());

				try {
					GoodsPageDTO pagedto = service.goodsinfo(map, Integer.parseInt(curPage));
					request.setAttribute("pagedto", pagedto);
					request.setAttribute("page", "myPage/myPageGoodsInfo.jsp");

				} catch (NumberFormatException | MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/goodsinforetrieve.do")) {

				String gCode = request.getParameter("gCode");

				try {
					GoodsDTO dto = service.goodsretrieve(gCode);
					request.setAttribute("dto", dto);
					target = "myPage/myPageGoodsInforetrieve.jsp";

				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/goodsdelete.do")) {
				String gCode = request.getParameter("gCode");
				try {
					service.goodsdelete(gCode);
					target = "goodsinfo.do";
					request.setAttribute("goodsdelete", "삭제되었습니다.");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/goodsupdate.do")) {
				String gCode = request.getParameter("gCode");
				String gCategory = request.getParameter("gCategory");
				String gName = request.getParameter("gName");
				String gPrice = request.getParameter("gPrice");
				/*
				 * String gImage = request.getParameter("gImage"); String gContentImage=
				 * request.getParameter("gContentImage");
				 */
				String gAmount = request.getParameter("gAmount");
				System.out.println(gAmount);

				HashMap<String, Object> map = new HashMap<>();
				map.put("gCode", gCode);
				map.put("gCategory", gCategory);
				map.put("gName", gName);
				map.put("gPrice", Integer.parseInt(gPrice));
				map.put("gAmount", Integer.parseInt(gAmount));

				try {
					service.goodsupdate(map);
					target = "goodsinfo.do";
					request.setAttribute("goodsupdate", "수정되었습니다.");
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (command.equals("/sellinfo.do")) {

				request.setAttribute("page", "myPage/myPageSellInfo.jsp");
				
				try {
					List<SalesStatusDTO> sdto = service.sellinfo(login.getUserid());
					request.setAttribute("sdto", sdto);
					for (SalesStatusDTO s : sdto) {
						System.out.println(s);
					}
					
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
