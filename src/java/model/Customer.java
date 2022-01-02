package model;

import java.io.Serializable;

public class Customer implements Serializable{
    private int id;
    private String email;
    private String phone;
    private Account account;
    private Address address;
    private Fullname fullname;

    public Customer() {}
    
    public Customer(int id, String email, String phone, Account account, Address address, Fullname fullname) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.account = account;
        this.address = address;
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Fullname getFullname() {
        return fullname;
    }

    public void setFullname(Fullname fullname) {
        this.fullname = fullname;
    }
}
