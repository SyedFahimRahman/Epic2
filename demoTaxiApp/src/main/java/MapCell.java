import java.util.Objects;

public class MapCell {

    private DaraList<Taxi> taxis;

    MapCell() {
        taxis = new DaraList<Taxi>();
    }

    public String printContents() {
        return String.format("T(%s)", taxis.size());
    }
    public boolean containsTaxi (String reg){
        for (Object obj : taxis.toArray()) {
            Taxi taxi = (Taxi) obj;
            if (taxi != null && Objects.equals(taxi.regNumber, reg)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Object[] taxiArray = taxis.toArray();
        for(Object t : taxiArray) {
            if(t != null) {
                result.append(t);
                result.append("\n");
            }
        }
        return result.toString();
    }


    public void addTaxi(Taxi taxi) {
        taxis.add(taxi);
    }

    public void removeTaxi(Taxi taxi){
        taxis.remove(taxi);
    }

    public DaraList<Taxi> getTaxis() {
        return taxis;
    }

}
