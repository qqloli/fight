<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/s2sh/userAction_login" method="post">
名字：<input type="text" name="user.name"><br>
密码：<input type="text" name="user.pwd"><br>
<input type="radio" value="0" name="type" checked>学生
<input type="radio" value="1" name="type">管理员<br>
<input type="submit" value="登录"/>
<input type="button" value="注册" onclick="window.location.href='register.jsp'" />



</form>
</body>
</html>