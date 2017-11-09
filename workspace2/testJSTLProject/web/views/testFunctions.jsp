<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testFunctions.jsp</title>
</head>
<body>
<h2>jstl functions 태그 라이브러리</h2>
자바 String 클래스의 메소드들을 태그로 제공한다고 보면 됨<br>
<h4>문자열 관련 함수 태그 : fn 태그명</h4>
<c:set var="str" value="How are you?"/>
str : ${str } <br>
<h4>다른 라이브러리 태그와 다른점 : el { fn:태그명(값) } 안에서 사용됨</h4>
모두 대문자로 : ${ fn:toUpperCase(str) } <br>
모두 소문자로 : ${ fn:toLowerCase(str) } <br>
are의 위치는 : ${ fn:indexOf(str, "are") } <br>
are 를 ware로 바꿈 : ${ fn:replace(str, "are", "ware") } <br>
문자열 길이 : ${ fn:length(str) } <br>
<hr>
<c:set var="colors" value="red*yellow/green cyan-blue"/>
<c:set var="colorlist" value="${ fn:split(colors, '*/ - ')}"/>
<c:forEach var="clr" items="${colorlist }">
	<font color="${clr }">글자색 적용</font><br>
</c:forEach>
</body>
</html>