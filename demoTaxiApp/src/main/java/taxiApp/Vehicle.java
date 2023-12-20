package taxiApp;

public class Vehicle {

    //Creation of classes private variables.
    private static String registrationNumber;
    private static Location location;

    //Creation of constructor for the Vehicle class.
    public Vehicle(String registrationNumber, Location location) {
        this.registrationNumber = registrationNumber;
        this.location = location;
    }

    //Getter methods for private variables.
    public static Location getLocation() {
        return location;
    }

    public static String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}