<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<form action="InquiryWriteServlet" method="post">
		<table>
			<input type="hidden" name="userid" value="${sessionScope.login.userid }">
			<tr>
				<td>작성자 : </td>
				<td>${sessionScope.login.userid }</td>
			</tr>
			<tr>
				<td>카테고리 :</td>
				<td>
					<select name="category">
						<option value="category1">카테고리 1</option>
						<option value="category2">카테고리 2</option>
						<option value="category3">카테고리 3</option>
						<option value="category4">카테고리 4</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>제목 :</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용 :</td>
				<td><textarea rows="18" cols="25" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="문의하기">&nbsp;<input type="button" value="목록보기">
				</td>
			</tr>
		</table>
	</form>
</div>