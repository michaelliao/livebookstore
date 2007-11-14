package example.chapter3;

import java.net.URL;

/**
 * @spring.bean id="basicBean" scope="prototype"
 */
public class BasicBean {

    /**
     * @spring.property value="true"
     */
    public void setUseCache(boolean useCache) {}

    /**
     * @spring.property value="100"
     */
    public void setMaxSize(int size) {}

    /**
     * @spring.property value="A Basic Bean"
     */
    public void setTitle(String title) {}

    /**
     * @spring.property value="config.xml"
     */
    public void setFile(URL url) {
        System.out.println(url);
    }
}
