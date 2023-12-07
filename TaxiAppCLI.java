import java.util.List;
import java.util.Scanner;

public class TaxiAppCLI {
    public static void main(String[] args) {
        TaxiHiringApp taxiApp = new TaxiHiringApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Vehicle");
            System.out.println("2. Move Vehicle");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Get Vehicle Location");
            System.out.println("5. Get Vehicles in Range");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter registration number: ");
                    String regNumber = scanner.nextLine();
                    System.out.print("Enter x coordinate: ");
                    int x = scanner.nextInt();
                    System.out.print("Enter y coordinate: ");
                    int y = scanner.nextInt();
                    Location location = new Location(x, y);
                    if (taxiApp.testAddToMap(regNumber, location)) {
                        System.out.println("Vehicle added successfully!");
                    } else {
                        System.out.println("Failed to add vehicle. Registration number already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter registration number: ");
                    String moveRegNumber = scanner.nextLine();
                    System.out.print("Enter new x coordinate: ");
                    int newX = scanner.nextInt();
                    System.out.print("Enter new y coordinate: ");
                    int newY = scanner.nextInt();
                    Location newLocation = new Location(newX, newY);
                    if (taxiApp.testMoveVehicle(moveRegNumber, newLocation)) {
                        System.out.println("Vehicle moved successfully!");
                    } else {
                        System.out.println("Failed to move vehicle. Vehicle not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter registration number to remove: ");
                    String removeRegNumber = scanner.nextLine();
                    if (taxiApp.testRemoveVehicle(removeRegNumber)) {
                        System.out.println("Vehicle removed successfully!");
                    } else {
                        System.out.println("Failed to remove vehicle. Vehicle not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter registration number to get location: ");
                    String getLocationRegNumber = scanner.nextLine();
                    Location vehicleLocation = taxiApp.testGetVehicleLoc(getLocationRegNumber);
                    if (vehicleLocation != null) {
                        System.out.println("Vehicle location: " + vehicleLocation.getX() + ", " + vehicleLocation.getY());
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
                    System.out.print("Enter range radius: ");
                    int rangeRadius = scanner.nextInt();
                    List<String> vehiclesInRange = taxiApp.testGetVehiclesInRange(rangeCenter, rangeRadius);
                    System.out.println("Vehicles in range: " + vehiclesInRange);
                    break;

                case 6:
                    System.out.println("Exiting the Taxi Hiring App. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}