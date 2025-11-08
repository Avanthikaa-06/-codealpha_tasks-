package org.hotel;

import java.util.Scanner;
import java.io.IOException;

public class Booking {
    private viewrooms vr;

    public Booking(viewrooms vr) {
        this.vr = vr;
    }


    public void bookRoom(Scanner sc, String filename) throws IOException {
        System.out.print("Enter Room Number to book: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        boolean roomFound = false;

        for (roomdetails room : vr.rooms) {
            if (room.getroomno() == roomNo) {
                roomFound = true;

                if (room.getroomstatus().equalsIgnoreCase("Available")) {
                    System.out.println("\nRoom Details:");
                    System.out.println("Type: " + room.getroomtype());
                    System.out.println("Price: ₹" + room.getroomprice());

                    System.out.print("Do you want to proceed with booking? (yes/no): ");
                    String confirm = sc.nextLine();
                    if (!confirm.equalsIgnoreCase("yes")) {
                        System.out.println("Booking cancelled by user.");
                        return;
                    }

                 
                    System.out.println("\nSelect Payment Method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. UPI");
                    System.out.println("3. Cash at Counter");
                    System.out.print("Enter your choice: ");
                    int payChoice = sc.nextInt();
                    sc.nextLine();

                    switch (payChoice) {
                        case 1:
                            System.out.print("Enter last 4 digits of your card: ");
                            sc.nextLine();
                            System.out.println("Processing payment of ₹" + room.getroomprice() + "...");
                            System.out.println("Payment Successful via Credit Card ✅");
                            break;

                        case 2:
                            System.out.print("Enter your UPI ID: ");
                            sc.nextLine();
                            System.out.println("Processing payment of ₹" + room.getroomprice() + "...");
                            System.out.println("Payment Successful via UPI ✅");
                            break;

                        case 3:
                            System.out.println("Payment will be made at hotel counter.");
                            break;

                        default:
                            System.out.println("Invalid payment option! Booking cancelled.");
                            return;
                    }

                    System.out.print("Enter Guest Name: ");
                    String guestName = sc.nextLine();
                    room.setroomstatus("Booked");
                    room.setguestname(guestName);
                    vr.saveroomsdetails(filename);

                    System.out.println("\nRoom " + roomNo + " booked successfully for " + guestName + "!");
                    return;
                } else {
                    System.out.println("Room is already booked!");
                    return;
                }
            }
        }

        if (!roomFound) {
            System.out.println("Room not found!");
        }
    }

   
    public void cancelRoom(Scanner sc, String filename) throws IOException {
        System.out.print("Enter Room Number to cancel booking: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        boolean roomFound = false;

        for (roomdetails room : vr.rooms) {
            if (room.getroomno() == roomNo) {
                roomFound = true;

                if (room.getroomstatus().equalsIgnoreCase("Booked")) {
                    System.out.print("Are you sure you want to cancel booking for Room " + roomNo + "? (yes/no): ");
                    String confirm = sc.nextLine();
                    if (!confirm.equalsIgnoreCase("yes")) {
                        System.out.println("Cancellation aborted by user.");
                        return;
                    }

                    room.setroomstatus("Available");
                    room.setguestname("-");
                    vr.saveroomsdetails(filename);

                    System.out.println("Booking for Room " + roomNo + " cancelled successfully.");
                    return;
                } else {
                    System.out.println("Room is not booked!");
                    return;
                }
            }
        }

        if (!roomFound) {
            System.out.println("Room not found!");
        }
    }

  
    public void viewAllBookings() {
        System.out.println("\n----- Booked Rooms -----");
        System.out.printf("%-7s %-10s %-9s %-12s %-10s%n", "RoomNo", "Type", "Price", "Status", "Guest");
        boolean found = false;

        for (roomdetails room : vr.rooms) {
            if (room.getroomstatus().equalsIgnoreCase("Booked")) {
                found = true;
                System.out.printf("%-7d %-10s %-9.2f %-12s %-10s%n",
                        room.getroomno(),
                        room.getroomtype(),
                        room.getroomprice(),
                        room.getroomstatus(),
                        room.getguestname());
            }
        }

        if (!found) {
            System.out.println("No bookings found.");
        }
    }
}
