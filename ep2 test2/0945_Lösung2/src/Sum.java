import java.util.*;

// This class represents a sum of two expressions. Since the two expressions can themselves be
// objects of 'ModifiableSum', we naturally get tree-like structures, where objects of 'Variable'
// and 'Constant' form the leafs of the tree. The implementation of this class can, but need not
// be based on a tree structure.
//
public class Sum implements Expression {

    // TODO: define missing parts of this class (including getters as needed).

    // Initializes 'this' with the two operands of the sum. If 'e1' and 'e2' contain at least two
    // variables with the same name but different identities, a 'DuplicateNameException' is thrown.
    // Precondition: 'e1' and 'e2' are not null.
    private Expression e1, e2;

    public Sum(Expression e1, Expression e2) throws DuplicateNameException {
        this.e1 = e1;
        this.e2 = e2;
        // TODO: implement constructor.
        for (Variable eleE1 : e1.asSet()) {
            for (Variable eleE2 : e2.asSet()) {
                if (eleE1.getName().equals(eleE2.getName()) && eleE1 != eleE2) {
                    throw new DuplicateNameException("different variables with same name '" + eleE1.toString() + "'!");
                }
            }
        }
    }

    // Replaces all occurrences of the specified variable 'toReplace' with the specified variable
    // 'replaceWith'. For example, if 'this' corresponds to x + y + 4, this.replace(y,z) changes
    // 'this' to x + z + 4.
    // Precondition: 'toReplace' and 'replaceWith' are not null.
    public void replace(Variable toReplace, Variable replaceWith) {
        // TODO: implement method.
        if (e1.equals(toReplace)) e1 = replaceWith;
        if (e2.equals(toReplace)) e2 = replaceWith;

        if (e1.getClass() == Sum.class) {
            ((Sum) e1).replace(toReplace, replaceWith);
        }
        if (e2.getClass() == Sum.class) {
            ((Sum) e2).replace(toReplace, replaceWith);
        }
    }

    @Override
    public Expression evaluate(HashMap<Variable, Constant> map) {
        // TODO: implement method.
        return e1.evaluate(map).sumWith(e2.evaluate(map));
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
        HashSet<Variable> res = new HashSet<>();

        for (Variable eleE1 : e1.asSet()) {
            res.add(eleE1);
        }
        for (Variable eleE2 : e2.asSet()) {
            res.add(eleE2);
        }
        return res;
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
        Iterator<Variable> iterleft = e1.iterator();
        Iterator<Variable> iterRight = e2.iterator();

        return new VariableIterator() {
            @Override
            public boolean hasNext() {
                return iterleft.hasNext() || iterRight.hasNext();
            }

            @Override
            public Variable next() {
                if (!hasNext()) throw new NoSuchElementException("no more variables!");
                if (iterleft.hasNext()) return iterleft.next();
                else return iterRight.next();
            }
        };
    }

    @Override
    public String toString() {
        Set<Variable> mySet = this.asSet();
        String res = new String("");
        for (Variable ele : mySet) {
            if(!this.coefficientOf(ele).toString().equals("1")) {
                res += this.coefficientOf(ele);
            }
            res += ele.toString() + "+";
        }

        if(!this.sumOfConstants().toString().equals("0")){
            res += this.sumOfConstants() + "+";
        }

        return res.length()>0 ? res.substring(0,res.length()-1) : "";
    }
}

//TODO: define additional classes as needed, either here or in a separate file.