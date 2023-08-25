package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.AccountType;
import org.academiadecodigo.bootcamp.Customer;

public class Account {

    private double balance;
    private Customer customer;
    private AccountType accountType;

    public Account(Customer customer, AccountType accountType) {
        this.customer = customer;
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(Account destination, double amount) {
        withdraw(amount);
        destination.deposit(amount);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", customer=" + customer +
                ", accountType=" + accountType +
                '}';
    }
}
