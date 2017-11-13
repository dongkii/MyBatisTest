<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 테스트</title>
</head>
<body>

<form action="/test/upload.do" method="post" enctype="multipart/form-data">

글쓴이 : <input type="text" name="name"/><br/>
제  목 : <input type="text" name="title"/><br/>
첨부파일 : <input type="file" name="uploadFile"/><br/>
<input type="submit" value="전송"/>
</form>
<br>
	<a href='/test/index.html'>이전으로 가기</a>
</body>
</html>
