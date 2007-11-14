<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Struts Login</title>
</head>

<body>
<html:form action="login.do">
    <p><font color="red"><html:errors /></font></p>
    <p>Username: <html:text property="username" /></p>
	<p>Password: <html:password property="password" /></p>
	<p><html:submit value="Login" /></p>
</html:form>
</body>
</html>
