<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberListView</title>
</head>
<body>
<h2 align="center">관리자 전용 페이지입니다.</h2>
<br><br>
<table border="1" cellspacing="0" align="center">
<th>아이디</th><th>암호</th><th>이름</th><th>성별</th><th>나이</th>
<th>이메일</th><th>전화번호</th><th>주소</th><th>취미</th><th>가입날짜</th>
<c:forEach var="m" items="${requestScope.list }">
<tr height="30">
<td>${m.memberId }</td>
<td>${m.memberPwd }</td>
<td>${m.memberName }</td>
<td>${m.gender }</td>
<td>${m.age }</td>
<td>${m.email }</td>
<td>${m.phone }</td>
<td>${m.address }</td>
<td>${m.hobby }</td>
<td>${m.enrollDate }</td>
</tr>
</c:forEach>
</table>
<br><br>
<div align="center">
<a href="<c:url value="/index.jsp"/>">시작페이지로</a>
</div>
</body>
</html>












