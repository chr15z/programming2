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
        return null;
    }

    @Override
    public String apply(String operand) throws OperationException {
        return "";
    }

    @Override
    public StringOperation andThen(StringOperation after) {
        return null;
    }

    @Override
    public void substitute(StringOperationSingle toSubstitute, StringOperationSingle substituteWith) {
        // Substitutes all occurrences of operations in this operation,
        // that are equal to 'toSubstitute' (according to equality criteria defined by
        // the 'equals' method) with the specified 'substituteWith'.
        // The method has no effect if 'this' is an instance of 'StringOperationSingle'.
        // Precondition: 'toSubstitute' and 'substituteWith' must not be 'null'.

    }

    @Override
    public Countable getCountable(StringOperationSingle search) {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }

}