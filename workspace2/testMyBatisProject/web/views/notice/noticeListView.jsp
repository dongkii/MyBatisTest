<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*, notice.model.vo.Notice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeListView</title>
<script type="text/javascript">
	function insertPage(){
		location.href="views/notice/noticeWriteForm.jsp";
	}
</script>
</head>
<body>
<c:import url="../../header.jsp" />
<h2 align="center">공지사항</h2>
<br><br>
<div align="center">
	<button onclick="insertPage();">글쓰기</button>
</div>
<br><br>
<div align="center">
	<form action="/testm/nsearch" method="post">
	<input type="search" autocomplete name="keyword" length="50"> &nbsp;
	<input type="submit" value="제목검색">
	</form>
</div>
<br><br>
<table align="center" width="600" border="1" cellspacing="0">
<th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>첨부파일</th>
<th>조회수</th>
<c:forEach items="${list}" var="notice" varStatus="st">
	<tr height="30">
	<td align="center">${notice.noticeNo}</td>
	<td>
	<c:if test="${!empty sessionScope.member }">
		<a href="/testm/ndetail?no=${notice.noticeNo}">
			${notice.noticeTitle}
		</a>
	</c:if>
	<c:if test="${empty sessionScope.member }">
		${notice.noticeTitle}
	</c:if>
	</td>
	<td align="center">${notice.noticeWriter}</td>
	<td align="center">${notice.noticeDate}</td>
	<td align="center">
	<c:choose>
	<c:when test="${!empty notice.originalFileName}">
		◎
	</c:when>
	<c:otherwise>
		&nbsp;
	</c:otherwise>
	</c:choose>
	</td>
	<td align="center">${notice.readCount}</td>
	</tr>
</c:forEach>
</table>
<br><br>
<div align="center">
	<a href="/testm/index.jsp">시작페이지로 이동</a>
</div>
<br>
<hr>
<c:import url="../../footer.jsp" />
</body>
</html>

















