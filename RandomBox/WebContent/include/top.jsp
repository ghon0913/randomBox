<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="jquery-3.2.1.js"></script>

<hr>
<div style="height: 200">
	<div>
		<a href="home.jsp"> <img src="logo.jpg" width="200" height="200"
			align="left"></a>
	</div>
	<c:if test="${empty sessionScope.login}">
		<div align="center">
			<form action="GoodsBySearchServlet" method="GET">
				<input type="text" name="searchBar" value="검색하세요" size="50">
				<input type="submit" value="검색"> <a href="LoginFormServlet">로그인</a>&nbsp;&nbsp;
				<a href="MemberAddFormServlet">회원가입</a>&nbsp;&nbsp; <a
					href="LoginFormServlet" id="cart">장바구니</a>&nbsp;&nbsp;
			</form>

			<script type="text/javascript">
				$("#cart").on("click", function() {
					alert("로그인이 필요한 메뉴입니다.");
				});
			</script>
		</div>
	</c:if>

	<c:if test="${!empty sessionScope.login}">
		<div align="center">
			<form action="GoodsBySearchServlet" method="GET">
				<input type="text" name="searchBar" value="검색하세요" size="50">
				<input type="submit" value="검색">
				<a href="LogoutServlet">로그아웃</a>&nbsp;&nbsp; <a href="MyPageServlet">마이페이지</a>&nbsp;&nbsp;
				<c:if test="${sessionScope.login.ox=='Y'}">
					<a href="GoodsRegisterFormServlet">상품등록</a>&nbsp;&nbsp; ${sessionScope.login.username}님 안녕하세요
   				</c:if>
				<c:if test="${sessionScope.login.ox=='N'}">
					<a href="CartListServlet">장바구니</a>&nbsp;&nbsp; ${sessionScope.login.username}님 안녕하세요
 				</c:if>
			</form>
		</div>
	</c:if>
</div>
<hr>
<div align="right" style="padding-right: 250px">
	<a href="InquiryListServlet">Q & A</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a
		href="ReviewListServlet">랜덤박스 후기</a>
</div>