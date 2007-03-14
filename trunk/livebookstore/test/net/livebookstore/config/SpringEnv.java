package net.livebookstore.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Super class for all test cases that needed spring enviroment. 
 * An xml file name as xxx.xml like xxx.class, and put with .class 
 * file together.
 * 
 * @author Xuefeng
 */
public abstract class SpringEnv {

    protected static ClassPathXmlApplicationContext context = null;
    protected static Log log = null;

    @Before
    public final void initBeanFactory() {
        if(log==null) {
            log = LogFactory.getLog(getClass());
        }
        if(context==null) {
            String path = getClass().getName().replace('.', '/') + ".xml";
            log.info("init: " + path);
            context = new ClassPathXmlApplicationContext(path);
        }
    }

    @AfterClass
    public static void destory() {
        log.info("destroy");
        if(context!=null) {
            context.close();
            context = null;
        }
    }

    protected final Object getBean(String id) {
        return context.getBean(id);
    }

}
