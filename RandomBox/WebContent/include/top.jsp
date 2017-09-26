<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="jquery-3.2.1.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#"><img src="logo.jpg" width="120" height="120"
			align="left"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="text" placeholder="Search"
				aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">로그인
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">장바구니</a>
			</li>
		</ul>

	</div>
</nav>





<hr>
<div style="height: 200">
	<div>
		<a href="home.jsp"> <img src="logo.jpg" width="200" height="200"
			align="left"></a>
	</div>
	<c:if test="${empty sessionScope.login}">
		<div align="center">
			<form action="GoodsBySearchServlet" method="GET">
				<input type="text" name="searchBar" value="" size="50"> <input
					type="submit" value="검색"> <a href="LoginFormServlet">로그인</a>&nbsp;&nbsp;
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
				<input type="text" name="searchBar" value="" size="50"> <input
					type="submit" value="검색"> <a href="LogoutServlet">로그아웃</a>&nbsp;&nbsp;
				<c:if test="${sessionScope.login.ox=='Y'}">
					<a href="MyPageServlet">마이페이지</a>&nbsp;&nbsp;
					<a href="GoodsRegisterFormServlet">상품등록</a>&nbsp;&nbsp; ${sessionScope.login.username}님 안녕하세요
   				</c:if>
				<c:if test="${sessionScope.login.ox=='N'}">
					<a href="MyPageServlet">마이페이지</a>&nbsp;&nbsp;
					<a href="CartListServlet">장바구니</a>&nbsp;&nbsp; ${sessionScope.login.username}님 안녕하세요
 				</c:if>
				<c:if test="${sessionScope.login.ox=='Z'}">
					<a href="first.admin">관리자페이지</a>&nbsp;&nbsp; 관리자님 안녕하세요.
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