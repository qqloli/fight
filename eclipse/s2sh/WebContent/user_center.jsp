<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
学生中心<br>
姓名：${user.name}<br>
性别： ${user.sexual}<br>
密码：${user.pwd}<br>
学号：${user.number}<br>
年级：${user.grade}<br>
专业：${user.zhunye}<br>
班级：${user.class_}<br>
公寓名：${user.gongyu}<br>
房间号：${user.roomno}<br>


</body>
</html>