import java.util.Objects;

public class Taxi {
    public String driverName;
    public String taxiSize;
    public String regNumber;

    public Taxi(String regNumber, String driverName, String taxiSize) {
        this.driverName = driverName;
        this.taxiSize = taxiSize;
        this.regNumber = regNumber;
    }

    public Taxi(String regNumber) {
        this.driverName = null;
        this.taxiSize = null;
        this.regNumber = regNumber;
    }

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

    @Override
    public String toString() {
        return "Taxi{regNumber='" + regNumber + "', driverName='" + driverName + "', taxiSize=" + taxiSize + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxi taxi = (Taxi) o;
        return Objects.equals(regNumber, taxi.regNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }

    public String getRegNumber() {
        return regNumber;
    }
}
