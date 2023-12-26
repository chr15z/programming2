import java.util.*;

// A 'Stick' has a specified stick weight, that can not be changed after
// initialisation. Mobiles can be attached to the stick (recursive structure).
// 'Stick' implements 'Mobile'.
// You can assume that no part of a mobile has the same identity as another part.
//
public class Stick implements Mobile // TODO: uncomment clause.
{

    //TODO: define missing parts of the class.
    private int stickWeight;
    private Mobile[] attached;

    // Initialises 'this'; throws an 'StickBreaksException' if the sum of the weight of
    // all mobiles in the array 'attached' is greater than 10 times the 'stickWeight'.
    // The detail message of the exception is "Stick breaks!".
    // Precondition: attached.length > 0 and for any two mobiles m1 and m2 being part of
    // 'attached' (including sub-mobiles) it holds that m1.equals(m2) == false, this is,
    // that there are no duplicates anywhere in a mobile.
    public Stick(int stickWeight, Mobile[] attached) throws StickBreaksException {

        // TODO: implement constructor.
        int counter = 0;
        for(Mobile mo: attached){
            counter+=mo.getWeight();
            if (counter > stickWeight * 10) throw new StickBreaksException("Stick breaks!");
        }
        this.stickWeight = stickWeight;
        this.attached = attached;
    }

    // Replaces the mobile equal to 'toReplace' with a new mobile 'replaceWith' if this mobile
    // is directly attached to this stick (no recursive search). In this case 'true' is returned.
    // Otherwise, the call of this method has no effect and 'false' is returned.
    // Throws a 'StickBreaksException' if the replacement would violate the
    // condition that the sum of the weight of all attached mobiles has to be
    // less than or equal to 10 times its stick weight.
    // Precondition: toReplace != null && replaceWith != null
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws StickBreaksException {

        // TODO: implement method.
        for (int i = 0; i < attached.length; i++) {
            if (attached[i].equals(toReplace)){
                attached[i] = replaceWith;
                int counter = 0;
                for(Mobile mo: attached){
                    counter+=mo.getWeight();
                    if (counter > stickWeight * 10) throw new StickBreaksException("Stick breaks!");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int getWeight() {
        int counter = 0;
        for(Mobile mo: attached){
            counter+=mo.getWeight();
        }
        return counter + stickWeight;
    }


    // Returns 'true' if 'o' is also of class 'Stick', has an equal stick weight, and has equal mobiles
    // attached, regardless of their order. This means that 'this' and 'o' have the same number of mobiles
    // attached and every mobile attached to 'this' is equal to a mobile attached to 'o' (and vice versa).
    // Otherwise, 'false' is returned.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stick stick = (Stick) o;
        if (stickWeight != stick.stickWeight) return false;
        for (Mobile m1: attached){
            boolean check = false;
            for (Mobile m2: stick.attached){
                if (m1.equals(m2)) check = true;
            }
            if (!check) return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(stickWeight);
        result = 31 * result + Arrays.hashCode(attached);
        return result;
    }



    @Override
    public Countable getStickCountable() {
        int counter = 1;
        for (int i = 0; i < attached.length; i++) {
            counter += attached[i].getStickCountable().count();
        }
        int finalCounter = counter;
        return new Countable() {
            @Override
            public int count() {
                return finalCounter;
            }
        };
    }

    @Override
    public StarIterator iterator() {
        StarIterator[] current = new StarIterator[attached.length];
        for (int i = 0; i < attached.length; i++) {
            current[i] = attached[i].iterator();
        }

        return new StarIterator() {
            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                for (StarIterator iterator: current){
                    hasNext = hasNext || iterator.hasNext();
                }
                return hasNext;
            }

            @Override
            public Star next() {
                if (hasNext()){
                    for (StarIterator iterator: current){
                        if(iterator.hasNext()) return iterator.next();                    }

                }
                throw new NoSuchElementException("no star element!");
            }
        };
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < attached.length - 1; i++) {
            res += attached[i].toString() + ", ";
        }
        res += attached[attached.length - 1].toString();
        /*for(Mobile mo: attached) {
            res += mo.toString();
        }*/

        return stickWeight + "[" + res + "]";
    }
}

// TODO: define additional classes if needed (either here or in a separate file).