import java.util.ArrayList;

// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest2 {

    public static void main(String[] args) {


        //* TODO: uncomment this block.

        Solid solid7 = new Solid(7);
        Solid solid2 = new Solid(2);
        Solid solid3 = new Solid(3);
        Solid solid5 = new Solid(5);
        Box box30 = new Box(30);
        Box box4 = new Box(4);
        Box box15 = new Box(15);

        System.out.println("Test 1: 'getVolume'");
        testEquals(box30.getVolume(), 30);
        testEquals(solid2.getVolume(), 2);

        System.out.println("\nTest 2: 'insert' and 'toString' (part1)");
        testEquals(box30.toString(),"[]30");
        testEquals(box15.toString(),"[]15");

        System.out.println("\nTest 3: 'insert'");
        testEquals(box30.insert(solid7), true);
        testEquals(box30.insert(solid3), true);
        testEquals(box30.insert(box15), true);
        testEquals(box30.insert(new Solid(16)), false);
        try {
            box30.insert(box15);
            System.out.println("Test NOT successful! This message should not be printed!");
        } catch (IdenticalBoxException ex) {
            System.out.println("Successful test");
        }

        System.out.println("\nTest 4: 'insert' and 'toString' (part2)");
        String s0 = box30.toString();
        System.out.println("Expected result: \"[#7, #3, []15]30\"" +
                " (but may be in different order)");
        System.out.println("Your result: " + s0);
        testEquals(s0.length(), 16);
        testEquals(s0.startsWith("["), true);
        testEquals(s0.endsWith("]30"), true);
        testEquals(s0.contains("#7"), true);
        testEquals(s0.contains("#3"), true);
        testEquals(s0.contains("[]15"), true);
        box15.insert(solid2);
        box15.insert(solid5);
        box15.insert(solid3);
        box15.insert(solid3);

        System.out.println("\nTest 5: 'insert' and 'toString' (part3)");
        String s1 = box15.toString();
        System.out.println("Expected result: \"[#2, #5, #3, #3]15\" (but may be in different " +
                "order)");
        System.out.println("Your result: " + s1);
        testEquals(s1.length(), 18);
        testEquals(s1.startsWith("["), true);
        testEquals(s1.endsWith("]15"), true);
        testEquals(s1.contains("#5"), true);
        testEquals(s1.contains("#2"), true);
        testEquals(s1.indexOf("#3") > 0 && s1.lastIndexOf("#3") > 0, true);
        testEquals(s1.indexOf("#3") != s1.lastIndexOf("#3"), true);

        System.out.println("\nTest 6: equals");
        Box equalBox30 = new Box(30);
        Box equalBox15 = new Box(15);
        equalBox30.insert(new Solid(3));
        equalBox30.insert(equalBox15);
        equalBox30.insert(new Solid(7));
        equalBox15.insert(new Solid(3));
        equalBox15.insert(new Solid(3));
        equalBox15.insert(new Solid(2));
        equalBox15.insert(new Solid(5));
        System.out.println("...comparing " + box30 + " and " + equalBox30 + ":");
        testEquals(box30, equalBox30);

        System.out.println("\nTest 7: Iterator");
        box30.insert(box4);
        BoxIterator iter = box30.iterator();
        ArrayList<Box> boxList = new ArrayList<>();
        while (iter.hasNext()) {
            boxList.add(iter.next());
        }
        testEquals(boxList.size(), 3);
        testEquals(boxList.remove(box4), true);
        testEquals(boxList.remove(box15), true);
        testEquals(boxList.remove(box30), true);
        testEquals(boxList.size(), 0);

        System.out.println("\nTest 8: iterator throwing exception");
        try {
            iter.next();
            System.out.println("This message should not be printed!");
        } catch (java.util.NoSuchElementException e) {
            testEquals(e.getMessage(), "no box element!");
        }

        System.out.println("\nTest 9: add and SolidSet");
        SolidSet cs = box30.getSolidSet();
        //System.out.println(box30);
        testEquals(cs.contains(new Solid(3)), true);
        testEquals(cs.contains(new Solid(1)), false);
        box30.insert(new Solid(1));
        testEquals(cs.contains(new Solid(1)), true);

        // TODO: end of block to uncomment. */

    }

    public static void testEquals(Object given, Object expected) {
        if (given == null) {
            if(expected == null) {
                System.out.println("Successful test");
            } else {
                System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                        "value: null");
            }
        } else {
            if (given.equals(expected)) {
                System.out.println("Successful test");
            } else {
                System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                        "value: " + given.toString());
            }
        }
    }
}
