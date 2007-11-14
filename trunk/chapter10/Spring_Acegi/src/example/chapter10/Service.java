package example.chapter10;

import org.acegisecurity.annotation.Secured;

public interface Service {

    @Secured({"ROLE_USER"})
    void createOrder(String orderId);

}
