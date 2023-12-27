// The reversed iterator of AB8.
//
public class MyLayeredRevIter implements RasterizedRGBIterator {

    private MyLayeredRevIter next;
    private Layered node;

    public MyLayeredRevIter() {

    }

    public MyLayeredRevIter(MyLayeredRevIter prev, Layered node) {
        this.node = prev.node; prev.node = node;
        this.next = prev.next; prev.next = this;
    }

    @Override
    public RasterizedRGB next() {
        RasterizedRGB result = this.node.getForeground();
        if (this.node != null) {
            this.node = next.node;
            this.next = next.next;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return this.node != null;
    }
}
