<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function submitCheck() {
		var id = $('#id').val();
		var password = $('#password').val();

		$.ajax({
			type : "POST",
			url : 'login.do',
			data : {//이런 형식을 보내면 제이슨 형태로 알아서 바꿔서 보낸다.
				id : id,
				password : password
			},
			success : function(response) {
				if (response == "false"){
					alert('잘못된 아이디이거나, 비밀번호가 틀렸습니다.');
				    //질문: 틀려도 홈으로 돌아갑니다요..	
				} else{
					alert('로그인에 성공하였습니다.');
					location.href = "home.do"; //로그인하면 home.do로 돌아가시면 됩니다.	
				}
			}
		});
	}
	
	/* $(document).ready(()=>{
		// $(document).ready 문서가 준비되면 매개변수로 넣은 콜백 함수를 실행하라는 의미입니다.
		// $(function(){}); 같은 의미이다.
		// modify를 누르면 일단 게시물 id(idx)를 받아와야한다. 2.modify.do로 보내버린다. 3.게시판 id를 가지고 가야한다.
		
		location.href="<c:url value='/boardModify.do'/>?bno=${boardInfo.boardnum}";//get 방식
		
		
		alert("${msg}")
  		}); */
	
</script>
</head>
<body>
	<form id="loginForm" method="post">
		<fieldset>
			<legend>로그인</legend>
			아이디 : <input type="text" id="id" name="id" /> <br /> 
			비밀번호 : <input type="password" id="password" name="password" />
			<input type="button" value="로그인" onclick="submitCheck()" />
		</fieldset>
		<a href="join.do">회원가입 </a>
	</form>
</body>
</html>