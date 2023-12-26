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
    public Expression evaluate(HashMap<Variable, Constant> map) {
        return null;
    }

    @Override
    public Constant coefficientOf(Variable variable) {
        return new Constant(1);
    }

    @Override
    public Constant getConstant() {
        return new Constant(0);
    }

    @Override
    public Map<Variable, Constant> asMap() {
        HashMap <Variable, Constant> map = new HashMap<>();
        map.put(this, new Constant(1));
        return map;
    }

    @Override
    public VariableSet getSetView() {
        return new VariableSet() {

            @Override
            public boolean contains(Variable variable) {
                return variable.name.equals(name);
            }

            @Override
            public VariableIterator iterator() {
                return Variable.this.iterator();
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

    @Override
    public String toString() {
        return name;
    }

    public VariableIterator iterator(){
        Variable current = this;
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
                    return current;
                }
                else throw new NoSuchElementException("no more variables!");
            }
        };
    }
}

//TODO: define additional classes as needed, either here or in a separate file.