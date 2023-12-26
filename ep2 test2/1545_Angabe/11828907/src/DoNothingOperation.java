import java.util.NoSuchElementException;

// Represents an operation with no effect on the specified operand.
//
public class DoNothingOperation implements StringOperationSingle //TODO: activate clause.
{
    // The only instance of this class.
    public static DoNothingOperation DO_NOTHING = new DoNothingOperation();

    // Initializes 'this'.
    private DoNothingOperation() {
    }

    //@Override
    // Applies this operation to the specified operand and returns the result.
    // 'DO_NOTHING.apply(operand)' returns the unchanged operand.
    public String apply(String operand) {
        return operand;
    }

    //@Override
    // Returns a new 'StringOperationSequence' object in which 'after' is applied to 'this'.
    public StringOperation andThen(StringOperation after) {
        return new StringOperationSequence(this, after);
    }

    @Override
    public void substitute(StringOperationSingle toSubstitute, StringOperationSingle substituteWith) {

    }

    // Returns a counter for the number of times an operation equal to 'search' occurs in 'this'.
    @Override
    public Countable getCountable(StringOperationSingle search) {
        return new Countable() {
            @Override
            public int count() {
                return DO_NOTHING.equals(search) ? 1 : 0;
            }
        };
    }

    @Override
    public OperationSingleIterator iterator() {
        return new OperationSingleIterator() {
            boolean hasNext = true;

            @Override
            public StringOperationSingle next() {
                if (hasNext()) {
                    hasNext = false;
                    return DO_NOTHING;
                }
                throw new NoSuchElementException("no more operations!");
            }

            @Override
            public boolean hasNext() {
                return hasNext;
            }
        };
    }

    //TODO: define missing parts of this class.
}
