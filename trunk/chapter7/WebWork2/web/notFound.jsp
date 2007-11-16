<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="webwork" prefix="ww" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring_WebWork2</title>
</head>

<body>
<h3>Book Not Found!</h3>
<h4>Sorry, Book with ISBN <ww:property value="isbn" /> not found!</h4>
<a href="listBooks.action">Back</a>
</body>
</html>
