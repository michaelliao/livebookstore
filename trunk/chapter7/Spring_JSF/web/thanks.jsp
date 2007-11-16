<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
<title>Thank you</title>
</head>
<body>
    <f:view>
        <h3>
            Thank you, <h:outputText value="#{subscriber.name}"/>!
        </h3>
        A confirm mail has been sent to your mail box <h:outputText value="#{subscriber.email}" />.
    </f:view>
</body>
</html>
