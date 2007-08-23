package net.livebookstore.web.core;

import org.apache.commons.logging.*;
import org.springframework.web.servlet.mvc.Controller;

import net.livebookstore.business.*;

/**
 * Super class used for init log and service objects. DONOT extends this class 
 * directly. Extends from AbstractMVCController, AbstractRedirectController, 
 * AbstractScriptController and AbstractXmlController.
 * 
 * @author xuefeng
 */
public abstract class AbstractBaseController implements Controller {

    protected Log log;

    protected BusinessService businessService;
    protected SearchService searchService;
    protected MailService mailService;

    public AbstractBaseController() {
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

}
