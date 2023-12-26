// Iterable objects with 'StringOperationSingle' elements.
//
public interface OperationSingleIterable extends Iterable<StringOperationSingle> {

    @Override
    // Returns an iterator over elements of 'StringOperationSingle'.
    OperationSingleIterator iterator();

}
