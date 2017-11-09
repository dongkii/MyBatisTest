<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- page 지시자 태그는 한 페이지에 한 개만 사용이 원칙임
     예외로 import 속성에 대해서만 따로 작성할 수 있음. --%>
<%@ page import="board.model.vo.Board, java.util.ArrayList, java.sql.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<c:set var="list" value="${ requestScope.list }"/>
<c:set var="listCount" value="${ requestScope.listCount }"/>
<c:set var="currentPage" value="${ requestScope.currentPage }"/>
<c:set var="startPage" value="${ requestScope.startPage }"/>
<c:set var="endPage" value="${ requestScope.endPage }"/>
<c:set var="maxPage" value="${ requestScope.maxPage }"/>
<c:import url="../../header.jsp"/>
<hr style="clear:both">
<h2 align="center">게시글 목록</h2>
<h3 align="center">총 게시글 갯수 : ${ listCount }</h3>
<br>
<c:if test="${ not empty sessionScope.member }">
	<div align="center">
	<button onclick="showWriteBoard();">글쓰기</button>
	</div>
</c:if>
<br>
<table align="center" border="1" cellspacing="0" width="700">
<tr bgcolor="gray"><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th>
   <th>첨부파일</th></tr>
<c:forEach var="b" items="${ list }">
<tr>
	<td align="center">${ b.boardNum }</td>
	<td>
	<%-- 답글일 때는 들여쓰기하면서 앞에 ▶ 표시함 --%>
		<c:if test="${ b.boardLevel eq 1 }">
		&nbsp; &nbsp; ▶
		</c:if>
		<c:if test="${ b.boardLevel eq 2 }">
		&nbsp; &nbsp; &nbsp; &nbsp; ▶▶
		</c:if>
	<%-- 로그인한 경우 상세보기 가능하게 처리함 --%>
		<c:if test="${ not empty sessionScope.member }">
		<c:url var="bdetail" value="/bdetail">
			<c:param name="bnum" value="${b.boardNum }"/>
			<c:param name="page" value="${currentPage }"/>
		</c:url>
			<a href="${bdetail }">
			${ b.boardTitle }
			</a>
		</c:if>
		<c:if test="${ empty sessionScope.member }">
			${ b.boardTitle }
		</c:if>
	</td>
	<td align="center">${ b.boardWriter }</td>
	<td align="center">${ b.boardDate }</td>
	<td align="center">${ b.boardReadCount }</td>
	<td align="center">
		<c:if test="${ not empty b.boardOriginalFileName }">
			◎
		</c:if>
		<c:if test="${ empty b.boardOriginalFileName }">
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
<c:if test="${ currentPage <= 1 }">
	[이전] &nbsp;
</c:if>
<c:if test="${ currentPage > 1 }">
	<c:url var="bpre" value="/blist">
		<c:param name="page" value="${ currentPage - 1 }"/>
	</c:url>
	<a href="${bpre }">[이전]</a>
</c:if>
<%-- 현재 페이지 숫자 보여주기 --%>
<c:forEach var="cnt" begin="${ startPage }" end="${ endPage }" step="1">
	<c:if test="${ currentPage eq cnt }">
	<b><font size="4" color="red">[${cnt }]</font></b>
	</c:if>
	<c:if test="${ currentPage != cnt  }">
		<c:url var="bl" value="/blist">
			<c:param name="page" value="${cnt }"/>
		</c:url>
	<a href="${ bl }">${cnt }</a>
</c:if>
</c:forEach>
<%-- 현재 페이지 다음 페이지에 대한 처리 --%>
<c:if test="${ currentPage >= maxPage }">
	[다음]
</c:if>
<c:if test="${ currentPage < maxPage }">
	<c:url var="blist" value="/blist">
		<c:param name="page" value="${currentPage + 1 }"/>
	</c:url> 
	<a href="${ blist }">[다음]</a>
</c:if>
</div>


<br><br><br>
<c:import url="../../footer.html"/>
</body>
</html>









