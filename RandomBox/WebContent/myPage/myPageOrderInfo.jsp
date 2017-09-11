<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
<form action="">
<table border="1">
	<tr>
		<form action="orderinfopage.do">
		<td colspan="3">기간별조회 <input type="date" name="startdate"> - <input
			type="date" name="finaldate"><input type="submit">
		</td>
		
		</form>
	</tr>
	<tr>

			<td colspan="3">
				<form action="MyPageOrderInfoPageServlet">
					<select name="perpage">
						<!-- change함수주기 -->
						<option value="3">3개씩보기</option>
						<option value="5">5개씩보기</option>
						<option value="7">7개씩보기</option>
					</select> <input type="submit">
				</form>
			</td>

		</tr>
	<tr>
		<td>날짜</td>
		<td>상품정보</td>
		<td>상태</td>
	</tr>
	<c:if test="${empty pagedto.getOlist() }">
		<tr>
			<td colspan="3"> 레코드가 없습니다.</td>
		</tr>
	</c:if>
	
	<c:if test="${!empty pagedto.getOlist() }">
	<!-- 기간내 foreach문 주문내역 -->
	
	<c:forEach var="order" items="${pagedto.getOlist() }">
	<tr>
		<td>${order.orderDay }<br/>
		<a href="orderinforetrieve.do?num=${order.num }" target="blank">${order.num }</a>
		<br />
		</td>
		<td>
		<img src="images/goods/${order.gImage }" height="100" width="100"> ${order.gName }${order.gPrice }</td>
		<td>배송중/배송완료</td> 
	</tr>
	</c:forEach>
	<tr>
				<td colspan="4" align="center"><jsp:include
						page="myPageOrderInfoPage.jsp" flush="true" /></td>
			</tr>
		</c:if>
</table>
</form>
</div>