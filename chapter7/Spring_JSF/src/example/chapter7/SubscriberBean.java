package example.chapter7;

public class SubscriberBean {

    private String name;
    private String email;
    private String language;

    private Service service = new ServiceImpl();

    public void setService(Service service) {
        this.service = service;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String submit() {
        // 处理订阅请求:
        service.subscribe(this);
        return "success";
    }
}
