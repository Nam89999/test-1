<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">   //준비가 되면은 $list가 클릭이 되면은 처리를 해라->list.do로 가도록
  	$(document).ready(()=>{
  		$("#comment-update").click(()=>{
  			alert("확인");
  			var commentId = $('#comment_id').val();
  	    	var content = $('#comment-content').val();
  			var data = {}
  			data['commentId']= commentId;
  			data['content']= content;
  			console.log(data);
  			$.ajax({
  				type : "POST",
  				url : 'modifyComment.do',
  				data : {
  					commentId: commentId,
  					content : content

  				},//data 쓰는 방법
  				success : function(response) {
  					if (response == "success"){
  						alert("댓글 수정 성공");  						
  						//질문-Ajax에서도 Redirect가 가능한가? 이걸로 했다 됐다고 봐야한다.
  						window.location.replace("<c:url value='/boardContents.do'/>?bno=${comment.boardnum}");
  						
  					}//'', "" 를 써도 무관하다.
  					else {
  						if(response != ''){
  							alert(response)
  						}else{
  							alert("댓글 수정 실패하였습니다.");						
  						}
						
  						//location.href="<c:url value='/boardContents.do'/>?bno=${boardInfo.boardnum}";
  					}
  				}
  			});
  		});
	});
  		 	
  </script>
</head>
<body>
	<input type="hidden" id="comment_id" value="${comment.commentId}"/>
	<div>
		<div class="container">
			<table class="table table-borderless">
				<tr>
					<th>작성자</th>
					<th>댓글내용</th>
					<th>작성일자</th>
				</tr>
					<tr>
						<td>${comment.commentWriter}</td>
						<td>
							<input type="text" value="${comment.content}"
								id="comment-content" />
				            <c:if test="${goCommentModify!= null && goCommentModify!= ''}">
							     <input type="button" value="수정"
							     	id="comment-update" />
						    </c:if>
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd"
								value="${comment.regdate}" />
						</td>
					</tr>
			</table>
		</div>
	</div>		
</body>
</html>