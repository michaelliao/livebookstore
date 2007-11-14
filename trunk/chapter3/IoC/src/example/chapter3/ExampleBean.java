package example.chapter3;

import java.util.ArrayList;
import java.util.List;

public class ExampleBean {

    private List list;
    private int size = 100;
    private String version;

    public void setSize(int size) {
        this.size = size;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void init() {
        list = new ArrayList(size);
    }
}
