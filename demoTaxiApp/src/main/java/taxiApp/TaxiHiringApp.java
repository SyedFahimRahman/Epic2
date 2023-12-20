package taxiApp;

import java.util.ArrayList;
import java.util.List;

public class TaxiHiringApp {

    TaxiMap map = new TaxiMap();

    public void addToMap(String reg, Location loc) {
        System.out.println();
        if (TaxiDetails.doesTaxiExist(reg)) {
            // Check if the taxi is already on the map
            if (map.isTaxiOnMap(reg)) {
                System.out.println("Error: taxiApp.Taxi already on map.");
                return;
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
                        isValid = true;
                    } else {
                        System.out.println("Invalid Y Coordinates, please try again.");
                    }
                } else {
                    System.out.println("Invalid X coordinate, please try again.");
                }
            }
        } else {
            System.out.println("Error: taxiApp.Taxi does not exist.");
        }
    }


    public void moveVehicle(String reg, Location loc) {
        if (!TaxiDetails.doesTaxiExist(reg)) {
            return;
        }

        int x = loc.getX();
        int y = loc.getY();

        boolean isValid = false;

        while (!isValid) {
            if (x >= 0 && x <= map.getCols()) {
                if (y >= 0 && y <= map.getRows()) {
                    TaxiDetails.getTaxi(reg);
                    System.out.println();
                    map.moveVehicle(reg, loc);
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
    }

    public void removeVehicle(String reg) {
        map.removeTaxiFromMap(reg);
        map.printMap();
    }

    public Location getVehicleLoc(String reg) {
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
            System.out.println("Error: taxiApp.Taxi not found on the map.");
            return null;
        } else {
            System.out.println("Error: taxiApp.Taxi does not exist.");
            return null;
        }
    }

    public List<String> getVehiclesInRange(Location loc, int r) {
        List<String> vehiclesInRange = new ArrayList<>();

        int centerX = loc.getX();
        int centerY = loc.getY();

        for(int i = Math.max(0, centerX - r); i <= Math.min(map.getCols() - 1, centerX + r); i++){
            for(int j = Math.max(0, centerY - r); j <= Math.min(map.getRows() - 1, centerY + r); j++) {
                if(map.isWithinRange(new Location(i, j), loc, r)) {
                    for(Taxi taxi : map.getArray()[j][i].getTaxis()) {
                        vehiclesInRange.add(taxi.getRegNumber());
                    }
                }
            }
        }
        return vehiclesInRange;
    }
}
