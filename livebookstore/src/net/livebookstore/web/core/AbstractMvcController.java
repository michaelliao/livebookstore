package net.livebookstore.web.core;

import java.util.Map;

import javax.servlet.http.*;

import org.springframework.web.servlet.ModelAndView;

/**
 * Template class for classic mvc handling.
 * 
 * @author xuefeng
 */
public abstract class AbstractMvcController extends AbstractBaseController {

    public final ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map map = getModel(request, response);
        if(map==null)
            return null;
        String view = getView(request, response);
        if(view==null)
            return null;
        return new ModelAndView(view, map);
    }

    /**
     * Template for subclass to handle request and expect a Map as model.
     */
    public abstract Map getModel(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * Get view name.
     */
    public abstract String getView(HttpServletRequest request, HttpServletResponse response);

}
