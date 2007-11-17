package example.chapter9;

import javax.management.AttributeChangeNotification;
import javax.management.NotificationBroadcasterSupport;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    private String name = "world";
    private long sequenceNumber;

    public String getName() { return name; }

    public synchronized void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        sendNotification(new AttributeChangeNotification(
                this,                        // 哪个对象的属性被更新了
                sequenceNumber++,            // 序列号
                System.currentTimeMillis(),  // 时间戳
                "Attribute 'name' changed!", // 描述
                "name",                      // 属性名称
                String.class.getName(),      // 属性的类型
                oldValue,                    // 更新前的属性值
                name                         // 更新后的属性值
        ));
    }

    public void sayHello() {
        System.out.println("Hello, " + name);
    }

}
