import java.util.*;

// Represents a variable. 'Variable' implements 'Expression'.
// Each variable is uniquely identified by its
// instance. Two variables are considered equal only if they have the same identity (regardless
// of their name).
//
public class Variable implements Expression // TODO: activate clause.
{

    // TODO: define missing parts of this class.
    private String name;


    public Variable(String name) {

        // TODO: implement constructor.
        this.name = name;
    }

    // Returns a new 'Expression' object representing the sum of 'this' and 'other'.
    // If 'other' contains a variable with the same name but different identity than
    // a variable in 'this', a 'DuplicateNameException' is thrown. The detail message contains
    // information about which name is used for different variables. For example, if the name "y"
    // is used for different variables, the message is "different variables with same name 'y'!".
    // Precondition: other != null.
    @Override
    public Expression sumWith(Expression other) throws DuplicateNameException {
        if (this != other && String.valueOf(this.toString()).equals(String.valueOf(other.toString()))){
            throw new DuplicateNameException("different variables with same name " + name);
        }
		return new Sum(this, other);
    }

    // Returns the name of this 'Variable'.
    public String getName() {

        // TODO: implement method.
        return name;
    }

    @Override
    public Expression evaluate(HashMap<Variable, Constant> map) {
        if (map.containsKey(this)){
            return map.get(this);
        }
        return this;
    }

    @Override
    public Constant coefficientOf(Variable variable) {
        if (String.valueOf(this.toString()).equals(String.valueOf(variable.toString()))) return new Constant(1);
        else return new Constant(0);
    }

    @Override
    public Constant sumOfConstants() {
        return new Constant(0);
    }

    @Override
    public Set<Variable> asSet() {
        HashSet<Variable> res = new HashSet<>();
        res.add(this);
        return res;
    }

    @Override
    public VariableSet getSetView() {
        Variable current = this;
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return current.equals(variable);
            }
        };
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public VariableIterator iterator() {
        Variable next = this;
		return new VariableIterator() {
            boolean visited = false;
            @Override
            public boolean hasNext() {
                return !visited;
            }

            @Override
            public Variable next() {
                if (visited){
                    throw new NoSuchElementException("no more variables!");
                }
                visited = true;
                return next;

            }
        };
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

//TODO: define additional classes as needed, either here or in a separate file.