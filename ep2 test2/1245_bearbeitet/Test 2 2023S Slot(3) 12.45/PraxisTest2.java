import java.util.HashMap;
import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {

        ///* TODO: uncomment this block.
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Variable z = new Variable("z");

        Monomial m1 = new Monomial(new Variable[]{x,y,x});
        Monomial m2 = new Monomial(new Variable[]{y,x,x});
        Monomial m3 = new Monomial(new Variable[]{y,x});

        System.out.println("\nTest 'equals' method:");
        testEquals(m1, m2);
        testEquals(m1.equals(m3), false);
        testEquals(m3, new Monomial(new Variable[]{x,y}));
        SimplePolynomial p = new SimplePolynomial(m1,3);
        p.add(m3);

        System.out.println("\nTest 'getCoefficientOf' method:");
        testEquals(m1.getCoefficientOf(m1), 1);
        testEquals(m1.getCoefficientOf(m2), 1);
        testEquals(m1.getCoefficientOf(m3), 0);

        testEquals(p.getCoefficientOf(m1), 3);
        testEquals(p.getCoefficientOf(m3), 1);
        testEquals(p.getCoefficientOf(m2), 3);

        System.out.println("\nTest 'toString' method:");
        testEquals(new Monomial(new Variable[]{x}).toString(), "x");

        // m1.toString should be like x*x*y or x*y*x
        String asString = m1.toString().replaceAll("\\s","");
        testEquals(asString.length(), 5);
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        testEquals(asString.contains("y"), true);
        asString = asString.replaceFirst("y", "");
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        testEquals(asString, "**");

        // 2*x*x*y + x*y
        p = new SimplePolynomial(m1, 2);
        p.add(m3);
        System.out.println(p);

        asString = p.toString().replaceAll("\\s","");
        asString = asString.replaceAll("\\*","");
        testEquals(asString.length(), 7);
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        testEquals(asString.length(), 6);
        testEquals(asString.contains("y"), true);
        asString = asString.replaceFirst("y", "");
        testEquals(asString.length(), 5);
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        testEquals(asString.length(), 4);
        testEquals(asString.contains("y"), true);
        asString = asString.replaceFirst("y", "");
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        asString = asString.replaceFirst("2", "");
        testEquals(asString, "+");

        System.out.println("\nTest 'evaluate' method:");
        // x*x*y -> y = 2 -> 2*x*x
        testEquals(new Monomial(new Variable[] {x,x,y}).evaluate(y,2),
                new SimplePolynomial(new Monomial(new Variable[] {x,x}), 2));

        // 2*x*x*y + x*y
        p = new SimplePolynomial(m1, 2);
        p.add(m3);
        // 2*x*x*y + x*y -> x = 2 -> 10*y
        testEquals(p.evaluate(x,2), new SimplePolynomial(new Monomial(new Variable[]{y}), 10));

        System.out.println("\nTest 'iterator' method:");
        MonomialIterator iter = new Monomial(new Variable[]{x}).iterator();
        testEquals(iter.hasNext(), true);
        testEquals(iter.next(), new Monomial(new Variable[]{x})); //x
        testEquals(iter.hasNext(), false);
        try {
            iter.next();
            System.out.println("This message should not be printed!");
        } catch (NoSuchElementException e) {
            testEquals(e.getMessage(), "no more monomials!");
        }

        iter = p.iterator();
        // p has two monomials: x*x*y and x*y.
        String sIter = "";
        while (iter.hasNext()) {
            sIter += iter.next() + " ";
        }
        try {
            iter.next();
            System.out.println("This message should not be printed!");
        } catch (NoSuchElementException e) {
            testEquals(e.getMessage(), "no more monomials!");
        }
        sIter = sIter.trim();
        testEquals(sIter.length(), 9);
        testEquals(sIter.contains("x"), true);
        sIter = sIter.replaceFirst("x", "");
        testEquals(sIter.contains("x"), true);
        sIter = sIter.replaceFirst("x", "");
        testEquals(sIter.contains("y"), true);
        sIter = sIter.replaceFirst("y", "");
        testEquals(sIter.contains("x"), true);
        sIter = sIter.replaceFirst("x", "");
        testEquals(sIter.contains("y"), true);
        sIter = sIter.replaceFirst("y", "");
        sIter = sIter.replaceFirst(" ", "");
        testEquals(sIter.trim(), "***");

        System.out.println("\nTest 'getSetView' method:");
        VariableSet view = p.getVariableSetView();
        testEquals(view.contains(y), true);
        testEquals(view.contains(x), true);
        testEquals(view.contains(z), false);
        p.add(new SimplePolynomial(new Monomial(new Variable[]{x,z}),3));
        testEquals(view.contains(z), true);

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
