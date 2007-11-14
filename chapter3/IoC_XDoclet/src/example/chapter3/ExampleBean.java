package example.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @spring.bean id="exampleBean" init-method="init"
 */
public class ExampleBean {

    private List list;
    private int size = 100;
    private String version;

    /**
     * @spring.property value="200"
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @spring.property value="1.0_beta"
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public void init() {
        list = new ArrayList(size);
    }
}
