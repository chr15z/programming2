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
    private LinkedList<Expression> list;
    // Initializes 'this' with the two operands of the sum. If 'e1' and 'e2' contain at least two
    // variables with the same name but different identities, a 'DuplicateNameException' is thrown.
    // Precondition: 'e1' and 'e2' are not null.
    public ModifiableSum(Expression e1, Expression e2) throws DuplicateNameException {

        // TODO: implement constructor.
        if (e1.toString()==e2.toString() && !e1.equals(e2)) throw new DuplicateNameException();
        left = e1;
        right = e2;
        list = new LinkedList<>();


    }

    private void fillList(Expression in){
        if (in==null) return;
        ModifiableSum temp = (ModifiableSum) in;
        fillList(temp.left);
        list.add(temp);
        fillList(temp.right);

    }

    // This method adds 'expression' to 'this'.
    // If 'expression' contains a variable with the same name but different identity than
    // a variable in 'this', a 'DuplicateNameException' is thrown.
    // Precondition: other != null.
    public void add(Expression expression) throws DuplicateNameException {

        // TODO: implement method.
        for(Expression e : list){
            if(e.toString()==expression.toString() && !e.equals(expression)) throw new DuplicateNameException();
        }
        list.add(expression);
    }

    @Override
    public Expression evaluate(HashMap<Variable, Constant> map) {

        // TODO: implement method.
        //if (asMap().equals(Variable, Constant))
        return null;
    }

    @Override
    public Constant coefficientOf(Variable variable) {

        // TODO: implement method.
        int counter = 0;
        int sum = 0;
        for(Expression e : list){
            if(e.toString() == variable.toString()) counter++;
            //sum += e.coefficientOf(e)
        }
        //if (counter == 0) return null;
        return new Constant(counter);
    }

    @Override
    public Constant getConstant() {

        // TODO: implement method.
        int c = 0;
        for(Expression e : list){
            if(e.getClass() == Constant.class) c+= ((Constant) e).intValue();
        }
        return new Constant(c);
    }

    @Override
    public Map<Variable, Constant> asMap() {

        // TODO: implement method.
        return new HashMap<Variable, Constant>();
    }

    @Override
    public VariableSet getSetView() {

        // TODO: implement method.
        LinkedList<VariableIterator> iterators= new LinkedList<>();
        for(Expression e: list){
            if (e.getClass() == Variable.class){
                iterators.add(((Variable) e).iterator());
            }
        }
        return new VariableSet() {
            @Override
            public boolean contains(Variable variable) {
                return iterators.contains(variable.iterator()) && variable.iterator().hasNext();
            }

            @Override
            public VariableIterator iterator() {
                return new VariableIterator() {
                    @Override
                    public boolean hasNext() {
                        return !iterators.isEmpty();
                    }

                    @Override
                    public Variable next() {
                        if (!hasNext()) throw  new NoSuchElementException();
                        return iterators.getFirst().next();
                    }
                };
            }
        };
    }

    @Override
    public String toString() {

        // TODO: implement method.
        Constant c = getConstant();
        String s = "";
        for(Expression e : list){
            if(e.getClass() == Variable.class){
                s += ((Variable) e).toString() + " +";
            }
        }
        return s + " " + c.toString();
    }
}

//TODO: define additional classes as needed, either here or in a separate file.