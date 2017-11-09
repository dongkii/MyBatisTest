<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%-- import="java.util.ArrayList, member.model.vo.Member" %> --%>
<%-- <%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
%> --%>
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
<c:set var="list" value="${ requestScope.list }"/>
<c:forEach var="m" items="${ list }">
<tr height="30">
<td><%-- <%= m.getMemberId() %> --%>${ m.memberId }</td>
<td><%-- <%= m.getMemberPwd() %> --%>${ m.memberPwd }</td>
<td><%-- <%= m.getMemberName() %> --%>${ m.memberName }</td>
<td><%-- <%= m.getGender() %> --%>${ m.gender }</td>
<td><%-- <%= m.getAge() %> --%>${ m.age }</td>
<td><%-- <%= m.getEmail() %> --%>${ m.email }</td>
<td><%-- <%= m.getPhone() %> --%>${ m.phone }</td>
<td><%-- <%= m.getAddress() %> --%>${ m.address }</td>
<td><%-- <%= m.getHobby() %> --%>${ m.hobby }</td>
<td><%-- <%= m.getEnrollDate() %> --%>${ m.enrollDate }</td>
</tr>
</c:forEach>
</table>
<br><br>
<div align="center">
<c:url var="index" value="/mweb/index.jsp"/>
<a href="${index }">시작페이지로</a>
</div>
</body>
</html>












