package com.crackj2ee.bookstore.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.*;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Super class for all test cases that needed spring enviroment. 
 * An xml file name as xxx.xml like xxx.class, and put with .class 
 * file together.
 * 
 * @author Xuefeng
 */
public abstract class SpringEnv {

    protected static XmlBeanFactory factory = null;
    protected static Log log = null;

    @Before
    public final void initBeanFactory() {
        if(log==null) {
            log = LogFactory.getLog(getClass());
        }
        if(factory==null) {
            String path = getClass().getName().replace('.', '/') + ".xml";
            log.info("init: " + path);
            factory = new XmlBeanFactory(new ClassPathResource(path));
        }
    }

    @AfterClass
    public static void destory() {
        log.info("destroy");
        if(factory!=null) {
            factory.destroySingletons();
            factory = null;
        }
    }

    protected final Object getBean(String id) {
        return factory.getBean(id);
    }

}
