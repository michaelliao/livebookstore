package example.chapter7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

    private ServletContext context;
    private Map<String, Controller> controllers;

    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
        // 将URL和对应的Controller关联起来:
        controllers = new HashMap<String, Controller>();
        controllers.put("/test.cmd", new TestController());
        controllers.put("/login.cmd", new LoginController());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI().substring(contextPath.length());
        Controller controller = controllers.get(uri);
        if(controller==null) {
            // 没有找到合适的Controller处理请求
            // 直接返回一个404错误:
            response.sendError(404);
            return;
        }
        try {
            // 将请求交给TestController处理:
            ModelAndView mv = controller.handleRequest(request, response);
            // 将Model绑到Request中:
            Map<String, Object> model = mv.getModel();
            Set<String> keys = model.keySet();
            for(String key : keys)
                request.setAttribute(key, model.get(key));
            // 获得JSP视图:
            String jsp = mv.getView();
            // 转发给JSP视图渲染:
            context.getRequestDispatcher(jsp).forward(request, response);
        }
        catch(Exception e) {
            // 处理过程中发生异常
            // 返回一个500错误:
            response.sendError(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST请求的处理方式和GET一样:
        doGet(request, response);
    }

}
