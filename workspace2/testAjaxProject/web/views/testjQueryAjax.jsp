<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testjQueryAjax</title>
<style type="text/css">
	p {
		width: 300px;
		height: 50px;
		border: 1px solid red;
	}
</style>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>jQuery ajax() 함수를 이용한 ajax 처리</h1>
<hr>
<h2>1. 서버로 전송값 없고, 결과로 문자열 받아 출력 처리하는 방법</h2>
<p id="p1"></p>
<button onclick="test1();">테스트1</button>
<script type="text/javascript">
	function test1(){
		//컨트롤러로 서비스를 요청하고, 결과로 문자열을 받는 경우에는
		//jQuery.ajax("요청컨트롤러url", {전달이름: 전달값}, 리턴값 받아 처리할 콜백함수);
		//전송방식이 get 방식일 경우
		$.get("/testa/test1.do", function(data){
			$('#p1').text(data);
		});
		
		//또는
		$.ajax({url: "/testa/test1.do",
			  type: "get", 
			  success: function(data){
				  $('#p1').text($('#p1').text() + ", " + data);
			  },
			  error: function(data){
				  console.log("에러발생 : " + data);
			  }
		});	
		
	}
</script>
<hr>
<h2>2. 서버 컨트롤러로 값을 전송하고, 결과로 문자열을 받아 출력 처리하는 방법</h2>
<p id="p2"></p>
<button onclick="test2();">테스트2</button>
<script type="text/javascript">
	function test2(){
		//get 방식으로 전송시
		//jQuery.get() 과 jQuery.ajax() 두 가지중 선택 사용
		$.get("/testa/test2.do", 
			{userid: "user11", userpwd: "pass11"}, 
			function(data){
				$('#p2').text(data);
		});
		
		$.ajax({
			url: "/testa/test2.do",
			data: {userid: "user22", userpwd: "pass22"},
			type: "get",
			success: function(data){
				$('#p2').text($('#p2').text() + ", " + data);
			},
			error: function(data){
				console.log("에러발생 : " + data);
			}
		});
	}

</script>
<hr>
<h2>3. 서버 컨트롤러로 값들을 전송하고, 결과를 안 받는 경우 : post 방식</h2>
<button onclick="test3();">테스트3</button>
<script type="text/javascript">
	function test3(){
		//post 전송방식을 사용할 때
		//jQuery.post() 또는 jQuery.ajax() 둘 중 하나 선택 사용
		$.post("/testa/test3.do", 
			{title: '제목입니다.', writer: 'user22', content: '내용 문구입니다.'});
		
		$.ajax({
			url: "/testa/test3.do",
			data: {title: '제목입니다.', writer: 'user22', content: '내용 문구입니다.'},
			type: "post"
		});
	}
</script>
<hr>
<h2>4. 서버 컨트롤러로 값 전송하고, 결과로 JSON 객체를 받아 출력 처리하는 방법</h2>
<p id="p4"></p>
<button onclick="test4();">테스트4</button>
<script type="text/javascript">
	function test4(){
		//get 방식으로 전송할 경우
		//jQuery.getJSON() 과 jQuery.ajax() 둘 중 하나 선택 사용
		$.getJSON("/testa/test4.do", {no: "12"}, 
			function(data){
				//한글 깨짐을 막기 위해 문자 인코딩 처리한 json 객체의 값은
				//decodeURIComponent() 로 디코딩 처리해서 사용함
				$('#p4').text(data.userid + ", " + data.userpwd + ", "
						+ decodeURIComponent(data.username) + ", "
						+ data.age + ", " + data.email + ", " +
						data.phone);
		});
		
		$.ajax({
			url: "/testa/test4.do",
			data: {no: "15"},
			type: "get",
			dataType: "json", //리턴되는 결과 자료형 명시함
			success: function(data){
				$('#p4').html($('#p4').text() + "<br>"
						+ data.userid + ", " + data.userpwd + ", "
						+ decodeURIComponent(data.username) + ", "
						+ data.age + ", " + data.email + ", " +
						data.phone);
			},
			error: function(data){
				console.log("에러 발생 : " + data);
			}
		});
	}
</script>
<hr>
<h2>5. 서버로 서비스 요청하고, list 나 map 결과를 json 배열로 받아 출력 처리하는 방법</h2>
<p id="p5" style="width:500px;height:200px;border:1px solid red;"></p>
<button onclick="test5();">테스트5</button>
<script type="text/javascript">
	function test5(){
		//post 방식일 때는 jQuery.ajax() 만 사용할 수 있음		
		//get 방식일 때는 jQuery.getJSON() 과 jQuery.ajax() 둘 다 사용 가능
		/* $.getJSON("/testa/test5.do", {no: "t5"},
			function(data){
				//console.log(data);  //{"list", Array(5)}
				var jsonStr = JSON.stringify(data);
				//배열 객체를 문자열 형태로 바꿈
				//console.log(jsonStr);
				var json = JSON.parse(jsonStr);
				//문자열을 json 객체로 파싱함
				//console.log(json); //실제 자바스크립트 배열 객체로 바꾼 것임
				
				var values = "";
				for(var i in json.list){
					values += json.list[i].userid + ", " + json.list[i].userpwd
					     + ", " + decodeURIComponent(json.list[i].username)
					     + ", " + json.list[i].age + ", " + json.list[i].email
					     + ", " + json.list[i].phone + "<br>";
				}
				
				$('#p5').html(values);
		}); */
		
		$.ajax({
			url : "/testa/test5.do",
			data : {no : "t55"},
			type : "post",
			dataType : "json",
			success : function(data){
				//console.log(data);
				var jsonStr = JSON.stringify(data);  //객체를 문자열로 변환
				//console.log(jsonStr);
				var json = JSON.parse(jsonStr); //문자열을 배열 객체로 바꿈
				
				var values = $("#p5").html();
				
				for(var i in json.list){
					//한글 깨짐을 막기 위해 문자 인코딩 처리한 json 객체의 값은 decodeURIComponent() 로 디코딩 처리함
					values += json.list[i].userid + ", " + json.list[i].userpwd + ", " + 
							decodeURIComponent(json.list[i].username) + 
							", " + json.list[i].age + ", " + json.list[i].email + ", " + 
							json.list[i].phone + "<br>";
				}
				
				$("#p5").html(values);
			}
		});
	}
</script>

</body>
</html>













