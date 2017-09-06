<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="FindUserIdServlet" method="get">
<br>
<br>
<br>
	이름 : <input type="text" name="username"><br> 전화번호 : <input
		type="text" name="phone"><br> <input type="submit"
		value="id찾기">
</form>

