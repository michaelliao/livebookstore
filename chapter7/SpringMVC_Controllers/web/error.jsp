<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html><!-- InstanceBegin template="/Templates/SpringMVC.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>SpringMVC入门</title>
<!-- InstanceEndEditable -->
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td><table width="760" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td width="513"><h1>SpringMVC示例 - <!-- InstanceBeginEditable name="PageTitle" -->MyHandlerExceptionResolver<!-- InstanceEndEditable --></h1></td>
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle all exception.
 * 
 * @author Xuefeng
 * 
 * @spring.bean id="handlerExceptionResolver"
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    private Log log = LogFactory.getLog(getClass());

    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        log.warn("Handle exception: " + ex.getClass().getName());
        // 如果抛出NeedLoginException,就将用户导向到登录页面:
        if(ex instanceof NeedLoginException)
            return new ModelAndView("redirect:login.do");
        // 对于其他Exception,在/error.jsp中显示Exception的信息:
        Map model = new HashMap();
        model.put("ex", ex.getClass().getSimpleName());
        model.put("message", ex.getMessage());
        return new ModelAndView("error", model);
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
		  <table width="664" border="0" cellspacing="0" cellpadding="3">
            <tr>
              <td colspan="2"><strong>很抱歉，发生了一个错误！</strong></td>
            </tr>
            <tr>
              <td width="115" align="right">异常类型：</td>
              <td width="549"><c:out value="${ex}" /></td>
            </tr>
            <tr>
              <td align="right">消息：</td>
              <td><c:out value="${message}" /></td>
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
