import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class TaxiHiringAppTest {

    @Test
    void testAddToMap() {
        TaxiDetails taxiDetails = new TaxiDetails();
        TaxiHiringApp taxiApp = new TaxiHiringApp();
        String reg = "12345";
        Location loc = new Location(2, 3);

        TaxiDetails.taxiRegistry.add(new Taxi(reg, "Dan", "regular"));

        assertTrue(taxiApp.testAddToMap(reg, loc));
        assertTrue(taxiApp.getMap().isTaxiOnMap(reg)); // Verify that taxi is on the map
    }

    @Test
    void testMoveVehicle() {
        TaxiHiringApp taxiApp = new TaxiHiringApp();
        String reg = "12345";
        Location initialLoc = new Location(2, 3);
        Location newLoc = new Location(4, 6);

        TaxiDetails.taxiRegistry.add(new Taxi(reg, "Dan", "regular"));

        assertTrue(taxiApp.testAddToMap(reg, initialLoc));
        assertTrue(taxiApp.testMoveVehicle(reg, newLoc));
        assertFalse(taxiApp.getMap().isTaxiOnMap(reg)); // Verify that taxi is not on the map at the old location
        assertTrue(taxiApp.getMap().isTaxiOnMap(reg));  // Verify that taxi is on the map at the new location
    }

    @Test
    void testRemoveVehicle() {
        TaxiHiringApp taxiApp = new TaxiHiringApp();
        String reg = "12345";
        Location loc = new Location(2, 3);

        TaxiDetails.taxiRegistry.add(new Taxi(reg, "Dan", "regular"));

        assertTrue(taxiApp.testAddToMap(reg, loc));
        assertTrue(taxiApp.testRemoveVehicle(reg));
        assertFalse(taxiApp.getMap().isTaxiOnMap(reg)); // Verify that taxi is not on the map after removal
    }

    @Test
    void testGetVehicleLoc() {
        TaxiHiringApp taxiApp = new TaxiHiringApp();
        String reg = "12345";
        Location loc = new Location(2, 3);

        assertTrue(taxiApp.testAddToMap(reg, loc));
        assertEquals(loc, taxiApp.testGetVehicleLoc(reg)); // Verify that retrieved location matches the expected location
    }

    @Test
    void testGetVehiclesInRange() {
        DummyData dummyData = new DummyData();
        DummyData.addDummyDataToMap();
        TaxiHiringApp taxiApp = new TaxiHiringApp();
        String reg1 = "12345";
        String reg2 = "67890";
        Location loc1 = new Location(2, 3);
        Location loc2 = new Location(5, 6);

        assertTrue(taxiApp.testAddToMap(reg1, loc1));
        assertTrue(taxiApp.testAddToMap(reg2, loc2));

        Location center = new Location(4, 5);
        int radius = 2;
        List<String> vehiclesInRange = taxiApp.testGetVehiclesInRange(center, radius);

        assertTrue(vehiclesInRange.contains(reg1)); // Verify that reg1 is in range
        assertFalse(vehiclesInRange.contains(reg2)); // Verify that reg2 is not in range
    }
}