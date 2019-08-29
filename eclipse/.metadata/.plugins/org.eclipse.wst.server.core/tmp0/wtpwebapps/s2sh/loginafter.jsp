<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
            .userMenu {
                float: left;
                width: 200px;
            }
            
            #content {
                float: left;
            }
        </style>
        <meta charset="utf-8">
        <script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>

</head>
<body>

 <div class="userWrap">
            <ul class="userMenu">
                <li class="current" data-id="center">用户中心</li>
                <li data-id="likai">离校申请</li>
                <li data-id="huilai">返校处理</li>
                 <li data-id="xiugai">修改密码</li>
          
            </ul>
            <div id="content"></div>
        </div>



</body>

<script>
        $(function() {
            $(".userMenu").on("click", "li", function() {
                var sId = $(this).data("id"); //获取data-id的值
                window.location.hash = sId; //设置锚点
                loadInner(sId);
            });
            function loadInner(sId) {
                var sId = window.location.hash;
                var pathn, i;
                switch(sId) {
                    case "#center":
                        pathn = "user_center.jsp";
                        i = 0;
                        break;
                    case "#likai":
                        pathn = "user_likai.jsp";
                        i = 1;
                        break;
                        
                    case "#huilai":
                        pathn = "user_huilai.jsp";
                        i = 2;
                        break;

                    case "#xiugai":
                        pathn = "user_xiugai.jsp";
                        i = 3;
                        break;
                        
                    default:
                        pathn = "user_center.jsp";
                        i = 0;
                        break;
                }
                $("#content").load(pathn); //加载相对应的内容
                $(".userMenu li").eq(i).addClass("current").siblings().removeClass("current"); //当前列表高亮
            }
            var sId = window.location.hash;
            loadInner(sId);
        });
    </script>


</html>