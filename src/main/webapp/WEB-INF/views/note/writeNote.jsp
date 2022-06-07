<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
/*
function sendingNote(){
	alert('확인');
	var title = $('#title').val();
    var recipientMembe$('#recipientMember').val();
	var content = $('#content').val();
    
    $.ajax({
		type : "POST",
		url : 'writeNote.do',
		data : {
			title : title,
			recipientMember: recipientMember, 
			content : content
		},
		success : function(response) {
			if (response == "fail"){
				alert("쪽지 보내기 실패.");
			}
			else{
				alert("쪽지 등록 성공.");
			 location.href = "note/noteList"; 
			}
		}
	});	
}
*/
function registerBoard(){
	alert('확인');
	var title = $('#title').val();
    var recipientMember = $('#recipientMember').val();
    var content = $('#content').val();
    
    $.ajax({
		type : "POST",
		url : 'writeNote.do',
		data : {
			title : title,
			recipientMember : recipientMember,
			content : content
		},
		success : function(response) {
			if (response == "fail"){
				alert("쪽지 전송 실패.");
			}
			else{
				alert("쪽지 전송 성공.");
			 location.href = "notebox.do"; 
			}
		}
	});

	
	
}


</script>
</head>
<body>
<div class="container">
  <h2>쪽지 쓰기</h2>
  <div class="panel panel-default">
    <div class="panel-heading">쪽지 쓰기</div>
    <div class="panel-body">
  <div class="form-group">
    <label>쪽지 제목</label>
    <input type="text" class="form-control" id="title">
  </div>
    <div class="form-group">
    <label>받는 이</label>
    <input type="text" class="form-control" id="recipientMember">
  </div>
  <div class="form-group">
    <label>내용</label>
	<textarea rows="3" class="form-control" id="content"></textarea>
  </div>
  <div class="form-group">
    <label>작성자</label>
    <input type="text" class="form-control" value="${senderMemberId}" readonly="readonly">
  </div>
  <c:if test="${sessionScope.memberNum!= null && sessionScope.memberNum!= ''}">
    <button type="submit" class="btn btn-default" onclick="registerBoard()">보내기</button>
  </c:if>
  <button type="reset" class="btn btn-default">취소</button>
    </div>
  <div class="pannel-footer">화이팅!</div>
</div>
</div>

</body>
</html>