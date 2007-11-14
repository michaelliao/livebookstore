package example.chapter3;

import java.util.List;

public class ListBean {

    public void setChildren(List children) {}

    public void setPrices(List<Float> prices) {
        for(Float f : prices) {
            System.out.println(f);
        }
    }

    public void setFibonacci(int[] fibonacci) {
        for(int n : fibonacci) {
            System.out.println(n);
        }
    }

}
