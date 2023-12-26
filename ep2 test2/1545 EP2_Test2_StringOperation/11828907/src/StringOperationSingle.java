// A single basic operation, that can not be decomposed into components.
//
public interface StringOperationSingle extends StringOperation {

    // The iterator of this class iterates over only one element.
    // See examples in 'PraxisTest2.java'.
    OperationSingleIterator iterator();

    @Override
    // Returns 'true' only if 'this' and 'o' are equal. 'this' and 'o' are considered to
    // be equal if they are of the same class and have equal parameter values (for
    // the parameters specified to the constructor of this operation).
    boolean equals(Object o);
}
