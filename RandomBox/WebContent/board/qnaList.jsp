<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h3>답변하기</h3>
	<table>
		<tr>
			<td colspan="10">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
		<tr>
			<td height="7" />
		</tr>
		<tr>
			<th>글번호</th>
			<th>카테고리</th>
			<th width="250">제목</th>
			<th>작성일</th>
			<th width="80">작성자</th>
			<th>조회수</th>
			<th>처리상태</th>
		</tr>
		<tr>
			<td colspan="10">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
		<tr>
			<td height="7" />
		</tr>
<!-- ----------------------------------------------------------------리스트 목록 없을 때 -------------------------------->
		<c:if test="${ boardList.getList().size() == 0 }">
			<tr>
				<td colspan="7" align="center">
					해당하는 글 목록이 없습니다.
				</td>
			</tr>
		</c:if>
<!-- ----------------------------------------------------------------리스트 목록 보여주기 -------------------------------->
		<c:if test="${ boardList.getList().size() != 0 }">
			<c:forEach var="bList" items="${ boardList.getList()}">
				<tr>
					<td>${bList.num }</td>
					<td>${bList.category }</td>
					<td style="padding-left: 30px">
							<a href="AnswerFormServlet?num=${bList.num }">${bList.title }</a>
					</td>
					<td>${bList.writeDay }</td>
					<td align="center">${bList.userId }</td>
					<td>${bList.readCnt }</td>
					<td>${bList.state }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="10">
					<hr size="1" color="CCCCCC">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="7">
					<jsp:include page="boardPage.jsp" flush="true"></jsp:include>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="10">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
	</table>
</div>