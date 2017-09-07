<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="jquery-3.2.1.js"></script>

<script type="text/javascript">




		$("#userinfo").on("click", function(event) {
			console.log("${login}");
			if("${login}"==null){
				location.href="myPageServlet";
			}else{
			$("#firstpage").empty();
			$.ajax({
				type : "get",
				url : "userinfo.do",
				data : {
					"userid" : "${login.userid}"
				},
				dataType : "text",
				success : function(responseData, status, xhr) {
					$("#here").html(responseData);
				},
				error : function(xhr, status, e) {
					console.log(xhr, status, e);
				}
			});
			}

		});

		$("#orderinfo").on("click", function(event) {
			$("#firstpage").empty();
			$.ajax({
				type : "get",
				url : "orderinfo.do",
				data : {
					"login" : "${login.userid}"
				},
				dataType : "text",
				success : function(responseData, status, xhr) {
					$("#here").html(responseData);
				},
				error : function(xhr, status, e) {
					console.log(xhr, status, e);
				}
			});

		});

		$("#writelist").on("click", function(event) {
			$("#firstpage").empty();
			$.ajax({
				type : "get",
				url : "writelist.do",
				data : {
					"userid" : "${login.userid}"
				},
				dataType : "text",
				success : function(responseData, status, xhr) {
					$("#here").html(responseData);
				},
				error : function(xhr, status, e) {
					console.log(xhr, status, e);
				}
			});

		});

		$("#sellinfo").on("click", function(event) {
			$("#firstpage").empty();
			$.ajax({
				type : "get",
				url : "sellinfo.do",
				data : {
					"userid" : "${login.userid}"
				},
				dataType : "text",
				success : function(responseData, status, xhr) {
					$("#here").html(responseData);
				},
				error : function(xhr, status, e) {
					console.log(xhr, status, e);
				}
			});
		});

		$("#writelist").on("click", function(event) {
			$("#firstpage").empty();
			$.ajax({
				type : "get",
				url : "writelist.do",
				data : {
					"userid" : "${login.userid}"
				},
				dataType : "text",
				success : function(responseData, status, xhr) {
					$("#here").html(responseData);
				},
				error : function(xhr, status, e) {
					console.log(xhr, status, e);
				}
			});
		});

		$("#goodsinfo").on("click", function(event) {
			$("#firstpage").empty();
			$.ajax({
				type : "get",
				url : "goodsinfo.do",
				data : {
					"userid" : "${login.userid}"
				},
				dataType : "text",
				success : function(responseData, status, xhr) {
					$("#here").html(responseData);
				},
				error : function(xhr, status, e) {
					console.log(xhr, status, e);
				}
			});

		});
	});
	
	

</script>


${login.username} 님 안녕하세요.
<br />
<br />

<img src="images/mypage/userinfo.png" id="userinfo" width="100">

	<c:if test="${login.ox=='N'}">
	
		<img src="images/mypage/orderinfo.png" id="orderinfo" width="100">
		<img src="images/mypage/writelist.png" id="writelist" width="100">
		<br />
	</c:if>


	<c:if test="${login.ox=='Y'}">
		<img src="images/mypage/sellinfo.png" id="sellinfo" width="100">
		<img src="images/mypage/goodsinfo.png" id="goodsinfo" width="100">
	</c:if>
<hr />

<div id="firstpage">
	<img align="center" src="logo.jpg">
</div>

<div id="here"></div>


