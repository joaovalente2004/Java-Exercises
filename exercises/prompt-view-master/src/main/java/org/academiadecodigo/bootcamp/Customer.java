package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Account;
import org.academiadecodigo.bootcamp.Recipient;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    List<Account> accounts = new ArrayList<>();
    List<Recipient> recipients = new ArrayList<>();

    private static List<Customer> customers = new ArrayList<>();

    public Customer(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Account getAccount() {
        for (Account account : accounts) {
            if (account.getCustomer().getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }

    public static Customer getCustomer(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addRecipient(Recipient recipient) {
        recipients.add(recipient);
    }

    public void removeRecipient(Recipient recipient) {
        recipients.remove(recipient);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void checkAccounts() {
        System.out.println("You have " + accounts.size() + " accounts.");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setAccount(Account account) {
        accounts.add(account);
    }
}
