<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="webwork" prefix="ww" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring_WebWork2</title>
</head>

<body>
<h3>Book Detail:</h3>
<img src="images/<ww:property value="book.isbn" />.jpg" align="absmiddle">
<h4> ISBN: <ww:property value="book.isbn" /></h4>
<h4> Title: <ww:property value="book.title" /></h4>
<h4>Author: <ww:property value="book.author" /></h4>
<a href="listBooks.action">Back</a>
</body>
</html>
