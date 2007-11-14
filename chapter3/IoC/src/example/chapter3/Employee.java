package example.chapter3;

import java.io.Serializable;

public class Employee implements Serializable {

    private String name;
    private String title;
    private String company;
    private String department;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

}
