package example.chapter3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InstanceFactoryBean {

    private String format = "yy-MM-dd HH:mm:ss";

    public void setFormat(String format) {
        this.format = format;
    }

    public String createTime() {
        return new SimpleDateFormat(format).format(new Date());
    }
}
