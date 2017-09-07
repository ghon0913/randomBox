package com.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.oreilly.servlet.MultipartRequest;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsRegisterServlet
 */
@WebServlet("/GoodsRegisterServlet")
public class GoodsRegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getRealPath("/upload");
		int sizeLimit = 1024 * 1024 * 15;
		response.setContentType("text/html; charset=UTF-8");
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit);
		HttpSession session = request.getSession();
		String gCode = multi.getParameter("gCode");
		String gCategory = multi.getParameter("gCategory");
		String gName = multi.getParameter("gName");
		String gPrice = multi.getParameter("gPrice");
		String gImage = multi.getFilesystemName("gImage");
		String gContentImage = multi.getFilesystemName("gContentImage");
		String gAmount = multi.getParameter("gAmount");
		MemberDTO mdto =(MemberDTO)session.getAttribute("login");
		String sellerId = mdto.getUserid(); 
		//이미지 파일 리셋
		gImage = "Koala.jpg";
		gContentImage = "Koala.jpg";
		System.out.println(gImage);
		System.out.println(gContentImage);

		GoodsDTO gdto = new GoodsDTO(Integer.parseInt(gPrice),gCode, gCategory, gName, gImage, gContentImage,
				Integer.parseInt(gAmount), sellerId);

		GoodsService service = new GoodsService();

		try {
			service.insertGoods(gdto);
			PrintWriter out = response.getWriter();
			out.print("업로드는 구현만 해놓았습니다. 실제 디비에는 Koala.jpg가 들어있으니 그냥 사용하시면 됩니다. 그리고 이다음이동 페이지는 마이페이지에 판매자 상품등록 내역 쯤 될것 같습니다");
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
