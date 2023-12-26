import java.util.NoSuchElementException;
import java.util.Objects;

// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight of type 'int', that can not be changed after
// initialisation. 'Star' implements 'Decoration'.
//
public class Star implements Decoration // TODO: uncomment clause.
{

    //TODO: define missing parts of the class.
    private final int weight;

    public Star(int weight) {

        // TODO: implement constructor.
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    // Returns a readable representation of 'this' with the
    // symbol '*' followed by the weight of this star.
    public String toString() {

        // TODO: implement method.
        return "*"+weight;
    }

    @Override
    public Countable getStickCountable() {
        return new Countable() {
            @Override
            public int count() {
                return 0;
            }
        };
    }

    @Override
    public StarIterator iterator() {
        return new StarIterator() {
            boolean hasNext = true;
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Star next() {
                if (hasNext){
                    hasNext = false;
                    return Star.this;
                }
                else throw new NoSuchElementException("no star element!");
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return weight == star.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
