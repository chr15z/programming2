import java.util.HashMap;

// Represents a polynomial as a weighted sum of an arbitrary number of different monomials.
// For example, 3*x*y*y + 2*y is a polynomial consisting of two monomials x*y*y and y summed up with
// coefficients 3 respectively 2. A monomial is itself a 'Polynomial' object (see class 'Monomial').
//
public interface Polynomial extends MonomialIterable {

    // Evaluates this polynomial using the provided 'value' for 'v'. For example,
    // the result of p.evaluate(x, 2) if 'p' is the polynomial 3*x*x*x*y is the polynomial 24*y.
    // (For simplicity, we assume that 'value' is a positive integer.)
    // Precondition: v != null && value > 0.
    Polynomial evaluate(Variable v, int value);

    // Returns a 'VariableSet' view of 'this'.
    VariableSet getVariableSetView();

    // Returns the coefficient of the specified monomial in this polynomial. For example,
    // in the polynomial 3*x*y*y + 2*x the coefficient of the monomial x*y*y is 3, while
    // the coefficient of the monomial x is 2. If 'm' does not occur in this polynomial,
    // the coefficient is 0.
    // Precondition: m != null.
    int getCoefficientOf(Monomial m);

    // Returns a string representation of 'this' where each monomial of the polynomial is shown
    // together with its coefficient as a summand. (The order of the terms is not specified).
    // Factors of 1 are not shown in the representation.
    // For example, the returned string can be as follows: "3*x*y*y + x*y + 5*x + 3".
    String toString();

    // Returns a new map which associates each monomial of the polynom with its coefficient.
    HashMap<Monomial, Integer> asMap();

    // Checks if 'this' and 'o' are equal polynomials. Two objects of type 'Polynomial' are
    // considered to be equal if they are of the same class and are mathematically equivalent. For
    // example, the monomials x*y*y and y*y*x are equal and the polynomials 3*x*y*y + 2*y and
    // 2*y + 3*y*x*y are equal.
    boolean equals(Object o);

    // Returns the hash code of 'this'.
    int hashCode();

    // Returns an iterator over all 'Monomial' objects of this polynomial. For example,
    // if 'this' corresponds to 3*x*y*y + x*y + 5*x, the iterations return x*y*y, x*y and x.
    // The order of the iterations is not specified.
    MonomialIterator iterator();
}
