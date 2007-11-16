<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html><!-- InstanceBegin template="/Templates/SpringMVC.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>SpringMVC入门 - RegisterController</title>
<!-- InstanceEndEditable -->
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td><table width="760" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td width="513"><h1>SpringMVC示例 - <!-- InstanceBeginEditable name="PageTitle" -->RegisterController<!-- InstanceEndEditable --></h1></td>
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
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

/**
 * A register wizard controller.
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/register.do"
 * @spring.property name="commandClass" value="example.chapter7.User"
 * @spring.property name="pages" list="registerStep0,registerStep1,registerStep2"
 */
public class RegisterController extends AbstractWizardFormController {

    private UserService userService;

    /**
     * @spring.property ref="userService"
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    // 当用户点击"_finish"按钮时,触发processFinish()方法:
    protected ModelAndView processFinish(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
        User user = (User)command;
        userService.register(user);
        Map model = new HashMap();
        model.put("username", user.getUsername());
        return new ModelAndView("registerSuccess", model);
    }

    @Override
    // 每当用户点击"_target?"准备前进到下一步时,触发validatePage()来验证当前页:
    protected void validatePage(Object command, Errors errors, int page) {
        User user = (User)command;
        if(page==0) {
            // 验证username,password:
            if(!user.getUsername().matches("[a-zA-Z0-9]{3,20}"))
                errors.rejectValue("username", "error.username", "用户名不符合要求");
            if(userService.isExist(user.getUsername()))
                errors.rejectValue("username", "error.username", "用户名已存在");
            if(user.getPassword()==null || user.getPassword().length()<6)
                errors.rejectValue("password", "error.password", "口令至少为6个字符");
        }
        else if(page==1) {
            // 验证email,blog,website:
            if(user.getEmail()==null)
                errors.rejectValue("email", "error.email.empty", "电子邮件不能为空");
            else if(!user.getEmail().matches("[a-zA-Z0-9\\_\\-]+\\@[a-zA-Z0-9\\_\\-]+[\\.[a-zA-Z0-9\\_\\-]+]{1,2}"))
                errors.rejectValue("email", "error.email", "电子邮件地址无效");
            if(user.getBlog()==null || user.getBlog().trim().equals(""))
                errors.rejectValue("blog", "error.blog", "博客地址不能为空");
            if(user.getWebsite()==null || user.getWebsite().trim().equals(""))
                errors.rejectValue("website", "error.website", "网址地址不能为空");
        }
        else if(page==2) {
            // 验证province,city,zip:
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
		  <p>注册新用户：第二步，输入联系方式</p>
		  <form:form method="post" action="register.do">
		    <table width="545" border="0" cellspacing="0" cellpadding="3">
              <tr>
                <td width="116" align="right">电子邮件：</td>
                <td width="417"><form:input path="email" maxlength="20" /> <form:errors path="email" /></td>
              </tr>
              <tr>
                <td align="right">博客：</td>
                <td><form:input path="blog" maxlength="20" /> <form:errors path="blog" /></td>
              </tr>
              <tr>
                <td align="right">站点：</td>
                <td><form:input path="website" maxlength="20" /> <form:errors path="website" /></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="_target0" value="上一步">
                  <input type="submit" name="_target2" value="下一步"></td>
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
