import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

// A 'BalancedStick' has a specified stick weight, that can not be changed after
// initialisation. On the left and right end of the stick mobiles
// are attached (recursive structure). 'BalancedStick' implements 'Mobile'.
// You can assume that no part of a mobile has the same identity as another part.
//
public class BalancedStick implements Mobile // TODO: activate clause.
{

    //TODO: define missing parts of the class.
    private int stickWeight;
    private Mobile left;
    private Mobile right;

    // Initialises 'this'; throws an 'UnbalancedException' if the resulting mobile
    // would not be balanced, i.e. if left.getWeight() != right.getWeight(). The detail message
    // of the exception contains information about the difference between left and right weight,
    // for example "Stick unbalanced (left 7 - right 16)" (see example in 'PraxisTest2.java').
    // Preconditions: stickWeight > 0, left != null, right != null, left != right,
    // no part of a mobile has the same identity as another part.
    public BalancedStick(int stickWeight, Mobile left, Mobile right) throws UnbalancedException {

        // TODO: implement constructor.
        if (left.getWeight() != right.getWeight())
            throw new UnbalancedException("Stick unbalanced (left "+ left.getWeight() +" - right "+right.getWeight()+")");
        this.left = left;
        this.right = right;
        this.stickWeight = stickWeight;
    }

    // Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' and
    // returns 'true' if such a mobile is contained as part of this mobile, i.e., attached to this
    // stick or below (recursive search). Otherwise, the call of this method has no effect and
    // 'false' is returned.
    // Throws an 'UnbalancedException' if the replacement would violate the
    // conditions that all sticks need to be balanced. The detail message
    // of the exception contains information about the difference between left and right weight.
    // Precondition: toReplace != null && replaceWith != null
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws UnbalancedException {

        // TODO: implement method.
        if (left.equals(toReplace)){
            if (left.getWeight() != replaceWith.getWeight())
                throw new UnbalancedException("Stick unbalanced (left "+ left.getWeight() +" - right "+right.getWeight()+")");
            left = replaceWith;
            return true;
        }
        if (right.equals(toReplace)){
            right = replaceWith;
            return true;
        }
        if (left.getClass() == BalancedStick.class) ((BalancedStick) left).replace(toReplace, replaceWith);
        if (right.getClass() == BalancedStick.class) ((BalancedStick) right).replace(toReplace, replaceWith);

        return false;
    }

    @Override
    public int getWeight() {
        return left.getWeight() + right.getWeight() + stickWeight;
    }


    // Two sticks are equal if
    // 1.) they have the same stick weight and
    // 2.) if the left part of 'this' equals the left part of 'o' and the right part of 'this'
    //       equals the right part of 'o'
    //     or
    //     if the right part of 'this' equals the left part of 'o' and the left part of 'this'
    //       equals the right part of 'o' (i.e., exchanging left and right part does not
    //       change the value returned by 'equals').
    //
    // For example, all three of the following mobiles are equal (provided that corresponding
    // objects of Star are equal):
    //
    //          |                      |                |
    //      +---2---+              +---2---+        +---2---+
    //      |       |              |       |        |       |
    //   +--2--+    *           +--2--+    *        *    +--2--+
    //   |     |    16          |     |    16       16   |     |
    //   *  +--1--+          +--1--+  *               +--1--+  *
    //   7  |     |          |     |  7               |     |  7
    //      *     *          *     *                  *     *
    //      3     3          3     3                  3     3
    //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalancedStick that = (BalancedStick) o;
        if (that.stickWeight != stickWeight) return false;
        return Objects.equals(left, that.left) && Objects.equals(right, that.right)
                || Objects.equals(right, that.left) && Objects.equals(left, that.right);
    }

    @Override
    public StarCollection getStarCollection() {
        Iterator iter = iterator();
        return new StarCollection() {
            @Override
            public boolean contains(Star s) {
                while (iter.hasNext()){
                    Star temp = (Star) iter.next();
                    if (temp.equals(s)) return true;
                }
                return false;
            }
        };
    }


    @Override
    public StarIterator iterator() {
        Iterator iterLeft = left.iterator();
        Iterator iterRight = right.iterator();
        return new StarIterator() {
            @Override
            public boolean hasNext() {
                return iterLeft.hasNext() || iterRight.hasNext();
            }

            @Override
            public Star next() {
                if (hasNext()){
                    if (iterLeft.hasNext()){
                        return (Star) iterLeft.next();
                    }
                    else return (Star) iterRight.next();
                }
                throw new NoSuchElementException("no star element!");
            }
        };
    }

    public Mobile getRight() {
        return right;
    }

    public Mobile getLeft() {
        return left;
    }

    @Override
    public String toString() {
        String res = "(" + left.toString() + ")-" + stickWeight + "-(" + right.toString() + ")";

        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stickWeight, left, right);
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
