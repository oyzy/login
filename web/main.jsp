<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/25
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    登录成功！欢迎您,${userName} &nbsp; &nbsp;<input type="button" value="退出"  onclick="quit()">
    <input type="hidden" id="userName" value="${userName}">
</body>
<script src="js/jquery.min.js"></script>
<script>
    //注释掉的原因是无法区分刷新还是关闭
   /* $(window).unload(function (evt) {
        if (typeof evt === 'undefined') {
            evt = window.event;
        }
        if (evt) {
            var n = window.event.screenX - window.screenLeft;
            var b = n > document.documentElement.scrollWidth-20;
            //右上角关闭浏览器或者alt+F4关闭
            if(b && window.event.clientY < 0 || window.event.altKey || window.event.ctrlKey) {
               // toAjax();
            //任务栏右键关闭浏览器
            }else if(event.clientY > document.body.clientHeight || event.altKey){
                //toAjax();
            } else {
                console.log("刷新");
                toAjax();
            }
        }
    });
    function toAjax() {
        $.ajax({
            url:"loginOut",
            type:"post",
            success:function(){
            }
        });
    }*/

   function quit() {
        $.ajax({
            url:"loginOut",
            type:"post",
            data:{"name":$("#userName").val()},
            success:function(data){
                if ("success" === data){
                    window.location.href = "index.jsp";
                }
            }
        });
    }



</script>
</html>
