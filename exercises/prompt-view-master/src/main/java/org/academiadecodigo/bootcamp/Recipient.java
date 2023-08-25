package org.academiadecodigo.bootcamp;

public class Recipient {

    private String name;

    private String description;

    private Integer accountNumber;

    private String email;

    private String phone;

    Customer customer;


    public Recipient(String name, String description, Integer accountNumber, String email, String phone, Customer customer) {
        this.name = name;
        this.description = description;
        this.accountNumber = accountNumber;
        this.email = email;
        this.phone = phone;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
