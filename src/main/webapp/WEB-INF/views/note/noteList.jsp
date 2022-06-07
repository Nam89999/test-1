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
</head>
<body>
<div class="container">
  <h2>쪽지함<h2>
  <div class="panel panel-default">
    <div class="panel-heading">Spring WEB MVC 쪽지함 만들기
    <button id="regBtn" type="button" class="btn btn-xs pull-right btn-primary">쪽지쓰기</button>
    </div>
    <div class="panel-body">
    <div class="table-responsive">          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>제목</th>
        <th>보낸이</th>
        <th>수신일</th>
        <th>수신확인</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="noteList" items="${noteList}">
      <tr>
        <td><a href="<c:url value='/noteContent.do?noticeNo=${noteList.noteId}'/>" >${noteList.title}</a></td><!--상세보기 요청 -->
        <td>${noteList.senderMember}</td>
        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${noteList.regdate}"/></td>
        <c:if test="${noteList.readCheck>0}">
        <td>읽음</td>
        </c:if>
        <c:if test="${noteList.readCheck==0}">
        <td>안읽음</td>
        </c:if>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>
  <button type="button" onclick="location.href='/writeNote.do';">쪽지 쓰기 </button>
 </div>
    <div class="panel-footer">화이팅!!</div>
  </div>
</div>
</body>
</html>