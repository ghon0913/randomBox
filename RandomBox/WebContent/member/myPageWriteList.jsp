<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table border="1">
	<tr>
		<td>문의제목</td>
		<td>답변상태</td>
	</tr>
	<c:if test="${empty list}">
		<tr>
			<td colspan="5">레코드가없습니다.</td>
		</tr>
	</c:if>
	<c:if test="${!empty list}"	>
	<%-- <c:foreach 문의사항 반복문> --%>
	<tr>
		<td>title</td>
		<td>yes/no</td>
		<%-- </c:foreach> --%>
	</tr>
	</c:if>
	<tr>
		<td colspan="2" align="center">페이지번호</td>
	</tr>
</table>

주문상세보기
<table border="1">
	<tr>
		<td>num</td>
		<td>title-자세히보기</td>
		<td>writeday</td>
	</tr>
	<%-- <c:foreach> --%>
	<tr>
		<td>후기게시판num</td>
		<td>후기제목</td>
		<td>작성일 to_char('writeday',mm/dd)</td>
	</tr>
	<%-- </c:foreach> --%>
	<tr>
		<td colspan="3" align="center">페이지번호</td>
	</tr>
</table>