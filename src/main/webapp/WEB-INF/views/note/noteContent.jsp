<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
	$(document).ready(()=>{
		$("#list").click(()=>{
			location.href="<c:url value='/notebox.do'/>";
		});
		});
  </script>
</head>
<body>
	<div class="container">
		<h2>쪽지</h2>
		<div class="panel panel-default">
			<div class="panel-heading">쪽지 보기</div>
			<div class="panel-body">
			 <input type="hidden" class="form-control"
					id="boardnum" value="${noteContent.noteId}" readonly="readonly">
				<label>쪽지 제목</label> <input type="text" class="form-control"
					name="title" value="${noteContent.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea rows="3" class="form-control" name="contents"
					readonly="readonly">${noteContent.content}</textarea>
			</div>
			<div class="form-group">
				<label>보낸 사람 ID</label> <input type="hidden" class="form-control"
					name="num" value="${noteContent.senderNum}" readonly="readonly"> <input
					type="text" class="form-control" value="${noteContent.senderMember}"
					readonly="readonly">
			</div>
			<button id="list" class="btn btn-info">쪽지함으로 이동</button>
		</div>
		<div class="pane-footer">쪽지 끝</div>
	</div>

</body>
</html>