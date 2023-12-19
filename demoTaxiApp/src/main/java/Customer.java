import java.util.Scanner;

public class Customer {

    Scanner scanner = new Scanner(System.in);
    private String name;
    private Location loc;

    public Customer(String name, Location loc) {
        this.name = name;
        this.loc = loc;
    }

    public void requestTaxi() {
        System.out.println("Enter Current X coordinate: ");
    }
}
