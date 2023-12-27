import java.awt.*;

// A map that associates a position (objects of type 'Point') with a color (objects of type 'Color').
// The number of key-value pairs is not limited.
// The map is implemented as hash map. The map does not contain any keys or values being 'null'.
//
public class HashPointColorMap {

    //TODO: declare variables.
    private Point[] keys;
    private Color[] values;
    private int size;

    // Initializes 'this' as an empty map.
    public HashPointColorMap() {
        keys = new Point[16];
        values = new Color[16];
    }

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise, 'null' is returned.
    // Precondition: key != null && value != null.
    public Color put(Point key, Color value) {

        //TODO: implement method.
        int point_hash = key.hashCode();
        int index = Math.abs(point_hash) % keys.length;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                Color oldValue = values[index];
                values[index] = value;
                return oldValue;
            }
            index = (index + 1) % keys.length;
        }

        //new key
        values[index] = value;
        keys[index] = key;
        size++;
        if (((size + 1.) / keys.length) > 0.5) {
            reHash();
        }
        return null;
    }

    // Returns the value associated with the specified key, i.e. the method returns the color
    // associated with the specified point.
    // More formally, if this map contains a mapping from a key k to a value v such that
    // key.equals(k) == true, then this method returns v.
    // (There can be at most one such mapping.)
    // Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Color get(Point key) {

        //TODO: implement method.
        int point_hash = key.hashCode();
        int index = Math.abs(point_hash) % keys.length;

        while (keys[index] != null) {
            if (key.equals(keys[index])) {
                return values[index];
            }
            index = (index + 1) % keys.length;
        }

        return null;
    }

    // Removes the mapping for a key from this map if it is present. More formally, if this map
    // contains a mapping from key k to value v such that key.equals(k) == true,
    // that mapping is removed. (The map can contain at most one such mapping.)
    // Returns the value to which this map previously associated the key, or 'null' if the map
    // contained no mapping for the key.
    // Precondition: key != null.
    public Color remove(Point key) {

        //TODO: implement method.
        int point_hash = key.hashCode();
        int index = Math.abs(point_hash) % keys.length;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                Color toReturn = values[index];
                keys[index] = null;
                values[index] = null;
                index = (index + 1) % keys.length;
                //rehash all continuous entries after deleted element
                while (keys[index] != null) {
                    Point p = keys[index];
                    Color c = values[index];
                    keys[index] = null;
                    values[index] = null;
                    size--;
                    put(p, c);
                    index = (index + 1) % keys.length;
                }
                size--;
                return toReturn;
            }
            index = (index + 1) % keys.length;
        }
        return null;
    }

    // Returns a queue with all keys of this map (ordering is not specified).
    public SimplePointQueue keys() {

        //TODO: implement method.
        SimplePointQueue queue = new SimplePointQueue(this.size);
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) queue.add(keys[i]);
        }
        return queue;
    }

    // Returns 'true' if the specified key is contained in this map.
    // Returns 'false' otherwise.
    public boolean containsKey(Point key) {

        //TODO: implement method.
        int point_hash = key.hashCode();
        int index = Math.abs(point_hash) % keys.length;

        while (keys[index] != null) {
            if (key.equals(keys[index])) {
                return true;
            }
            index = (index + 1) % keys.length;
        }

        return false;
    }

    // Returns 'true' if the specified value is contained at least once in this map.
    // Returns 'false' otherwise.
    public boolean containsValue(Color value) {

        //TODO: implement method.
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null && values[i].equals(value)) return true;
        }
        return false;
    }

    // Returns a string representation of this map with key-value pairs in parentheses, separated
    // by commas (order is not specified).
    // Example: {([9, 2], java.awt.Color[r=255,g=255,b=0]), ([7, 1], java.awt.Color[r=255,g=0,b=0])}
    public String toString() {

        //TODO: implement method.
        String s = "{";
        int cnt = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                s += "(" + keys[i] + ", " + values[i] + ")";
                cnt++;
                if (cnt != size) s += ", ";
            }

        }

        return s + "}";
    }

    // Returns 'true' if 'this' and 'o' are equal, meaning 'o' is of class 'HashPointColorMap'
    // and 'this' and 'o' contain the same key-value pairs, i.e. the number of key-value pairs is
    // the same in both maps and every key-value pair in 'this' equals one key-value pair in 'o'.
    // Two key-value pairs are equal if the two keys are equal and the two values are equal.
    // Otherwise, 'false' is returned.
    public boolean equals(Object o) {

        //TODO: implement method.
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        HashPointColorMap otherMap = ((HashPointColorMap)o);

        SimplePointQueue q1 = this.keys();
        SimplePointQueue q2 = otherMap.keys();

        if (q1.size() != q2.size()) return false;

        while (q1.size() > 0) {
            Point p = q1.poll();
            if (!this.get(p).equals(otherMap.get(p))) {
                return false;
            }
        }
        return true;
    }

    // Returns the hash code of 'this'.
    public int hashCode() {

        //TODO: implement method.
        int hash = 0;
        SimplePointQueue q = this.keys();
        while (q.size() > 0) {
            hash += q.poll().hashCode();
        }
        return hash;
    }

    //doubles the capacity and performs a rehash of all entries
    private void reHash() {
        Point[] oldKeys = keys;
        Color[] oldValues = values;
        keys = new Point[oldKeys.length * 2];
        values = new Color[oldValues.length * 2];
        size = 0;
        for (int i = 0; i < oldKeys.length; i++) {
            if (oldKeys[i] != null) {
                put(oldKeys[i], oldValues[i]);
            }
        }
    }
}

