package models.response.users;

public class UsersResponsePojo {

    private int id;
    private String name;
    private String username;



    public UsersResponsePojo(int id, String name, String username, String email, AddressObject address, String phone, String website, CompanyObject company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    private String email;
    private AddressObject address;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public CompanyObject getCompany() {
        return company;
    }

    public void setCompany(CompanyObject company) {
        this.company = company;
    }

    private String phone;
    private String website;
    private CompanyObject company;

    public UsersResponsePojo(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressObject getAddress() {
        return address;
    }

    public void setAddress(AddressObject addressObject) {
        this.address = addressObject;
    }
}
