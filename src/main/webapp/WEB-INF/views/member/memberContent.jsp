<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>\
  <script type="text/javascript">
  
	$(document).ready(()=>{
		// $(document).ready 문서가 준비되면 매개변수로 넣은 콜백 함수를 실행하라는 의미입니다.
		// $(function(){}); 같은 의미이다.
		// modify를 누르면 일단 게시물 id(idx)를 받아와야한다. 2.modify.do로 보내버린다. 3.게시판 id를 가지고 가야한다. 
		$("#modify").click(()=>{
			location.href="<c:url value='/memberModify.do'/>";
		});
  		});
  </script>
    		<!--?num 이것은 무엇을 기준으로 적어주는가? DBorVO-->
</head>
<body>
 
<div class="container">
  <h2>내정보 보기</h2>
  <div class="panel panel-default">
    <div class="panel-heading">내정보 보기</div>
    <div class="panel-body">Panel Content
    <label>id</label>
    <input type="text" class="form-control" name="id" value="${ContentInfo.id}" readonly="readonly">
  </div>
  <div class="form-group">
    <label>name</label>
    <input type="text" class="form-control" name="name" value="${ContentInfo.name}" readonly="readonly">
  </div>
  <div class="form-group">
    <label>age</label><!-- int인데 text로 해도 상관없나? -->
    <input type="text" class="form-control" name="age" value="${ContentInfo.age}" readonly="readonly">
  </div>
  <div class="form-group">
    <label>email</label>
    <input type="text" class="form-control" name="email" value="${ContentInfo.email}" readonly="readonly">
  </div>
   <div class="form-group">
    <label>phone</label>
    <input type="text" class="form-control" name="phone" value="${ContentInfo.phone}" readonly="readonly">
  </div>
  <button id="modify" class="btn btn-default">회원 수정</button>
  <button id="list" class="btn btn-info">비밀번호 수정</button>
    </div>
    <div class="pane-footer">제발!</div>
  </div>
</div>

</body>
</html>