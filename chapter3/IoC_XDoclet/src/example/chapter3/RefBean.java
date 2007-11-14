package example.chapter3;

/**
 * @spring.bean id="refBean"
 */
public class RefBean {

    private BasicBean basicBean;

    /**
     * @spring.bean ref="basicBean"
     */
    public void setBasic(BasicBean basicBean) {
        this.basicBean = basicBean;
    }
}
