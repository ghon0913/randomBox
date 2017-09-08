<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">

	<table border="1">
		<tr>
			<td colspan="4">
				<form action="MyPageBoardPageServlet">
					<select name="searchName">
						<option value="state">문의중</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchValue">
					<input type="submit" value="검색">
				</form>
			</td>
			<!-- 검색항목을 선택해주세요 스크립트 -->
		</tr>
		<tr>
			<form action="MyPageBoardPageServlet" >
			<td colspan="4">
				<select name="perpage" ><!-- change함수주기 -->
					<option value="3">3개씩보기</option>
					<option value="5">5개씩보기</option>
					<option value="7">7개씩보기</option>
				</select>
				<input type="submit">
			</td>
			</form>
		</tr>
		
		<tr>
			<td>번호</td>
			<td>글 제목</td>
			<td>상태</td>
			<td>날짜</td>
		</tr>
		<c:if test="${empty pagedto}">
			<tr>
				<td colspan="4">레코드가없습니다.</td>
			</tr>
		</c:if>

		${pagedto}
		
		<c:if test="${! empty pagedto}">
			<c:forEach var="a" items="${pagedto.getBlist()}">
				<tr>
					<td>${a.num }</td>
					<td><a href="BoardRetrieve.do?bnum=${a.num}" target="_blank">${a.title}</a></td>
					<td>${a.state}</td>
					<td>${a.writeDay }</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<%-- <td colspan="4" align="center"><jsp:include
					page="myPageBoardPage.jsp" flush="true" /></td> --%>
		</tr>
	</table>
</div>