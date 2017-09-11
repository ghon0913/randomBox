<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
<form action="">
<table border="1">
	<tr>
		<td colspan="3">기간별조회 <input type="date" name="startdate"> - <input
			type="date" name="finaldate">
		</td>
	</tr>
	<tr>
		<td>날짜</td>
		<td>상품정보</td>
		<td>상태</td>
	</tr>
	<!-- 기간내 foreach문 주문내역 -->
	<c:forEach var="order" items="${orderdto }">
	<tr>
		<td>${order.orderDay }<br/>
		<a href="orderinforetrieve.do?num=${order.num }">${order.num }</a>
		<br />
		</td>
		<td>${order.gImage }${order.gName }${order.gPrice }</td>
		<td>배송중/배송완료</td> 
	</tr>
	</c:forEach>
</table>
</form>
</div>