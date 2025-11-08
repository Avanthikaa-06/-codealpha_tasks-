package org.hotel;

import java.io.IOException;
import java.util.Scanner;

public class userinterface {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        viewrooms vr = new viewrooms();

       
        String filePath = "C:\\Users\\Avanthikaa S G\\OneDrive\\Desktop\\codealpha\\Hotel_Reservation_System\\src\\rooms.txt";
        vr.loadroomsdetails(filePath);

        Booking booking = new Booking(vr);

        while (true) {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. VIEW ROOMS");
            System.out.println("2. BOOK ROOM");
            System.out.println("3. CANCEL BOOKING");
            System.out.println("4. VIEW ALL BOOKINGS");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice (1-5): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    vr.displayRooms();
                    break;
                case 2:
                    booking.bookRoom(sc, filePath);
                    break;
                case 3:
                    booking.cancelRoom(sc, filePath);
                    break;
                case 4:
                    booking.viewAllBookings();
                    break;
                case 5:
                    System.out.println("Thank you for using our system! Goodbye 👋");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

