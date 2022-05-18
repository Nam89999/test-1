<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<body> 
	<ul>
	    <c:if test="${sessionScope.memberInfo==null || sessionScope.memberInfo==''}">
	   	    <a href="<c:url value='/login.do'/>">로그인</a>   
	   </c:if>		
     <c:if test="${sessionScope.memberInfo!=null && sessionScope.memberInfo!=''}">
	   		<h4><a href="<c:url value='/readMember.do'/>">회원이름</a></h4>환영합니다!
	    <a href="<c:url value='/logout.do'/>">로그아웃</a>   
		</c:if>
	</ul>


</body>
</html>