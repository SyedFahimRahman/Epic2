import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaxiHiringApp implements VehicleHiringTest {
    @Override
    public boolean testAddToMap(String reg, Location loc) {
        return false;
    }

    @Override
    public boolean testMoveVehicle(String reg, Location loc) {
        return false;
    }

    @Override
    public boolean testRemoveVehicle(String reg) {
        return false;
    }

    @Override
    public Location testGetVehicleLoc(String reg) {
        return null;
    }

    @Override
    public List<String> testGetVehiclesInRange(Location loc, int r) {
        return null;
    }
}
