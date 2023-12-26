import java.util.*;

// This class represents a product of variables, like x*x*y*z. The coefficient of
// a monomial is considered to be 1.
//
public class Monomial implements Polynomial // TODO: activate clause.
{

    // TODO: define missing parts of this class (including getters as needed).

    private final ArrayList<Variable> variables;

    // Initializes 'this' with the specified variables. Variables can occur more often than once
    // in the specified array. (The number of occurrences corresponds to the exponent of the
    // variable.) If variables.length == 0, this monomial corresponds to the constant 1.
    // Precondition: variables != null.
    public Monomial(Variable[] variables) {

        //TODO: implement constructor.
        this.variables = new ArrayList<>();
        this.variables.addAll(List.of(variables));
    }

    @Override
    public Polynomial evaluate(Variable v, int value) {
        return null;
    }

    @Override
    public VariableSet getVariableSetView() {

        return new VariableSet() {
            //HashSet<Variable> set = new HashSet<>();
            @Override
            public boolean contains(Variable variable) {
                return variables.contains(variable);
            }
        };
    }

    // Returns the coefficient of the specified monomial in this polynomial.
    // Precondition: m != null.
    public int getCoefficientOf(Monomial m) {

        return m.equals(this) ? 1 : 0;
    }

    @Override
    public HashMap<Monomial, Integer> asMap() {
        HashMap<Monomial, Integer> map = new HashMap<>();
        map.put(this, 1);
        return map;
    }


    // @Override
    // The iterator of this class iterates over only one element.
    // See examples in 'PraxisTest2.java'.
    public MonomialIterator iterator() {

        //TODO: implement method.
        Monomial current = this;
        return new MonomialIterator() {
            boolean hasNext = true;
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Monomial next() {
                if (hasNext){
                    hasNext = false;
                    return current;
                }
                else throw new NoSuchElementException("no more monomials!");
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        if (this.variables == null && monomial.variables == null) return true;
        if (this.variables == null || monomial.variables == null) return false;
        return monomial.asVariableHasMap().equals(this.asVariableHasMap());
    }
    private HashMap<Variable, Integer> asVariableHasMap(){
        HashMap <Variable, Integer> counters = new HashMap<>();
        for (Variable v : variables){
            if (counters.containsKey(v)) counters.put(v, 1+counters.get(v));
            else counters.put(v, 1);
        }
        return counters;
    }


    @Override
    public int hashCode() {
        return Objects.hash(variables);
    }

    @Override
    public String toString() {
        //if (variables == null) return "1";

        String s = "";
        for (Variable v : variables){
            s+= v.getName() + "*";
        }
        return s.substring(0,s.lastIndexOf("*"));
    }
}
