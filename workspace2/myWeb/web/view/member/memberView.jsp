<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, first.member.model.vo.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% 
	ArrayList<Member> mlist = (ArrayList<Member>)request.getAttribute("mlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC2 방식의 데이터베이스 연동</title>
<link href="/test/css/style.css" rel="stylesheet" type = "text/css">
</head>
<body>
<h2>MVC2 방식의 데이터베이스 연동</h2>
<h3>회원 정보 조회</h3>
	<table>
		<tr>
			<td><strong>ID</strong></td>
			<td><strong> PASSWD </strong></td>
			<td><strong>NAME</strong></td>
			<td><strong>E_MAIL</strong></td>
		</tr>
		<% for(Member m : mlist){ %>
			<tr>
				<td><%=m.getId() %></td>
				<td><%=m.getPasswd() %></td>
				<td><%=m.getName() %></td>
				<td><%=m.getEmail() %></td>
			</tr>
		<% } %>
	</table>
	<br>
	total records : <%= mlist.size() %>
	<br>
	<a href='/test/index.html'>이전으로 가기</a>
</body>
</html>