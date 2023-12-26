import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {

        System.out.println("Test 'sumWith' method:");
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Variable z = new Variable("y");
        try {
            Expression e = x.sumWith(y).sumWith(z);
            System.out.println("This message should not be printed!");
        } catch (DuplicateNameException e) {
            testEquals(e.getMessage(), "different variables with same name 'y'!");
        }
        System.out.println("\nTest 'equals' method:");
        Constant c4 = new Constant(4);
        testEquals(x.equals(y), false);
        testEquals(y.equals(z), false);
        testEquals(c4, new Constant(4));

        System.out.println("\nTest 'coefficientOf' method:");
        z = new Variable("z");
        Constant c5 = new Constant(5);
        Expression e = x.sumWith(y).sumWith(c5).sumWith(c4).sumWith(x);
        testEquals(e.coefficientOf(x), new Constant(2));
        testEquals(e.coefficientOf(y), new Constant(1));
        testEquals(e.coefficientOf(z), new Constant(0));

        System.out.println("\nTest 'sumOfConstants' method:");
        testEquals(e.sumOfConstants(), new Constant(9));

        System.out.println("\nTest 'toString' method:");
        testEquals(z.toString(), "z");
        testEquals(new Constant(0).toString(), "0");

        // e.toString() should be like "2x + y + 9" or "y + 2x + 9"
        String asString = e.toString().replaceAll("\\s","");
        testEquals(asString.length(), 6);
        testEquals(asString.contains("2x"), true);
        asString = asString.replaceFirst("2x", "");
        testEquals(asString.contains("y"), true);
        asString = asString.replaceFirst("y", "");
        testEquals(asString.contains("9"), true);
        asString = asString.replaceFirst("9", "");
        testEquals(asString, "++");

        System.out.println("\nTest 'evaluate' method:");
        HashMap<Variable, Constant> map = new HashMap<>();
        map.put(x, new Constant(3));
        testEquals(e.evaluate(map).sumOfConstants(), new Constant(15));
        testEquals(e.evaluate(map).coefficientOf(x), new Constant(0));
        testEquals(e.evaluate(map).coefficientOf(y), new Constant(1));
        map.put(y, new Constant(4));
        testEquals(e.evaluate(map).coefficientOf(y), new Constant(0));
        testEquals(e.evaluate(map).toString(), "19");

        System.out.println("\nTest 'asSet' method:");
        HashSet<Variable> s = new HashSet<Variable>();
        s.add(x);
        s.add(y);
        testEquals(e.asSet(), s);

        System.out.println("\nTest 'iterator' method:");
        VariableIterator iter = z.iterator();
        testEquals(iter.hasNext(), true);
        testEquals(iter.next(), z); //x
        testEquals(iter.hasNext(), false);
        try {
            iter.next();
            System.out.println("This message should not be printed!");
        } catch (NoSuchElementException ex) {
            testEquals(ex.getMessage(), "no more variables!");
        }
        iter = e.iterator();
        String sIter = "";
        while (iter.hasNext()) {
            sIter += iter.next(); //xxy
        }
        try {
            iter.next();
            System.out.println("This message should not be printed!");
        } catch (NoSuchElementException ex) {
            testEquals(ex.getMessage(), "no more variables!");
        }
        // sIter should be like "xxy", but may be in different order
        testEquals(sIter.length(), 3);
        testEquals(sIter.contains("x"), true);
        sIter = sIter.replaceFirst("x", "");
        testEquals(sIter.contains("x"), true);
        sIter = sIter.replaceFirst("x", "");
        testEquals(sIter.contains("y"), true);
        sIter = sIter.replaceFirst("y", "");
        testEquals(sIter.isEmpty(), true);

        System.out.println("\nTest 'replace' method:");
        ((Sum) e).replace(x,z);
        testEquals(e.coefficientOf(x), new Constant(0));
        testEquals(e.coefficientOf(z), new Constant(2));

        System.out.println("\nTest 'getSetView' method:");
        VariableSet view = e.getSetView();
        ((Sum) e).replace(y,x);
        testEquals(view.contains(y), false);
        testEquals(view.contains(x), true);

        // TODO: end of block to uncomment. */

    }

    public static void testEquals(Object given, Object expected) {
        if (given == expected) {
            System.out.println("Successful test");
            return;
        } else {
            if (given == null) {
                System.out.println("Test NOT successful! Expected value: " +
                        expected +
                        " / Given value: null");
                return;
            }
            if (expected == null) {
                System.out.println("Test NOT successful! Expected value: null / " +
                        "Given value: " + given);
                return;
            }
        }
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                    "value: " + given.toString());
        }
    }
}
