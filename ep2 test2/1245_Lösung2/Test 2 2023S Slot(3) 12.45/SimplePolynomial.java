import java.util.*;

// This class represents a polynomial corresponding to a sum of terms, where each term is a
// 'Monomial' object multiplied by a coefficient, like 3*x*y + 4*x*x + 1*x*x*y + 3*1. (Factors
// of one are omitted in the string representation, see specification of 'toString'.)
// A polynomial may also consist of a single term like 2*x*y.
//
public class SimplePolynomial implements Polynomial //TODO: activate clause.
{

    // TODO: define missing parts of this class (including getters as needed).
    private final HashMap<Monomial, Integer> monomials;



    // Initializes 'this' with one term corresponding to coefficient*m. Polynomials with
    // multiple terms can be constructed by calling 'sumWith'.
    // Precondition: m != null && coefficient > 0.
    public SimplePolynomial(Monomial m, int coefficient) {

        // TODO: implement constructor.
        this.monomials = new HashMap<>();
        monomials.put(m,coefficient);
    }

    // Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
    // and 'other' to x*y*y then 'this' becomes 4*x*y*y + 2*x.
    // Precondition: other != null.
    void add(Polynomial other) {

        // TODO: implement method.
        HashMap <Monomial, Integer> map = other.asMap();
        for (Monomial m : map.keySet()){
            if (monomials.containsKey(m)) monomials.put(m, monomials.get(m) + map.get(m));
            else monomials.put(m, map.get(m));
        }
    }


    @Override
    public Polynomial evaluate(Variable v, int value) {
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

    @Override
    public int getCoefficientOf(Monomial m) {
        return monomials.containsKey(m)? monomials.get(m): 0;
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

    @Override
    public String toString() {
        String res = "";
        for(Monomial m: monomials.keySet()){
            if (monomials.get(m) == 1){
                res += m.toString() + " + ";
            }
            else res += monomials.get(m) + "*" + m.toString() + " + ";
        }
        return res.substring(0,res.lastIndexOf("+"));
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplePolynomial simplePolynomial = (SimplePolynomial) o;
        HashMap<Monomial, Integer> copy = simplePolynomial.monomials;
        for (Monomial mon: monomials.keySet()) {
            if (copy.get(mon) == monomials.get(mon)){
                copy.remove(mon);
            }
            else return false;
        }
        return copy.isEmpty();
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(monomials);
    }
}
