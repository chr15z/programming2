import java.util.NoSuchElementException;
import java.util.Objects;

// Leaf node of a mobile. The actual decoration of a mobile.
// A 'Star' has a specified weight, that can not be changed after
// initialisation. 'Star' implements 'Decoration'.
//
public class Star implements Decoration //TODO: activate clause.
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

    @Override
    // Returns a readable representation of 'this' with the
    // symbol '*' followed by the weight of this star.
    public String toString() {

        // TODO: implement method.
        return "*"+weight;
    }

    @Override
    public StarCollection getStarCollection() {
        return new StarCollection() {
            @Override
            public boolean contains(Star s) {
                return Star.this.equals(s);
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
                throw new NoSuchElementException("no star element!");
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
