<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
    <head>
        <title>SpringMVC</title>
    </head>
    <body>
        <h3>Hello, <c:out value="${name}" />,
        it is <c:out value="${time}" /></h3>
    </body>
</html>
