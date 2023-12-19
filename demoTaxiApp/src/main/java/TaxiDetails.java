import java.util.Scanner;

public class TaxiDetails {
    static Scanner sc = new Scanner(System.in);
    static DaraList<Taxi> taxiRegistry = new DaraList<>();

    public static String regNumber() {
        while (true) {
            System.out.println("Enter taxi's 5 digit registration number: ");
            String regNumber = sc.nextLine();
             if (regNumber.length() == 5 && regNumber.matches("\\d{5}")) {
                System.out.println("Taxi's registration number is: " + regNumber);
                return regNumber;
            } else {
                System.out.println("Invalid registration number, please enter a new registration number: ");
                System.out.println();
            }
        }
    }

    public static String driverName() {
        while (true) {
            String regex = "^[a-zA-Z]+$";
            System.out.println("Enter driver's name: ");
            String driverName = sc.nextLine();
            if (driverName.matches(regex)) {
                return driverName;
            } else {
                System.out.println("Invalid driver name, please try again: ");
            }
        }
    }

    public static String taxiSize() {
        while (true) {
            System.out.println("Enter taxi's capacity: (2 options; regular (4 people) or XL (6 people)");
            String taxiSize = sc.nextLine();
            if ("regular".equalsIgnoreCase(taxiSize) || "XL".equalsIgnoreCase(taxiSize)) {
                return taxiSize;
            } else {
                System.out.println("Invalid taxi size. Please re-enter one of the two valid sizes given.");
                System.out.println();
            }
        }
    }

    public static Location taxiLocation() {
        while(true) {
            System.out.println("Enter the X and Y coordinates for the taxi separated by a space: ");
            String location = sc.nextLine();
            String[] coords = location.trim().split(" ");
            if(coords.length != 2) {
                System.out.println("Invalid coordinates entered, please try again. ");
            } else {
                return new Location(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
            }
        }
    }

    public static void registerVehicle() {
        System.out.println();
        var reg = regNumber();
        if(TaxiDetails.doesTaxiExist(reg)) {
            System.out.println("Error: Taxi already exists");
            return;
        }
        System.out.println();
        var driver = driverName();
        System.out.println();
        var taxiSize = taxiSize();
        taxiRegistry.add(new Taxi(reg, driver, taxiSize));
        System.out.println();
        System.out.println(taxiRegistry);
    }

    public static boolean doesTaxiExist(String regNumber) {
        return taxiRegistry.contains(new Taxi(regNumber));
    }

    public static Taxi getTaxi(String reg) {
        Object[] taxis = taxiRegistry.toArray();
        for(Object t : taxis) {
            if(t != null && ((Taxi)t).regNumber.equals(reg)) {
                return (Taxi)t;
            }
        }
        return null;
    }
}
