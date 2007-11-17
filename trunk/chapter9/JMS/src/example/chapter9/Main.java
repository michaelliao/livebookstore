package example.chapter9;

public class Main {

    public static void main(String[] args) throws Exception {
        Mom4jUtil.startJmsServer();
        new Sender().start();
        new Receiver().start();
        Thread.sleep(30000);
        System.exit(0);
    }
}
