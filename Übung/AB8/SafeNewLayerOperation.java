public class SafeNewLayerOperation implements SafeOperationSingle // TODO: activate clause.
{

    // TODO: define missing parts of this class.
    @Override
    public RasterizedRGB execute(RasterizedRGB raster) throws OperationException {

        return new MultiLayerRasterRGBA(new TreeSparseRasterRGBA(raster.getWidth(),
                raster.getHeight()), raster);
    }

    @Override
    public String toString() {
        return "newlayer";
    }
}
