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
		alert("확인");
		var id = $('#id').val();
		var password = $('#password').val();

		$.ajax({
			type : "POST",
			url : 'login.do',
			data : {
				id : id,
				password : password
			},//실행안됨
			success : function(data) {
				if (data == "false")
					alert('잘못된 아이디이거나, 비밀번호가 틀렸습니다.');
				else
					alert('로그인에 성공하였습니다.');
					location.href = "home.do"; //로그인하면 home.do로 돌아가시면 됩니다.
			}
		});
	}
</script>
</head>
<body>
	<form id="loginForm" method="post">
		<fieldset>
			<legend>로그인</legend>
			아이디 : <input type="text" id="id" name="id" /> <br /> 
			비밀번호 : <input type="password" id="password" name="password" />
			<!-- vo와 같게 해야되는지 password는 password id는 id -->
			<input type="button" value="로그인" onclick="submitCheck()" />
		</fieldset>
	</form>
</body>
</html>