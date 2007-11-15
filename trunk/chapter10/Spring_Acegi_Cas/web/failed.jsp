<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Login to CAS failed</title></head>
<body>
    <h1>Login to CAS failed</h1>
    <font color="red">
        Your CAS credentials were rejected.<BR><BR>
        Reason: <%= ((org.acegisecurity.AuthenticationException)session.getAttribute(org.acegisecurity.ui.AbstractProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
    </font>
</body>
</html>
