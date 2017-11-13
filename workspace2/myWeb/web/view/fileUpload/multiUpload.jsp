<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여러 파일 업로드 테스트</title>
</head>
<body>

<form action="/test/multiUpload.do" method="post" enctype="multipart/form-data">
첨부파일1 : <input type="file" name="uploadFile1"/><br/>
첨부파일2 : <input type="file" name="uploadFile2"/><br/>
첨부파일3 : <input type="file" name="uploadFile3"/><br/>
<input type="submit" value="전송"/>
</form>
<br>
	<a href='/test/index.html'>이전으로 가기</a>
</body>
</html>