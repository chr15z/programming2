import java.util.*;

// This class represents a sum of two expressions. Since the two expressions can themselves be
// objects of 'ModifiableSum', we naturally get tree-like structures, where objects of 'Variable'
// and 'Constant' form the leafs of the tree. The implementation of this class can, but need not
// be based on a tree structure.
//
public class ModifiableSum implements Expression {

    // TODO: define missing parts of this class (including getters as needed).

    private Expression left;
    private Expression right;

    // Initializes 'this' with the two operands of the sum. If 'e1' and 'e2' contain at least two
    // variables with the same name but different identities, a 'DuplicateNameException' is thrown.
    // Precondition: 'e1' and 'e2' are not null.
    public ModifiableSum(Expression e1, Expression e2) throws DuplicateNameException {

        // TODO: implement constructor.
        for (Variable var1: e1.asMap().keySet()){
            for (Variable var2: e2.asMap().keySet()){
                if (String.valueOf(var1.toString()).equals(var2.toString()) && var1 != var2)
                    throw new DuplicateNameException("different variables with same name '" + var1.toString() + "'!");
            }
        }
        left = e1;
        right = e2;
    }

    // This method adds 'expression' to 'this'.
    // If 'expression' contains a variable with the same name but different identity than
    // a variable in 'this', a 'DuplicateNameException' is thrown.
    // Precondition: other != null.
    public void add(Expression expression) throws DuplicateNameException {

        // TODO: implement method.
        for (Variable var : asMap().keySet()) {
            if (String.valueOf(expression.toString()).equals(var.toString()) && expression != var)
                throw new DuplicateNameException("different variables with same name '" + var.toString() + "'!");
        }
        left = new ModifiableSum(left, right);
        right = expression;

    }

    @Override
    public Expression evaluate(HashMap<Variable, Constant> map) {

        // TODO: implement method.
        return new Constant(0);
    }

    @Override
    public Constant coefficientOf(Variable variable) {

        // TODO: implement method.
        if (asMap().get(variable) == null) return new Constant(0);
        return asMap().get(variable);
    }

    @Override
    public Constant getConstant() {

        // TODO: implement method.
        return left.getConstant().sumWith(right.getConstant());
    }

    @Override
    public Map<Variable, Constant> asMap() {

        // TODO: implement method.
        HashMap<Variable, Constant> map = new HashMap<>();
        Constant one = new Constant(1);
        for (Variable var : left.asMap().keySet()) {
            if (map.get(var) == null) map.put(var, one);
            else map.put(var, map.get(var).sumWith(one));
        }
        for (Variable var : right.asMap().keySet()) {
            if (map.get(var) == null) map.put(var, one);
            else map.put(var, map.get(var).sumWith(one));
        }

        return map;
    }

    @Override
    public VariableSet getSetView() {

        // TODO: implement method.
        return new VariableSet() {
            private boolean contains = false;
            @Override
            public boolean contains(Variable variable) {
                contains = contains || left.getSetView().contains(variable) || right.getSetView().contains(variable);
                return contains;
            }

            @Override
            public VariableIterator iterator() {
                return new VariableIterator() {
                    Iterator<Variable> iter = asMap().keySet().iterator();
                    @Override
                    public boolean hasNext() {
                        return iter.hasNext();
                    }

                    @Override
                    public Variable next() {
                        if (hasNext()) return iter.next();
                        else throw new NoSuchElementException("no more variables!");
                    }
                };
            }
        };
    }

    @Override
    public String toString() {

        // TODO: implement method.
        String res = "";
        for (Variable var: asMap().keySet()){
            if (asMap().get(var).toString().equals("1")) res += var.toString() + " + ";
            else res += asMap().get(var) + var.toString() + " + ";
        }
        return res + getConstant();
    }
}

//TODO: define additional classes as needed, either here or in a separate file.