package example.chapter3;

public class ConstructorBean {

    public ConstructorBean(int min, int max) {
        System.out.println("(int, int)");
    }

    public ConstructorBean(String min, String max) {
        System.out.println("(String, String)");
    }

}
