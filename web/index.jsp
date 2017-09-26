<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/25
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>登陆</title>
  </head>
  <body>

  用户名:<input type="text" id="name"><br>
  密码:  <input type="text" id="password"><br>
         <input type="button" value="提交" id="login">
         <input type="hidden" id="message">
  </body>
  <form id="indexForm" action="user/index" method="post">
      <input type="hidden" name="name" id="userName">
  </form>
  <script src="/js/jquery.min.js"></script>
  <script>
    function load(){
        var message = $("#message").val();
        if (message !== null && message !== "" && message !== undefined){
            alert(message);
        }
    }

    $("#login").click(function () {
        $.ajax({
            type:"post",
            url:"login",
            data:{"name":$("#name").val(),"password":$("#password").val()},
            success:function (data) {
                var strs= new Array();
                strs=data.split(",");
                if ("success" === strs[0]) {
                    $("#userName").val(strs[1]);
                    $("#indexForm").submit();
                } else {
                    $("#message").val(data);
                    load();
                }
            }
        })
    })
  </script>
</html>
