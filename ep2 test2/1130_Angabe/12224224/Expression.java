// Represents an expression as a sum of variables and constants, for example x + -7 + y.
// Please, do not change this interface definition!
//
public interface Expression {

    // Evaluates this expression using the provided variable-value mapping. For example,
    // if 'map' associates variable x with constant 2 and variable y with constant 3, the
    // expression x + y is evaluated to the expression 2 + 3. If 'map' contains the mapping
    // for y, but no mapping for x, then x + y is evaluated to x + 3. If there is neither
    // a mapping for x nor for y, then x + y is evaluated to x + y.
    // Precondition: map != null.
    Expression evaluate(java.util.HashMap<Variable, Constant> map);

    // Returns the coefficient of the specified variable in the expression. For example,
    // in the expression x + y + x + 3 the variable 'x' has a coefficient of 2, while 'y'
    // has the coefficient 1 (and variables that are not occurring in the expression have a
    // coefficient of 0).
    // Precondition: variable != null.
    Constant coefficientOf(Variable variable);

    // Returns the sum of all constants in the expression. For example,
    // for the expression x + y + x + 3 the method returns 3. For the expression 3 + x + 4
    // the method returns 7.
    Constant getConstant();

    // Returns a map that associates each variable in this expression with its coefficient.
    // For example, for the expression x + y + x + 3 the map has two mappings, associating variable
    // 'x' with constant 2 and variable 'y' with constant 1.
    java.util.Map<Variable, Constant> asMap();

    // Returns a 'VariableSet' view of 'this'.
    VariableSet getSetView();

    // Returns a string representation of 'this' where each variable occurs at most once and there
    // is at most one constant. For example, a sum of 2, x, y, x  and -4 is represented by
    // "2x + y + -2" or "-2 + 2x + y". (The order of the terms is not specified. Coefficients of 1
    // are omitted in the representation.)
    String toString();
}