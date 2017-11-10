<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="board.model.vo.Board, java.sql.Date, java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetailView</title>
</head>
<body>
<c:import url="../../header.jsp" />
<hr style="clear:both;">
<h2 align="center">${board.boardNum}번 게시글 상세보기</h2>
<br>
<table align="center" cellspacing="0" cellpadding="10" border="1" width="500">
<tr><th>제목</th><td>${board.boardTitle}</td></tr>
<tr><th>작성자</th><td>${board.boardWriter}</td></tr>
<tr><th>첨부파일</th>
	<td>
	<c:if test="${empty board.boardOriginalFileName }">
		첨부파일 없음
	</c:if>
	<c:if test="${!empty board.boardOriginalFileName}">
		<a href="/testm/bfdown?ofile=${board.boardOriginalFileName}&rfile=${board.boardRenameFileName}">
			${board.boardOriginalFileName}
		</a>
	</c:if>
	</td>
</tr>
<tr><th>내용</th><td>${board.boardContent}</td></tr>
<tr><td colspan="2" align="center">
<c:if test="${!empty sessionScope.member }">
	<a href="/testm/views/board/boardReployForm.jsp?bnum=${board.boardNum}&page=${currentPage}">[댓글달기]</a>
	<c:if test="${sessionScope.member.memberId eq board.boardWriter }">
		<a href="/testm/bupview?bnum=${board.boardNum }&page=${currentPage}">[수정페이지로 이동]</a>
			&nbsp; <a href="/testm/bdelete?bnum=${board.boardNum }">[삭제]</a>
	</c:if>
</c:if>
&nbsp; <a href="/testm/blist?page=${currentPage }">[목록]</a>
</td></tr>
</table>
<br>
<hr>
<c:import url="../../footer.jsp" />
</body>
</html>











