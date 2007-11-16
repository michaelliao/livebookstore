<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="webwork" prefix="ww" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring_WebWork2</title>
</head>
<body>
<h3>List All Books:</h3>
<ww:iterator value="books">
    <h4><img src="images/<ww:property value="isbn" />.jpg" align="absmiddle">
    <a href="bookDetail.action?isbn=<ww:property value="isbn" />"><ww:property value="title" /></a></h4>
</ww>
</body>
</html>
