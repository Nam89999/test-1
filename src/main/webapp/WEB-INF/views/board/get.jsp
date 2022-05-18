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
  <script type="text/javascript">   //준비가 되면은 $list가 클릭이 되면은 처리를 해라->list.do로 가도록
  	$(document).ready(()=>{
  		$("#list").click(()=>{
  			location.href="<c:url value='/list.do'/>";
  		});
  		//modify를 누르면 일단 게시물 id(idx)를 받아와야한다. 2.modify.do로 보내버린다. 3.게시판 id를 가지고 가야한다. 
  		$("#modify").click(()=>{
  			//var idx=$("#idx").val();
  			//alert(${board.idx});
  			//location.href="<c:url value='/modify.do'/>?bno="+idx;
  			location.href="<c:url value='/modify.do'/>?bno=${board.idx}";//get 방식
  		});
  	
  	});
  </script>
</head>
<body>
 
<div class="container">
  <h2>Board Read</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Board Read Page</div>
    <div class="panel-body">Panel Content
      <div class="form-group">
       <label>Bno</label>
    <input type="text" class="form-control" id="idx" name="idx" value="${board.idx}" readonly="readonly">
  </div>
    <label>Title</label>
    <input type="text" class="form-control" name="title" value="${board.title}" readonly="readonly">
  </div>
  <div class="form-group">
    <label>Text area</label>
	<textarea rows="3" class="form-control" name="contents" readonly="readonly">${board.contents}</textarea>
  </div>
  <div class="form-group">
    <label>writer</label>
    <input type="text" class="form-control" name="writer" value="${board.writer}" readonly="readonly">
  </div>
  <button id="modify" class="btn btn-default">Modify</button>
  <button id="list" class="btn btn-info">List</button>
    </div>
    <div class="pane-footer">인프런 화이팅!</div>
  </div>
</div>

</body>
</html>