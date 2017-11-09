<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdateView</title>
</head>
<body>
<c:import url="../../header.jsp"/>
<c:set var="board" value="${ requestScope.board }"/>
<c:set var="currentPage" value="${ requestScope.currentPage }"/>
<hr style="clear:both;">
<br>
<h2 align="center">${ board.boardNum } 번글 수정페이지</h2>
<c:if test="${ board.boardLevel == 0 }">
<form action="/mweb/bupdate0" method="post" enctype="multipart/form-data">
<input type="hidden" name="bnum" value="${ board.boardNum }">
<input type="hidden" name="ofile" value="${ board.boardOriginalFileName }">
<input type="hidden" name="rfile" value="${ board.boardRenameFileName }">
<input type="hidden" name="page" value="${ currentPage }">

<table align="center" border="1" cellspacing="0" width="700">
<tr><th>제목</th><td><input type="text" name="btitle" value="${ board.boardTitle }"></td></tr>
<tr><th>작성자</th>
<td><input type="text" readonly name="bwriter" value="${ board.boardWriter }"></td></tr>
<tr><th>첨부파일</th>
<td>
<c:if test="${ not empty board.boardOriginalFileName }">
	${ board.boardOriginalFileName }
</c:if>
<br>
<input type="file" name="upfile"></td></tr>
<tr><th>내용</th><td><textarea cols="50" rows="7" name="bcontent">${ board.boardContent }</textarea></td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="수정하기">	
	</td>
</tr>
</table>
</form>
</c:if>
<c:if test="${ board.boardLevel != 0 }">
<form action="/mweb/bupdate1" method="post">
<input type="hidden" name="bnum" value="${ board.boardNum }">
<input type="hidden" name="page" value="${ currentPage }">

<table align="center" cellspacing="0" border="1" width="500">
<tr><th>제목</th><td><input type="text" name="btitle" value="${ board.boardTitle }"></td></tr>
<tr><th>작성자</th>
<td>
<input type="text" name="bwriter" value="${ board.boardWriter }" readonly></td></tr>
<tr><th>내용</th><td><textarea name="bcontent" rows="7" cols="50">${ board.boardContent }</textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="댓글수정">	
</th></tr>
</table>
</form>
</c:if>
<br>
<div align="center">
<c:url var="blist3" value="/mweb/blist">
	<c:param name="page" value="${ currentPage }"/>
</c:url>
<a href="${blist3 }">목록</a>
</div>
<c:import url="../../footer.html"/>
</body>
</html>













