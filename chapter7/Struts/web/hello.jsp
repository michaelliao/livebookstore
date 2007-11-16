<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Struts Hello</title>
</head>

<body>
    <h3>Hello, <%=session.getAttribute("username")%>!</h3>
    <p><a href="logout.do">Logout</a><p>
</body>
</html>
