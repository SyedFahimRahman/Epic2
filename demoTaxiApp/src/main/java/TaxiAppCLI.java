import java.util.List;
import java.util.Scanner;

public class TaxiAppCLI {
    public static void taxiAppCLI() {
        TaxiHiringApp taxiApp = new TaxiHiringApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n0. Register Vehicle");
            System.out.println("1. Add Vehicle To Map");
            System.out.println("2. Move Vehicle");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Get Vehicle Location");
            System.out.println("5. Get Vehicles in Range");
            System.out.println("6. View Map Cell");
            System.out.println("7. Add Dummy Data");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 0:
                    TaxiDetails.registerVehicle();
                    break;

                case 1:
                    taxiApp.addToMap(TaxiDetails.regNumber(), TaxiDetails.taxiLocation());
                    break;

                case 2:
                    taxiApp.moveVehicle(TaxiDetails.regNumber(), TaxiDetails.taxiLocation());
                    break;

                case 3:
                    taxiApp.removeVehicle(TaxiDetails.regNumber());
                    break;

                case 4:
                    System.out.print("Enter registration number to get location: ");
                    String getLocationRegNumber = scanner.nextLine();
                    Location vehicleLocation = taxiApp.getVehicleLoc(getLocationRegNumber);
                    if (vehicleLocation != null) {
                        System.out.println("Vehicle location: " + vehicleLocation.getY() + ", " + vehicleLocation.getX());
                    } else {
                        System.out.println("Vehicle not found or not on the map.");
                    }
                    break;

                case 5:
                    System.out.print("Enter x coordinate for range center: ");
                    int rangeX = scanner.nextInt();
                    System.out.print("Enter y coordinate for range center: ");
                    int rangeY = scanner.nextInt();
                    Location rangeCenter = new Location(rangeX, rangeY);
                    int rangeRadius = 5;
                    List<String> vehiclesInRange = taxiApp.getVehiclesInRange(rangeCenter, rangeRadius);
                    System.out.println("Vehicles in range: " + vehiclesInRange);
                    break;

                case 6:
                    TaxiMap.printCellContents();
                    break;

                case 7:
                    DummyData.addDummyDataToMap();
                    break;

                case 8:
                    System.out.println("Exiting the Taxi Hiring App. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}