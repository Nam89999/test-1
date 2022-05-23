<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function submitSignUp() {
		alert("확인");
		var id = $('#id').val();
		var password = $('#password').val();
		var name = $('#name').val();
		var age = $('#age').val();
		var email = $('#email').val();
		var phone = $('#phone').val();

		$.ajax({
			type : "POST",
			url : 'join.do',
			data : {
				id : id,
				password : password,
				name : name,
				age : age,
				email : email,
				phone : phone
			},
			success : function(response) {
				if (response == "false")
					alert("회원가입이 실패하였습니다."); //'', "" 를 써도 무관하다.
					// 질문:왜 자동적으로 home.do로 이동하는가?
				else
					alert("회원가입 성공하였습니다.");
				 location.href = "login.do"; //가입 성공하면 로그인을 하여라.
			}
		});

	}
</script>
</head>
<body>
	회원가입화면
	<form id="signFrm" name="signFrm" method="post">
		<table class="table table-bordered">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id" name="id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name" /></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" id="age" name="age" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="email" name="email" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" id="phone" name="phone" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" id="join" value="회원가입" class="btn btn-primary" onclick="submitSignUp()" /> 
			    <input type="reset" value="취소" class="btn btn-warning" /></td>
			</tr>
		</table>
	</form>



</body>
</html>