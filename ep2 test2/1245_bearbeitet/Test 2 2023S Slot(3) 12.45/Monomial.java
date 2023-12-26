import java.util.*;

// This class represents a product of variables, like x*x*y*z. The coefficient of
// a monomial is considered to be 1.
//
public class Monomial implements Polynomial // TODO: activate clause.
{

    // TODO: define missing parts of this class (including getters as needed).
    private Variable[] variables;



    // Initializes 'this' with the specified variables. Variables can occur more often than once
    // in the specified array. (The number of occurrences corresponds to the exponent of the
    // variable.) If variables.length == 0, this monomial corresponds to the constant 1.
    // Precondition: variables != null.
    public Monomial(Variable[] variables) {

        //TODO: implement constructor.
        this.variables = variables;
    }

    @Override
    public Polynomial evaluate(Variable v, int value) {
        int coefficent = 1;
        List<Variable> vars = new Stack<>();
        for (Variable var : variables){
            if (String.valueOf(var.getName()).equals(String.valueOf(v.getName()))){
                coefficent = coefficent * value;
            }
            else vars.add(var);
        }
        Variable[] out = new Variable[vars.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = vars.get(i);
        }
        return new SimplePolynomial(new Monomial(out), coefficent);
    }

    @Override
    public VariableSet getVariableSetView() {
        HashSet<Variable> hashSet = new HashSet<>();
        for (int i = 0; i < variables.length; i++) {
            hashSet.add(variables[i]);
        }
        return new VariableSet() {
            HashSet<Variable> set = hashSet;
            @Override
            public boolean contains(Variable variable) {
                return hashSet.contains(variable);
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
        return null;
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
        //Sets vergleichen
        if (monomial.variables.length != variables.length) return false;
        return true;

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(variables);
    }

    @Override
    public String toString() {
        String res = "";

        if (variables.length > 1){
            for (int i = 0; i < variables.length - 1; i++) {
                res += variables[i].toString() + " * ";
            }
        }
        res += variables[variables.length - 1].toString();
        return res;
    }

    public Variable[] getVariables() {
        return variables;
    }
}
