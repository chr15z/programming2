import java.util.Iterator;

// An iterator over 'Monomial' objects.
// Please, do not change this interface definition!
//
public interface MonomialIterator extends Iterator<Monomial> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements. The
    // detail message of the exception is "no more monomials!".
    Monomial next();
}
