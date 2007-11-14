package example.chapter3;

/**
 * @author Xuefeng
 * 
 * @spring.bean id="constructorBean"
 */
public class ConstructorBean {

    /**
     * @spring.constructor-arg type="int" value="100"
     * @spring.constructor-arg type="int" value="200"
     */
    public ConstructorBean(int min, int max) {
        System.out.println("(int, int)");
    }

    public ConstructorBean(String min, String max) {
        System.out.println("(String, String)");
    }

}
