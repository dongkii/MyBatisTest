<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board, java.sql.Date, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%
	Board board = (Board)request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetailView</title>
</head>
<body>
<c:set var="board" value="${ requestScope.board }"/>
<c:set var="currentPage" value="${ requestScope.currentPage }"/>
<c:import url="../../header.jsp"/>
<hr style="clear:both;">
<h2 align="center">${ board.boardNum }번 게시글 상세보기</h2>
<br>
<table align="center" cellspacing="0" cellpadding="10" border="1" width="500">
<tr><th>제목</th><td>${ board.boardTitle }</td></tr>
<tr><th>작성자</th><td>${ board.boardWriter }</td></tr>
<tr><th>첨부파일</th>
	<td>
	<c:if test="${ empty board.boardOriginalFileName }">
		첨부파일 없음
	</c:if>
	<c:if test="${ not empty board.boardOriginalFileName }">
	<c:url var="bf" value="/bfdown">
		<c:param name="ofile" value="${ board.boardOriginalFileName }"/>
		<c:param name="rfile" value="${ board.boardRenameFileName}"/>
	</c:url>
	<a href="${bf }">
		${ board.boardOriginalFileName }
	</a>
	</c:if>
	</td>
</tr>
<tr><th>내용</th><td>${ board.boardContent }</td></tr>
<tr><td colspan="2" align="center">
<c:if test="${ not empty sessionScope.member }">
	<c:url var="boardReploy" value="/views/board/boardReployForm.jsp">
		<c:param name="bnum" value="${ board.boardNum }"/>
		<c:param name="page" value="${ currentPage }"/>
	</c:url>
	<a href="${boardReploy }">[댓글달기]</a>
	<c:if test="${ sessionScope.member.memberId eq board.boardWriter }">
	<c:url var="bupview" value="/bupview">
		<c:param name="bnum" value="${ board.boardNum }"/>
		<c:param name="page" value="${ currentPage }"/>
	</c:url>
	<a href="${bupview }">[수정페이지로 이동]</a>
	&nbsp;
	<c:url var="bdelete" value="/bdelete">
		<c:param name="bnum" value="${ board.boardNum }"/>
	</c:url>
	<a href="${ bdelete }">[삭제]</a>
	</c:if>
</c:if>
&nbsp; 
<c:url var="preb" value="/blist">
	<c:param name="page" value="${ currentPage }"/>
</c:url>
<a href="${ preb}">[목록]</a>
</td></tr>
</table>
<br>
<hr>
<c:import url="../../footer.html"/>
</body>
</html>











