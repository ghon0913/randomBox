<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table width="100%" cellspacing="0" cellpadding="0">
	<tr height="10" />

	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border=1>

				<tr height="30">
					<td align="center"><a href="home.jsp">구매페이지</a></td>
					<td align="center"><a href="GoodsRetrieveServlet">상품설명</a></td>
					<td align="center"><a href="">Q&A</a></td>
					<td align="center"><a href="">후기</a></td>
				</tr>
				<tr>

					<td colspan="4" align="center">
						<table style='padding: 15px' align="center">

							<tr>
								<td><a href=""> <img src="images/items/basicImage.png"
										border="0" align="center" width="200">
								</a></td>
							</tr>

						</table>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						구성품(총16개의 상품)<br>
						<c:forEach var="list16" items="${sessionScope.goodsList16}">
							${list16.gName} &nbsp;
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<a href="GoodsMixListServlet"><input type="button" value="새로 구성하기"/></a>
						<a href=""><input type="button" value="장바구니 넣기"/></a>
						<a href=""><input type="button" value="주문하기"/></a>
					</td>
				</tr>

				<tr height="10" />
			</table>
	<tr height="10" />
</table>