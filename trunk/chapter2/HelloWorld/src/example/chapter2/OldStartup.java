package example.chapter2;

public class OldStartup {

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorldImpl();
        hello.setName("Spring");
        System.out.println(hello.say());
    }

}
