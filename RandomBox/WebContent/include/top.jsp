<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<!-- bootstrap -->
<link href="bootstrap-4.0.0-beta-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<div>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="GoodsListServlet"><img
			src="logo.jpg" width="150" height="150" align="left"></a>

		<div align="left">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>



				<form class="form-inline my-2 my-lg-0"
					action="GoodsBySearchServlet">
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search" aria-label="Search" name="searchBar" size=50>
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>

				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<c:if test="${empty sessionScope.login}">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="LoginFormServlet">로그인 <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="MemberAddFormServlet">회원가입</a></li>
						<li class="nav-item"><a class="nav-link"
							href="LoginFormServlet" id="cart">장바구니</a></li>
					</ul>
				</c:if>
				<c:if test="${!empty sessionScope.login}">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="LogoutServlet">로그아웃 </a></li>
						<c:if test="${sessionScope.login.ox=='Y'}">
							<li class="nav-item"><a class="nav-link"
								href="MyPageServlet">마이페이지</a></li>
							<%-- ${sessionScope.login.username}님 안녕하세요 --%>

							<li class="nav-item"><a class="nav-link"
								href="GoodsRegisterFormServlet">상품등록</a></li>
						</c:if>
						<c:if test="${sessionScope.login.ox=='N'}">
							<li class="nav-item"><a class="nav-link"
								href="MyPageServlet">마이페이지</a></li>
							<%-- ${sessionScope.login.username}님 안녕하세요 --%>

							<li class="nav-item"><a class="nav-link"
								href="CartListServlet">장바구니</a></li>
						</c:if>
						<c:if test="${sessionScope.login.ox=='Z'}">
							<li class="nav-item"><a class="nav-link" href="first.admin">관리자페이지</a></li>
							<%-- ${sessionScope.login.username}님 안녕하세요 --%>
						</c:if>
					</ul>
				</c:if>
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link"
						href="ReviewListServlet">|</a></li>
					<li class="nav-item"><a class="nav-link"
						href="InquiryListServlet">Q & A</a></li>
					<li class="nav-item"><a class="nav-link"
						href="ReviewListServlet">랜덤박스 후기</a></li>
				</ul>


			</div>
			<script type="text/javascript">
				$("#cart").on("click", function() {
					alert("로그인이 필요한 메뉴입니다.");
				});
			</script>
		</div>

	</nav>
</div>