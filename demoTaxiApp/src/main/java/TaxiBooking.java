//import java.util.Scanner;
//
//public class TaxiBooking {
//
//
//    public Location bookATrip() {
//        TaxiMap map = new TaxiMap();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter you current X coordinate: ");
//        int x =  sc.nextInt();
//        System.out.println("Enter your current Y coordinate: ");
//        int y = sc.nextInt();
//        if (x >= 0 && x <= map.getCols()) {
//            if (y >= 0 && y <= map.getRows()) {
//                System.out.println("You are located at: " + x + ", " + y);
//            } else {
//                System.out.println("Invalid coordinates, please try again.");
//            }
//            while (true) {
//                System.out.println("Please enter the coordinates you wish to travel to, separated by a space in the format (X , Y)");
//                String location = sc.nextLine();
//                String[] coords = location.trim().split(" ");
//                if (coords.length != 2) {
//                    System.out.println("Invalid coordinates entered, please try again. ");
//                } else {
//                    return new Location(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
//                }
//            }
//        }
//        return null;
//    }
//}