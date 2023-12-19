import java.util.*;
import java.util.stream.Collectors;

public class TaxiHiringApp implements VehicleHiringTest {
    private Map<String, Vehicle> vehicles = new HashMap<>();
    DaraList<Taxi> taxis = new DaraList<>();

    private final TaxiMap map;

    public TaxiHiringApp() {
        this.vehicles = new HashMap<>();
        this.map = new TaxiMap();
    }

    @Override
    public boolean testAddToMap(String reg, Location loc) {
        System.out.println();
        if (TaxiDetails.doesTaxiExist(reg)) {
            // Check if the taxi is already on the map
            if (map.isTaxiOnMap(reg)) {
                System.out.println("Error: Taxi already on map.");
                return false;
            }

            int x = loc.getX();
            int y = loc.getY();

            boolean isValid = false;

            while (!isValid) {
                if (x >= 0 && x < map.getCols()) {
                    if (y >= 0 && y < map.getRows()) {
                        Taxi taxi = TaxiDetails.getTaxi(reg);
                        map.addTaxiToMap(y, x, taxi);
                        map.printMap();
                        System.out.println();

                        isValid = true;
                    } else {
                        System.out.println("Invalid Y Coordinates, please try again.");
                    }
                } else {
                    System.out.println("Invalid X coordinate, please try again.");
                }
            }
            return isValid;
        } else {
            System.out.println("Error: Taxi does not exist.");
            return false;
        }
    }

    @Override
    public boolean testMoveVehicle(String reg, Location loc) {
        if (!TaxiDetails.doesTaxiExist(reg)) {
            return false;
        }

        int x = loc.getX();
        int y = loc.getY();

        boolean isValid = false;

        while (!isValid) {
            if (x >= 0 && x <= map.getCols()) {
                if (y >= 0 && y <= map.getRows()) {
                    TaxiDetails.getTaxi(reg);
                    System.out.println();
                    map.moveTaxi(reg, loc);
                    map.printMap();
                    System.out.println();

                    isValid = true;
                } else {
                    System.out.println("Invalid X coordinate, please try again.");
                }
            } else {
                System.out.println("Invalid Y coordinate, please try again: ");
            }
        }
        return isValid;
    }


    @Override
    public boolean testRemoveVehicle(String reg) {
        map.removeTaxiFromMap(reg);
        map.printMap();
        return true;
    }

    @Override
    public Location testGetVehicleLoc(String reg) {
        // Check if the taxi exists
        if (TaxiDetails.doesTaxiExist(reg)) {
            for (int i = 0; i < map.getRows(); i++) {
                for (int j = 0; j < map.getCols(); j++) {
                    MapCell currentCell = map.getArray()[i][j];
                    if (currentCell.containsTaxi(reg)) {
                        return new Location(i, j);
                    }
                }
            }
            System.out.println("Error: Taxi not found on the map.");
            return null;
        } else {
            System.out.println("Error: Taxi does not exist.");
            return null;
        }
    }

    @Override
    public List<String> testGetVehiclesInRange(Location loc, int r) {
        return vehicles.values().stream()
                .filter(vehicle -> getMap().isWithinRange(vehicle.getLocation(), loc, r))
                .map(Vehicle::getRegistrationNumber)
                .collect(Collectors.toList());
    }
    public TaxiMap getMap() {
        return this.map;
    }
}