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

    @Override
    public Expression sumWith(Expression other) throws DuplicateNameException {
        if (getClass() == other.getClass()){
            Variable temp = (Variable) other;
            if (temp.getName().equals(name) && temp != this){
                throw new DuplicateNameException("different variables with same name '"+ name + "'!");
            }
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

        return new Constant(0);
    }

    @Override
    public Constant coefficientOf(Variable variable) {

        if (variable.getName().equals(getName())) return new Constant(1);
        else return new Constant(0);
    }

    @Override
    public Constant sumOfConstants() {
        return new Constant(0);
    }

    @Override
    public Set<Variable> asSet() {
        HashSet<Variable> set = new HashSet<>();
        set.add(this);
        return set;
    }

    @Override
    public VariableSet getSetView() {
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return variable.equals(Variable.this);
            }
        };
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public VariableIterator iterator() {
		return new VariableIterator() {
            private boolean hasNext = true;
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Variable next() {
                if (hasNext){
                    hasNext = false;
                    return Variable.this;
                }
                throw new NoSuchElementException("no more variables!");            }
        };
    }

    @Override
    public boolean equals(Object o) {
        return this== o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

//TODO: define additional classes as needed, either here or in a separate file.