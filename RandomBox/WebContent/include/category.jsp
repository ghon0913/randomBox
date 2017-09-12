<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<hr>
<div>
	<table border=1 align="center">
		<tr>
			<td><a href="GoodsListServlet">전체</a></td>
			<td><a href="GoodsByCategoryServlet?category=c1">카테고리1</a></td>
			<td><a href="GoodsByCategoryServlet?category=c2">카테고리2</a></td>
			<td><a href="GoodsByCategoryServlet?category=c3">카테고리3</a></td>

		</tr>
		<tr>
			<td><a href="GoodsByCategoryServlet?category=c4">카테고리4</a></td>
			<td><a href="GoodsByCategoryServlet?category=c5">카테고리5</a></td>
			<td><a href="GoodsByCategoryServlet?category=c6">카테고리6</a></td>
			<td><a href="GoodsByCategoryServlet?category=c7">카테고리7</a></td>
		</tr>

	</table>
</div>
<hr>