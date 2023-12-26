// Building blocks are part of a building kit. Some building blocks are boxes such that
// further building blocks can be inserted to create recursive structures in the form of a tree.
// Another type of building block is solid. Nothing can be inserted into solid blocks. Solid blocks
// are the leaf nodes of the tree.
//
// Please, do not change this interface definition!
//
public interface BuildingBlock extends BoxIterable {

    // Returns a readable representation of the building block showing its nested structure.
    // Boxes are represented by brackets, solid blocks are represented by '#'. The representation
    // also includes the volumes of each component as a suffix.
    // For example, if the building block is solid with volume 3 the
    // representation is "#3". An empty box with volume 2 is represented as "[]2". A box with
    // volume 5 and two solid blocks in it is represented as in this example: "[#3, #1]5".
    // A box with two solid blocks and a box in it, where the
    // nested box has volume 10 and three solid blocks in it, is represented as in this example:
    // "[#3, #1, [#2, #5, #3]10]15".
    String toString();

    // Returns the volume of this building block.
    int getVolume();

    // Returns 'true' if 'this' and 'o' are equal.
    boolean equals(Object o);

    // Returns the hash code of 'this'.
    int hashCode();

    // Returns a 'SolidSet' view of 'this'. For example, for the building block
    // [#3, #1, [#2, #5, #3]10]15 the set contains the elements #3, #1, #2, #5
    // (two occurrences of #3 are equal).
    // Later changes in 'this' will be reflected in the returned view.
    SolidSet getSolidSet();

    // Returns an iterator over all 'Box' objects of 'this' (including the element 'this').
    // For example, the box "[#1, #2, [#2, #5, #3]10, []1]15" returns an iterator
    // over the following 3 boxes:
    //
    // [#1, #2, [#2, #5, #3]10, []1]15
    // [#2, #5, #3]10
    // []1
    //
    // The order is not specified.
    BoxIterator iterator();
}
