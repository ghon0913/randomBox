<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<form action="ReviewUpdateServlet" method="post" id="reviewRetrieveForm">
		<table>
			<tr>
				<td>글번호 : ${retrieveDTO.num }<input type="hidden" name="num" value="${retrieveDTO.num }"></td>
				<td id="writer">작성자 : ${retrieveDTO.userId }</td>
				<td>작성일 : ${retrieveDTO.writeDay }</td>
			</tr>
			<tr>
				<td>${retrieveDTO.state }</td>
				<td></td>
				<td>조회수 : ${retrieveDTO.readCnt }</td>
			</tr>
			<tr>
				<td>상품 카테고리 :</td>
				<td>${retrieveDTO.category }</td>
			</tr>
			<tr>
				<td>랜덤 배정 상품 :</td>
				<td>${retrieveDTO.gCode }</td>
			</tr>
		</table>
		<table>
			<c:if test="${retrieveDTO.userId == sessionScope.login.userid}">
				<tr>
					<td>제목 :</td>
					<td><input type="text" name="title" id="title" value="${retrieveDTO.title }"></td>
				</tr>
				<tr>
					<td>문의 내용 :</td>
					<td><textarea rows="10" cols="50" name="content" id="content">${retrieveDTO.content }</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정하기" id="update">&nbsp;
						<input type="button" value="삭제하기" id="delete">&nbsp;
						<input type="button" value="목록보기" id="inquiryList">
					</td>
				</tr>
			</c:if>
			<c:if test="${retrieveDTO.userId != sessionScope.login.userid}">
				<tr >
					<td>제목 :</td>
					<td><input type="text" name="title" id="title" readonly="readonly"></td>
				</tr>
				<tr id="content">
					<td>문의 내용 :</td>
					<td><textarea rows="10" cols="50" name="content" id="content" readonly="readonly"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="목록보기" id="reviewList">
					</td>
				</tr>
			</c:if>
		</table>
	</form>
</div>

<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script>
$(document).ready(function(){

	/* 목록보기 */
	$("#reviewList").on("click", function(){
		$(location).attr("href", "ReviewListServlet");
	});
	
	/* 삭제하기 */
	$("#delete").on("click", function(){
		$(location).attr("href", "ReviewDeleteServlet?num=${retrieveDTO.num }");
	});

});

</script>