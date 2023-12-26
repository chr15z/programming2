import java.util.*;

// This class implements 'StringOperation' and represents a sequence of two 'StringOperation'
// objects that are applied in succession.
// Calling this object's 'apply' method returns the result of applying the second 'StringOperation'
// on the result of applying the first one on the specified string.
// 'StringOperationSequence' objects can be build using the 'andThen' method specified in the
// interface 'StringOperation'.
// Since the two sequential operations can themselves be objects of 'StringOperationSequence',
// we naturally get tree-like structures, where objects of 'StringOperationSingle' form the leafs
// of the tree. The implementation of this class can, but need not be based on a tree structure.
//
public class StringOperationSequence implements StringOperation //TODO: uncomment clause.
{

    private StringOperation first;
    private StringOperation second;

    // Initializes 'this' with two sequential operations.
    public StringOperationSequence(StringOperation first, StringOperation second) {
        this.first = first;
        this.second = second;
    }

    // Returns an iterator over all 'StringOperationSingle' objects of this sequence.
    // See examples in 'PraxisTest2.java'.
    public OperationSingleIterator iterator() {

        //TODO: implement method.
        return new OperationSingleIterator() {
            OperationSingleIterator iter1 = first.iterator();
            OperationSingleIterator iter2 = second.iterator();

            @Override
            public StringOperationSingle next() {
                if (hasNext()) {
                    if (iter1.hasNext()) {
                        return iter1.next();
                    }
                    if (iter2.hasNext()) {
                        return iter2.next();
                    }
                }
                throw new NoSuchElementException("no more operations!");
            }

            @Override
            public boolean hasNext() {
                return iter1.hasNext() || iter2.hasNext();
            }
        };
    }

    @Override
    public String apply(String operand) throws OperationException {
        return second.apply(first.apply(operand));
    }

    @Override
    public StringOperation andThen(StringOperation after) {
        return new StringOperationSequence(this, after);
    }

    @Override
    public void substitute(StringOperationSingle toSubstitute, StringOperationSingle substituteWith) {
        // Substitutes all occurrences of operations in this operation,
        // that are equal to 'toSubstitute' (according to equality criteria defined by
        // the 'equals' method) with the specified 'substituteWith'.
        // The method has no effect if 'this' is an instance of 'StringOperationSingle'.
        // Precondition: 'toSubstitute' and 'substituteWith' must not be 'null'.
        if (!first.equals(toSubstitute) || !second.equals(toSubstitute)) {
            first.substitute(toSubstitute, substituteWith);
            second.substitute(toSubstitute, substituteWith);
        }
        if (first.equals(toSubstitute)) {
            first = substituteWith;
        }
        if (second.equals(toSubstitute)) {
            second = substituteWith;
        }
    }

    @Override
    public Countable getCountable(StringOperationSingle search) {
        StringOperationSequence that = this;
        return new Countable() {
            @Override
            public int count() {
                int count = 0;
                for (StringOperationSingle s : that) {
                    if (s.equals(search)) {
                        count++;
                    }
                }
                return count;
            }
        };
    }

    @Override
    public String toString() {
        return first.toString() + " and then " + second.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringOperationSequence that = (StringOperationSequence) o;
        ArrayList<StringOperationSingle> list = new ArrayList<>();
        ArrayList<StringOperationSingle> list2 = new ArrayList<>();
        for (StringOperationSingle s : this) {
            if (s instanceof DoNothingOperation) {

            } else {
                list.add(s);
            }
        }
        for (StringOperationSingle s : that) {
            if (s instanceof DoNothingOperation) {

            } else {
                list2.add(s);
            }
        }
        return list.equals(list2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}