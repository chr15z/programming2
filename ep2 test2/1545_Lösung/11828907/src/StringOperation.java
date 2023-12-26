// Do not change this interface definition.
//
// Represents an operation on a string with a string as a result. Additional parameters can be
// specified by passing them to the constructor.
//
// See examples in the 'PraxisTest2' class.
//
public interface StringOperation extends OperationSingleIterable {

    // Applies this operation to the specified operand and returns the result.
    String apply(String operand) throws OperationException;

    // Returns a new operation sequence that first applies this operation to its input, and then
    // applies the 'after' operation to the result.
    // Precondition: 'after' must not be 'null'.
    StringOperation andThen(StringOperation after);

    // Checks if 'this' and 'o' apply the same operations in the same order. Occurrences of
    // 'DoNothingOperation.DO_NOTHING' in a sequence are ignored in the comparison.
    // For example,
    // new InsertOperation(2, "abc").andThen(DO_NOTHING).andThen(new InsertOperation(0, "e"))
    // is equal to
    // DO_NOTHING.andThen(new InsertOperation(2, "abc").andThen(DO_NOTHING.andThen(new
    // InsertOperation(0, "e")))).
    boolean equals(Object o);

    // Returns the hash code of this object.
    int hashCode();

    // Substitutes all occurrences of operations in this operation,
    // that are equal to 'toSubstitute' (according to equality criteria defined by
    // the 'equals' method) with the specified 'substituteWith'.
    // The method has no effect if 'this' is an instance of 'StringOperationSingle'.
    // Precondition: 'toSubstitute' and 'substituteWith' must not be 'null'.
    void substitute(StringOperationSingle toSubstitute,
                    StringOperationSingle substituteWith);

    // Returns a string representation of the operation, including any additional parameters.
    // If 'this' is a operation sequence, the representation of the individual operations is
    // separated by "and then". Occurrences of DO_NOTHING are not shown in the string
    // representation.
    // Examples:
    // insert "xyz" at position 2 and then insert "e" at position 2
    // See further examples in the 'PraxisTest2' class.
    String toString();

    // Returns a counter for the number of times an operation equal to 'search' occurs in 'this'.
    Countable getCountable(StringOperationSingle search);
}
