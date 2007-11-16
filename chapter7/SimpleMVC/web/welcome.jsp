<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LoginController -&gt; welcome.jsp</title>
</head>

<body>
<p>login.cmd (LoginController) -&gt; welcome.jsp</p>
<p>Username: <c:out value="${username}" /></p>
<p>Greet: <c:out value="${greet}" /></p>
<p>Time: <c:out value="${time}" /></p>
</body>
</html>
