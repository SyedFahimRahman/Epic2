package taxiApp;

import java.util.List;

//Test interface with all 5 of the projects core functions, used in the testing of said core functions.
public interface VehicleHiringTest {
    public abstract boolean testAddToMap(String reg, Location loc);
    public abstract boolean testMoveVehicle(String reg, Location loc);
    public abstract boolean testRemoveVehicle(String reg);
    public abstract Location testGetVehicleLoc(String reg);
    public abstract List<String> testGetVehiclesInRange(Location loc, int r);
}