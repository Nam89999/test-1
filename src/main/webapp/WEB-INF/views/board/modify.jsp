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
  <script type="text/javascript">
      $(document).ready(()=>{
    	 $("#list").click(()=>{
    		 location.href="<c:url value='/readBoardList.do'/>";
    	 }); 
    	 
    	 //삭제
    	 
    	 $("#remove").click(()=>{
    		var idx=
    			
       		 location.href="<c:url value='/remove.do'/>?bno=${board.idx}";
    		 
    	 });
    	  
    	  
      });
      
  	$(document).ready(()=>{
  		
  		$("#modify").click(()=>{
  			alert("확인");
  	    	var boardnum = $('#boardnum').val();
  			var title = $('#title').val();
  	    	var contents = $('#contents').val();
  			var num = $('#num').val();
  			
  			$.ajax({
  				type : "POST",
  				url : 'boardModify.do',
  				data : {
  					boardnum : boardnum,
  					title : title,
  					contents : contents,
  					num : num
  				},
  				success : function(response) {
  					if (response == "success"){
  						alert("게시물 수정 성공하였습니다.");
  						location.href="/readBoardList.do"
  						
  						//질문-Ajax에서도 Redirect가 가능한가?

  					}//'', "" 를 써도 무관하다.
  					else {
  						if(response != ''){
  							alert(response)
  						}else{
  							alert("게시물 수정 실패하였습니다.");						
  						}

  						//location.href="/readBoardList.do"
  						location.href="<c:url value='/boardContents.do'/>?bno=${boardInfo.boardnum}";
  					}
  						
  				      //"<c:url value='/readBoardList.do'/>" 차이점은 무엇인가 없다면 왜 c태그를 사용하나?
  					  //가입 성공하면 로그인을 하여라.
  				}
  			});
		});
	  
  	});
  
  </script>
</head>
<body>
 
<div class="container">
  <h2>Board Modify Page</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Board Modify Page</div>
    <div class="panel-body">
    <div class="form-group">
     <label>Bno</label>
     <input type="text" class="form-control" name="boardnum" id="boardnum" value="${boardInfo.boardnum}" readonly="readonly">
  </div>
  <div class="form-group">
    <label>Title</label>
    <input type="text" class="form-control" value="${boardInfo.title}" id="title" name="title">
  </div>
  <div class="form-group">
    <label>Text area</label>
	<textarea rows="3" class="form-control" id="contents" name="contents">${boardInfo.contents}</textarea>
  </div>
  <div class="form-group">
    <label>writer</label>
    <input type="hidden" class="form-control" id="num" name="num" value="${boardInfo.num}" readonly="readonly">
    <input type="text" class="form-control" value="${boardInfo.writer}" readonly="readonly"> 
  </div>
  <button type="submit" class="btn btn-primary" id="modify">수정</button>
  <button id="remove" type="button" class="btn btn-danger">삭제</button>
  <button id="list" type="button" class="btn btn-info">리스트</button>
    </div>
  <div class="pannel-footer"> 화이팅!</div>
</div>
</div>
</body>
</html>