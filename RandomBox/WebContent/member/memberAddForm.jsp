<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- DAUM 주소 라이브러리 시작 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/daum.js"></script>
<!-- DAUM 주소 라이브러리 끝 -->

<div>
	<form action="MemberAddServlet" method="post" id="memberAddForm">
		<h3>구매 회원가입</h3>
		<p>회원 정보를 입력해 주세요. 모두 입력하셔야 가입이 가능합니다.</p>
		<table name="memberAddForm">
			<tr>
				<td colspan="2" align="center">일반 구매회원 <input type="radio"
					name="ox" value="N" checked="checked"> 사업자 판매회원 <input
					type="radio" name="ox" value="Y">
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" id="userid"> <span
					id="idCheck"></span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" id="passwd"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="passwd2" id="passwd2">
					<span id="passwdCheck"></span></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td id="email_td"><input type="text" name="email1" id="email1">
					@ <select name="email2" id="email2">
						<option value="empty">선택하기</option>
						<option id="etc" value="etc">직접입력하기</option>
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="nate.com">nate.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hotmail.com">hotmail.com</option>
						<option value="korea.com">korea.com</option>
				</select> <span id="emailCheck"></span></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>남 <input type="radio" name="gender" value="남"
					checked="checked"> 여 <input type="radio" name="gender"
					value="여"></td>
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="date" name="birthday" id="birthday"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<!-- 다음주소 시작--> <input name="post1" id="post1" size="5" readonly="">
					- <input name="post2" id="post2" size="5" readonly=""> <input
					onclick="openDaumPostcode()" type="button" value="우편번호찾기"><br>
					<span style="line-height: 10%;"><br></span> <input
					name="addr1" id="addr1" size="40" readonly="" placeholder="도로명주소"><br>
					<span style="line-height: 10%;"><br></span> <input
					name="addr2" id="addr2" size="40" placeholder="지번주소"> <!-- 다음주소 끝 -->
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><select name="phone1" id="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="017">016</option>
						<option value="017">017</option>
						<option value="017">018</option>
						<option value="017">019</option>
				</select> - <input type="text" name="phone2" id="phone2"> - <input
					type="text" name="phone3" id="phone3"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원가입"> <input type="reset" value="다시 작성하기">
					<input type="button" value="취소" id="cancel"></td>
			</tr>
		</table>
	</form>
</div> 
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){

    /* 아이디 중복 검사 */     
    $("#userid").on("keyup", function(event){
    	
    	$.ajax({
    		
    		type : "get",
    		url : "IdCheckServlet",
    		data : {
    			userid:$("#userid").val()
    		},
    		dataType : "text",
    		success : function(responseData, status, xhr){
    			$("#idCheck").text(responseData);
    		},
    		error : function(xhr, status, e){
    			console.log(status, e);
    		}
    	}); // end ajax
    });
    
    /* 비밀번호 확인 */
     $("#passwd2").on("keyup", function(event){
    	
    	 var passwd = $("#passwd").val();
    	 var passwd2 = $("#passwd2").val();
    	 
    	 if($("#passwd2").val().length != 0){
	    	 if(passwd == passwd2){
	    		 $("#passwdCheck").text("비밀번호 일치");
	    	 }else{
	    		 $("#passwdCheck").text("비밀번호 불일치");
	    	 }
    	 }else{
    		 $("#passwdCheck").text("");
    	 }
 
    });
    
    
    /* 이메일 직접 입력  */
    $("select#email2").on("change", function(event){
    	
		if($("#email2 option:selected").attr("value")=='etc'){
			$("select#email2").before("<input type='text' name='email2' id='email_etc'>");
		}
		
		if($("#email2 option:selected").attr("value")!='etc'){
			$("#email_etc").remove("input#email_etc");
		}
    });

    
    /* 이메일 중복, 유효성 검사 */
    var email1, email2, email;
    $("select#email2").on("change", function(){
    	
    	switch ($("#email2 option:selected").attr("value")) {
    	
    	case 'etc' : 
	    	$("#email_etc").on("keyUp", function(){
	        	console.log("##############");
	        	/* if($("#email1").val() != null){
	        		email1 = $("#email1").val();
	        		email2 = $("[name = email2]").val();
	        	}
	        	email = email1+"@"+email2;
	        	console.log(email+"###");
	        	
	         	if(ck_email.test(email) != true){
	         		$("#emailCheck").empty();
	        		$("#emailCheck").text("이메일 유형 부적합");
	        	}*/
	       	});
	    	break;
    	
    	case 'empty' :
    		break;
    		
    	default :
    		email1 = $("#email1").val();
    		email2 = $("[name = email2]").val();
    		break;
    	}
    	
    	email = email1+"@"+email2;
	 	
    	$.ajax({
    		
    		type : "post",
    		url : "EmailCheckServlet",
    		data : {
    			email: email
    		},
    		dataType : "text",
    		success : function(responseData, status, xhr){
    			$("#emailCheck").text(responseData);
    		},
    		error : function(xhr, status, e){
    			console.log(status, e);
    		}
    	}); // end ajax
   	});
    

    
    /* 유효성, 빈칸 없나 확인 */
	$("#memberAddForm").on("submit", function(e){
		
		if($("#userid").val().length==0){
			alert("입력하신 아이디를 확인해주세요!");
			e.preventDefault();
		}else if($("#passwd").val().length==0 || $("#passwd2").val().length==0 || $("#passwdCheck").text()=="비밀번호 불일치"){
			alert("입력하신 비밀번호를 확인해주세요!");
			e.preventDefault();
		}else if($("#username").val().length==0){
			alert("입력하신 이름을 확인해주세요!");
			e.preventDefault();
		}else if($("#email1").val().length==0 || $("#email2 option:selected").attr("value")=='empty' || $("#email_etc").val().length==0){
			alert("입력하신 이메일을 확인해주세요!");
			e.preventDefault();
 		}else if($("#birthday").val().length == 0){
			alert("입력하신 생일을 확인해주세요!");
			e.preventDefault();
		}else if($("#post1").val().length == 0){
			alert("입력하신 주소를 확인해주세요!");
			e.preventDefault();
		}else if($("#phone2").val().length < 3 || $("#phone2").val().length > 4 || $("#phone3").val().length != 4){
			alert("입력하신 전화번호를 확인해주세요!");
			e.preventDefault();
		}
	});
});
</script>