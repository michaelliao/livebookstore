package example.chapter2;

public class HelloWorldImpl implements HelloWorld {

    private String name = null;

    public void setName(String name) {
        this.name = name;
    }

    public String say() {
        if(name==null)
            return "Hello, world!";
        return "Hello, " + name + "!";
    }

}
