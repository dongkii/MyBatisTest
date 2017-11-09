<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testEncording.jsp</title>
</head>
<body>
<h2>인코딩 처리 확인 페이지</h2>
<fmt:requestEncoding value="utf-8"/><!-- request.setCharacterEncording("utf-8"); 과 같음 -->
전송온 값 test : ${param.test }
</body>
</html>