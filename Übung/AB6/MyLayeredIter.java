// Iterator class for LinkedListRasterRGBA
public class MyLayeredIter implements RasterizedRGBIterator {
    private Layered currentNode;

    public MyLayeredIter(Layered top) {
        currentNode = top;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public RasterizedRGB next() {
        if (!hasNext()) return null;
        Layered raster = currentNode.getForeground();
        currentNode = currentNode.getBackground();
        return raster;
    }
}