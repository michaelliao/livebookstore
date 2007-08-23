package net.livebookstore.web.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractRedirectController extends AbstractBaseController {

    public final ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = redirect(request, response);
        response.sendRedirect(url);
        return null;
    }

    /**
     * Get redirect url if no exception.
     */
    protected abstract String redirect(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
