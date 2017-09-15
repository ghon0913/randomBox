<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<form action="InquiryUpdateServlet" method="post">
		<table>
			<tr>
				<td>글번호 : ${retrieveDTO.num }<input type="hidden" name="num" value="${retrieveDTO.num }"></td>
				<td id="writer">작성자 : ${retrieveDTO.userId }</td>
				<td>작성일 : ${retrieveDTO.writeDay }</td>
			</tr>
			<tr>
				<td>처리상태 : ${retrieveDTO.state }</td>
				<td></td>
				<td>조회수 : ${retrieveDTO.readCnt }</td>
			</tr>
		</table>
		<table>
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
					<td>문의글 공개여부 :</td>
					<td id="open"><input type="radio" name="open" value="N">비공개글로 작성&nbsp;&nbsp;
					<input type="radio" name="open" value="Y" checked="checked">공개글로 작성</td>
				</tr>
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
				<tr>
					<td>카테고리 :</td>
					<td>${retrieveDTO.category }</td>
				</tr>
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
						<input type="button" value="목록보기" id="inquiryList">
						<c:if test="${sessionScope.login.ox == 'Y'}">
							&nbsp;<input type="button" value="답변하기" id="addAnswer">
						</c:if>
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
	$("#inquiryList").on("click", function(){
		$(location).attr("href", "InquiryListServlet");
	});
	
	/* 지정한 카테고리로 설정되도록 */
	var category = '${retrieveDTO.category }';
	$("#category").find("[value='"+category+"']").attr("selected", "selected");
	
	/* 삭제하기 */
	$("#delete").on("click", function(){
		$(location).attr("href", "InquiryDeleteServlet?num=${retrieveDTO.num }");
	});
	
	/* 지정했던 공개여부 선택되도록 */
	var open = '${retrieveDTO.open }';
	$("#open").find("[value='"+open+"']").attr("checked", "checked");
	
	/* 답변하기 */
/* 	$("#addAnswer").on("click", function(event){
		var answerForm = $("<tr style='display: none;' id='answerForm'><td>답변 :</td><td><textarea rows='10'"
						+" cols='50' name='answer' id='answer'></textarea></td></tr>").fadeIn(2000);
		$("#content").after(answerForm);
	}); */
	
});

</script>