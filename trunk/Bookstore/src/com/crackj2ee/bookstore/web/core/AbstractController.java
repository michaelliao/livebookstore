package com.crackj2ee.bookstore.web.core;

import javax.servlet.http.*;

import org.apache.commons.logging.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.crackj2ee.bookstore.business.*;
import com.crackj2ee.bookstore.exception.NeedLoginException;
import com.crackj2ee.bookstore.util.HttpUtil;

/**
 * Super class used for init log and service object. DONOT extends this class 
 * directly. Extends from AbstractStatelessController, AbstractSessionController, 
 * AbstractScriptController and AbstractXmlController.
 * 
 * @author xuefeng
 */
public abstract class AbstractController implements Controller {

    protected Log log;

    protected BusinessService businessService;
    protected SearchService searchService;
    protected MailService mailService;

    public AbstractController() {
        log = LogFactory.getLog(this.getClass());
        log.info("Init controller: " + this.getClass().getName());
    }

    /**
     * Inject BusinessService object. All DAO operations are wrapped in 
     * this core interface.
     * 
     * @spring.property ref="businessService"
     */
    public final void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * Inject SearchService object. All search operations are wrapped in 
     * this interface.
     * 
     * @spring.property ref="searchService"
     */
    public final void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    /**
     * Inject MailService object. Sub-class can use it to send mails.
     * 
     * @spring.property ref="mailService"
     */
    public final void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public final ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // check if login required:
        Identity identity = HttpUtil.getIdentity();
        if(this instanceof LoginRequired) {
            if(identity==null)
                throw new NeedLoginException();
        }
        // check if admin-role required:
        if(this instanceof AdminRequired) {
            if(identity==null || !identity.isAdmin())
                throw new NeedLoginException();
        }
        return handleRequest2(request, response);
    }

    public abstract ModelAndView handleRequest2(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
