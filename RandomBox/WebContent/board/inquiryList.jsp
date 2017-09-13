<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h3>Q & A</h3>
	<table>
		<tr>
			<td colspan="2">
				<select id="searchCategory" name="searchCategory">
					<option>카테고리별로 보기</option>
					<option value="category1">category1</option>
					<option value="category2">category2</option>
					<option value="category3">category3</option>
					<option value="category4">category4</option>
				</select>
			</td>
			<td height="30">
					<td colspan="6" align="right">
						<input type="button" id="inquiry" value="문의하기">
					</td>
			</td>
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
						<c:if test="${bList.open == 'N' }">
							<c:if test="${bList.userId == sessionScope.login.userid }">
								<a href="InquiryRetrieveServlet?num=${bList.num }" class="ck_writer" >${bList.title }
								<img src="images/items/lock.png" width="12px" height="12px"/></a>
							</c:if>
							<c:if test="${bList.userId != sessionScope.login.userid }">
								<a href="#" class="ck_writer" >${bList.title }
								<img src="images/items/lock.png" width="12px" height="12px"/></a>
							</c:if>
						</c:if>
						<c:if test="${bList.open == null || bList.open == 'Y' }">
							<a href="InquiryRetrieveServlet?num=${bList.num }">${bList.title }</a>
						</c:if>
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
		<tr>
			<form action="InquiryListServlet">
			<td colspan="7" style="padding-left: 10px" align="center">
				<select id="searchName" name="searchName">
					<option value="title">제목으로 검색</option>
					<option value="content">내용으로 검색</option>
				</select>
				<input type="text" id="searchWord" name="searchWord">
				<input type="submit" value="검색">
			</td>
			</form>
		</tr>
	</table>
</div>

<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script>
$(document).ready(function(){
	
	/* 문의글 작성 */
	$("#inquiry").on("click", function() {

		$(location).attr("href", "InquiryFormServlet");
	});
	
	/* 카테고리별로 보기 */
	$("#searchCategory").on("change", function(){
		var searchCategory = $("option:selected").val();
		$(location).attr("href", "InquiryListServlet?searchCategory="+searchCategory);
	});
	
});
</script>