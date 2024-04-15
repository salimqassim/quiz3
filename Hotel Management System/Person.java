public class Person {
    private String id;
    private String name;
    private String surname;

    public Person(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

public class Room {
    private int number;
    private boolean booked;

    public Room(int number) {
        this.number = number;
        this.booked = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        booked = true;
    }

    public void checkout() {
        booked = false;
    }
}

import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private String hotelName;
    private List<Room> rooms;

    public HotelManager(String hotelName, int numberOfRooms) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public void checkIn(Person guest, int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                if (!room.isBooked()) {
                    room.book();
                    System.out.println("Welcome, " + guest.getName() + "! You have successfully checked into room " + roomNumber + ".");
                    return;
                } else {
                    System.out.println("Sorry, room " + roomNumber + " is already booked.");
                    return;
                }
            }
        }
        System.out.println("Room " + roomNumber + " does not exist in " + hotelName + ".");
    }

    public void checkOut(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                if (room.isBooked()) {
                    room.checkout();
                    System.out.println("Thank you! Room " + roomNumber + " has been checked out.");
                    return;
                } else {
                    System.out.println("Room " + roomNumber + " is not currently booked.");
                    return;
                }
            }
        }
        System.out.println("Room " + roomNumber + " does not exist in " + hotelName + ".");
    }
}
