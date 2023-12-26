import java.util.HashMap;
import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {

        ///* TODO: uncomment this block.
        System.out.println("Test 'add' method:");
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Variable z = new Variable("y");
        try {
            new ModifiableSum(x,y).add(z);
            System.out.println("This message should not be printed!");
        } catch (DuplicateNameException e) {
            testEquals(e.getMessage(), "different variables with same name 'y'!");
        }
        System.out.println("\nTest 'equals' method:");

        testEquals(x.equals(y), false);
        testEquals(y.equals(z), false);
        Constant c4 = new Constant(4);
        testEquals(c4, new Constant(4));

        System.out.println("\nTest 'add' and 'coefficientOf' method:");
        z = new Variable("z");
        Constant c5 = new Constant(5);
        ModifiableSum sum = new ModifiableSum(x, y);
        sum.add(c5);
        sum.add(c4);
        sum.add(x);
        testEquals(sum.coefficientOf(x), new Constant(2));
        testEquals(sum.coefficientOf(y), new Constant(1));
        testEquals(sum.coefficientOf(z), new Constant(0));

        System.out.println("\nTest 'getConstant' method:");
        testEquals(sum.getConstant(), new Constant(9));

        System.out.println("\nTest 'toString' method:");
        testEquals(z.toString(), "z");
        testEquals(new Constant(0).toString(), "0");

        // sum.toString() should be like "2x + y + 9" or "y + 2x + 9"
        System.out.println(sum);
        String asString = sum.toString().replaceAll("\\s","");
        testEquals(asString.length(), 6);
        testEquals(asString.contains("2x"), true);
        asString = asString.replaceFirst("2x", "");
        testEquals(asString.contains("y"), true);
        asString = asString.replaceFirst("y", "");
        testEquals(asString.contains("9"), true);
        asString = asString.replaceFirst("9", "");
        testEquals(asString, "++");

        System.out.println("\nTest 'evaluate' method:");
        HashMap<Variable, Constant> evalMap = new HashMap<>();
        evalMap.put(x, new Constant(3));
        testEquals(sum.evaluate(evalMap).getConstant(), new Constant(15));
        testEquals(sum.evaluate(evalMap).coefficientOf(x), new Constant(0));
        testEquals(sum.evaluate(evalMap).coefficientOf(y), new Constant(1));
        evalMap.put(y, new Constant(4));
        testEquals(sum.evaluate(evalMap).coefficientOf(y), new Constant(0));
        testEquals(sum.evaluate(evalMap).toString(), "19");

        System.out.println("\nTest 'asMap' method:");
        HashMap<Variable, Constant> map = new HashMap<Variable, Constant>();
        map.put(x, new Constant(2));
        map.put(y, new Constant(1));
        testEquals(sum.asMap(), map);

        System.out.println("\nTest 'contains' method of 'VariableSet' view:");
        VariableSet view = sum.getSetView();
        testEquals(view.contains(z), false);
        sum.add(z);
        testEquals(view.contains(x), true);
        testEquals(view.contains(y), true);
        testEquals(view.contains(z), true);

        System.out.println("\nTest 'iterator' method of 'VariableSet' view:");
        VariableIterator iter = view.iterator();
        String sIter = "";
        while (iter.hasNext()) {
            sIter += iter.next(); //xxy
        }
        try {
            iter.next();
            System.out.println("This message should not be printed!");
        } catch (NoSuchElementException e) {
            testEquals(e.getMessage(), "no more variables!");
        }
        // sIter should be like "xyz", but may be in different order
        testEquals(sIter.length(), 3);
        testEquals(sIter.contains("x"), true);
        sIter = sIter.replaceFirst("x", "");
        testEquals(sIter.contains("y"), true);
        sIter = sIter.replaceFirst("y", "");
        testEquals(sIter.contains("z"), true);
        sIter = sIter.replaceFirst("z", "");
        testEquals(sIter.isEmpty(), true);

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
