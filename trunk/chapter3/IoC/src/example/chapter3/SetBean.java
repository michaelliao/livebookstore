package example.chapter3;

import java.util.Set;

public class SetBean {

    public void setCups(Set cups) {
        for(Object obj : cups) {
            System.out.println(obj);
        }
    }
}
