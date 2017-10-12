<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h3>후기 쓰기</h3>
	<form id="reviewWriteForm" action="reviewWriteServlet" method="post">
		<table>
			<input type="hidden" name="userid" value="${sessionScope.login.userid }">
			<tr>
				<td>작성자 : </td>
				<td>${sessionScope.login.userid }</td>
			</tr>
			<tr>
				<td>구매 카테고리 : </td>
				<td>${gName }</td>
				<input type="hidden" name="gName" value="${gName }">
			</tr>
			<tr>
				<td>랜덤 배송 상품 :</td>
				<td>${goodsName }</td>
				<input type="hidden" name="goodsName" value="${goodsName }">
			</tr>
			<tr>
				<td>제목 :</td>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			<tr>
				<td>후기 내용 :</td>
				<td><textarea rows="10" cols="30" name="content" id="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="후기작성">&nbsp;
					<input type="reset" value="다시작성">&nbsp;
				</td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script>
$(document).ready(function(){
	
	/* 입력사항 확인  */
	$("#reviewWriteForm").on("submit", function(e){
		
		if($("#title").val().length==0){
			alert("제목을 입력해 주세요!");
			e.preventDefault();
		}else if($("#content").val().length==0){
			alert("내용을 입력해 주세요!");
			e.preventDefault();
		}
	});
});

</script>