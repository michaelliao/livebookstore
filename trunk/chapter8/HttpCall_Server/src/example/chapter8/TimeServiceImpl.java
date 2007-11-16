package example.chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServiceImpl implements TimeService {

    public String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
