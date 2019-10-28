<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户详细信息</title>
</head>
<body>
ID : ${ sessionScope.user_info.userId }
<br>
用户名 : ${ sessionScope.user_info.userName }
<br>
电子邮件 : ${ sessionScope.user_info.userEmail }
<br>
</body>
</html>