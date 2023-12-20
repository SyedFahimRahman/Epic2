package taxiApp;

//This class is specifically for testing purposes only, and should not be treated as part of the actual app.
public class DummyData {
    static TaxiMap map = new TaxiMap();

    public static void addDummyDataToMap() {

        map.addTaxiToMap(8, 7, new Taxi("20000", "Mark", "XL"));
        map.addTaxiToMap(2, 3, new Taxi("30000", "Danny", "regular"));
        map.addTaxiToMap(6, 4, new Taxi("40000", "Harry", "XL"));
        map.addTaxiToMap(6, 5, new Taxi("50000", "Lenny", "regular"));
        map.addTaxiToMap(4, 6, new Taxi("60000", "Patrick", "XL"));
        map.addTaxiToMap(5, 1, new Taxi("70000", "Pablo", "regular"));
        map.addTaxiToMap(1, 2, new Taxi("80000", "Steven", "XL"));
        map.addTaxiToMap(9, 9, new Taxi("90000", "Sean", "regular"));
        map.addTaxiToMap(8, 4, new Taxi("11000", "Sarah", "XL"));
        map.addTaxiToMap(7, 2, new Taxi("22000", "Mason", "regular"));
        map.addTaxiToMap(3, 7, new Taxi("33000", "David", "XL"));
        map.addTaxiToMap(2, 8, new Taxi("44000", "Paul", "regular"));
        map.addTaxiToMap(1, 3, new Taxi("55000", "Jason", "XL"));
        map.addTaxiToMap(1, 3, new Taxi("66000", "Jeffrey", "regular"));
        map.addTaxiToMap(1, 3, new Taxi("77000", "John", "XL"));
        map.addTaxiToMap(1, 3, new Taxi("88000", "Jack", "regular"));

        map.printMap();
    }
}
