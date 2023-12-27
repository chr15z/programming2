import java.util.NoSuchElementException;
import java.util.Stack;

// Represents a succession of two operations. Each of which can be itself of type
// 'SafeOperationSequence' such that this class represents a recursive (tree-like)
// structure. The foundation (leafs of the tree) is represented by objects of
// 'SafeSingleOperation'.
public class SafeOperationSequence implements SafeOperation, SafeOperationIterable {

    //TODO: define missing parts of this class.
    private final SafeOperation first;
    private final SafeOperation second;

    public SafeOperationSequence(SafeOperation first, SafeOperation second) {

        //TODO: implement constructor.
        this.first = first;
        this.second = second;
    }

    @Override
    public RasterizedRGB execute(RasterizedRGB raster) throws OperationException {

        //TODO: implement method.
        return second.execute(first.execute(raster));
    }

    public SafeOperation getFirst() {

        //TODO: implement method.
        return first;
    }

    public SafeOperation getSecond() {

        //TODO: implement method.
        return second;
    }

    @Override
    public SafeOperationIterator iterator() {

        //TODO: implement method.
        return new MyOperationIterator(this);
    }

    @Override
    public String toString() {

        //TODO: implement method.
        return first + "\n" + second;
    }
}

//TODO: additional classes for the implementation of the iterator.
class MyOperationIterator implements SafeOperationIterator {

    private final Stack<SafeOperation> fringe = new Stack<>();

    public MyOperationIterator(SafeOperation root) {
        iter(root);
    }

    private void iter(SafeOperation root) {
        while (root instanceof SafeOperationSequence) {
            fringe.push(root);
            root = ((SafeOperationSequence) root).getFirst();
        }
        fringe.push(root);
    }

    @Override
    public boolean hasNext() {
        return !fringe.empty();
    }

    @Override
    public SafeOperationSingle next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        assert(fringe.peek() instanceof SafeOperationSingle);
        SafeOperationSingle node = (SafeOperationSingle) fringe.pop();

        if (!fringe.empty() && fringe.peek() instanceof SafeOperationSequence) {
            iter(((SafeOperationSequence)fringe.pop()).getSecond());
        }

        return node;
    }
}

