import java.util.*;

// This class represents a product of variables, like x*x*y*z. The coefficient of
// a monomial is considered to be 1.
//
public class Monomial implements Polynomial {

    private final ArrayList<Variable> variables;
    //TODO: If list is null!!

    // Initializes 'this' with the specified variables. Variables can occur more often than once
    // in the specified array. (The number of occurrences corresponds to the exponent of the
    // variable.) If variables.length == 0, this monomial corresponds to the constant 1.
    // Precondition: variables != null.
    public Monomial(Variable[] variables) {
        if (variables.length != 0){
            this.variables = new ArrayList<>();
            this.variables.addAll(List.of(variables));
        } else this.variables = null;
    }

    @Override
    public String toString() {
        if (variables == null) return "1";

        String s = "";
        for (Variable v : variables){
            s+= v.getName() + "*";
        }
        return s.substring(0,s.lastIndexOf("*"));
    }

    // Checks if 'this' and 'o' are equal polynomials. Two objects of type 'Polynomial' are
    // considered to be equal if they are of the same class and are mathematically equivalent. For
    // example, the monomials x*y*y and y*y*x are equal and the polynomials 3*x*y*y + 2*y and
    // 2*y + 3*y*x*y are equal.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        if (this.variables == null && monomial.variables == null) return true;
        if (this.variables == null || monomial.variables == null) return false;
        return monomial.asVariableHasMap().equals(this.asVariableHasMap());
    }

    @Override
    public int hashCode() {
        if (this.variables == null) return 1227;
        int hash = 0;
        for (Variable v : variables){
            hash+= v.hashCode();
        }
        return hash;
    }

    // Evaluates this polynomial using the provided 'value' for 'v'. For example,
    // the result of p.evaluate(x, 2) if 'p' is the polynomial 3*x*x*x*y is the polynomial 24*y.
    // (For simplicity, we assume that 'value' is a positive integer.)
    // Precondition: v != null && value > 0.
    @Override
    public Polynomial evaluate(Variable v, int value) {
        if (this.variables == null) return null;

        HashMap <Variable, Integer> counters = asVariableHasMap();
        if (!counters.containsKey(v)) return this;

        int coeff = 1;
        for (int i = 0; i < counters.get(v); i++) {
            coeff *= value;
        }

        counters.remove(v);
        ArrayList<Variable>  remainingVariables = this.variables;
        while (remainingVariables.contains(v)){
            remainingVariables.remove(v);
        }

        return new SimplePolynomial(new Monomial(remainingVariables.toArray(new Variable[0])), coeff);
    }

    // Returns the coefficient of the specified monomial in this polynomial. For example,
    // in the polynomial 3*x*y*y + 2*x the coefficient of the monomial x*y*y is 3, while
    // the coefficient of the monomial x is 2. If 'm' does not occur in this polynomial,
    // the coefficient is 0.
    // Precondition: m != null.
    @Override
    public VariableSet getVariableSetView() {
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return variables != null && variables.contains(variable);
            }
        };
    }

    // Returns the coefficient of the specified monomial in this polynomial.
    // Precondition: m != null.
    public int getCoefficientOf(Monomial m) {
        return this.equals(m) ? 1 : 0;
    }

    // Returns a new map which associates each monomial of the polynom with its coefficient.
    @Override
    public HashMap<Monomial, Integer> asMap() {
        HashMap <Monomial, Integer> map = new HashMap<>();
        if (this.variables == null) return map; //TODO: wahr?
        map.put(this, 1);
        return map;
    }

    private HashMap<Variable, Integer> asVariableHasMap(){
        HashMap <Variable, Integer> counters = new HashMap<>();
        for (Variable v : variables){
            if (counters.containsKey(v)) counters.put(v, 1+counters.get(v));
            else counters.put(v, 1);
        }
        return counters;
    }

    // @Override
    // The iterator of this class iterates over only one element.
    // See examples in 'PraxisTest2.java'.
    public MonomialIterator iterator() {
        return new MonomialIterator() {
            boolean visited = false;
            @Override
            public boolean hasNext() {
                if (variables == null) return false;
                return !visited;
            }

            @Override
            public Monomial next() {
                if (!hasNext()) throw new NoSuchElementException("no more monomials!");
                visited = true;
                return Monomial.this;
            }
        };
    }
}
