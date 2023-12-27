import java.awt.*;

// A map that associates a position with a color. The number of key-value pairs is not limited.
// The map does not contain any keys or values being 'null'.
//
public class SimplePointColorMap {

    //TODO: declare variables.
    private Point[] keys;
    private Color[] values;
    private int size = 0;

    //we implement this class using binary search

    // Initializes this map with an initial capacity (length of internal array).
    // Precondition: initialCapacity > 0.
    public SimplePointColorMap(int initialCapacity) {

        //TODO: define constructor.
        keys = new Point[initialCapacity];
        values = new Color[initialCapacity];
    }

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise, 'null' is returned.
    // Precondition: key != null && value != null.
    public Color put(Point key, Color value) {

        //TODO: implement method.
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (keys[middle].compareTo(key) == 0) {
                //key found -> replace value and return old value
                Color toReturn = values[middle];
                values[middle] = value;
                return toReturn;
            }
            if (keys[middle].compareTo(key) < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        //key not found: insert key-value pair
        //index where to insert: right + 1
        //shift to right
        for (int i = size; i >= right + 2; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[right + 1] = key;
        values[right + 1] = value;
        size++;
        if (size == keys.length) {
            doubleCapacity();
        }
        return null;
    }

    private void doubleCapacity() {
        Point[] newKeys = new Point[keys.length * 2];
        Color[] newValues = new Color[values.length * 2];
        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    // Returns the value associated with the specified key, i.e. the method returns the color
    // associated with the specified point.
    // More formally, if this map contains a mapping from a key k to a value v such that
    // key.compareTo(k) == 0, then this method returns v.
    // (There can be at most one such mapping.)
    // Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Color get(Point key) {

        //TODO: implement method.
        int index = search(key);
        return index >= 0 ? values[index] : null;
    }


    // Removes the mapping for a key from this map if it is present. More formally, if this map
    // contains a mapping from key k to value v such that key.compareTo(k) == 0,
    // that mapping is removed. (The map can contain at most one such mapping.)
    // Returns the value to which this map previously associated the key, or 'null' if the map
    // contained no mapping for the key.
    // Precondition: key != null.
    public Color remove(Point key) {

        //TODO: implement method.
        int index = search(key);
        if (index < 0) return null;
        Color toReturn = values[index];
        for (int i = index; i < size; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
        return toReturn;
    }

    // Returns a queue with all keys of this map (ordering is not specified).
    public SimplePointQueue keys() {

        //TODO: implement method.
        SimplePointQueue queue = new SimplePointQueue(keys.length);
        for (int i = 0; i < size; i++) {
            queue.add(keys[i]);
        }
        return queue;
    }

    //searches the in the map and returns its index, and -1 if the key is not present
    private int search(Point key) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (keys[middle].compareTo(key) == 0) {
                return middle;
            }
            if (keys[middle].compareTo(key) < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}