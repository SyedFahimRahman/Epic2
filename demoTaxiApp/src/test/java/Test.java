import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class TaxiHiringAppTestsTest {

    TaxiHiringAppTests tests = new TaxiHiringAppTests();
    TaxiHiringApp taxiApp = new TaxiHiringApp();
    @Test
    void testAddToMap() {
        String reg = "12345";
        Location loc = new Location(2, 3);

        TaxiDetails.taxiRegistry.add(new Taxi(reg, "Dan", "regular"));

        assertTrue(tests.testAddToMap(reg, loc));
        assertTrue(taxiApp.getMap().isTaxiOnMap(reg)); // Verify that taxi is on the map
    }

    @Test
    void testMoveVehicle() {
        TaxiDetails.taxiRegistry.add(new Taxi("54321", "Dan", "regular"));

        tests.testAddToMap("54321", new Location(1,2));
        System.out.println(tests.testGetVehicleLoc("54321"));
        tests.testMoveVehicle("54321", new Location(2,2));
        System.out.println(tests.testGetVehicleLoc("54321"));

        assertNotEquals(new Location(1,2), tests.testGetVehicleLoc("54321"));
        assertEquals(new Location(2,2), tests.testGetVehicleLoc("54321"));
    }

    @Test
    void testRemoveVehicle() {
        String reg = "12345";
        Location loc = new Location(2, 3);

        TaxiDetails.taxiRegistry.add(new Taxi(reg, "Dan", "regular"));

        assertTrue(tests.testAddToMap(reg, loc));
        assertTrue(tests.testRemoveVehicle(reg));
        assertFalse(taxiApp.getMap().isTaxiOnMap(reg)); // Verify that taxi is not on the map after removal
    }

    @Test
    void testGetVehicleLoc() {
        String reg = "10101";
        TaxiDetails.taxiRegistry.add(new Taxi(reg, "Frank", "xl"));

        Location loc = new Location(2, 3);

        assertTrue(tests.testAddToMap(reg, loc));
        assertEquals(loc, tests.testGetVehicleLoc(reg));
    }

    @Test
    void testGetVehiclesInRange() {
        String reg1 = "20202";
        String reg2 = "30303";

        TaxiDetails.taxiRegistry.add(new Taxi(reg1, "David", "xl"));
        TaxiDetails.taxiRegistry.add(new Taxi(reg2, "Gary", "regular"));

        Location loc1 = new Location(2, 3);
        Location loc2 = new Location(5, 6);

        assertTrue(tests.testAddToMap(reg1, loc1));
        assertTrue(tests.testAddToMap(reg2, loc2));

        Location center = new Location(4, 5);
        int radius = 2;
        List<String> vehiclesInRange = tests.testGetVehiclesInRange(center, radius);

        assertTrue(vehiclesInRange.contains(reg2), "Expected " + reg2 + " to be in range. Location: " + loc2);
        assertFalse(vehiclesInRange.contains(reg1), "Expected " + reg1 + " to be out of range. Location: " + loc1);
    }
}