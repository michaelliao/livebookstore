<%
response.setHeader("Cache-Control", "Private");
response.setDateHeader("Expires", System.currentTimeMillis() + 864000000L);
response.sendRedirect("listBooks.jspx");
%>