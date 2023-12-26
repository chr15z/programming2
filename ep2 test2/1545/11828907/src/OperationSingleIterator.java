import java.util.Iterator;

// An iterator over 'StringOperationSingle' elements.
//
public interface OperationSingleIterator extends Iterator<StringOperationSingle> {

    @Override
    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more
    // elements with the detail message "no more operations!".
    StringOperationSingle next();

    @Override
    // Returns 'true' if the iteration has more elements.
    boolean hasNext();
}
