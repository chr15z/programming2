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
        this.value = value;
    }

    @Override
    public VariableIterator iterator() {
		return new VariableIterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Variable next() {
                throw new NoSuchElementException("no more variables!");
            }
        };
    }

    // Evaluates the constant with the provided variable-value mapping.
    // Since a constant does not depend on variables, it returns itself.
    @Override
    public Expression evaluate(HashMap<Variable, Constant> map) {

        return this;
    }

    public int getValue()
    {
        return value;
    }

    // Returns a new 'Constant' object representing the sum of this constant and another constant.
    public Constant sumWith(Constant c) {

        // TODO: implement method.
        return new Constant(c.getValue() + value);
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

    // Returns a string representation of the constant value.
    @Override
    public String toString() {

        //TODO: implement method.
        return ""+value;
    }

    // Returns 'true' only if this constant is equal to the given object.

    // Two constants are considered equal if they have the same value.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant variables = (Constant) o;
        return value == variables.value;
    }


    // Returns a hash code for this constant.

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

//TODO: define additional classes as needed, either here or in a separate file.
