<%--
  Created by IntelliJ IDEA.
  User: 29769
  Date: 2022/4/18
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList = new Array();
        userList.push({username:"zhangsan",age:18,addr:"beijing"});
        userList.push({username:"zhanger",age:17,addr:"sandong"});
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/quick15",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        })
    </script>
</head>
<body>

</body>
</html>
