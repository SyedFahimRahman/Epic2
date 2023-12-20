package taxiApp;

import java.util.Scanner;

public class TaxiMap {

    private static int rows = 15;
    private static int cols = 15;
    public static MapCell[][] array = new MapCell[rows][cols];

    public TaxiMap() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.array[i][j] = new MapCell();
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j].printContents() + "   ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

    public void addTaxiToMap(int rows, int cols, Taxi value) {
        array[rows][cols].addTaxi(value);
    }

    public boolean isTaxiOnMap(String reg) {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                MapCell currentCell = getArray()[i][j];
                if (currentCell.containsTaxi(reg)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeTaxiFromMap(String reg) {
        if (!TaxiDetails.doesTaxiExist(reg)) {
            System.out.println("Error: Taxi does not exist.");
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    MapCell currentCell = array[i][j];
                    if (currentCell.containsTaxi(reg)) {
                        currentCell.removeTaxi(new Taxi(reg));
                        System.out.println("Taxi successfully removed.");
                        return;
                    }

                }
            }
        }
    }

    public void moveVehicle(String reg, Location loc) {
        Scanner sc = new Scanner(System.in);
        removeTaxiFromMap(reg);
        System.out.println("Enter the X coordinate you want the taxi to move to: ");
        int x = sc.nextInt();
        System.out.println("Enter the Y coordinates you want the taxi to move to: ");
        int y = sc.nextInt();
        Taxi taxi = TaxiDetails.getTaxi(reg);
        if (isValidIndex(array, x, y)) {
            array[y][x].addTaxi(taxi);
        } else {
            System.out.println("Invalid index. Cannot move element.");
        }
    }


    public static boolean isValidIndex(MapCell[][] array, int rows, int cols) {
        return rows >= 0 && rows < array.length && cols >= 0 && cols < array[0].length;
    }

    public static void printCellContents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter X coordinate of cell you wish to view the contents of: ");
        int x = sc.nextInt();
        System.out.println("Enter Y coordinate of cell you wish to view the contents of: ");
        int y = sc.nextInt();


        if (array[y][x] != null) {
            System.out.println("Contents at coordinates (" + x + ", " + y + "): \n" + array[y][x].toString());
        } else {
            System.out.println("No Taxi object at coordinates (" + x + ", " + y + ")");
        }
    }

    public boolean isWithinRange(Location loc1, Location loc2, int r) {
        double distance = Math.sqrt(Math.pow(loc2.getX() - loc1.getX(), 2) + Math.pow(loc2.getY() - loc1.getY(), 2));
        return distance <= r;
    }

        public MapCell[][] getArray() {
        return array;
    }
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}