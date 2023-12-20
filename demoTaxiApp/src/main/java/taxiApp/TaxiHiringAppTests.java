package taxiApp;

import java.util.*;

public class TaxiHiringAppTests implements VehicleHiringTest{
    private Map<String, Vehicle> vehicles = new HashMap<>();

    private final TaxiMap map;

    public TaxiHiringAppTests() {
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
                    map.removeTaxiFromMap(reg);
                    Taxi taxi = TaxiDetails.getTaxi(reg);
                    if (TaxiMap.isValidIndex(TaxiMap.array, x, y)) {
                        TaxiMap.array[x][y].addTaxi(taxi);
                    } else {
                        System.out.println("Invalid index. Cannot move element.");
                    }
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
                    MapCell currentCell = map.getArray()[j][i];
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
        List<String> vehiclesInRange = new ArrayList<>();

        int centerX = loc.getX();
        int centerY = loc.getY();

        for (int i = Math.max(0, centerX - r); i <= Math.min(map.getCols() - 1, centerX + r); i++) {
            for (int j = Math.max(0, centerY - r); j <= Math.min(map.getRows() - 1, centerY + r); j++) {
                if (map.isWithinRange(new Location(i, j), loc, r)) {
                    for (Taxi taxi : map.getArray()[j][i].getTaxis()) {
                        String regNumber = taxi.getRegNumber();
                        if (!vehiclesInRange.contains(regNumber)) {
                            System.out.println("Taxi within range: " + regNumber);
                            vehiclesInRange.add(regNumber);
                        }
                    }
                }
            }
        }
        return vehiclesInRange;
    }
    public TaxiMap getMap() {
        return this.map;
    }
}