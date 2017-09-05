<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- daum주소라이브러리안됨 -->	
<!-- DAUM 주소 라이브러리 시작 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/daum.js"></script>
<!-- DAUM 주소 라이브러리 끝 -->
<div align="center">
<form action="userinfoupdate.do">
<table border="1">
	<tr colspan="2">
		<td>이름</td>
		<td><input type="text" id="userName" value="${dto.username}" readonly="readonly"></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" id="userid" value="${dto.userid}" readonly="readonly"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" id="passwd"><br /> <input
			type="password" id="checkPasswd"></td>
	</tr>
	<tr>
		<td>휴대전화</td>
		<td><input type="text" id="phoneNumber" value="${dto.phone}"></td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<!-- 다음주소 시작--> <input name="post1" id="post1" size="5"
			value="${dto.post1}" readonly=""> - <input name="post2"
			id="post2" size="5" value="${dto.post2}" readonly=""> <input
			onclick="openDaumPostcode()" type="button" value="우편번호찾기"> <br>
			<input name="addr1" id="addr1" size="40" readonly=""
			placeholder="도로명주소" value="${dto.addr1}"> <br> <span
			style="line-height: 10%;"><br></span> <input name="addr2"
			id="addr2" size="40" value="${dto.addr2}" placeholder="지번주소">
			<!-- 다음주소 끝 -->
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="전송">
		</td>
	</tr>
</table>
</form>
</div>

