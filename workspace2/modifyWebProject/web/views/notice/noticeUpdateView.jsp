<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeUpdateView</title>
</head>
<body>
<c:set var="notice" value="${ requestScope.notice }"/>
<c:import url="../../header.jsp "/>
<hr>
<br>
<h2 align="center">${ notice.noticeNo }번 공지글 수정 페이지</h2>
<br>
<section align="center">
	<form action="/mweb/nupdate" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${ notice.noticeNo }">
	<table align="center" width="600">
	<tr><th width="150" bgcolor="gray">제목</th>
		<td align="left"><input type="text" name="title" value="${notice.noticeTitle }"></td>
	</tr>
	<tr><th width="150" bgcolor="gray">작성자</th>
		<td align="left"><input type="text" name="writer" value="${notice.noticeWriter }" readonly></td>
	</tr>
	<tr><th width="150" bgcolor="gray">첨부파일</th>
	    <td align="left">
	    <c:if test="${not empty notice.originalFileName || not empty notice.renameFileName  }">
	    <input type="file" name="file" value="${ notice.originalFileName }">
	    </c:if>
	    <c:if test="${ empty notice.originalFileName && empty notice.renameFileName }">
	    <input type="file" name="file">
	    </c:if>
	    </td>
	</tr>
	<tr><th width="150" bgcolor="gray">내용</th>
		<td align="left">
			<textarea rows="5" cols="50" name="content">
				${ notice.noticeContent }
			</textarea>
		</td>
	</tr>
	<tr><th width="150" bgcolor="gray" colspan="2">
		<input type="submit" value="수정하기"> &nbsp;
		<input type="reset" value="취소하기">
	</th></tr>
	</table>
	</form>
	<br>
	<c:set var="nl" value="/mweb/nlist"/>
	<a href="${nl }">목록으로 이동</a>
</section>

<br>
<hr>
<c:import url="../../footer.html"/>
</body>
</html>