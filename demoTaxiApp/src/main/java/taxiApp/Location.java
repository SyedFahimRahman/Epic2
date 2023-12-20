package taxiApp;

public class Location {
    private int x;
    private int y;

    //Creating constructor for Location to sore x and y.
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getters for both X and Y.
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Override the Location classes .equals function
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return x == location.x && y == location.y;
    }

    //Override the Location classes toString function.
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}