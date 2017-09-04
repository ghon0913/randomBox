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
				onclick="userinfo('${cartList.num}','${cartList.userid}')">
			</td>
			
			<td><input type="button" value="주문내역"
				onclick="orderinfo('${cartList.num}','${cartList.userid}')">
			</td>
			
			<td><input type="button" value="내가쓴글"
				onclick="writelist'${cartList.num}','${cartList.userid}')">
			</td>
		</tr>

	</table>




</form>

<script>
	function userinfo(num, userid) {
		location.href = "MyPageUserInfoServlet?num=" + num + "&userid=" + userid;
		//number에해당되는물품정보 id에해당되는 개인정보
	}
	function orderinfo(num, userid) {
		location.href = "MyPageOrderInfoServlet?num=" + num + "&userid=" + userid;
		//number에해당되는물품정보 id에해당되는 개인정보
	}
	function writelist(num, userid) {
		location.href = "MyPageWriteListServlet?num=" + num + "&userid=" + userid;
		//number에해당되는물품정보 id에해당되는 개인정보
	}
</script>