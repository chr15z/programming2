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
    // Evaluates the constant with the provided variable-value mapping.
    // Since a constant does not depend on variables, it returns itself.
    public Expression evaluate(HashMap<Variable, Constant> map) {

        return this;
    }

    // Returns a new 'Constant' object representing the sum of this constant and another constant.
    public Constant sumWith(Constant c) {

        // TODO: implement method.
        return new Constant(intValue() + c.intValue());
    }

    @Override
    // Since a constant does not depend on variables, the coefficient of the
    // specified variable is always 0.
    public Constant coefficientOf(Variable variable) {

        return new Constant(0);
    }

    @Override
    // Returns the sum of all constants in the constant expression.
    // Since 'this' is a constant itself, it returns itself.
    public Constant getConstant() {

        return this;
    }

    @Override
    // Since a constant does not depend on variables, an empty map is returned.
    public Map<Variable, Constant> asMap() {

        return new HashMap<>();
    }


    // Returns the value of this constant.
    public int intValue() {

        // TODO: implement method.
        return value;
    }

    @Override
    // Returns 'true' only if this constant is equal to the given object.
    // Two constants are considered equal if they have the same value.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant constant = (Constant) o;
        return value == constant.value;
    }


    // Returns a hash code for this constant.
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }



    @Override
    public VariableSet getSetView() {

        //TODO: implement method.
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return false;
            }

            @Override
            public VariableIterator iterator() {
                return null;
            }
        };
    }

    // Returns a string representation of the constant value.
    @Override
    public String toString() {

        //TODO: implement method.
        return "" + value;
    }
}

//TODO: define additional classes as needed, either here or in a separate file.
