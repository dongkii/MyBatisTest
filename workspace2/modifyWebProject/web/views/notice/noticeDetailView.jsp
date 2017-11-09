<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- 
<%
   Notice notice = (Notice) request.getAttribute("notice");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetailView</title>
</head>
<body>
   <c:import url="../../header.jsp"/> 
   <c:set var="notice" value="${requestScope.notice}"/>
   <hr>
   <h2 align="center">${notice.noticeNo }번 공지글 상세보기
   </h2>
   <br>
   <table border="1" cellspacing="0" width="600" align="center">
      <tr>
         <th>제목</th>
         <td>${notice.noticeTitle }</td>
      </tr>
      <tr>
         <th>작성자</th>
         <td>${notice.noticeWriter }</td>
      </tr>
      <tr>
         <th>작성날짜</th>
         <td>${notice.noticeDate }</td>
      </tr>
      <tr>
         <th>첨부파일</th>
         <td>
         <c:if test="${not empty notice.originalFileName}">
            <c:url var="fdownVal" value="fdown">
               <c:param name="oname" value="${notice.originalFileName }"/>
               <c:param name="rname" value="${notice.renameFileName }"/>
            </c:url>
            <a href="${fdownVal }">${notice.originalFileName }</a>
         </c:if>
         <c:if test="${empty notice.originalFileName }">
            첨부파일 없음
         </c:if>
         </td>
      </tr>
      <tr>
         <th>조회수 </th>
            <td>${notice.readCount }</td>
      </tr>
      <tr>
         <th>내용</th>
         <td>${notice.noticeContent }</td>
      </tr>
      <c:if test="${notice.noticeWriter eq sessionScope.member.memberId }">
      <tr>
         <th colspan="2">
            <c:url var="nupview" value="nupview">
               <c:param name="no" value="${notice.noticeNo }"/>
            </c:url>
            <a href="${nupview }">수정페이지로 이동</a> &nbsp; &nbsp; &nbsp;
            <c:url var="ndel" value="ndel">
               <c:param name="no" value="${notice.noticeNo }"/>
            </c:url>
            <a href="${ndel }">삭제하기</a>
         </th>
      </tr>
      </c:if>
      <%-- <%}else { %>
      
      <%} %> --%>
      <tr>
         <th colspan="2"></th>
      </tr>
   </table>
   <br>
   <div align="center">
      <c:url var="nlist" value="nlist"/>
      <a href="${nlist}">목록보기로 이동</a>
   </div>
   <hr>
   <c:import url="../../footer.html" />
</body>
</html>