import java.util.*;

// This class represents an integer constant (no objects of class 'Variable' are contained
// in this expression).
//
public class Constant implements Expression {

    // TODO: define missing parts of this class.
    private int value;
    // Initializes 'this' with the specified value.
    public Constant(int value) {
        //TODO: implement constructor.
        this.value=value;
    }

    @Override
    public VariableIterator iterator() {
        //TODO: implement method.
        return new VariableIterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Variable next() {
                throw new NoSuchElementException("no Element");
            }
        };
    }

    // Evaluates the constant with the provided variable-value mapping.
    // Since a constant does not depend on variables, it returns itself.
    @Override
    public Expression evaluate(HashMap<Variable, Constant> map) {

        return this;
    }

    // Returns a new 'Constant' object representing the sum of this constant and another constant.
    public Constant sumWith(Constant c) {

        // TODO: implement method.
        return new Constant(this.value+c.value);
    }

    // Since a constant does not depend on variables, the coefficient of the
    // specified variable is always 0.
    @Override
    public Constant coefficientOf(Variable variable) {

        return new Constant(0);
    }

    // Returns the sum of all constants in the constant expression.
    // Since 'this' is a constant itself, it returns itself.
    @Override
    public Constant sumOfConstants() {

        return this;
    }

    // Returns a set with all variables in the constant expression.
    // Since a constant does not depend on variables, an empty set is returned.
    @Override
    public Set<Variable> asSet() {
        return new HashSet<>();
    }

    @Override
    public VariableSet getSetView() {

        //TODO: implement method.
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return false;
            }
        };
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant variables = (Constant) o;
        return value == variables.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

//TODO: define additional classes as needed, either here or in a separate file.
