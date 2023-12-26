import java.util.Iterator;

// An iterator over 'Box' objects.
// Please, do not change this interface definition!
//
public interface BoxIterator extends Iterator<Box> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements. The
    // detail massage of the exception is "no box element!".
    Box next();
}
