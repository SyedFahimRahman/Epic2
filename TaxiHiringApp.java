import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaxiHiringApp implements VehicleHiringTest {
    private Map<String, Vehicle> vehicles = new HashMap<>();
    public TaxiHiringApp() {
        this.vehicles = new HashMap<>();
    }
    @Override
    public boolean testAddToMap(String reg, Location loc) {
        return false;
    }

    @Override
    public boolean testMoveVehicle(String reg, Location loc) {
        Vehicle vehicle = vehicles.get(reg);
        if (vehicle != null) {
            vehicle.setLocation(loc);
            return true;
        }
        return false;
    }

    @Override
    public boolean testRemoveVehicle(String reg) {
        return vehicles.remove(reg) != null;
    }

    @Override
    public Location testGetVehicleLoc(String reg) {
        Vehicle vehicle = vehicles.get(reg);
        return (vehicle != null) ? vehicle.getLocation() : null;
    }

    @Override
    public List<String> testGetVehiclesInRange(Location loc, int r) {
        return vehicles.values().stream()
                .filter(vehicle -> isWithinRange(vehicle.getLocation(), loc, r))
                .map(Vehicle::getRegistrationNumber)
                .collect(Collectors.toList());
    }

    private boolean isWithinRange(Location loc1, Location loc2, int r) {
        return false;
    }
}