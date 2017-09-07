<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<table border="1">
	
		<tr>
			<td> 등록중인 상품
			</td>
			<td align="right">
				 <input type="button" onclick="GoodsRegisterFormServlet
				 추가" value="상품등록하기">
			</td>
		</tr>
		<c:if test="${gdto.size()}">
		</c:if>
		<tr>
		<td>
		</tr>
		
	</table>
	
<table width="100%" cellspacing="0" cellpadding="0">
	<tr height="10" />

	<tr>
		<td>
		</td>
		</tr>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border=1>

				<tr height="30">
					<td align="center"></td>
				</tr>
				<tr>

					<td>
						<table style='padding: 15px'>

							<tr>
								<td><a href=""> <img src="images/items/basicImage.png"
										border="0" align="center" width="200">
								</a></td>
							</tr>

						</table>
					</td>
										<td>
						<table style='padding: 15px'>

							<tr>
								<td><a href=""> <img src="images/items/basicImage.png"
										border="0" align="center" width="200">
								</a></td>
							</tr>

						</table>
					</td>
										<td>
						<table style='padding: 15px'>

							<tr>
								<td><a href=""> <img src="images/items/basicImage.png"
										border="0" align="center" width="200">
								</a></td>
							</tr>

						</table>
					</td>
										<td>
						<table style='padding: 15px'>

							<tr>
								<td><a href=""> <img src="images/items/basicImage.png"
										border="0" align="center" width="200">
								</a></td>
							</tr>

						</table>
					</td>
					
				</tr>
				<tr height="10" />
			</table>
	<tr height="10" />
</table>