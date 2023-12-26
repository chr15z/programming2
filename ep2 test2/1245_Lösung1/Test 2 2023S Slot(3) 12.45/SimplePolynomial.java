import java.util.*;

// This class represents a polynomial corresponding to a sum of terms, where each term is a
// 'Monomial' object multiplied by a coefficient, like 3*x*y + 4*x*x + 1*x*x*y + 3*1. (Factors
// of one are omitted in the string representation, see specification of 'toString'.)
// A polynomial may also consist of a single term like 2*x*y.
//
public class SimplePolynomial  implements Polynomial //TODO: activate clause.
{

    // TODO: define missing parts of this class (including getters as needed).
    private Monomial m;
    private int coefficient;
    private SimplePolynomial added;


    // Initializes 'this' with one term corresponding to coefficient*m. Polynomials with
    // multiple terms can be constructed by calling 'sumWith'.
    // Precondition: m != null && coefficient > 0.
    public SimplePolynomial(Monomial m, int coefficient) {

        // TODO: implement constructor.
        this.m = m;
        this.coefficient = coefficient;
        this.added = null;
    }

    // Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
    // and 'other' to x*y*y then 'this' becomes 4*x*y*y + 2*x.
    // Precondition: other != null.
    void add(Polynomial other) {

        // TODO: implement method.
        if (added == null){
            added = new SimplePolynomial(m, coefficient);
            if (other.getClass() == Monomial.class){
                Monomial temp = (Monomial) other;
                m = temp;
                coefficient = 1;
            }
            if (other.getClass() == SimplePolynomial.class){
                SimplePolynomial temp = (SimplePolynomial) other;
                m = temp.m;
                coefficient = temp.coefficient;
            }
        }
        else{
            added.add(other);
        }

    }


    @Override
    public Polynomial evaluate(Variable v, int value) {
        SimplePolynomial out = (SimplePolynomial) m.evaluate(v, value);
        if (added != null){
            out.add(added.evaluate(v,value));
        }
        return out;
    }

    @Override
    public VariableSet getVariableSetView() {
        HashSet<Variable> hashSet = new HashSet<>();
        for (int i = 0; i < m.getVariables().length; i++) {
            hashSet.add(m.getVariables()[i]);
        }
        if (added != null){
            for (int i = 0; i < added.m.getVariables().length; i++) {
                hashSet.add(added.m.getVariables()[i]);
            }
        }
        return new VariableSet() {
            HashSet<Variable> set = hashSet;
            @Override
            public boolean contains(Variable variable) {
                return hashSet.contains(variable);
            }

        };
    }

    @Override
    public int getCoefficientOf(Monomial m) {

        if (this.m.equals(m)) return coefficient;
        else if (added != null) return added.getCoefficientOf(m);
        return 0;
    }

    @Override
    public HashMap<Monomial, Integer> asMap() {
        return null;
    }

    @Override
    public MonomialIterator iterator() {
        MonomialIterator current = m.iterator();
        final MonomialIterator next;

        if (added != null) {
            next = added.iterator();
        } else {
            next = null;
        }

        return new MonomialIterator() {
            @Override
            public boolean hasNext() {
                return current.hasNext() || (next != null && next.hasNext());

            }

            @Override
            public Monomial next() {
                if (current.hasNext()) return current.next();
                else if (next != null && next.hasNext()) return next.next();
                else throw new NoSuchElementException("no more monomials!");
            }
        };
    }

    @Override
    public String toString() {
        String res = "";
        if (coefficient > 1) res += coefficient + " * ";
        res += m.toString();
        if (added != null) res += " + " + added.toString();
        return res;
    }
}
