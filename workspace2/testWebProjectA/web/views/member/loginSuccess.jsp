<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess</title>
</head>
<body>
<h2>로그인 성공 : ${sessionScope.member.memberName }님 환영합니다.</h2>
<a href="<c:url value="/logout" />">로그아웃</a>
</body>
</html>