<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html><!-- InstanceBegin template="/Templates/SpringMVC.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>SpringMVC入门 - ViewProfileController</title>
<!-- InstanceEndEditable -->
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td><table width="760" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td width="513"><h1>SpringMVC示例 - <!-- InstanceBeginEditable name="PageTitle" -->ViewProfileController<!-- InstanceEndEditable --></h1></td>
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

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 可以处理多个动作的MultiActionController
 * 
 * @author Xuefeng
 * 
 * @spring.bean name="/*Profile.do"
 * 
 * 如果要使用ParameterMethodNameResolver,将Bean name设置为"/profile.do",加下列注释:
 * spring.property name="methodNameResolver" ref="methodNameResolver"
 * URL: /profile.do?action=basicProfile
 */
public class ViewProfileController extends MultiActionController {

    private UserService userService;

    /**
     * @spring.property ref="userService"
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String getUsername(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("USERNAME");
        if(username==null)
            throw new NeedLoginException();
        return username;
    }

    public ModelAndView basicProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = getUsername(request);
        User user = userService.query(username);
        Map model = new HashMap();
        model.put("username", user.getUsername());
        return new ModelAndView("basicProfile", model);
    }

    public ModelAndView contactProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = getUsername(request);
        User user = userService.query(username);
        Map model = new HashMap();
        model.put("email", user.getEmail());
        model.put("blog", user.getBlog());
        model.put("website", user.getWebsite());
        return new ModelAndView("contactProfile", model);
    }

    public ModelAndView addressProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = getUsername(request);
        User user = userService.query(username);
        Map model = new HashMap();
        model.put("province", user.getProvince());
        model.put("city", user.getCity());
        model.put("zip", user.getZip());
        return new ModelAndView("addressProfile", model);
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
			<p>查看个人资料：<a href="basicProfile.do">基本资料</a> 联系方式 <a href="addressProfile.do">详细地址</a> [<a href="logout.do">注销</a>]</p>
			<table width="377" border="0" cellspacing="0" cellpadding="3">
				<tr>
					<td width="109" align="right">电子邮件：</td>
					<td width="256"><c:out value="${email}" /></td>
				</tr>
				<tr>
					<td align="right">博客：</td>
					<td><c:out value="${blog}" /></td>
				</tr>
				<tr>
					<td align="right">站点：</td>
					<td><c:out value="${website}" /></td>
				</tr>
			</table>
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
