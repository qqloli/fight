<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
 
<html>
    <head>
        <title>emplist</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
        

                <!-- meta使用viewport以确保页面可自由缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 引入 jQuery Mobile 样式 -->
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">

<!-- 引入 jQuery 库 -->
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- 引入 jQuery Mobile 库 -->
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

    </head>
    <body>
    <form action="/s2sh/userAction_leave" method="post">
             离校原因：<input type="text" name="leave.reason">
             携带行李：<input type="text" name="leave.package_">
             
    <input type="submit" value="提交">
    </form>

    </body>
</html>