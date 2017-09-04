<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table border="1">
	<tr>
		<td colspan="3">기간별조회 <input type="date" name=""> - <input
			type="date" name="">
		</td>
	</tr>
	<tr>
		<td>날짜</td>
		<td>상품정보</td>
		<td>상태</td>
	</tr>
	<!-- 기간내 foreach문 주문내역 -->
	<%-- <c:forEach> --%>
	<tr>
		<td>date<br /> <input type="button" name="" value="주문상세보기">
		</td>
		<td>gimage, gname, gprice</td>
		<td>배송중/배송완료</td>
	</tr>
	<%-- </c:forEach> --%>
</table>


<!-- 주문상세보기 -->
<table border="1">
	<tr>
		<td>주문정보<br /> (주문번호)
		</td>
		<td>주문상품<input name="" value="꾜꾜" readonly=""> <br />
			결제금액<input name="" value="100만원" readonly=""> <br /> <input
			name="" value="상태" readonly=""> <br />
		</td>
	</tr>
	<tr>
		<td>결제정보</td>
		<td>결제방식:<input name="" value="결제방식" readonly=""> <br />
			금액:<input name="" value="금액" readonly=""> <br /> 결제시간:<input
			name="" value="결제시간" readonly=""> <br />
		</td>
	</tr>
	<tr>
		<td>배송정보</td>
		<td>이름:<input name="" value="수취인이름" readonly=""> <br />
			연락처:<input name="" value="phone" readonly=""><br /> 주소:<input
			name="" value="address" readonly=""><br /> 배송요청사항:<input
			name="" value="mes" readonly=""><br />
		</td>
	</tr>
</table>