// A set containing 'Variable' elements of an expression (a collection of distinct elements, where
// no two elements are equal according to the equality criteria defined for 'Variable' objects).
// Please, do not change this interface definition!
//
public interface VariableSet extends VariableIterable {

    // Returns 'true' if 'this' has an element equal to the specified object
    // and 'false' otherwise.
    // Precondition: s != null.
    boolean contains(Variable variable);

    // Returns an iterator over all 'Variable' objects of 'this'.
    // The order of the iteration is not specified.
    VariableIterator iterator();
}
