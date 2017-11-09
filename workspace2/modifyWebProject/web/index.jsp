<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url: "/mweb/btop3",
			type: "get",
			dataType: "json",
			success: function(data){
				var json = JSON.parse(JSON.stringify(data));
				var values = "";
				for(var i in json.list){
					values += "<tr><td><a href='/mweb/bdetail?bnum=" +
							json.list[i].bnum + "&page=1'>" +
							decodeURIComponent(json.list[i].btitle) +
							"</a></td></tr>";
				}
				
				$('#toplist').html(values);
			}
		});
	});
</script>
</head>
<body>
<c:import url="header.jsp"/>
<hr>
<section>
<!-- 본문영역 : ajax 이용 게시글 조회수 top3 원글 조회 출력 처리 -->
<table id="toplist" border="1" cellspacing="0" width="500" bgcolor="yellow">
</table>


</section>
<hr>
<c:import url="footer.html"/>
</body>
</html>





