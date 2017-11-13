<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test Page</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#btnSend").on('click', function() {
			var num1 = $("#num1").val();
			var num2 = $("#num2").val();
			var oper = $("#oper").val();

			var url = "/test/calc.do";
			var query = "n1=" + num1 + "&n2=" + num2;
			query += "&oper=" + oper;

			$.ajax({
				type : "POST",
				url : url,
				data : query,
				dataType : "json",
				success : function(data) {
					$("#result").html(data.result);
					$("#num1").val("");
					$("#num2").val("");
					$("#oper").val("add");
				},
				error : function(e) {
					alert(e.responseText);
				}
			});
		});
	});
</script>
</head>
<body>

	<input type="text" id="num1">
	<select id="oper">
		<option value="add">더하기</option>
		<option value="sub">빼기</option>
		<option value="mul">곱하기</option>
		<option value="div">나누기</option>
	</select>
	<input type="text" id="num2">
	<input type="button" value=" = " id="btnSend">
	<hr>
	<div id="result"></div>
	<br><br>
 <a href='/test/index.html'>이전으로 가기</a>
</body>
</html>