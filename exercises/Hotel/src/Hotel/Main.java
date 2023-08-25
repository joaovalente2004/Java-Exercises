package Hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        Scanner scanner = new Scanner(System.in);






        System.out.println("Welcome to our hotel");
        System.out.println("Select your option from the menu: \n 1 - check in, \n 2 - check out, \n 3 - exit");
        int option = scanner.nextInt();

        while (option != 3) {

            if (option == 1) {

                hotel.checkin();

            } else if (option == 2) {

                hotel.checkout();

            } else if (option == 3) {

                System.out.println("Thank you for using our hotel");
                break;

            } else {

                System.out.println("Invalid option");
            }

            System.out.println("Select your option from the menu 1 - check in, 2 - check out, 3 - exit");
            option = scanner.nextInt();

        }










    }






}
