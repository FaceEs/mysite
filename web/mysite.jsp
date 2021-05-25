<%--
  Created by IntelliJ IDEA.
  User: appat
  Date: 25.05.2021
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Button</title>
</head>
<body>
    <button onclick="window.location.href = '<%request.getRequestURL();%>/simple';">Button 1</button>
    <button onclick="window.location.href = '<%request.getRequestURL();%>/second';">Button 2</button>
</body>
</html>
