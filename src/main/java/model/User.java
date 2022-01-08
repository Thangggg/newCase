package model;

public class User {
    private int id ;
    private  String nameUser;
    private  String password;
    private  String phone ;
    private  String address;
    private String email;
    private  int roll;

    public User(int id, String nameUser, String password, String phone, String address, String email, int roll) {
        this.id = id;
        this.nameUser = nameUser;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.roll = roll;
    }

    public User(String nameUser, String password, String phone, String address, String email) {
        this.nameUser = nameUser;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}
