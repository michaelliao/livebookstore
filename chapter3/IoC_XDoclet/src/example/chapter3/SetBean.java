package example.chapter3;

import java.util.Set;

/**
 * @spring.bean id="setBean"
 */
public class SetBean {

    /**
     * @spring.property setRef="basicBean,constructorBean,listBean"
     */
    public void setCups(Set cups) {
        for(Object obj : cups) {
            System.out.println(obj);
        }
    }
}
