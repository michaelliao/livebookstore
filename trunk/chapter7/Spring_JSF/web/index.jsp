<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
<title>Subscribe Form</title>
</head>
<body>
    <f:view>
        <h:form>
            <h4>Subscribe</h4>
            Your name:
            <h:inputText id="id_name" value="#{subscriber.name}" required="true">
                <f:validateLength minimum="3" maximum="20" />
            </h:inputText>
            <h:message for="id_name" />
            <br/>
            Your email:
            <h:inputText id="id_email" value="#{subscriber.email}" required="true">
                <f:validator validatorId="emailValidator" />
            </h:inputText>
            <h:message for="id_email" />
            <br/>
            Preferred Language:
            <h:selectOneMenu value="#{subscriber.language}" required="true">
                <f:selectItem itemLabel="English" itemValue="English" />
                <f:selectItem itemLabel="Chinese" itemValue="Chinese" />
            </h:selectOneMenu>
            <br/>
            <h:commandButton type="submit" value="Submit" action="#{subscriber.submit}" />
        </h:form>
    </f:view>
</body>
</html>
