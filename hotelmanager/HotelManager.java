import java.util.HashMap;
import java.util.Map;

public class HotelManager {
    private String hotelName;
    private Map<String, Room> guestRooms;

    public HotelManager(String hotelName, int numberOfRooms) {
        this.hotelName = hotelName;
        this.guestRooms = new HashMap<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            Room room = new Room(i);
            guestRooms.put(null, room); // Initialize with null key
        }
    }

    public void checkIn(Person guest, int roomNumber) {
        Room room = guestRooms.get(guest.getId());
        if (room != null) {
            System.out.println("Guest with ID " + guest.getId() + " is already checked in to room " + room.getNumber());
            return;
        }
        room = getRoomByNumber(roomNumber);
        if (room != null) {
            if (!room.isBooked()) {
                room.book();
                guestRooms.put(guest.getId(), room);
                System.out.println("Welcome, " + guest.getName() + "! You have successfully checked into room " + roomNumber + ".");
            } else {
                System.out.println("Sorry, room " + roomNumber + " is already booked.");
            }
        } else {
            System.out.println("Room " + roomNumber + " does not exist in " + hotelName + ".");
        }
    }

    public void checkOut(String guestId) {
        Room room = guestRooms.get(guestId);
        if (room != null) {
            room.checkout();
            guestRooms.remove(guestId);
            System.out.println("Guest with ID " + guestId + " has successfully checked out from room " + room.getNumber() + ".");
        } else {
            System.out.println("Guest with ID " + guestId + " is not currently checked in to any room.");
        }
    }

    public void displayInfo() {
        System.out.println("Hotel Guests Information:");
        for (Map.Entry<String, Room> entry : guestRooms.entrySet()) {
            String guestId = entry.getKey();
            Room room = entry.getValue();
            if (guestId != null) {
                System.out.println("Guest ID: " + guestId + ", Room Number: " + room.getNumber());
            }
        }
    }

    private Room getRoomByNumber(int roomNumber) {
        for (Room room : guestRooms.values()) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

