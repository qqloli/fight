<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/s2sh/userAction_register" method="post">
名字：&nbsp;&nbsp;<input type="text" name="user.name"><br>
性别：&nbsp;<input type="radio" value="male" name="user.sexual">男
<input type="radio" value="female" name="user.sexual">女<br>
密码：&nbsp;&nbsp;<input type="password" name="user.pwd"><br>
学号：&nbsp;&nbsp;<input type="text" name="user.number"><br>
年级：&nbsp;&nbsp;<input type="text" name="user.grade"><br>
专业：&nbsp;&nbsp;<input type="text" name="user.zhunye"><br>
班级：&nbsp;&nbsp;<input type="text" name="user.class_"><br>
公寓名：<input type="text" name="user.gongyu"><br>
房间号：<input type="text" name="user.roomno"><br>
 
<input type="submit" value="提交">
</form>
</body>
</html>