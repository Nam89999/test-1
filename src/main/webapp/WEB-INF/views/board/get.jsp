<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript">   //준비가 되면은 $list가 클릭이 되면은 처리를 해라->list.do로 가도록
  	$(document).ready(()=>{
  		$("#list").click(()=>{
  			location.href="<c:url value='/readBoardList.do'/>";
  		});
  		//modify를 누르면 일단 게시물 id(idx)를 받아와야한다. 2.modify.do로 보내버린다. 3.게시판 id를 가지고 가야한다. 
  		$("#modify").click(()=>{
  			//var idx=$("#idx").val();
  			//alert(${board.idx});
  			//location.href="<c:url value='/modify.do'/>?bno="+idx;
  			location.href="<c:url value='/boardModify.do'/>?bno=${boardInfo.boardnum}";//get 방식
  		});
  		
  		$("#comment-create-btn").click(()=>{
  			
  			alert("확인");
  			var boardnum = $('#boardnum').val();
  	    	var content = $('#comment-content').val();
  			var commentWriter = $('#comment-writer').val();
  			
  			$.ajax({
  				type : "POST",
  				url : 'registerComment.do',
  				data : {
  					boardnum: boardnum,
  					content : content,
  					commentWriter : commentWriter

  				},//data 쓰는 방법
  				success : function(response) {
  					if (response == "success"){
  						alert("댓글 등록 성공하였습니다.");  						
  						//질문-Ajax에서도 Redirect가 가능한가? 이걸로 했다 됐다고 봐야한다.
  						window.location.replace("<c:url value='/boardContents.do'/>?bno=${boardInfo.boardnum}");
  					}//'', "" 를 써도 무관하다.
  					else {
  						if(response != ''){
  							alert(response)
  						}else{
  							alert("댓글 등록 실패하였습니다.");						
  						}
						
  						//location.href="<c:url value='/boardContents.do'/>?bno=${boardInfo.boardnum}";
  					}
  						
  				}
  			});
			
  		});
  	
  		
  		$("#comment-update").click(()=>{

  			location.href="<c:url value='/modifyComment.do'/>?cno=${comment.commentId}";//get 방식
  		});
  	});
  	
  	
  	
  	
  </script>
</head>
<body>

	<div class="container">
		<h2>Board Read</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<div class="panel-body">
				Panel Content <input type="hidden" class="form-control"
					id="boardnum" value="${boardInfo.boardnum}" readonly="readonly">
				<label>Title</label> <input type="text" class="form-control"
					name="title" value="${boardInfo.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>Text area</label>
				<textarea rows="3" class="form-control" name="contents"
					readonly="readonly">${boardInfo.contents}</textarea>
			</div>
			<div class="form-group">
				<label>writer</label> <input type="hidden" class="form-control"
					name="num" value="${boardInfo.num}" readonly="readonly"> <input
					type="text" class="form-control" value="${boardInfo.writer}"
					readonly="readonly">
			</div>
			<c:if test="${goModify!= null && goModify!= ''}">
				<button id="modify" class="btn btn-default">수정하기</button>
			</c:if>
			<button id="list" class="btn btn-info">게시물 목록</button>
		</div>
		<div class="pane-footer">게시물 끝</div>
	</div>
	<!-- 댓글 불러오기 구현 -->
	<div>
		<div class="container">
			<table class="table table-borderless">
				<tr>
					<th>댓글번호</th>
					<th>작성자</th>
					<th>댓글내용</th>
					<th>작성일자</th>
				</tr>
				<c:forEach var="comment" items="${commentList}">
					<tr>
						<td>${comment.commentId}</td>
						<c:if test="${comment.boardWriter}">
						<td>글쓴이</td>
						</c:if>
						<td>${comment.commentWriter}</td>
						<td><a
							href="${ctx}/modifyComment.do?cno=${comment.commentId}">${comment.content}</a></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${comment.regdate}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- 댓글 입력처리 -->
	<c:if
		test="${sessionScope.memberNum!=null || sessionScope.memberNum!=''}">
		<div class="card" id="comments">
			<div class="card-body">
				<form>
					<div class="form-group">
						<label>댓글 작성</label>
						<textarea class="form-control" id="comment-content" rows="3"></textarea>
					</div>
					<input type="hidden" id="comment-writer" value="${memberInfo}"
						readonly="readonly">
					<button type="button" class="btn btn-primary"
						id="comment-create-btn">제출</button>
				</form>
			</div>
		</div>
	</c:if>
	<input type="hidden" name="idx" value="댓글 번호" />
</body>
</html>