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
        this.name=name;
        // TODO: implement constructor.
    }

    // Returns the name of this 'Variable'.
    public String getName() {
        // TODO: implement method.
        return name;
    }

    @Override
    public Expression evaluate(HashMap<Variable, Constant> map) {
        if(map.get(this)!=null) {
            return map.get(this);
        }
        return this;
    }

    @Override
    public Constant coefficientOf(Variable variable) {
        return this.equals(variable) ? new Constant(1) : new Constant(0);
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
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return asSet().contains(variable);
            }
        };
    }

    @Override
    public VariableIterator iterator() {
        Variable v = this;
        return new VariableIterator() {
            private boolean hasNext=true;
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Variable next() {
                if(!hasNext) throw new NoSuchElementException("no more variables!");
                hasNext=false;
                return v;
            }
        };
    }

    @Override
    public String toString() {
        return name;
    }
}

//TODO: define additional classes as needed, either here or in a separate file.