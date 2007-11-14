package example.chapter3;

import java.util.List;

/**
 * @spring.bean id="listBean"
 */
public class ListBean {

    /**
     * @spring.property listRef="basicBean,constructorBean"
     */
    public void setChildren(List children) {}

    /**
     * @spring.property list="2.32,9.23,10.3"
     */
    public void setPrices(List<Float> prices) {
        for(Float f : prices) {
            System.out.println(f);
        }
    }

    /**
     * @spring.property list="1,1,2,3,5,8"
     */
    public void setFibonacci(int[] fibonacci) {
        for(int n : fibonacci) {
            System.out.println(n);
        }
    }

}
