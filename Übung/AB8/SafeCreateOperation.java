public class SafeCreateOperation implements SafeOperationSingle // TODO: activate clause.
{

    // TODO: define missing parts of this class.
    private final int width, height;

    public SafeCreateOperation(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public RasterizedRGB execute(RasterizedRGB raster) throws OperationException {
        return new TreeSparseRasterRGBA(width, height);
    }

    @Override
    public SafeOperation after(SafeOperation op) {
        return this;
    }

    @Override
    public String toString() {
        return "create " +width + " " + height;
    }
}
