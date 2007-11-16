// file: Greeting.groovy

import example.chapter9.Greeting;

class GroovyGreeting implements Greeting {
    String msg;

    String getMessage() {
        return msg;
    }

    void setMessage(String msg) {
        this.msg = msg;
    }
}
