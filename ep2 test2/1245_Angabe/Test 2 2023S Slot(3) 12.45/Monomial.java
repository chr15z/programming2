import java.util.*;

// This class represents a product of variables, like x*x*y*z. The coefficient of
// a monomial is considered to be 1.
//
public class Monomial implements Polynomial // TODO: activate clause.
{

    private ArrayList<Variable> list;

    // Initializes 'this' with the specified variables. Variables can occur more often than once
    // in the specified array. (The number of occurrences corresponds to the exponent of the
    // variable.) If variables.length == 0, this monomial corresponds to the constant 1.
    // Precondition: variables != null.
    public Monomial(Variable[] variables) {
        list = new ArrayList<>();
        list.addAll(List.of(variables));
    }

    @Override
    // Evaluates this polynomial using the provided 'value' for 'v'. For example,
    // the result of p.evaluate(x, 2) if 'p' is the polynomial 3*x*x*x*y is the polynomial 24*y.
    // (For simplicity, we assume that 'value' is a positive integer.)
    // Precondition: v != null && value > 0.
    public Polynomial evaluate(Variable v, int value) {
        if (!getVariableSetView().contains(v)) return this;
        else
        return null;
    }

    @Override
    public VariableSet getVariableSetView() {
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                for (Variable v : list){
                    if (v.equals(variable)){
                        return true;
                    }
                }
                return false;
            }
        };
    }

    // Returns the coefficient of the specified monomial in this polynomial.
    // Precondition: m != null.
    public int getCoefficientOf(Monomial m) {
        return m.equals(this) ? 1 : 0;
    }

    @Override
    // Returns a new map which associates each monomial of the polynom with its coefficient.
    public HashMap<Monomial, Integer> asMap() {
        HashMap<Monomial, Integer> map = new HashMap<>();
        map.put(this, 1);
        return map;
    }


    // @Override
    // The iterator of this class iterates over only one element.
    // See examples in 'PraxisTest2.java'.
    public MonomialIterator iterator() {
        return new MonomialIterator() {
            private boolean hasNext = true;
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Monomial next() {
                if (hasNext){
                    hasNext = false;
                    return Monomial.this;
                }
                throw new NoSuchElementException("no more monomials!");
            }
        };
    }

    @Override
    public String toString() {
        String result = "";
        for (Variable v : list){
            result += "*" + v.toString();
        }
        return result.substring(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        int counter = 0;
        for(Variable v: monomial.list){
            for(Variable var: monomial.list){
                if (var.equals(v)) counter++;
            }
            for(Variable var: this.list){
                if (var.equals(v)) counter--;
            }
            if (counter != 0) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
