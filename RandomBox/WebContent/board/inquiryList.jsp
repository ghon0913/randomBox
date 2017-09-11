<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<h3>Q & A</h3>
	<table>
		<tr>
			<td height="30"><c:if test="${! empty sessionScope.login }">
					<td colspan="6" align="right"><input type="button"
						id="inquiry" value="문의하기"></td>
				</c:if></td>
		</tr>
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
			<th>작성자</th>
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
		<c:forEach var="bList" items="${ inquiryList.getList()}">
			<tr>
				<td>${bList.num }</td>
				<td>${bList.category }</td>
				<td style="padding-left: 30px"><a href="InquiryRetrieveServlet?num=${bList.num }">${bList.title }</a></td>
				<td>${bList.writeDay }</td>
				<td>${bList.userId }</td>
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
			<td align="center" colspan="7"><jsp:include page="boardPage.jsp"
					flush="true"></jsp:include></td>
		</tr>
		<tr>
			<td colspan="10">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
	</table>
</div>

<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script>
	$("#inquiry").on("click", function() {

		$(location).attr("href", "InquiryFormServlet");
	});
</script>