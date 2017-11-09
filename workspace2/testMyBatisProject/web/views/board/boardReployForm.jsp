<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardReployForm</title>
</head>
<body>
<c:import url="../../header.jsp"/>
<hr style="clear:both;">
<h2 align="center">${ param.bnum } 번글 댓글달기</h2>
<br>
<form action="/testm/breply" method="post">
	<input type="hidden" name="page" value="${ param.page }">
	<input type="hidden" name="bnum" value="${ param.bnum }">
	
	<table align="center" cellspacing="0" border="1" width="500">
	<tr><th>제목</th><td><input type="text" name="btitle"></td></tr>
	<tr><th>작성자</th>
	<td>
	<input type="text" name="bwriter" value="${ sessionScope.member.memberId }" readonly></td></tr>
	<tr><th>내용</th><td><textarea name="bcontent" rows="7" cols="50"></textarea></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="댓글등록"> &nbsp;
		<a href="javascript:history.go(-1);">이전 페이지로</a>
	</th></tr>
	</table>
</form>
	<c:url var="blist" value="/blist">
		<c:param name="page" value="${ param.page }"/>
	</c:url>
<h4 align="center"><a href="${blist }">목록</a></h4>
<br>

<c:import url="../../footer.html"></c:import>
</body>
</html>














