<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/s2sh/userAction_change" method="post">
 旧密码： 
 <input type="password" name="pwd.password" size="10" /> <br>
 
 新密码:
 <input type="password" name="pwd.password1" size="10" /> <br>
 确认密码 
 <input type="password" name="pwd.password2" size="10" /> <br>
 
<input type="submit" name="submit" value="修改"> 
</form>
</body>
</html>
