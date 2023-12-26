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

    // TODO: define missing parts of the class.
    TreeNode root;

    // Initialises 'this' as an empty set.
    public TreeSetRational() {

        // TODO: implement constructor.
        root = null;
    }

    // Adds the specified Rational object to the set.
    // Returns 'true' if the set did not already contain the specified element
    // and 'false' otherwise.
    // Precondition: r != null.
    public boolean add(Rational r) {

        // TODO: implement method.
        if (root == null){
            root = new TreeNode(r);
            return true;
        }
        else{
            if (root.contains(r)) return false;
            else{
                root.add(r);

                return true;
            }


        }

    }

    // Returns a new 'TreeSetRational' object that is the union of this set and the 'other' set.
    // 'this' and 'other' are not changed by this method.
    // Precondition: other != null.
    public TreeSetRational union(TreeSetRational other) {

        // TODO: implement method.
        if (root == null) return other;
        TreeSetRational out = new TreeSetRational();
        out.add(this.root.getValue());
        /*if (this.root.left != null){
            out.root.addAll(this.root.left);
        }
        if (this.root.right != null){
            out.root.addAll(this.root.right);
        }*/
        out.root.addAll(other.root);
        return out;
    }

    // Returns the number of rational numbers in the set that are within the range defined by
    // the lowest and highest rational number (inclusive). The method exploits the structure of
    // the binary search tree and traverses only relevant parts of the tree.
    // Precondition: lowest != null && highest != null && lowest.compareTo(highest) <= 0.
    public int countWithinRange(Rational lowest, Rational highest) {

        // TODO: implement method.
        if (root == null) return 0;
        return root.countRange(lowest, highest, 0);
    }

    // Removes the lowest rational number from this set. Returns the rational number that was
    // removed from this set or 'null' if this set is empty.
    // (The corresponding node is removed by replacing it with the subtree of the node that
    // contains entries greater than the minimum.)
    public Rational removeMinimum() {

        // TODO: implement method.
        if (root == null) return null;
        if (root.left == null){
            Rational out = root.getValue();
            root = root.right;
            return out;
        }

        return root.removeMin(root);
    }

    // Returns a string representation of 'this' with all rational objects
    // ordered ascending. The format of the string uses
    // brackets and is as in the following example with a set of four elements:
    // "[-3/4, -2/3, -1/3, 1/2]"
    // Returns "[]" if this set is empty.
    public String toString() {

        // TODO: implement method.
        if (root == null) return "[]";
        else return "[" + root.stringIt("") + "]";
    }
}

// TODO: define further classes, if needed (either here or in a separate file).


class TreeNode{
    TreeNode left;
    TreeNode right;
    Rational value;

    public TreeNode(Rational value){
        this.value = value;
    }

    public boolean contains(Rational r){
        return getValue().compareTo(r) == 0 ||
                (getValue().compareTo(r) > 0 ? left != null && left.contains(r) : right != null && right.contains(r));
    }

    public Rational getValue() {
        return value;
    }

    public void add(Rational r){
        if (!contains(r)){

            if (getValue().compareTo(r) < 0){ // wenn r größer als this ist
                if (right != null) right.add(r);
                else right = new TreeNode(r);
            }
            else{
                if (left != null) left.add(r);
                else left = new TreeNode(r);
            }
        }
    }

    public int countRange(Rational lowest, Rational highest, int counter){

        if (getValue().compareTo(lowest) >= 0 && getValue().compareTo(highest) <= 0) { //node liegt in der range
            counter++;
            if (left != null) counter = left.countRange(lowest, highest, counter);
            if (right != null) counter = right.countRange(lowest, highest, counter);
        }
        else if (getValue().compareTo(lowest) < 0){ // wenn lowest größer als this ist -> rechts
            if (right != null) counter = right.countRange(lowest, highest, counter);
        }
        else { // -> links
            if (left != null) counter = left.countRange(lowest, highest, counter);
        }

        return counter;
    }

    public void addAll(TreeNode Node){
        //System.out.println(Node.getValue());
        if (Node.left != null) addAll(Node.left);
        add(Node.getValue());
        if (Node.right != null) addAll(Node.right);
    }

    public Rational removeMin(TreeNode Node){
        if (Node.left.left != null) return removeMin(Node.left);
        else{
            Rational out = Node.left.getValue();
            if (Node.left.right != null) setLeft(left.right);
            else setLeft(null);
            return out;
        }
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public Rational getMin(TreeNode Node){
        if (Node.left != null) return getMin(Node.left);
        else{
            Rational out = Node.getValue();
            return out;
        }
    }

    public String stringIt(String out){
        if (left != null) out = left.stringIt(out);

        if (out.isEmpty()) out = getValue().toString();
            else out += ", " + getValue().toString();

        if (right != null) out = right.stringIt(out);
        return out;
    }
}