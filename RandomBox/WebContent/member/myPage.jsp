<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#userinfo").on("click",function(event){
		console.log($("#userinfo").val());
		$.ajax({
			type:"get",
			url:"ThrowMyPagekindServlet",
			data:{
				kind:$("#userinfo").val()
			},
			dataType:"text",
			success:function(responseData,status,xhr){
				$("#here").html(responseData);
			},
			error:function(xhr,status,e){
				console.log(xhr,status,e);
			}
		});
		
	});
	
	$("#orderinfo").on("click",function(event){
		console.log($("#orderinfo").val());
		$.ajax({
			type:"get",
			url:"ThrowMyPagekindServlet",
			data:{
				kind:$("#orderinfo").val()
			},
			dataType:"text",
			success:function(responseData,status,xhr){
				$("#here").html(responseData);
			},
			error:function(xhr,status,e){
				console.log(xhr,status,e);
			}
		});
		
	});

	$("#writelist").on("click",function(event){
		console.log($("#writelist").val());
		$.ajax({
			type:"get",
			url:"ThrowMyPagekindServlet",
			data:{
				kind:$("#writelist").val()
			},
			dataType:"text",
			success:function(responseData,status,xhr){
				$("#here").html(responseData);
			},
			error:function(xhr,status,e){
				console.log(xhr,status,e);
			}
		});
		
	});
		
});
/* 
$("button").click(function(){
	    $("#w3s").attr("href", "https://www.w3schools.com/jquery");
	}); 

$("#daum").attr("href","http://www.google.com");
*/

</script>

username 님 안녕하세요.<br/><br/>
<button id="userinfo" value="userinfo" >회원정보</button>
<button id="orderinfo" value="orderinfo" >주문내역</button>
<button id="writelist" value="writelist" >내가쓴글</button>



<hr/>
<div id="here"> </div>

</form>

	
