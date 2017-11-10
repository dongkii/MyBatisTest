<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="board.model.vo.Board, java.util.ArrayList, java.sql.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardListView</title>
<script type="text/javascript">
	function showWriteBoard(){
		location.href = "views/board/boardWriteForm.jsp";
	}
</script>
</head>
<body>
<c:import url="../../header.jsp" />
<hr style="clear:both">
<h2 align="center">게시글 목록</h2>
<h3 align="center">총 게시글 갯수 : ${listCount}</h3>
<br>
<c:if test="${!empty sessionScope.member }">
	<div align="center">
	<button onclick="showWriteBoard();">글쓰기</button>
	</div>
</c:if>
<br>
<table align="center" border="1" cellspacing="0" width="700">
<tr bgcolor="gray"><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th>
   <th>첨부파일</th></tr>
<c:forEach items="${list}" var="b" varStatus="st">
<tr>
	<td align="center">${b.boardNum}</td>
	<td>
	<%-- 답글일 때는 들여쓰기하면서 앞에 ▶ 표시함 --%>
		<c:if test="${b.boardLevel eq 1}">
		&nbsp; &nbsp; ▶
		</c:if>	
		<c:if test="${b.boardLevel eq 2}">
		&nbsp; &nbsp; &nbsp; &nbsp; ▶▶
		</c:if>
	<%-- 로그인한 경우 상세보기 가능하게 처리함 --%>
		<c:if test="${!empty sessionScope.member }">
			<a href="/testm/bdetail?bnum=${b.boardNum}&page=${currentPage}">${b.boardTitle}</a>
		</c:if>
		<c:if test="${empty sessionScope.member }">
			${b.boardTitle}
		</c:if>
	</td>
	<td align="center">${b.boardWriter}</td>
	<td align="center">${b.boardDate}</td>
	<td align="center">${b.boardReadCount}</td>
	<td align="center">
		<c:if test="${!empty b.boardOriginalFileName}">
			◎
		</c:if>
		<c:if test="${empty b.boardOriginalFileName}">
			&nbsp;
		</c:if>
	</td>
</tr>
</c:forEach>

</table>
<br>
<%-- 페이지 번호 처리 --%>
<div align="center">
<%-- 이전 페이지 있을 경우에 대한 처리 --%>
<c:if test="${currentPage <= 1}">
	[이전] &nbsp;
</c:if>
<c:if test="${currentPage > 1}">
	<a href="/testm/blist?page=${currentPage-1 }">[이전]</a>
</c:if>
<%-- 현재 페이지 숫자 보여주기 --%>
<c:forEach var="p" begin="${startPage }" end="${endPage }">
<c:choose>
	<c:when test="${currentPage == p}">
		<b><font size="4" color="red">[${p}]</font></b>
	</c:when>
	<c:otherwise>
		<a href="/testm/blist?page=${p}">${p}</a>
	</c:otherwise>
</c:choose>
</c:forEach>
<%-- 현재 페이지 다음 페이지에 대한 처리 --%>
<c:choose>
	<c:when test="${currentPage >= maxPage}">
		[다음]
	</c:when>
	<c:otherwise>
		<a href="/testm/blist?page=${currentPage+1 }">[다음]</a>
	</c:otherwise>
</c:choose>
</div>
<br><br><br>
<c:import url="../../footer.jsp" />
</body>
</html>









