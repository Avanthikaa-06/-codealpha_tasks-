package org.hotel;

public class roomdetails {
    private int roomno;
    private String roomtype;
    private double roomprice;
    private String roomstatus;
    private String guestname;

    public roomdetails(int roomno, String roomtype, double roomprice, String roomstatus, String guestname) {
        this.roomno = roomno;
        this.roomtype = roomtype;
        this.roomprice = roomprice;
        this.roomstatus = roomstatus;
        this.guestname = guestname;
    }

    public int getroomno() {
        return roomno;
    }

    public String getroomtype() {
        return roomtype;
    }

    public double getroomprice() {
        return roomprice;
    }

    public String getroomstatus() {
        return roomstatus;
    }

    public String getguestname() {
        return guestname;
    }

    public void setroomstatus(String status) {
        this.roomstatus = status;
    }

    public void setguestname(String name) {
        this.guestname = name; 
    }
}
