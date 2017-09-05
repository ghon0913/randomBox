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
			url:"userinfo.do",
			data:{
				kind:$("#userinfo").attr("id")
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
			url:"orderinfo.do",
			data:{
				kind:$("#orderinfo").attr("id")
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
		console.log($("#writelist").attr("id"));
		$.ajax({
			type:"get",
			url:"writelist.do",
			data:{
				kind:$("#writelist").attr("id")
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
<button id="userinfo"  >회원정보</button>
<button id="orderinfo" >주문내역</button>
<button id="writelist"  >내가쓴글</button>



<hr/>
<div id="here"> </div>

</form>

	
