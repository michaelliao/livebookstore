package example.chapter3;

public class Contact {

    private String name;
    private String address;
    private String zip;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String toString() {
        return name + "; " + address + "; " + zip;
    }
}
