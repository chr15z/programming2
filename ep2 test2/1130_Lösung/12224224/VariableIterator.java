import java.util.Iterator;

// An iterator over 'Variable' objects.
// Please, do not change this interface definition!
//
public interface VariableIterator extends Iterator<Variable> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements. The
    // detail massage of the exception is "no more variables!".
    Variable next();
}
