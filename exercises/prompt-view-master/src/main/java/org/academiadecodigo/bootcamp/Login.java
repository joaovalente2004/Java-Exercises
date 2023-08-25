package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Account;
import org.academiadecodigo.bootcamp.AccountType;
import org.academiadecodigo.bootcamp.Customer;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        String[] emails = new String[200];
        String phone;

        Map<String, Customer> customers = new HashMap<>();

        Prompt prompt = new Prompt(System.in, System.out);
        PasswordInputScanner scannerPassword = new PasswordInputScanner();

        BufferedReader reader = null;

        BufferedWriter writer = null;

        int answerIndex = 0;

        while (answerIndex != 3) {
            scanner.nextLine();
            System.out.println("\u001B[32m" + "Welcome to the new application page! \n" + "\u001B[0m");
            System.out.println("\u001B[31m" + "Select one of the options below :" + "\u001B[0m");

            String[] options = {"Login", "Create Account", "Exit"};
            MenuInputScanner scanner1 = new MenuInputScanner(options);
            answerIndex = prompt.getUserInput(scanner1);

            reader = new BufferedReader(new FileReader("src/main/resources/credentials.txt"));
            String line = reader.readLine();
            int emailIndex = 0;
            while (line != null) {
                String[] credentials = line.split(" ");
                String email = credentials[2]; // índice 2 contém o email

                emails[emailIndex] = email;
                emailIndex++;

                line = reader.readLine();
            }
            reader.close();


            switch (answerIndex) {
                case 1:
                    System.out.println("Please enter your email : ");
                    String email = scanner.nextLine();

                    String savedEmail = "";

                    // check if email is in the file

                    boolean emailFound = false;

                    for (int i = 0; i < emailIndex; i++) {
                        if (email.equals(emails[i])) {
                            emailFound = true;
                            break;
                        }
                    }
                    int answerIndex3 = 0;

                    if (emailFound) {
                        while (answerIndex3 != 4) {

                            // Obtenha o customer do mapa
                            Customer customer = customers.get(email);
                            System.out.println("\u001B[32m" + "Welcome " + customer.getFirstName() + " " + customer.getLastName() + "!" + "\u001B[0m");

                            System.out.println("\u001B[31m" + "Select one of the options below :" + "\u001B[0m");
                            String[] options3 = {"View Balance", "Transfer Money", "Withdraw Money", "Exit"};
                            MenuInputScanner scanner3 = new MenuInputScanner(options3);
                            answerIndex3 = prompt.getUserInput(scanner3);

                            switch (answerIndex3) {
                                case 1:
                                    System.out.println("Your balance is : " + customer.getAccount().getBalance());
                                    break;
                                case 2:
                                    System.out.println("Please enter the amount you want to transfer : ");
                                    double amount = scanner.nextDouble();
                                    customer.getAccount().withdraw(amount);
                                    System.out.println("Your new balance is : " + customer.getAccount().getBalance());
                                    break;
                                case 3:
                                    System.out.println("Please enter the amount you want to withdraw : ");
                                    double amount2 = scanner.nextDouble();
                                    customer.getAccount().withdraw(amount2);
                                    System.out.println("Your new balance is : " + customer.getAccount().getBalance());
                                    break;
                                case 4:
                                    System.out.println("Thank you for using our application!");
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                                    break;
                            }

                        }
                    } else {
                        System.out.println("Email not found!");
                    }
                    break;


                case 2:
                    String[] options2 = {"Saving Account", "Checking Account"};
                    MenuInputScanner scanner2 = new MenuInputScanner(options2);
                    int answerIndex2 = prompt.getUserInput(scanner2);

                    System.out.println("Please enter your First Name : ");
                    firstName = scanner.nextLine();
                    System.out.println("");
                    System.out.println("Please enter your Last Name : ");
                    lastName = scanner.nextLine();
                    System.out.println("");
                    System.out.println("Please enter your email : ");
                    String newEmail = scanner.nextLine();
                    System.out.println("");
                    System.out.println("Please enter your phone number : ");
                    phone = scanner.nextLine();
                    System.out.println("");

                    Customer customer = new Customer(firstName, lastName, newEmail, phone);
                    customers.put(newEmail, customer);

                    writer = new BufferedWriter(new FileWriter("src/main/resources/credentials.txt", true));
                    writer.write(firstName + " " + lastName + " " + newEmail + " " + phone);
                    writer.newLine();
                    writer.close();

                    System.out.println("Your account has been created! \n");
                    System.out.println("Your credentials are: " + customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail() + " " + customer.getPhone());

                    Account account;
                    if (answerIndex2 == 1) {
                        account = new Account(customer, AccountType.SAVINGACCOUNT);
                    } else {
                        account = new Account(customer, AccountType.CHECKINGACCOUNT);
                    }

                    customer.setAccount(account);

                    System.out.println("How much money do you want to deposit? ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);

                    System.out.println("Your account type is: " + account.getAccountType());
                    System.out.println("Your balance is: " + account.getBalance());

                    break;

                case 3:
                    System.out.println("You are logged out!");
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
