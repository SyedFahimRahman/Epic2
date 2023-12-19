import java.util.Objects;

// creation of my own array list
public class DaraList<T> {

    private T[] items;
    private int size;

    public DaraList() {
        items = (T[]) new Object[10];
        size = 0;
    }


    public void add(T item) {
        if(size == items.length) {
            increaseCapacity();
        }
        items[size] = item;
        size++;
    }

    // multiplies the current capacity by 2.
    public void increaseCapacity() {
        int currentSize = items.length;
        T[] newArray = (T[]) new Object[currentSize * 2];
        System.arraycopy(items, 0, newArray, 0, size);
        // setting global variable to the new array.MapCell
        items = newArray;
    }
    public void remove(T item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, items[i])) {
                int currentSize = items.length;
                T[] newArray = (T[]) new Object[currentSize];
                if (i != size - 1) {
                    System.arraycopy(items, i + 1, newArray, i, size - i - 1);
                }
                items[i] = null;
                size--;
                break;
            }
        }
    }

    public Object[] toArray() {
        return items;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? items[i] == null : element.equals(items[i])) {
                return true;
            }
        }
        return false;
    }
    public int size() {
        return size;
    }

    public T get(int i) {
        return items[i];
    }

    @Override
    public String toString() {
        String result = "";
        for(Object o : items) {
            if(o != null) {
                result += o.toString();
                result += "\n";
            }
        }
        return result;
    }
}
