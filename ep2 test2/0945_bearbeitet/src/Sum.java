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
        this.e1 = e1;
        this.e2 = e2;


    }

    // Replaces all occurrences of the specified variable 'toReplace' with the specified variable
    // 'replaceWith'. For example, if 'this' corresponds to x + y + 4, this.replace(y,z) changes
    // 'this' to x + z + 4.
    // Precondition: 'toReplace' and 'replaceWith' are not null.
    public void replace(Variable toReplace, Variable replaceWith) {

        // TODO: implement method.
        if (e1.equals(toReplace)) e1 = replaceWith;
        if (e2.equals(toReplace)) e2 = replaceWith;

        if (e1.getClass() == Sum.class) ((Sum) e1).replace(toReplace, replaceWith);
        if (e2.getClass() == Sum.class) ((Sum) e2).replace(toReplace, replaceWith);

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

        for (Variable ele1 : e1.asSet()) {
            res.add(ele1);
        }
        for (Variable ele2 : e2.asSet()) {
            res.add(ele2);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sum variables = (Sum) o;
        return Objects.equals(e1, variables.e1) && Objects.equals(e2, variables.e2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e1, e2);
    }

    // Returns a string representation of 'this' where each variable occurs at most once and there
    // is at most one constant. For example, a sum of 2, x, y, x  and -4 is represented by
    // "2x + y + -2" or "-2 + 2x + y". (The order of the terms is not specified. Coefficients of 1
    // are omitted in the representation.)
    @Override
    public String toString() {
        Constant c = sumOfConstants();
        Set<Variable> mySet = this.asSet();
        String res = "";
        for (Variable var: mySet){
            if (!coefficientOf(var).toString().equals("1")){
                res += coefficientOf(var) + var.toString() + " + ";
            }
            else res += var.toString() + " + ";

        }
        return res + c.toString();
    }
}

//TODO: define additional classes as needed, either here or in a separate file.