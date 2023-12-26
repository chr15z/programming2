import java.util.*;

// This class represents a polynomial corresponding to a sum of terms, where each term is a
// 'Monomial' object multiplied by a coefficient, like 3*x*y + 4*x*x + 1*x*x*y + 3*1. (Factors
// of one are omitted in the string representation, see specification of 'toString'.)
// A polynomial may also consist of a single term like 2*x*y.
//
public class SimplePolynomial implements Polynomial {

    private final HashMap<Monomial, Integer> monomials;

    // Initializes 'this' with one term corresponding to coefficient*m. Polynomials with
    // multiple terms can be constructed by calling 'sumWith'.
    // Precondition: m != null && coefficient > 0.
    public SimplePolynomial(Monomial m, int coefficient) {
        monomials = new HashMap<>();
        monomials.put(m, coefficient);
    }

    // Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
    // and 'other' to x*y*y then 'this' becomes 4*x*y*y + 2*x.
    // Precondition: other != null.
    void add(Polynomial other) {
        HashMap<Monomial, Integer> map = other.asMap();
        for (Monomial m : map.keySet()){
            if (monomials.containsKey(m)) monomials.put(m, monomials.get(m) + map.get(m));
            else monomials.put(m, map.get(m));
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Monomial m : monomials.keySet()){
            s+= monomials.get(m) + "*"+ m.toString() + " + ";
        }
        return s.substring(0, s.lastIndexOf(" + ")).replaceAll("1\\*","");
    }

    @Override
    public Polynomial evaluate(Variable v, int value) {
        HashMap<Monomial, Integer> map = this.asMap();
//
//        HashMap <Variable, Integer> counters = asVariableHasMap();
//        if (!counters.containsKey(v)) return this;
//
//        int coeff = this.monomials.get(v);
//        for (int i = 0; i < counters.get(v); i++) {
//            coeff *= value;
//        }
//
//        counters.remove(v);
//        ArrayList<Variable>  remainingVariables = this.variables;
//        while (remainingVariables.contains(v)){
//            remainingVariables.remove(v);
//        }
//
//        return new SimplePolynomial(new Monomial(remainingVariables.toArray(new Variable[0])), coeff);
        return null;
    }

    @Override
    public VariableSet getVariableSetView() {
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                boolean contains = false;
                for (Polynomial p : monomials.keySet()){
                    contains = contains || p.getVariableSetView().contains(variable);
                }
                return contains;
            }
        };
    }

    // Returns the coefficient of the specified monomial in this polynomial. For example,
    // in the polynomial 3*x*y*y + 2*x the coefficient of the monomial x*y*y is 3, while
    // the coefficient of the monomial x is 2. If 'm' does not occur in this polynomial,
    // the coefficient is 0.
    // Precondition: m != null.
    @Override
    public int getCoefficientOf(Monomial m) {
        return monomials.containsKey(m) ? monomials.get(m) : 0;
    }

    @Override
    public HashMap<Monomial, Integer> asMap() {
        return monomials;
    }

    @Override
    public MonomialIterator iterator() {
        return new MonomialIterator() {
            Iterator<Monomial> iter = monomials.keySet().iterator();
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Monomial next() {
                if (!hasNext()) throw new NoSuchElementException("no more monomials!");
                return iter.next();
            }
        };
    }
}
