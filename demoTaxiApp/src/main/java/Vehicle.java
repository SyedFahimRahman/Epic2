public class Vehicle {
    private String registrationNumber;
    private Location location;

    public Vehicle(String registrationNumber, Location location) {
        this.registrationNumber = registrationNumber;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}