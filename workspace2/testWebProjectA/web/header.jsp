<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testm</title>
<style type="text/css">
	ul { list-style: none; }
	nav ul li {
		float: left;
	}
	
	nav ul li a {
		display: block;
		width: 150px;
		height: 35px;
		background: orange;
		color: navy;
		padding-top: 7px;
		text-decoration: none;
		text-align: center;
		font-weight: bold;
		text-shadow: 1px 1px 4px black;
		margin-right: 3px;
	}
	
	nav ul li a:hover{ background: olive; }
	
	div#loginBox {
		background : lightgray;
		float: right;
		width: 200px;
		height: 100px;
		border: 1px dotted gray;
		margin-right: 200px;
		font-size: 9pt;
	}
	
</style>
</head>
<body>
<header>
<h1>Welcome testMyBatisProject</h1>
<c:url var="m1" value="/index.jsp" />
<c:url var="m2" value="/nlist" />
<c:url var="m3" value="/blist" />
<nav>
<ul>
	<li><a href="${m1 }">home</a></li>
	<li><a href="${m2 }">공지사항</a></li>
	<li><a href="${m3 }">댓글게시판</a></li>
	<li><a href="#">메뉴4</a></li>
	<li><a href="#">메뉴5</a></li>
</ul>
</nav>
</header>
<hr style="clear:left;">
<div id="loginBox">
<%-- 로그인되지 않았다면 --%>
<c:if test="${empty sessionScope.member }">
<form action="*.me" method="post">
<input type="hidden" name="action" value="login">
<input type="text" name="userid" placeholder="아이디 입력"> <br>
<input type="password" name="userpwd" placeholder="암호 입력"> <br>
<input type="submit" value="로그인">
</form>
<a href="views/member/enrollForm.html">회원가입</a> &nbsp;
<a>아이디/비밀번호 조회</a>
</c:if>
<c:if test="${!empty sessionScope.member}">
<c:url var="lout" value="*.me">
	<c:param name="action" value="logout"/>
</c:url>
<c:url var="mi" value="*.me">
	<c:param name="userid" value="${member.memberId }" />
	<c:param name="action" value="minfo"/>
</c:url>
${ member.memberName }님 &nbsp; 
<a href="${lout }">로그아웃</a> <br>
<a href="${mi }">내정보보기</a>
</c:if>
</div>

</body>
</html>