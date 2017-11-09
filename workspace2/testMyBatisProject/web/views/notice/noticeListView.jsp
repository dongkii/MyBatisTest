<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.*, notice.model.vo.Notice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<%-- <%@ include file="../../header.jsp" %> --%>
<c:import url="../../header.jsp"/>
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
<%-- <%  while(entryIter.hasNext()){
		Map.Entry<Integer, Notice> entry = entryIter.next();
		Integer key = entry.getKey();
		Notice notice = entry.getValue(); 
		
	for(Notice notice : list){
%> --%>
<c:set var="list" value="${ requestScope.list }"/>
<c:forEach var="notice" items="${ list }"> 
	<tr height="30">
	<td align="center">${notice.noticeNo}</td>
	<td>
		<c:if  test="${ not empty sessionScope.member }">
			<c:url var="ndetail" value="ndetail">
				<c:param name="no" value="${ notice.noticeNo }"/>
			</c:url>
			<a href="${ ndetail }">
				${ notice.noticeTitle }
			</a>
		</c:if>
		<c:if test="${ empty sessionScope.member  }">
			${ notice.noticeTitle }
		</c:if>
	</td>
	<td align="center">	${ notice.noticeWriter }
	</td>
	<td align="center">
		${ notice.noticeDate }
	</td>
	<td align="center">
		<c:if test="${ not empty  noitce.originalFileName }">
			◎
		</c:if>
		<c:if test="${ empty notice.originalFileName }">
			&nbsp
		</c:if>
	</td>
	<td align="center"><%-- <%= notice.getReadCount() %> --%>
		${ notice.readCount }
	</td>
	</tr>
</c:forEach>
</table>
<br><br>
<div align="center">
	<c:set var="index" value="/testm/index.jsp"/>
	<a href="${index }">시작페이지로 이동</a>
</div>
<br>
<hr>
<c:import url="../../footer.html"/>
</body>
</html>

















