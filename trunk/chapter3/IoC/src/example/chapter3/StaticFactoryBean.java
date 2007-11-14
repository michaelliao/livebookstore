package example.chapter3;

import java.util.Random;

public class StaticFactoryBean {

    public static Integer createRandom() {
        return new Integer(new Random().nextInt());
    }
}
