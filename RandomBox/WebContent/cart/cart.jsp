<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<h3>나의 장바구니</h3>
	<table width="90%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td class="td_default" align="center"><input type="checkbox"
				name="allCheck" id="allCheck" onchange="allCheck()"> <strong>전체선택</strong></td>
			<td class="td_default" align="center"><strong>주문번호</strong></td>
			<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
			<td class="td_default" align="center"><strong>판매가</strong></td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td height="7">
		</tr>
		
		<c:if test="${fn:length(cartList)==0}">
			<tr>
				<td colspan="10">
					<hr size="1" color="CCCCCC">
				</td>
			</tr>

			<tr>
				<td height="5">
			</tr>
			<tr>
				<td class="td_default" align="center">카트에 추가된 상품이 없습니다.</td>
			</tr>
		</c:if>
		
<!--cartList---------------------------------------------------------------------------------------------------------->

		<c:if test="${fn:length(cartList)!=0}">
			<tr>
				<td colspan="10">
					<hr size="1" color="CCCCCC">
				</td>
			</tr>
		<form name="cartListForm">
			<c:forEach var="xxx" items="${cartList}">
				<input type="hidden" name="num${xxx.num}" value="${xxx.num}"
					id="num${xxx.num}">
				<input type="hidden" name="gImage${xxx.num}" value="${xxx.gImage}"
					id="gImage${xxx.num}">
				<input type="hidden" name="gName${xxx.num}" value="${xxx.gName}"
					id="gName${xxx.num}">
				<input type="hidden" name="gPrice${xxx.num}" value="${xxx.gPrice}"
					id="gPrice${xxx.num}">
				<input type="hidden" name="userid" value="${xxx.userId}"
					id="userid">
				<tr>
					<td class="td_default" width="80">
						<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
						<input
						type="checkbox" name="check" id="check${xxx.num}" class="check"
						value="${xxx.num}">
					</td>
					<td class="td_default" width="80" id="num">${xxx.num}</td>
					<td class="td_default" width="80"><img
						src="images/goods/${xxx.gImage}" border="0" align="center"
						width="80" /></td>
					<td class="td_default" width="300" style='padding-left: 30px'>${xxx.gName}</td>
					<td class="td_default" align="center" width="110"><fmt:formatNumber
							value="${xxx.gPrice}" type="currency" /></td>
					<td class="td_default" align="center" width="30"
						style='padding-left: 10px'><input type="button" value="주문"
						onclick="order('${xxx.num}','${xxx.userId}')"></td>
					<td class="td_default" align="center" width="30"
						style='padding-left: 10px'><input type="button" value="삭제"
						onclick="delCart('${xxx.num}')"></td>
					<td height="10"></td>
				</tr>
			</c:forEach>
		</form>
		
<!--end cartList------------------------------------------------------------------------------------------------------>
		
			<tr>
				<td colspan="10">
					<hr size="1" color="CCCCCC">
				</td>
			</tr>
			<tr>
				<td height="30">
			</tr>

			<tr>
				<td align="center" colspan="5"><a class="a_black"
					href="javascript:orderAllConfirm(cartListForm)"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="a_black" href="javascript:delAllCart(cartListForm)"> 전체
						삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; <a class="a_black" href="start.jsp">
						계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td height="20">
			</tr>
		</c:if>
	</table>
</div>

<!--script cartList------------------------------------------------------------------------------------------------------>

<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script>
	function delCart(num){
		location.href = "CartDelServlet?num=" + num;
	}
	
	function allCheck(){
		
		if($("#allCheck").prop("checked")){
			$(".check").prop("checked", true);
		}else{
			$(".check").prop("checked", false);
		}
	}
	
	function delAllCart(f){
		f.action = "CartDelAllServlet";
		f.submit();
	}
	
	function order(num, userid){
		location.href = "OrderConfirmServlet?num="+num+"&userid="+userid;
	}
	
	function orderAllConfirm(f){
		f.action = "OrderAllConfirmServlet";
		f.submit();
	}
</script>