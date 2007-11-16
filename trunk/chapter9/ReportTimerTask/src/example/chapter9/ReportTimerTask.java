package example.chapter9;

import java.util.Date;
import java.util.TimerTask;

public class ReportTimerTask extends TimerTask {

    public void run() {
        String log = "read from log file at " + new Date();
        System.out.println(log);
        // analyse...
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        // send mail...
    }

}
