import java.util.*;

// A 'Box' is a hollow building block such that further building blocks
// can be placed in the box. Because 'Box' implements 'BuildingBlock' and
// 'BuildingBlock' objects can be inserted, we naturally get tree-like structures, where 'Box'
// objects can have multiple child nodes and objects of 'Solid' form the leafs of the tree. The
// implementation of this class can, but need not be based on a tree structure.
//
public class Box implements BuildingBlock // TODO: uncomment clause.
{

    private final int space;
    private ArrayList<BuildingBlock> list;

    // Initialises this box as an empty box with the specified volume.
    // Precondition: volume > 0.
    public Box(int volume) {
        list = new ArrayList<>();
        this.space = volume;
    }

    // Inserts the specified 'block' into 'this' box if there is an empty space anywhere in this
    // box or its nested boxes (recursively) where the block must fit as a whole.
    // ("Empty space" refers to the volume of 'this' minus the sum of volumes of direct child nodes
    // of 'this').
    // If several boxes within 'this' have an empty space large enough for the block, it is
    // unspecified which box the block will be stored in. The method returns 'true' if and only if
    // 'block' was inserted by the method call.
    //
    // Several objects of type 'Solid' within boxes can be identical,
    // for example, after the command box1.insert(s); box1.insert(s); 's' occurs twice in 'box1'.
    //
    // Objects of type 'Box' within boxes can be equal but must not be identical.
    // The method throws an 'IdenticalBoxException' if the box iterator of 'this' iterates over
    // at least one element identical with an element over which also the iterator of 'block'
    // iterates.
    //
    // For example, the commands
    // box1.insert(box1);
    // or
    // box1.insert(box2); box2.insert(box1);
    // or
    // box1.insert(box2); box1.insert(box2);
    // will throw the 'IdenticalBoxException'.
    //
    // No exception is thrown if 'block' does not fit into 'this' anyway.
    // Precondition: block != null.
    public boolean insert(BuildingBlock block) throws IdenticalBoxException {
        if (block.getVolume() < space - getSpace()){
            list.add(block);
            return true;
        }
        for (BuildingBlock b: list){
            if (b.getClass() == Box.class){
                Box temp = (Box) b;
                if (block.equals(b)) throw new IdenticalBoxException();
                if (block.getVolume() < temp.space - temp.getSpace())  {
                    temp.insert(block);
                }
            }


        }

        return false;

    }
    public int getSpace(){
        // ("Empty space" refers to the volume of 'this' minus the sum of volumes of direct child nodes
        // of 'this').
        int childVolume = 0;
        for(BuildingBlock b: list){
            childVolume += b.getVolume();
        }
        return childVolume;
    }

    @Override
    public int getVolume() {
        return space;
    }

    @Override
    // Returns 'true' if and only if
    // - 'o' is also of class 'Box',
    // - 'o' has the same volume as 'this' and
    // - for each direct child node 'n' in 'this' and 'o':
    //      in 'this' and 'o' the number of direct child nodes equal to 'n' is the same.
    // For example, [#7, #3, [#2, #5, #3, #3]15]30 and [#3, [#3, #3, #2, #5]15, #7]30 are equal,
    // but [#7, [#2]15]30 and [#2, [#7]15]30 are not equal.
    // Also, [#1, #2, #2] and [#1, #1, #2] are not equal.
    // Otherwise, 'false' is returned.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        if (box.getVolume() != this.getVolume()) return false;
        for(BuildingBlock b: list){
            int counter = 0;
            for (BuildingBlock bl: list){
                if (bl.equals(b)) counter++;
            }
            for (BuildingBlock bl: box.list){
                if (bl.equals(b)) counter--;
            }
            if (counter != 0) return false;
        }
        return true;
    }


    @Override
    public SolidSet getSolidSet() {
        return new SolidSet() {
            @Override
            public boolean contains(Solid element) {
                for (BuildingBlock b: list){
                    if (b.getSolidSet().contains(element)){
                        return true;
                    }
                }
                return false;
            }
        };
    }

    @Override
    public BoxIterator iterator() {
        ArrayList<BoxIterator> iters = new ArrayList<>();
        for(BuildingBlock b: list){
            if (b.getClass()== Box.class){
                Box temp = (Box) b;
                iters.add(b.iterator());
            }
        }
        return new BoxIterator() {
            private boolean hasNext = true;
            @Override
            public boolean hasNext() {
                for(BoxIterator b: iters){
                    if (b.hasNext())return true;
                }
                return hasNext;
            }

            @Override
            public Box next() {
                for(BoxIterator b: iters){
                    if (b.hasNext()) return b.next();
                }
                if (!hasNext) throw new NoSuchElementException("no box element!");
                else{
                    hasNext = false;
                    return Box.this;
                }

            }
        };
    }

    @Override
    // Returns a readable representation of the building block showing its nested structure.
    // Boxes are represented by brackets, solid blocks are represented by '#'. The representation
    // also includes the volumes of each component as a suffix.
    // For example, if the building block is solid with volume 3 the
    // representation is "#3". An empty box with volume 2 is represented as "[]2". A box with
    // volume 5 and two solid blocks in it is represented as in this example: "[#3, #1]5".
    // A box with two solid blocks and a box in it, where the
    // nested box has volume 10 and three solid blocks in it, is represented as in this example:
    // "[#3, #1, [#2, #5, #3]10]15".
    public String toString() {
        String result = "";
        for (BuildingBlock b: list){
            result += b.toString() + ", ";
        }
        if (result.length() > 2){
           result = result.substring(0, result.length() - 2);
        }
        return "[" + result + "]"+getVolume();
    }


}

// TODO: define additional classes if needed (either here or in a separate file).