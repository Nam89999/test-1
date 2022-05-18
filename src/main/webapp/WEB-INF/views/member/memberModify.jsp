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
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>회원 정보 수정</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Member Modify Page</div>
    <div class="panel-body">
  <form action="<c:url value='/memberModify.do'/>" method="post">
    <div class="form-group">
    <label>id</label>
    <input type="text" class="form-control" name="id" value="${memberInfo.id}" readonly="readonly">
  </div>
    <div class="form-group">
    <label>name</label>
    <input type="text" class="form-control" name="name" value="${memberInfo.name}" readonly="readonly">
  </div>
  <div class="form-group">
    <label>age</label>
    <input type="text" class="form-control" name="age" value="${memberInfo.age}">
  </div>
  <div class="form-group">
    <label>email</label>
    <input type="email" class="form-control" name="email" value="${memberInfo.email}">
  </div>
  <div class="form-group">
    <label>phone</label>
    <input type="phone" class="form-control" name="phone" value="${memberInfo.phone}">
  </div>
  <button type="submit" class="btn btn-primary">회원 수정</button>
  <button id="remove" type="button" class="btn btn-danger">회원 삭제</button>
</form>
    </div>
  <div class="pannel-footer">근주</div>
</div>
</div>
</body>
</html>