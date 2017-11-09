<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testFmt.jsp</title>
</head>
<body>
<h4>testCore.jsp 파일에서 만든 변수 sum 값 확인 : ${sessionScope.sum }</h4>
<h2>포매팅 라이브러리</h2>
<h4>지역대 설정 : fmt:setLocale 태그</h4>
<fmt:setLocale value="ko_kr"/>
<hr>
<h4>날짜, 시간, 숫자 데이터의 출력 형식을 지정할 때 사용하는 태그 라이브러리 임</h4>
오늘 날짜 : <fmt:formatDate value="<%= new java.util.Date() %>"/><br>
현재 시간 : <fmt:formatDate value="<%= new java.util.Date() %>" type="time"/><br>
현재 날짜와 시간 : <fmt:formatDate value="<%= new java.util.Date() %>" type="both"/><br>
<c:set var="today" value="<%= new java.util.Date() %>"/>
<hr>

<h2>날짜 데이터 출력 포맷 지정 속성 : dataStyle</h2>
[short] : <fmt:formatDate value="${today}" dateStyle='short' timeStyle="short" /> <br/>
[medium] : <fmt:formatDate value="${today}" dateStyle='medium' timeStyle="medium" /> <br/>
[long] : <fmt:formatDate value="${today}" dateStyle='long' timeStyle="long" /> <br/>
[full] : <fmt:formatDate value="${today}" dateStyle='full' timeStyle="full" />
<hr>

<h2>시간 시간 데이터 출력 포맷 지정 속성 : timeStyle</h2>
[short] : <fmt:formatDate value="${today}" type="time" dateStyle='short' timeStyle="short" /> <br/>
[medium] : <fmt:formatDate value="${today}" type="time" dateStyle='medium' timeStyle="medium" /> <br/>
[long] : <fmt:formatDate value="${today}" type="time" dateStyle='long' timeStyle="long" /> <br/>
[full] : <fmt:formatDate value="${today}" type="time" dateStyle='full' timeStyle="full" />
<hr>

<h2>날짜와 시간 둘 다 출력할 경우</h2>
[short] : <fmt:formatDate value="${today}" type="both" dateStyle='short' timeStyle="short" /> <br/>
[medium] : <fmt:formatDate value="${today}" type="both" dateStyle='medium' timeStyle="medium" /> <br/>
[long] : <fmt:formatDate value="${today}" type="both" dateStyle='long' timeStyle="long" /> <br/>
[full] : <fmt:formatDate value="${today}" type="both" dateStyle='full' timeStyle="full" />
<hr>

<h2>패턴을 만들어 사용</h2>
현재 날짜 : <fmt:formatDate value="${today}" type="date" pattern="yyyy/MM/dd (E)" /> <br/>
현재 시각 : <fmt:formatDate value="${today}" type="time" pattern="(a) hh:mm:ss" />
<hr>

<h2> 수치 포맷</h2>
<fmt:formatNumber value="123456789" groupingUsed="true" /> <br />
<fmt:formatNumber value="1.234567" pattern="#.##" /> <br />
<fmt:formatNumber value="1.2" pattern="#.##" /> <br />
<fmt:formatNumber value="1.2" pattern="#.00" />

<hr>
<h2>tpye 속성으로 백분율, 통화기호 표시 처리함</h2>
<fmt:formatNumber value="0.12" type="percent"/> <br />
<fmt:formatNumber value="123456789" type="currency" /> <br />
<fmt:formatNumber value="123456789" type="currency" currencySymbol="$" /> <br />

<h2> 시간대 설정 : timeZone 태그 또는 setTimeZone 사용</h2>
한국 현재 시간 : <fmt:formatDate value="${today}" type="both"/><br>
뉴욕 현재 시간 : <fmt:timeZone value="America/New_York">
							<fmt:formatDate value="<%= new java.util.Date() %>" type="both" /><br>
						</fmt:timeZone>
런던 현재 시간 : <fmt:timeZone value="Europe/London">
	<fmt:formatDate value="<%= new java.util.Date() %>" type="both"/>
</fmt:timeZone>
<hr>

<h2>다른 페이지로 한글을 넘길 때의 인코딩 처리</h2>
<form action="testEncording.jsp" method="post">
전송값 : <input type="text" name="test"><br>
<input type="submit" value="전송하기">
</form>

</body>
</html>