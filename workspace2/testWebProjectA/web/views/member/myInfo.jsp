<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfo</title>
<style>
	th { background: lightgray; }
</style>
<script type="text/javascript">
	function mdel(){
		<%-- location.href = "/first/mdelete?userid=<%= member.getMemberId() %>"; --%>
		location.href = "/twa/*.me?userid=${ requestScope.member.getMemberId() }&action=mdelete";
		return false;
	}
</script>
</head>
<body>
<h2 align="center">${requestScope.member.memberName } 님 정보보기</h2>
<br><br>
<form action="*.me" method="post">
<input type="hidden" name="action" value="mupdate">
<table align="center" width="600" height="350">
<tr><th width="150">아이디</th>
	<td width="450">
	<input name="userid" value="${requestScope.member.memberId }" readonly>
	</td>
</tr>
<tr><th>이 름</th>
	<td>
	<input type="text" name="username" value="${requestScope.member.memberName }">
	</td>
</tr>
<tr><th>암 호</th>
	<td>
	<input type="password" name="userpwd" value="${requestScope.member.memberPwd }">
	</td>
</tr>
<tr><th>암호확인</th><td><input type="password" name="userpwd2"></td></tr>
<tr><th>성 별</th>
	<c:if test="${requestScope.member.gender eq 'M' }">
	<td><input type="radio" name="gender" value="M" checked> 남
		<input type="radio" name="gender" value="F"> 여
	</td>
	</c:if>
	<c:if test="${requestScope.member.gender eq 'F' }">
	<td>
		<input type="radio" name="gender" value="M"> 남
		<input type="radio" name="gender" value="F" checked> 여
	</td>	
	</c:if>
</tr>
<tr><th>나 이</th>
	<td>
	<input type="number" name="age" min="1" max="100" value="${member.age }">
	</td>
</tr>
<tr><th>전화번호</th>
	<td>
	<input type="tel" name="phone" value="${requestScope.member.phone }">
	</td>
</tr>
<tr><th>이메일</th>
	<td>
	<input type="email" name="email" value="${requestScope.member.email }">
	</td>
</tr>
<tr><th>주 소</th>
	<td>
	<input type="text" name="address" value="${requestScope.member.address }">
	</td>
</tr>
<tr><th>취 미</th>
	<td>
	<c:forTokens var="hobby" items="${member.hobby }" delims="," >
		<c:if test="${hobby eq '독서' }"> <c:set var="checked0"  value="checked" /></c:if>
		<c:if test="${hobby eq '운동' }"> <c:set var="checked1"  value="checked" /></c:if>
		<c:if test="${hobby eq '등산' }"> <c:set var="checked2"  value="checked" /></c:if>
		<c:if test="${hobby eq '그림' }"> <c:set var="checked3"  value="checked" /></c:if>
		<c:if test="${hobby eq '요리' }"> <c:set var="checked4"  value="checked" /></c:if>
		<c:if test="${hobby eq '음악' }"> <c:set var="checked5"  value="checked" /></c:if>
		<c:if test="${hobby eq '게임' }"> <c:set var="checked6"  value="checked" /></c:if>
		<c:if test="${hobby eq '댄스' }"> <c:set var="checked7"  value="checked" /></c:if>
		<c:if test="${hobby eq '기타' }"> <c:set var="checked8"  value="checked" /></c:if>	
	</c:forTokens>	
	<table>
	<tr>
		<td><input type="checkbox" name="hobby" value="독서" ${ checked0 }> 독서</td>
		<td><input type="checkbox" name="hobby" value="운동" ${ checked1 }> 운동</td>
		<td><input type="checkbox" name="hobby" value="등산" ${ checked2 }> 등산</td>
	</tr>
	<tr>	
		<td><input type="checkbox" name="hobby" value="그림" ${ checked3 }> 그림</td>
		<td><input type="checkbox" name="hobby" value="요리" ${ checked4 }> 요리</td>
		<td><input type="checkbox" name="hobby" value="음악" ${ checked5 }> 음악</td>
	</tr>
	<tr>
		<td><input type="checkbox" name="hobby" value="게임" ${ checked6 }> 게임</td>
		<td><input type="checkbox" name="hobby" value="댄스" ${ checked7 }> 댄스</td>
		<td><input type="checkbox" name="hobby" value="기타" ${ checked8 }> 기타</td>
	</tr>
	
	</table>	
	</td>
</tr>
<tr><th colspan="2">
	<input type="submit" value="수정하기"> &nbsp;
	<input type="reset" value="취소"> &nbsp;
	<button onclick="return mdel();">탈퇴하기</button>
</th></tr>
</table>
</form>
<br><br>
<div align="center">
	<a href="<c:url value="/index.jsp" />">시작페이지로 이동</a>
</div>



</body>
</html>





