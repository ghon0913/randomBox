<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<table border="1">
	<tr colspan="2">
		<td>이름</td>
		<td><input type="text" id="userName" value=""></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" id="userId" value=""></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" id="passwd"><br /> <input
			type="text" id="checkPasswd"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" id="telNumber" value=""></td>
	</tr>
	<tr>
		<td>휴대전화</td>
		<td><input type="text" id="phoneNumber" value=""></td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<!-- 다음주소 시작--> <input name="post1" id="post1" size="5"
			value="${login.post1}" readonly=""> - <input name="post2"
			id="post2" size="5" value="${login.post2}" readonly=""> <input
			onclick="openDaumPostcode()" type="button" value="우편번호찾기"> <br>
			<input name="addr1" id="addr1" size="40" readonly=""
			placeholder="도로명주소" value="${login.addr1}"> <br> <span
			style="line-height: 10%;"><br></span> <input name="addr2"
			id="addr2" size="40" value="${login.addr2}" placeholder="지번주소">
			<!-- 다음주소 끝 -->
	</tr>
</table>