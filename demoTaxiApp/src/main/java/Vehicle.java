public class Vehicle {
    private static String registrationNumber;
    private static Location location;

    public Vehicle(String registrationNumber, Location location) {
        this.registrationNumber = registrationNumber;
        this.location = location;
    }

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