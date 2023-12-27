// Iterator class for LinkedListRasterRGBA
class MyLinkedListIter implements RasterizedRGBIterator {
    private MyDoubleListNode currentNode;

    public MyLinkedListIter(MyDoubleListNode tail) {
        currentNode = tail;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public RasterizedRGB next() {
        if (!hasNext()) {
            return null;
        }
        RasterizedRGB raster = currentNode.getRaster();
        currentNode = currentNode.getPrev();
        return raster;
    }
}