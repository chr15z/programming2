import java.awt.*;

// A map that associates a position (objects of type 'Point') with a color (objects of type 'Color'). The number of
// key-value pairs is not limited.
// The map is implemented as a binary tree. The keys are ordered based on the 'compareTo' method of 'Point'.
// The map does not contain any keys being 'null'.
//
// TODO: define further classes and methods for the implementation of the binary search tree,
//  if needed.
//
public class TreePointColorMap {

    //TODO: declare variables.
    private MyTreeNode root;

    // Adds a new key-value association to this map. If the key already exists in this map,
    // the value is replaced and the old value is returned. Otherwise, 'null' is returned.
    // Precondition: key != null.
    public Color put(Point key, Color value) {

        //TODO: implement method.
        if (root == null) {
            root = new MyTreeNode(key, value, null, null);
            return null;
        }
        MyTreeNode node = root;
        MyTreeNode parent;
        int compareValue;
        do {
            parent = node;
            compareValue = key.compareTo(node.getKey());
            if (compareValue == 0) {
                Color oldValue = node.getValue();
                node.setValue(value);
                return oldValue;
            }
            if (compareValue < 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        } while (node != null);
        if (compareValue < 0) {
            parent.setLeft(new MyTreeNode(key, value, null, null));
        } else {
            parent.setRight(new MyTreeNode(key, value, null, null));
        }
        return null;
    }

    // Returns the value associated with the specified key, i.e. the method returns the color
    // associated with coordinates specified by key (the key must have the same coordinates as the
    // specified 'key'). Returns 'null' if the key is not contained in this map.
    // Precondition: key != null.
    public Color get(Point key) {

        //TODO: implement method.
        if (root == null) return null;
        MyTreeNode node = root;
        int compareValue;
        do {
            compareValue = key.compareTo(node.getKey());
            if (compareValue == 0) {
                return node.getValue();
            }
            if (compareValue < 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        } while (node != null);
        return null;
    }

    // Returns 'true' if this map contains a mapping for the specified key, this means
    // for a point with the same coordinates as the specified 'key'.
    // Precondition: key != null.
    public boolean containsKey(Point key) {

        //TODO: implement method.
        if (root == null) return false;
        MyTreeNode node = root;
        int compareValue;
        do {
            compareValue = key.compareTo(node.getKey());
            if (compareValue == 0) {
                return true;
            }
            if (compareValue < 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        } while (node != null);
        return false;
    }

    // Returns a list with all keys of this map ordered ascending according to the
    // key order relation.
    public PointLinkedList keys() {

        //TODO: implement method.
        PointLinkedList list = new PointLinkedList();
        if (root != null) addToList(root, list);
        return list;
    }

    private void addToList(MyTreeNode node, PointLinkedList list) {
        if (node.getLeft() != null) addToList(node.getLeft(), list);
        list.addLast(node.getKey());
        if (node.getRight() != null) addToList(node.getRight(), list);
    }

    // Returns a new raster representing a region with the specified size from this
    // map. The upper left corner of the region is (0,0) and the lower right corner is (width-1, height-1).
    // All pixels outside the specified region are cropped (not included).
    // Preconditions: width > 0 && height > 0
    public SimpleRasterRGB asRasterRGB(int width, int height) {

        //TODO: implement method.
        SimpleRasterRGB raster = new SimpleRasterRGB(width, height);
        if (root != null) addToRaster(root, raster);
        return raster;
    }

    private void addToRaster(MyTreeNode node, SimpleRasterRGB raster) {
        if (node.getLeft() != null) addToRaster(node.getLeft(), raster);
        if (node.getKey().getX() < raster.getWidth() && node.getKey().getY() < raster.getHeight()) {
            Color c = node.getValue();
            raster.setPixelColor(node.getKey().getX(), node.getKey().getY(), c == null ? new Color(0, 0, 0) : c);
        }
        //traversing the right tree is only done if current position is not already outside the width x height frame
        if (node.getRight() != null && (node.getKey().getX() < raster.getWidth() || node.getKey().getY() < raster.getHeight())) {
            addToRaster(node.getRight(), raster);
        }
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
class MyTreeNode {
    private MyTreeNode left;
    private MyTreeNode right;
    private final Point key;
    private Color value;

    public MyTreeNode(Point key, Color value, MyTreeNode left, MyTreeNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }

    public Point getKey() {
        return key;
    }

    public Color getValue() {
        return value;
    }

    public void setValue(Color value) {
        this.value = value;
    }
}

