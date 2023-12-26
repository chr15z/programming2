import java.util.*;

// This class represents a sum of two expressions. Since the two expressions can themselves be
// objects of 'ModifiableSum', we naturally get tree-like structures, where objects of 'Variable'
// and 'Constant' form the leafs of the tree. The implementation of this class can, but need not
// be based on a tree structure.
//
public class Sum implements Expression {

    // TODO: define missing parts of this class (including getters as needed).
    private Expression e1;
    private Expression e2;

    // Initializes 'this' with the two operands of the sum. If 'e1' and 'e2' contain at least two
    // variables with the same name but different identities, a 'DuplicateNameException' is thrown.
    // Precondition: 'e1' and 'e2' are not null.
    public Sum(Expression e1, Expression e2) throws DuplicateNameException {

        // TODO: implement constructor.
        for(Variable var1: e1.asSet()){
            for(Variable var2: e2.asSet()){
                if (var1.getName().equals(var2.getName()) && var1 != var2){
                    throw new DuplicateNameException("different variables with same name '"+ var1.getName() + "'!");
                }
            }
        }

        this.e1 = e1;
        this.e2 = e2;
    }

    // Replaces all occurrences of the specified variable 'toReplace' with the specified variable
    // 'replaceWith'. For example, if 'this' corresponds to x + y + 4, this.replace(y,z) changes
    // 'this' to x + z + 4.
    // Precondition: 'toReplace' and 'replaceWith' are not null.
    public void replace(Variable toReplace, Variable replaceWith) {

        // TODO: implement method.
        if(e1.equals(toReplace)) e1 = replaceWith;
        if(e2.equals(toReplace)) e2 = replaceWith;

        if (e1.getClass() == Sum.class){
            Sum temp = (Sum) e1;
            temp.replace(toReplace, replaceWith);
        }
        if (e2.getClass() == Sum.class){
            Sum temp = (Sum) e1;
            temp.replace(toReplace, replaceWith);
        }
    }

    @Override
    public Expression evaluate(HashMap<Variable, Constant> map) {

        // TODO: implement method.
        int value = sumOfConstants().getValue();
        for (Variable var: asSet()){
            if(map.get(var) != null){
                value += coefficientOf(var).getValue() * map.get(var).getValue();
            }
        }
        return new Constant(value);
    }

    @Override
    public Constant coefficientOf(Variable variable) {

        // TODO: implement method.
        return e1.coefficientOf(variable).sumWith(e2.coefficientOf(variable));
    }

    @Override
    public Constant sumOfConstants() {

        // TODO: implement method.
        return e1.sumOfConstants().sumWith(e2.sumOfConstants());
    }

    @Override
    public Set<Variable> asSet() {

        // TODO: implement method.
        HashSet <Variable> set = new HashSet<>();
        set.addAll(e1.asSet());
        set.addAll(e2.asSet());
        return set;
    }

    @Override
    public VariableSet getSetView() {

        // TODO: implement method.
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return e1.getSetView().contains(variable) || e2.getSetView().contains(variable);
            }
        };
    }

    @Override
    public VariableIterator iterator() {

        // TODO: implement method.
        Iterator i1 = e1.iterator();
        Iterator i2 = e2.iterator();

		return new VariableIterator() {
            @Override
            public boolean hasNext() {
                return i1.hasNext() || i2.hasNext();
            }

            @Override
            public Variable next() {
                if (hasNext()){
                    if (i1.hasNext()) return (Variable) i1.next();
                    else return (Variable) i2.next();
                }
                throw new NoSuchElementException("no more variables!");
            }
        };
    }

    @Override
    public String toString() {
        String res = "";
        for(Variable var: asSet()){
            if (coefficientOf(var).getValue() == 1){
                res += var.toString() + " + ";
            }
            else{
                res += coefficientOf(var) + var.toString() + " + ";
            }
        }

        return res + sumOfConstants();
    }
}

//TODO: define additional classes as needed, either here or in a separate file.