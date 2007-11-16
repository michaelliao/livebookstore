<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html><!-- InstanceBegin template="/Templates/SpringMVC.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>SpringMVC入门 - 用户登录</title>
<!-- InstanceEndEditable -->
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td><table width="760" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td width="513"><h1>SpringMVC示例 - <!-- InstanceBeginEditable name="PageTitle" -->LoginController<!-- InstanceEndEditable --></h1></td>
				<td width="235" align="center" valign="top">&nbsp;</td>
			</tr>
		</table></td>
	</tr>
	<tr>
		<td><table width="760" border="0" cellpadding="3" cellspacing="0">
			<tr>
				<td><a href="javascript:void(0)" id="openCode" onClick="document.getElementById('openCode').style.display='none';document.getElementById('closeCode').style.display='';document.getElementById('tdCode').style.display=''">查看源码</a>
			<a href="javascript:void(0)" id="closeCode" onClick="document.getElementById('closeCode').style.display='none';document.getElementById('openCode').style.display='';document.getElementById('tdCode').style.display='none'" style="display:none">关闭源码</a></td>
			</tr>
			<tr>
				<td>
				<table id="tdCode" width="100%" border="0" cellspacing="0" cellpadding="3" style="display:none">
	<tr>
		<td><!-- InstanceBeginEditable name="Code" -->
					<textarea name="txtCode" rows="10" id="txtCode" style="width:100%">package example.chapter7;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 处理用户登录表单
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/login.do"
 * @spring.property name="commandClass" value="example.chapter7.User"
 * @spring.property name="formView" value="login"
 * @spring.property name="successView" value="loginSuccess"
 * @spring.property name="validator" ref="loginValidator"
 */
public class LoginController extends SimpleFormController {

    private UserService userService;

    /**
     * @spring.property ref="userService"
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        User user = (User)command;
        try {
            userService.login(user.getUsername(), user.getPassword());
            // 登录成功，在Session中标记:
            request.getSession().setAttribute("USERNAME", user.getUsername());
            // 然后返回successView:
            Map model = new HashMap();
            model.put("username", user.getUsername());
            return new ModelAndView(getSuccessView(), model);
        }
        catch(RuntimeException e) {
            // 登录失败,返回formView让用户重新填写表单:
            Map model = new HashMap();
            model.put("command", command);
            model.put("error", e.getMessage());
            return new ModelAndView(getFormView(), model);
        }
    }

}</textarea>
				<!-- InstanceEndEditable -->
		</td>
	</tr>
</table>

				</td>
			</tr>
			<tr><td height="20"><hr width="100%" size="1" noshade="noshade" /></td></tr>
		</table></td>
	</tr>
	<tr>
		<td style="padding:6px;"><!-- InstanceBeginEditable name="MainPage" -->
			<form:form method="post" action="login.do">
			<table width="100%" border="0" cellspacing="0" cellpadding="3">
				<tr>
					<td colspan="2"><h1>注册用户请登录</h1></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td><font color="#FF0000"><c:out value="${error}" /></font></td>
				</tr>
				<tr>
					<td width="11%" align="right">用户名：</td>
					<td width="89%"><form:input path="username" /> <form:errors path="username" /></td>
				</tr>
				
				<tr>
					<td align="right">口令：</td>
					<td><form:password path="password" /> <form:errors path="password" /></td>
				</tr>
				<tr>
				  <td>&nbsp;</td>
				  <td>管理员用户：admin, password</td>
			  </tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="Submit" value="登录" />
					<input type="button" name="Submit2" value="注册新用户" onClick="location.assign('register.do')" /></td>
				</tr>
			</table>
			</form:form>
		<!-- InstanceEndEditable --></td>
	</tr>
	<tr>
		<td><table width="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td height="20"><hr width="100%" size="1" noshade="noshade" /></td>
			</tr>
			<tr>
				<td align="center">第七章 Spring MVC示例 Copyright&copy;2006</td>
			</tr>
		</table></td>
	</tr>
</table>
</body>
<!-- InstanceEnd --></html>
