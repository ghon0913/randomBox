<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">

	<table border="1">

		<tr>
			<td>NUM.${bndto.num }</td>
			<td>카테고리: ${bndto.category }</td>
			<td>작성일: ${bndto.writeDay }</td>
			<td>상태: ${bndto.state }</td>
		</tr>
		<tr>
			<td colspan="5" align="center">제목: ${bndto.title }</td>
		</tr>
		<tr>
			<td colspan="5">내용<br /> <input type="text" height="100%"
				width="100%" value="${bndto.content }">
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right"><input type="button" value="돌아가기"
				id=""></td>
		</tr>

	</table>

</div>