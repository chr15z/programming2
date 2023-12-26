import java.util.NoSuchElementException;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {

        // TODO: REMOVE THIS LINE.

        System.out.println("Test 'apply' method:");
        InsertOperation singleRep = new InsertOperation("just ", 8);
        testEquals(singleRep.toString(), "insert \"just \" at position 8");
        testEquals(singleRep.apply("This is a test!"), "This is just a test!");

        System.out.println("\nTest 'andThen' method:");
        StringOperation rep1 = new InsertOperation(", again", 27);
        for (int i = 0; i < 2; i++) {
            rep1 = rep1.andThen(new InsertOperation(" and again", 34));
        }
        testEquals(rep1.apply("I'm running towards nothing"),
                "I'm running towards nothing, again and again and again");
        rep1 = new InsertOperation(", again", 6);
        for (int i = 0; i < 2; i++) {
            rep1 = rep1.andThen(new InsertOperation(" and again", 13));
        }
        testEquals(rep1.andThen(rep1).apply("Try it"),
                "Try it, again and again and again, again and again and again");

        System.out.println("\nTest 'apply' with illegal arguments:");
        try {
            testEquals(rep1.andThen(rep1).apply("Try"),
                    "Try it, again and again and again, again and again and again");
            System.out.println("This message should not be printed!");
        } catch (OperationException ex) {
            testEquals(ex.getMessage(), "startIndex 6, length 3");
        }

        System.out.println("\nTest 'toString' method:");
        testEquals(rep1.toString(), "insert \", again\" at position 6 and then " +
                "insert \" and again\" at position 13 and then insert \" and again\" at position 13");

        System.out.println("\nTest 'equals':");
        rep1 = new InsertOperation("one more ", 8)
                    .andThen(new InsertOperation("just ", 8));
        StringOperation rep2 = new InsertOperation("one more ", 8)
                .andThen(new InsertOperation("just ", 8));
        testEquals(rep1, rep2);
        testEquals(rep1,DoNothingOperation.DO_NOTHING.andThen(rep2));
        testEquals(rep1.equals(rep2.andThen(rep1)), false);
        rep1 = new InsertOperation("A",1)
                .andThen(new InsertOperation("B",2))
                .andThen(new InsertOperation("C", 3));
        rep2 = new InsertOperation("A",1)
                .andThen(new InsertOperation("B",2)
                .andThen(new InsertOperation("C", 3)));
        testEquals(rep1, rep2);

        System.out.println("\nTest 'iterator' method:");
        OperationSingleIterator iter = singleRep.iterator();
        while (iter.hasNext()) {
            testEquals(iter.next(),singleRep);
        }

        try {
            iter.next();
            System.out.println("This message should not be printed!");
        } catch (NoSuchElementException e) {
            testEquals(e.getMessage(), "no more operations!");
        }

        iter = rep1.iterator();
        testEquals(iter.hasNext(), true);
        testEquals(iter.next().toString(), "insert \"A\" at position 1");
        testEquals(iter.hasNext(), true);
        testEquals(iter.next().toString(), "insert \"B\" at position 2");
        testEquals(iter.hasNext(), true);
        testEquals(iter.next().toString(), "insert \"C\" at position 3");
        testEquals(iter.hasNext(), false);
        try {
            iter.next();
            System.out.println("This message should not be printed!");
        } catch (NoSuchElementException e) {
            testEquals(e.getMessage(), "no more operations!");
        }

        System.out.println("\nTest 'getCountable' method:");
        rep1 = DoNothingOperation.DO_NOTHING.andThen(rep1.andThen(DoNothingOperation.DO_NOTHING));
        Countable c1 = rep1.getCountable(DoNothingOperation.DO_NOTHING);
        Countable c2 = rep1.getCountable(new InsertOperation("D", 4));
        testEquals(c1.count(), 2);
        testEquals(c2.count(), 0);
        rep1.substitute(DoNothingOperation.DO_NOTHING, new InsertOperation("D", 4));
        testEquals(c1.count(), 0);
        testEquals(c2.count(), 2);

        // TODO: REMOVE THIS LINE. */
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

