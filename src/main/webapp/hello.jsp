<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: cs
  Date: 02.06.2022
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Hello ${name} from DispatcherServlet</h2>
    <p>
    <%
        final Enumeration<String> en = request.getParameterNames();
        out.println(Optional.ofNullable(request.getAttribute("name")).orElse(""));
    %>
    </p>
</body>
</html>
