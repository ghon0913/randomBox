<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">

	<table border="1">
		<tr>
			<td>번호</td>
			<td>글 제목</td>
			<td>상태</td>
			<td>날짜</td>
		</tr>
		<c:if test="${empty bdto}">
			<tr>
				<td colspan="4">레코드가없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${! empty bdto}">
			<c:forEach var="a" items="${bdto}">
				<tr>
					<td>${a.num }</td>
					<td><a href="BoardRetrieve.do?bnum=${a.num}" target="_blank">${a.title}</a></td>
					<td>${a.state}</td>
					<td>${a.writeDay }</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td colspan="4" align="center">페이지번호</td>
		</tr>
	</table>
</div>