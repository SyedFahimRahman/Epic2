package taxiApp;

import java.util.Objects;
import java.util.Iterator;

// creation of my own array list
public class DaraList<T> implements Iterable<T>{

    //Creation of private variables.
    private T[] items;
    private int size;

    //Constructor for DaraList class.
    public DaraList() {
        items = (T[]) new Object[10];
        size = 0;
    }

    //Creation of the add function for my self-implemented array list.
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
        // setting global variable to the new array.taxiApp.MapCell
        items = newArray;
    }
    //Method to remove an item from DaraList.
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

    //Creation of toArray() method for my ArrayList.
    public Object[] toArray() {
        return items;
    }

    //Creation of boolean contains() to check whether my array list contains a taxi value.
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

    //Override of the DaraList classes toString() method.
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

    //Override of the DaraList classes iterator() method.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

    //Override of the DaraList classes hasNext() function.
    @Override
            public boolean hasNext() {
                return currentIndex < size && items[currentIndex] != null;
            }

    //Override of the DaraList classes next() function.
    @Override
            public T next() {
                return items[currentIndex++];
            }
        };
    }
}
