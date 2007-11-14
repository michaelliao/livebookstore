<html>
  <body>
    <h3>Please Login</h3>
    <%
      String error = request.getParameter("login_error");
      if(error!=null) {
        out.println("<p><font color=\"red\">");
        out.println(error);
        out.println("</font></p>");
      }
    %>
    <form action="j_login.do" method="POST">
      <p>Username: <input type="text" name="j_username" /></p>
      <p>Password: <input type="password" name="j_password"></p>
      <p><input type="checkbox" id="remember" name="j_remember_me">
        <label for="remember">Remember me</label>
      </p>
      <p><input name="submit" type="submit" value="Login"></p>
    </form>
  </body>
</html>
