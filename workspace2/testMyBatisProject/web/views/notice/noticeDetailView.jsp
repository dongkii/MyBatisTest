<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetailView</title>
</head>
<body>
	<c:import url="../../header.jsp" />
	<session>
		<h2 align="center">${notice.noticeNo}번 공지글 상세보기</h2><br>
<table border="1" cellspacing="0" width="600" align="center">
	<tr><th>제목</th><td>${notice.noticeTitle}</td></tr>
	<tr><th>작성자</th><td>${notice.noticeWriter}</td></tr>
	<tr><th>작성날짜</th><td>${notice.noticeDate}</td></tr>
	<tr><th>첨부파일</th>
		<td>
		<c:if test="${!empty notice.originalFileName }">
		<a href="/testm/fdown?oname=${notice.originalFileName}&rname=${notice.renameFileName}">${notice.originalFileName}</a>
		</c:if>
		<c:if test="${empty notice.originalFileName }">첨부파일 없음</c:if>
		</td>
	</tr>
	<tr><th>조회수</th><td>${notice.readCount}</td></tr>
	<tr><th>내용</th><td>${notice.noticeContent}</td></tr>
	<c:if test="${notice.noticeWriter eq sessionScope.member.memberId }">
	<tr><th colspan="2">
		<a href="/testm/nupview?no=${notice.noticeNo}">수정페이지로 이동</a> &nbsp;
		<a href="/testm/ndel?no=${notice.noticeNo}">삭제하기</a>
	</th></tr>
	</c:if>
</table>
<br>
<div align="center">
	<a href="/testm/nlist">목록보기로 이동</a>
</div>
<br><br>
<hr>
<c:import url="../../footer.jsp" />
</body>
</html>















