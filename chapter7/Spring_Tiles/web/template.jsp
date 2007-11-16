<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><tiles:getAsString name="title" /></title>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td bgcolor="#f0f0f0"><tiles:insert name="header" /></td>
    </tr>
    <tr>
        <td><tiles:insert name="body" /></td>
    </tr>
    <tr>
        <td bgcolor="#f0f0f0"><tiles:insert name="footer" /></td>
    </tr>
</table>
</body>
</html>
