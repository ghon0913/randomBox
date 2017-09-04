<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form id="myPage">

	<table border="1" style="color: yellow">
		<!-- 상단 회원정보/주문내역/내가쓴글 선택시 화면 전환 -->
		<tr>

			<td><input type="button" value="회원정보"
				onclick="userinfo()">
			</td>
			
			<td><input type="button" value="주문내역"
				onclick="orderinfo()">
			</td>
			
			<td><input type="button" value="내가쓴글"
				onclick="writelist()">
			</td>
		</tr>
		<tr>
			<td>
				ㅇㅇ님 안녕하세용
			</td>
		</tr>

	</table>




</form>

<script>
	function userinfo() {
		location.href = "MyPageUserInfoServlet";
	}
	function orderinfo() {
		location.href = "MyPageOrderInfoServlet";
	}
	function writelist() {
		location.href = "MyPageWriteListServlet";
	}
</script>