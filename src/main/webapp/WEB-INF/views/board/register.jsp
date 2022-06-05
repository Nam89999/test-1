<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
function registerBoard(){
	alert('확인');
	var title = $('#title').val();
    var contents = $('#contents').val();
    var num= $('#num').val();
    
    $.ajax({
		type : "POST",
		url : 'registerBoard.do',
		data : {
			title : title,
			contents : contents,
			num : num
		},
		success : function(response) {
			if (response == "false"){
				alert("게시물 등록 실패.");
			}
			else{
				alert("게시물 등록 성공.");
			 location.href = "readBoardList.do"; 
			}
		}
	});

	
	
}




</script>
</head>
<body>
 
<div class="container">
  <h2>Board Register</h2>
  <div class="panel panel-default">
    <div class="panel-heading">게시판 올리기</div>
    <div class="panel-body">
  <div class="form-group">
    <label>Title</label>
    <input type="text" class="form-control" id="title">
  </div>
  <div class="form-group">
    <label>Text area</label>
	<textarea rows="3" class="form-control" id="contents"></textarea>
  </div>
  <div class="form-group">
    <label>writer</label>
    <input type="hidden" class="form-control" id="num" readonly="readonly">
    <input type="text" class="form-control" value="${memberId}" readonly="readonly">
  </div>
    <button type="submit" class="btn btn-default" onclick="registerBoard()">등록</button>
  <c:if test="${sessionScope.memberNum!= null && sessionScope.memberNum!= ''}">
  <button type="submit" class="btn btn-default" id="registerBoard">등록</button>
  </c:if>
  <button type="reset" class="btn btn-default">취소</button>
    </div>
  <div class="pannel-footer">인프런 화이팅!</div>
</div>
</div>
</body>
</html>
