<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">	
<table border="1">


<tr>
<td colspan="10">
<form action="goodsinfo.do">
<select name="searchName">
	<option value="gCode">상품코드</option>
	</select>
	<input type="text" name="searchValue">
	<input type="submit" value="검색"> 
	
</form>	
</td>
</tr>
<c:if test="${empty pagedto.glist }">
<tr>
	<td colspan="10"	> 레코드가없습니다.</td>
</tr>
</c:if>
<c:if test="${! empty pagedto.glist }">

<tr>
	<td>상품코드</td>
	<td>상품명</td>
	<td>카테고리</td>
	<td>가격</td>
</tr>

<c:forEach var="goods" items="${pagedto.glist }">
<tr>
	<td> <a href="goodsinforetrieve.do" target="blank">${goods.gCode }</a>
	</td>
	<td>${goods.gImage }${goods.gName }
	</td>
	<td>${goods.gCategory }
	</td>
	<td>${goods.gPrice }
	</td>
</tr>

</c:forEach>

<tr>
	<td  colspan="10"><jsp:include page="myPageGoodsInfoPage.jsp"></jsp:include>
</tr>
</c:if>
<tr>
<td colspan="10" align="right"> <input type="button" value="등록하기" onclick="goodsadd(f)">
</tr>



</table>
</div>
<script>
 function cartAdd(f){
    f.action="GoodsRegisterFormServlet";	
 }
 </script>