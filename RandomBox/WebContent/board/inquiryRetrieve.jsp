<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script>
$(document).ready(function(){
	$("inquiryList").on("click", function(){
		$(location).attr("href", "InquiryListServlet");
	});
	
	var category = '${retrieveDTO.category }';
	console.log($("option [value='"+category+"']"));
	$("option [value='"+category+"']").attr("selected", "selected");

});
</script>
<div>
	<form action="InquiryUpdateServlet" method="post">
		<table>
			<tr>
				<td>글번호 : ${retrieveDTO.num }</td>
				<td id="writer">작성자 : ${retrieveDTO.userId }</td>
				<td>작성일 : ${retrieveDTO.writeDay }</td>
				<td>조회수 : ${retrieveDTO.readCnt }</td>
			</tr>
			<tr>
				<td>처리상태 : ${retrieveDTO.state }</td>
			</tr>
			<c:if test="${retrieveDTO.userId == sessionScope.login.userid}">
				<tr>
					<td>카테고리 :</td>
					<td>
						<select name="category" id="category">
							<option value="category1">카테고리 1</option>
							<option value="category2">카테고리 2</option>
							<option value="category3">카테고리 3</option>
							<option value="category4">카테고리 4</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>제목 :</td>
					<td><input type="text" name="title" id="title" value="${retrieveDTO.title }"></td>
				</tr>
				<tr>
					<td>내용 :</td>
					<td><textarea rows="18" cols="25" name="content" id="content">${retrieveDTO.content }</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정하기" id="update">&nbsp;<input type="button" value="목록보기">
					</td>
				</tr>
			</c:if>
			<c:if test="${retrieveDTO.userId != sessionScope.login.userid}">
				<tr>
					<td>카테고리 :  ${retrieveDTO.category }</td>
				</tr>
				<tr>
					<td>제목 :</td>
					<td><input type="text" name="title" id="title" readonly="readonly"></td>
				</tr>
				<tr>
					<td>내용 :</td>
					<td><textarea rows="18" cols="25" name="content" id="content" readonly="readonly"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="목록보기" id="inquiryList">
					</td>
				</tr>
			</c:if>
		</table>
	</form>
</div>
