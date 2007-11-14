package example.chapter3;

import java.net.URL;

public class BasicBean {

    private String title;

    public void setUseCache(boolean useCache) {}

    public void setMaxSize(int size) {}

    public String getTitle() { return title; }
    public void setTitle(String title) {this.title = title;}

    public void setFile(URL url) {
        System.out.println(url);
    }
}
