// An object with a method that returns a 'VariableIterator'.
// Please, do not change this interface definition!
//
public interface VariableIterable extends Iterable<Variable> {

    // Returns an iterator over all 'Variable' objects of an expression.
    VariableIterator iterator();
}
