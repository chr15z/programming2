import java.util.NoSuchElementException;
import java.util.Objects;

// Leaf node of a 'BuildingBlock'. It represents a solid building block
// in which nothing can be inserted. 'Solid' implements 'BuildingBlock'.
//
public class Solid implements BuildingBlock // TODO: uncomment clause.
{

    private final int volume;

    // Initializes 'this' with the specified volume.
    // Precondition: volume > 0.
    public Solid(int volume) {

        this.volume = volume;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    // Returns 'true' if and only if 'o' is also of class 'Solid' and has the same volume.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solid boxes = (Solid) o;
        return volume == boxes.volume;
    }

    @Override
    //"#3"
    public String toString() {
        String result = "#" + volume;
        return result;
    }

    @Override
    public SolidSet getSolidSet() {
        return new SolidSet() {
            @Override
            public boolean contains(Solid element) {
                return Solid.this.equals(element);
            }
        };
    }

    @Override
    public BoxIterator iterator() {
        return new BoxIterator() {
            //private boolean hasNext = true;
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Box next() {
                throw new NoSuchElementException("no box element!");

            }
        };
    }
}

// TODO: define additional classes if needed (either here or in a separate file).
