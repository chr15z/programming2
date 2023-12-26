// A set of rational numbers implemented as a binary search tree. There are no
// duplicate entries in this set (no two elements e1 and e2 for which e1.compareTo(e2) == 0). The
// elements are sorted according to their value (the ordering is given by the method 'compareTo'
// of class 'Rational').
//
// TODO: define further classes and methods for the implementation of the binary search tree,
//   if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class TreeSetRational
{
    private TreeSetNode root;


    // Initialises 'this' as an empty set.
    public TreeSetRational() {
        root = null;
    }

    // Adds the specified Rational object to the set.
    // Returns 'true' if the set did not already contain the specified element
    // and 'false' otherwise.
    // Precondition: r != null.
    public boolean add(Rational r) {
        if(root == null){
            root = new TreeSetNode(r,null,null);
            return true;
        }
        return root.add(new TreeSetNode(r,null,null));
    }

    // Returns a new 'TreeSetRational' object that is the union of this set and the 'other' set.
    // 'this' and 'other' are not changed by this method.
    // Precondition: other != null.
    public TreeSetRational union(TreeSetRational other) {
        if(root == null) return other;

        TreeSetRational newTree = new TreeSetRational();
        root.addTo(newTree);
        other.root.addTo(newTree);

        return newTree;
    }

    // Returns the number of rational numbers in the set that are within the range defined by
    // the lowest and highest rational number (inclusive). The method exploits the structure of
    // the binary search tree and traverses only relevant parts of the tree.
    // Precondition: lowest != null && highest != null && lowest.compareTo(highest) <= 0.
    public int countWithinRange(Rational lowest, Rational highest) {
        if(root == null) return 0;
        int res = root.countElementsWithinRange(lowest, highest);

        return res;
    }

    // Removes the lowest rational number from this set. Returns the rational number that was
    // removed from this set or 'null' if this set is empty.
    // (The corresponding node is removed by replacing it with the subtree of the node that
    // contains entries greater than the minimum.)
    public Rational removeMinimum() {
        if(root == null) return null;

        //Base Case überprüfen, danach rekursiv lösen
        if(root.getLeft() == null){ //root removen!
            Rational ret = root.getValue();
            if(root.getRight() == null){
                root = null; //keine Elemente außer root sind drinne
                return ret;
            }else{
                TreeSetNode rightElement = root.getRight(); //rechtes Element wird root
                root = null;
                root = rightElement;
                return ret;
            }
        }

        Rational rem = root.removeMin();
        return rem;
    }

    // Returns a string representation of 'this' with all rational objects
    // ordered ascending. The format of the string uses
    // brackets and is as in the following example with a set of four elements:
    // "[-3/4, -2/3, -1/3, 1/2]"
    // Returns "[]" if this set is empty.
    public String toString() {
        if(root == null) return "[]";
        String res = "[";

        res += root.stringIt();

        res += "]";
        return res;
    }
}

class TreeSetNode{
    private Rational value;
    private TreeSetNode left, right;


    public TreeSetNode(Rational value, TreeSetNode left, TreeSetNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean add(TreeSetNode val){
        int cmp = val.value.compareTo(value);
        if(cmp < 0){
            if(left == null){
                left = val;
                return true;
            }
            else return left.add(val);
        }else if(cmp > 0){
            if(right == null){
                right = val;
                return true;
            }
            else return right.add(val);
        }

        return false;   // cmp = 0
    }
    private boolean isValueWithinRange(Rational lowest, Rational highest){
        return value.compareTo(lowest) >= 0 && value.compareTo(highest) <= 0;
    }

    public int countElementsWithinRange(Rational lowest, Rational highest) {
        int res = 0;
        if(isValueWithinRange(lowest,highest)) res += 1;
        if(left != null && !(value.compareTo(lowest) < 0)) res += left.countElementsWithinRange(lowest,highest);
        if(right != null && !(value.compareTo(highest) > 0)) res += right.countElementsWithinRange(lowest, highest);

        return res;
    }


    public void addTo(TreeSetRational newTree) {
        //Inorder
        if(left != null) left.addTo(newTree);
        newTree.add(value);
        if(right != null) right.addTo(newTree);
    }

    public Rational removeMin() { // Fall wo left != null ist!
        if(left.left == null){  //linkestes Element
            Rational ret = left.getValue();
            if(left.right == null){ //keine Rechten Nachfolger
                left = null;
                return ret;
            }else{
                TreeSetNode rightElement = left.right;
                left = null;
                left = rightElement;
                return ret;
            }
        }
        return left.removeMin();
    }


    public String stringIt() {
        String ret = "";
        if(left != null) ret += left.stringIt() + ", ";
        ret += value.toString();
        if(right != null) ret += ", "+right.stringIt();
        return ret;
    }

    public TreeSetNode getLeft() {
        return left;
    }

    public void setLeft(TreeSetNode left) {
        this.left = left;
    }

    public TreeSetNode getRight() {
        return right;
    }

    public void setRight(TreeSetNode right) {
        this.right = right;
    }

    public Rational getValue() {
        return value;
    }

    public void setValue(Rational value) {
        this.value = value;
    }
}