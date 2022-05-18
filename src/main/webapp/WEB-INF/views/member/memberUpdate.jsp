<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보 수정</title>
    <!-- bootstrap/css -->
    <link rel="stylesheet" type="text/css" th:href="@{/css/bootstrap.css}" />
    <!-- bootstrap/js -->
    <script type="text/javascript" th:src="@{/js/bootstrap.min.js}"></script>
</head>
<body>
    
    
    <div style="padding: 20px;">
        
        <h3>회원정보 수정</h3>
        <hr />
        <form action="memberUpdate.do" method="post">

            아이디: <input type="text" name="id" th:value="${memberInfo.id}" readonly /> <br />
            이름: <input type="text" name="name" th:value="${memberInfo.name}" /> <br />
            나이: <input type="text" name="age" th:value="${memberInfo.age}" /> <br />
            <input type="submit" value="수정" />

        </form>
        
    </div>
    
</body>
</html>

</body>
</html>