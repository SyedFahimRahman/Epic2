package taxiApp;

import java.util.Objects;

public class Taxi {

    //Creating private class variables.
    private String driverName;
    private String taxiSize;
    public String regNumber;

    //Creating taxi constructor for Taxi object to store a regNumber, driverName and taxiSize.
    public Taxi(String regNumber, String driverName, String taxiSize) {
        this.driverName = driverName;
        this.taxiSize = taxiSize;
        this.regNumber = regNumber;
    }

    //Creating another constructor so a Taxi can be located using only it's specific regNumber.
    public Taxi(String regNumber) {
        this.driverName = null;
        this.taxiSize = null;
        this.regNumber = regNumber;
    }

    //Getters and setters for the private class variables.
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTaxiSize() {
        return taxiSize;
    }

    public void setTaxiSize(String taxiSize) {
        this.taxiSize = taxiSize;
    }

    public String getRegNumber() {
        return regNumber;
    }

    //Overriding the Taxi classes toString method.
    @Override
    public String toString() {
        return "Taxi{regNumber='" + regNumber + "', driverName='" + driverName + "', taxiSize=" + taxiSize + "}";
    }

    //Overriding the Taxi classes .equals function.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxi taxi = (Taxi) o;
        return Objects.equals(regNumber, taxi.regNumber);
    }

    //Overriding the Taxi classes hashCode function.
    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }

}
