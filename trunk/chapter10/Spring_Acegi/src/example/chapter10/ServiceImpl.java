package example.chapter10;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceImpl implements Service {

    private Log log = LogFactory.getLog(getClass());

    public void createOrder(String orderId) {
        log.info("createOrder");
    }

}
