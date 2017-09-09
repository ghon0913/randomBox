<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript" src="jquery-3.2.1.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$("#userinfo").on("click", function() {
			//console.log(">>>>>>>>>>",'${login}');
			location.href = "userinfo.do";
		})
		$("#orderinfo").on("click", function() {
			//console.log(">>>>>>>>>>",'${login}');
			location.href = "orderinfo.do";
		})
		$("#myboard").on("click", function() {
			//console.log(">>>>>>>>>>",'${login}');
			location.href = "searchmyboard.do";
		})
		$("#sellinfo").on("click", function() {
			//console.log(">>>>>>>>>>",'${login}');
			location.href = "sellinfo.do";
		})
		$("#goodsinfo").on("click", function() {
			//console.log(">>>>>>>>>>",'${login}');
			location.href = "goodsinfo.do";
		})
		
		
		
	});
	
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<jsp:include page="include/top.jsp" flush="true" />


	${login.username} 님 안녕하세요.
	<br />
	<br />
	<img src="images/mypage/userinfo.png" id="userinfo" width="100">
	<c:if test="${login.ox=='N'}">
		<img src="images/mypage/orderinfo.png" id="orderinfo" width="100">
		<img src="images/mypage/writelist.png" id="myboard" width="100">
		<br />
	</c:if>


	<c:if test="${login.ox=='Y'}">
		<img src="images/mypage/sellinfo.png" id="sellinfo" width="100">
		<img src="images/mypage/goodsinfo.png" id="goodsinfo" width="100">
		<br/>
	</c:if>

	<hr />
	
	<jsp:include page="${page}"/>
	
	<%
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expries", 0);
		response.setHeader("Cache-Control", "no-cache");
	%>
</body>
</html>
