// Represents an expression as a sum of variables and constants, for example x + -7 + y.
// Please, do not change this interface definition!
//
public interface Expression extends VariableIterable {

    // Evaluates this expression using the provided variable-value mapping. For example,
    // if 'map' associates variable x with constant 2 and variable y with constant 3, the
    // expression x + y is evaluated to the expression 2 + 3. If 'map' contains the mapping
    // for y, but no mapping for x, then x + y is evaluated to x + 3. If there is neither
    // a mapping for x nor for y, then x + y is evaluated to x + y.
    // Precondition: map != null.
    Expression evaluate(java.util.HashMap<Variable, Constant> map);

    // Returns a new 'Expression' object representing the sum of 'this' and 'other'.
    // If 'other' contains a variable with the same name but different identity than
    // a variable in 'this', a 'DuplicateNameException' is thrown. The detail message contains
    // information about which name is used for different variables. For example, if the name "y"
    // is used for different variables, the message is "different variables with same name 'y'!".
    // Precondition: other != null.
    default Expression sumWith(Expression other) throws DuplicateNameException {

        return new Sum(this, other);
    }

    // Returns the coefficient of the specified variable in the expression. The coefficient
    // corresponds to the number of times the variable appears in the expression.
    // For example, for the sum of 2, x, y, x  and -4 the coefficient of 'x' is 2 while the
    // coefficient of 'y' is 1 (and variables that are not occurring in the expression have a
    // coefficient of 0).
    // Precondition: variable != null.
    Constant coefficientOf(Variable variable);

    // Returns the sum of all constants in the expression
    // (the sum is represented by an object of 'Constant').
    Constant sumOfConstants();

    // Returns a set with all variables in this expression.
    java.util.Set<Variable> asSet();

    // Returns a 'VariableSet' view of 'this'.
    VariableSet getSetView();

    // Returns a string representation of 'this' where each variable occurs at most once and there
    // is at most one constant. For example, a sum of 2, x, y, x  and -4 is represented by
    // "2x + y + -2" or "-2 + 2x + y". (The order of the terms is not specified. Coefficients of 1
    // are omitted in the representation.)
    String toString();

    // Returns an iterator over all 'Variable' objects of an expression. The number of times
    // the iteration returns a variable 'x' corresponds to this.coefficientOf(x).
    // For example, the iterations over an expression where 2, x, y, x  and -4 were summed up,
    // return x, x, y (or x, y, x or y, x, x). The order of the iterations is not specified.
    // (Hint: Note that by definition, a set has no duplicate elements. Therefore, iterating over
    // the set (view) of 'this' would not be an effective approach.)
    VariableIterator iterator();
}