<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	var kind="myPageOrderInfo";
	
	$("#userinfo").on("click",function(){

		var d = "myPageUserInfo.jsp"
		console.log(kind);
	});
	$("#orderinfo").on("click",function(){
		var kk=$("#orderinfo").val()
		console.log(kind);
		
		$.ajax({
    		type:"get",
    		url:"ThrowMyPagekindServlet",
    		data:{
    			kind:$("#orderinfo").val()
    		},
    		dataType:"text"

		});
		
	});

	$("#writelist").on("click",function(){
		console.log("writelist 클릭");
	});
		
});

</script>

<button id="userinfo" value="userinfo" >회원정보</button>
<button id="orderinfo" value="userinfo" >주문내역</button>
<button id="writelist" >내가쓴글</button>


하
<hr/>
<jsp:include page="${kind}.jsp" flush="true"/>


</form>

	
