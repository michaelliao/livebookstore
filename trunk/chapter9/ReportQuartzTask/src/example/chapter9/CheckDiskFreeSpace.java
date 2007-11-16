package example.chapter9;

import java.util.Date;

public class CheckDiskFreeSpace {

    public void check() {
        // get disk free space:
        long freeSpace = Math.random() > 0.5 ? 100000000 : 200000000;
        System.out.println("Check disk free space at " + new Date());
        if(freeSpace<100*1024*1024) { // <100MB
            System.out.println("Warning! Low disk free space...");
        }
    }
}
