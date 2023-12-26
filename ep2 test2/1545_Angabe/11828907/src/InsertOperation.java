import java.util.*;

// This class implements 'StringOperationSingle' and represents a insertion operation on a string.
//
public class InsertOperation implements StringOperationSingle // TODO: uncomment clause.
{

    //TODO: define missing parts of this class.
    private final String toInsert;
    private final int startIndex;

    // Initializes this with the specified string 'toInsert' and the 'startIndex' where the string
    // will be inserted by this operation. For example, if 'toInsert' is "xyz" and 'startIndex'
    // is 2 then 'apply("abcd")' will return "abxyzcd".
    // Precondition: toInsert != null, startIndex >= 0.
    public InsertOperation(String toInsert, int startIndex) {
        this.toInsert = toInsert;
        this.startIndex = startIndex;
    }

    // @Override
    // Applies this operation to the specified operand and returns the result.
    // Throws an 'OperationException' if 'startIndex < 0' or if 'startIndex > operand.length()'.
    // The detail message of the exception is "startIndex i, length l" where 'i' is the specified
    // 'startIndex' of 'this' and 'l' is operand.length().
    // Precondition: operand != null.
    public String apply(String operand) throws OperationException {
        if (startIndex < 0 || startIndex > operand.length())
            throw new OperationException("startIndex "+ startIndex +", length " + operand.length());
        return operand.substring(0, startIndex) + toInsert + operand.substring(startIndex);
    }

    // Returns a new operation sequence that first applies this operation to its input, and then
    // applies the 'after' operation to the result.
    // Precondition: 'after' must not be 'null'.
    @Override
    public StringOperation andThen(StringOperation after) {
        return null;
    }

    // Substitutes all occurrences of operations in this operation,
    // that are equal to 'toSubstitute' (according to equality criteria defined by
    // the 'equals' method) with the specified 'substituteWith'.
    // The method has no effect if 'this' is an instance of 'StringOperationSingle'.
    // Precondition: 'toSubstitute' and 'substituteWith' must not be 'null'.
    @Override
    public void substitute(StringOperationSingle toSubstitute, StringOperationSingle substituteWith) {

    }

    @Override
    // Returns a string representation of this operation in the form:
    // insert "xyz" at position i
    // where 'xyz' stands for the specified string 'toInsert' and 'i' stands for
    // the specified position 'startIndex'.
    public String toString() {
        return "insert \"" + toInsert + "\" at position " + startIndex;
    }

    // Returns a counter for the number of times an operation equal to 'search' occurs in 'this'.
    @Override
    public Countable getCountable(StringOperationSingle search) {
        return null;
    }

    @Override
    public OperationSingleIterator iterator() {
        return null;
    }

    // Checks if 'this' and 'o' apply the same operations in the same order. Occurrences of
    // 'DoNothingOperation.DO_NOTHING' in a sequence are ignored in the comparison.
    // For example,
    // new InsertOperation(2, "abc").andThen(DO_NOTHING).andThen(new InsertOperation(0, "e"))
    // is equal to
    // DO_NOTHING.andThen(new InsertOperation(2, "abc").andThen(DO_NOTHING.andThen(new
    // InsertOperation(0, "e")))).

}
