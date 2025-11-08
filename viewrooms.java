package org.hotel;

import java.io.*;
import java.util.*;

public class viewrooms {
    public List<roomdetails> rooms = new ArrayList<>();

   
    public void loadroomsdetails(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] roomlist = line.split("\\|");
            int roomno = Integer.parseInt(roomlist[0]);
            String roomtype = roomlist[1];
            double roomprice = Double.parseDouble(roomlist[2]);
            String roomstatus = roomlist[3];
            String guestname = roomlist[4];
            rooms.add(new roomdetails(roomno, roomtype, roomprice, roomstatus, guestname));
        }
        br.close();
    }

      public void displayRooms() {
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-7s %-10s %-10s %-12s %-10s%n", "RoomNo", "Type", "Price", "Status", "Guest");
        System.out.println("-------------------------------------------------------------");
        for (roomdetails r : rooms) {
            System.out.printf("%-7d %-10s %-10.2f %-12s %-10s%n",
                    r.getroomno(), r.getroomtype(), r.getroomprice(),
                    r.getroomstatus(), r.getguestname());
        }
    }

    
    public void saveroomsdetails(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (roomdetails r : rooms) {
            bw.write(r.getroomno() + "|" + r.getroomtype() + "|" + r.getroomprice() + "|" + 
                     r.getroomstatus() + "|" + r.getguestname());
            bw.newLine();
        }
        bw.close();
    }
}
