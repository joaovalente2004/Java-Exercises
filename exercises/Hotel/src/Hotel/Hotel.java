package Hotel;

import java.util.Scanner;

public class Hotel {


    private Room[] rooms;

    public Hotel() {

        this.rooms = new Room[100];

        for (int i = 0; i < rooms.length; i++) {

            rooms[i] = new Room(i + 1, i + 1);

        }

    }

    public void checkout() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your room key to check out");
        int roomNumber = scanner.nextInt();

        for (int i = 0; i < rooms.length; i++) {

            if (rooms[i].getNumber() == roomNumber) {

                if (rooms[i].getisavailable() == 1) {


                    System.out.println("You are checked out");
                    System.out.println("Thank you for using our hotel");
                    //remove client from room
                    rooms[i].setisavailable(0);

                } else {
                    System.out.println("This room is not available");
                }

            }

        }
    }


    //creat 40 rooms


    public String checkin() {


        Scanner scanner = new Scanner(System.in);



        System.out.println("Enter your name");
        String name = scanner.nextLine();



            System.out.println("Enter your room");
            int roomNumber = scanner.nextInt();

            for (int i = 0; i < rooms.length; i++) {
                Client client = new Client(name, roomNumber);


                if (rooms[i].getNumber() == roomNumber) {


                    if (rooms[i].getisavailable() == 0) {

                        client.setKey(roomNumber);

                        System.out.println("Welcome to our hotel : " + client.getName() + " your room number is : " + client.getKey());

                        rooms[i].setisavailable(1);
                        System.out.println("You are checked in");

                    } else {
                        System.out.println("This room is not available");
                    }


                }

            }

        return name;

        }

}

























