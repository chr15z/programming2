import java.util.*;

// This class represents a polynomial corresponding to a sum of terms, where each term is a
// 'Monomial' object multiplied by a coefficient, like 3*x*y + 4*x*x + 1*x*x*y + 3*1. (Factors
// of one are omitted in the string representation, see specification of 'toString'.)
// A polynomial may also consist of a single term like 2*x*y.
//
public class SimplePolynomial implements Polynomial //TODO: activate clause.
{

    private HashMap<Monomial, Integer> map;
    // Initializes 'this' with one term corresponding to coefficient*m. Polynomials with
    // multiple terms can be constructed by calling 'sumWith'.
    // Precondition: m != null && coefficient > 0.
    public SimplePolynomial(Monomial m, int coefficient) {
        map = new HashMap<>();
        map.put(m, coefficient);
    }

    // Add the specified polynomial to 'this'. For example, if 'this' corresponds to 3*x*y*y + 2*x
    // and 'other' to x*y*y then 'this' becomes 4*x*y*y + 2*x.
    // Precondition: other != null.
    void add(Polynomial other) {
        if (other.getClass() == SimplePolynomial.class){
            for (Monomial m: asMap().keySet()){
                if (!map.containsKey(map)) map.put(m, 1);
                else map.put(m, map.get(m) + 1);
            }
        }
        else {//Monomial
            map.put((Monomial) other, 1);
        }

    }


    @Override
    // Evaluates this polynomial using the provided 'value' for 'v'. For example,
    // the result of p.evaluate(x, 2) if 'p' is the polynomial 3*x*x*x*y is the polynomial 24*y.
    // (For simplicity, we assume that 'value' is a positive integer.)
    // Precondition: v != null && value > 0.
    public Polynomial evaluate(Variable v, int value) {
        return null;
    }

    @Override
    public VariableSet getVariableSetView() {
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                for (Monomial m : map.keySet()){
                    if (m.getVariableSetView().contains(variable)) return true;
                }
                return false;
            }
        };
    }

    @Override
    public int getCoefficientOf(Monomial m) {
        for(Monomial mon: map.keySet()){
            if (mon.equals(m)) return map.get(mon);
        }
        return 0;
    }

    @Override
    public HashMap<Monomial, Integer> asMap() {
        return map;
    }

    @Override
    public MonomialIterator iterator() {
        ArrayList<MonomialIterator> iters = new ArrayList<>();
        for (Monomial m : map.keySet()) {
            iters.add(m.iterator());
        }
        return new MonomialIterator() {
            @Override
            public boolean hasNext() {
                for (MonomialIterator m: iters){
                    if (m.hasNext()) return true;
                }
                return false;
            }

            @Override
            public Monomial next() {
                if (hasNext()){
                    for (MonomialIterator m: iters){
                        if (m.hasNext()) return m.next();
                    }
                }
                throw new NoSuchElementException("no more monomials!");
            }
        };
    }

    @Override
    public String toString() {
        String result = "";
        for (Monomial m: map.keySet()){
            if (map.get(m) == 1) result += " + " + m.toString();
            else result += " + " + map.get(m) + "*" + m.toString();
        }
        return result.substring(3);
    }
}
