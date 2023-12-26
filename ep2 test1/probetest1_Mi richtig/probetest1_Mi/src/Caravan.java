// A caravan of camels implemented as a singly linked list with entries of 'Camel'.
// There are no 'null' entries in the list.
//
// TODO: define further classes and methods for the implementation of the singly linked list,
//  if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class Caravan {

    //TODO: declare variables.
    CamelNode start;

    // Initializes this caravan as an empty list.
    public Caravan() {

        //TODO: define constructor.
        start = null;
    }

    // Adds 'camel' as the last camel to the end of this caravan.
    // Precondition: camel != null.
    public void addLast(Camel camel) {

        // TODO: implement method.
        if (start==null){
            start = new CamelNode(camel);
        }
        else {
            CamelNode temp = start;
            while (temp.getNext() != null){// temp -> last CamelNode
                temp = temp.getNext();
            }
            temp.setNext(new CamelNode(camel));

        }
    }

    // Inserts a new camel into this caravan. Seen from the head of the caravan, the camel is
    // inserted just before the first camel in the caravan that has the same strength as the
    // specified 'searchStrength'. If no such camel is found, the new camel is added as the head
    // of the caravan.
    // Precondition: camel != null.
    public void insertBefore(int searchStrength, Camel camel) {

        // TODO: implement method.

        CamelNode temp = start;
        while (temp.getNext() != null){// temp -> last CamelNode
            if (temp.getNext().getCamel().getStrength() == searchStrength){
                CamelNode next = temp.getNext();
                temp.setNext(new CamelNode(camel));
                temp.getNext().setNext(next);
                break;
            }
            temp = temp.getNext();
        }

    }

    // Removes 'number' camels from the front of the caravan (the first 'number'
    // camels seen from the head of the caravan) and returns them as a new caravan in which they
    // have the same order as they had in 'this' (see examples in 'PraxisTest1.java'). If this
    // caravan is empty (this.size() == 0) or number == 0 then the result is a new empty caravan.
    // Precondition: number >= 0 && number <= this.size().
    public Caravan detachFront(int number) {

        // TODO: implement method.
        if (this.size() == 0 || number == 0){
            return new Caravan();
        }
        Caravan out = new Caravan();
        CamelNode temp = start;
        for (int i = 0; i < number; i++) { //finds new start
            out.addLast(temp.getCamel());
            temp = temp.getNext();
        }

        start = temp;
        while (temp != null){
            temp = temp.getNext();
        }
        return out;

    }

    // Returns the number of camels in the caravan.
    public int size() {

        //TODO: implement method.
        if (start == null) return 0;
        int out = 0;
        CamelNode temp = start;
        while (temp.getNext() != null){// temp -> last CamelNode
            temp = temp.getNext();
            out++;
        }
        out++;
        return out;
    }

    // Returns a string representation of this caravan with all its camels in brackets
    // in corresponding order with head of the caravan on the left,
    // followed by the pace of the caravan, which corresponds to the pace of
    // the slowest camel in the caravan.
    // Example: [(10-2=8), (5-2=3), (7-3=4), (10-3=7)] pace = 3
    // Returns "[]" if the caravan is empty.
    public String toString() {

        // TODO: implement method.
        if (start == null) return "[]";

        String out = "";
        int minPace = Integer.MAX_VALUE;
        CamelNode temp = start;
        while (temp.getNext() != null){
            out += temp.getCamel().toString() + ", ";
            if (temp.getCamel().getMaxPace() < minPace){
                minPace = temp.getCamel().getMaxPace();
            }
            temp = temp.getNext();
        }
        out += temp.getCamel().toString();
        if (temp.getCamel().getMaxPace() < minPace){
            minPace = temp.getCamel().getMaxPace();
        }
        return "[" + out + "] pace = " + minPace;
    }
}

class CamelNode {
    private Camel camel;
    private CamelNode next;

    public CamelNode(Camel camel){
        this.camel = camel;
        next = null;
    }

    public void setNext(CamelNode next) {
        this.next = next;
    }

    public CamelNode getNext() {
        return next;
    }

    public Camel getCamel() {
        return camel;
    }
}


// TODO: define further classes, if needed (either here or in a separate file).
