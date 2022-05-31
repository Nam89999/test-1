<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script	
	  src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
<script type="text/javascript">

		
		$(document).ready(()=>{
			
			$("#modify").click(()=>{
			
		var id = $('#id').val();//value 약자
		var name = $('#name').val();
		var age = $('#age').val();
		var email = $('#email').val();
		var phone = $('#phone').val();


		$.ajax({
			type : "POST",
			url : 'memberModify.do', // 설정에 따라서 앞에 '/' 유무를 정해준다.
			data : { //이런 형식을 보내면 제이슨 형태로 알아서 바꿔서 보낸다. 왼쪽이 'key'(vo값을 맞춤) : 'value'( 클라이언트가 입력한 변수값)
				id : id,
				name : name,
				age : age,
				email : email,
				phone : phone
			},
			success : function(response) {
				if (response == "false")
					alert('수정 실패, 다시 한번 도전하세요');
				else
				 	alert('수정 성공');
				     location.href = "readMember.do";
				    //제자리로 두기 위해서 안보내도 된다.
				    //upgrade 고정된 회원정보를 볼 수 있게 할 수 있나?
			}
		});
			});
		});
	
</script>
</head>
<body>

	<div class="container">
		<h2>회원 정보 수정</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Member Modify Page</div>
			<div class="panel-body">
					<div class="form-group">
						<label>id</label> <input type="text" class="form-control"
							id="id" value="${memberInfo.id}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>name</label> <input type="text" class="form-control"
							id="name" value="${memberInfo.name}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>age</label> <input type="text" class="form-control"
							id="age" value="${memberInfo.age}">
					</div>
					<div class="form-group">
						<label>email</label> <input type="email" class="form-control"
							id="email" value="${memberInfo.email}">
					</div>
					<div class="form-group">
						<label>phone</label> <input type="phone" class="form-control"
							id="phone" value="${memberInfo.phone}">
					</div>
					<button type="submit" class="btn btn-primary" id="modify">회원 수정</button>
					<button id="remove" type="button" class="btn btn-danger">회원 삭제</button>
			       </div>
			<div class="pannel-footer">근주</div>
		</div>
	</div>
</body>
</html>