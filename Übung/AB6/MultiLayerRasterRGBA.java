import java.awt.*;
import java.util.ArrayList;

// Represents a raster consisting of at least two layers.
//
public class MultiLayerRasterRGBA implements Layered //TODO: activate clause.
{

    // TODO: define missing parts of this class.
    private final Layered background;
    private final SingleLayer foreground;

    // Initializes 'this' with top-layer 'foreground' and 'background'.
    // Performs dynamic type checking of 'background'. If 'background' is an instance of 'Layered'
    // this constructor initializes 'this' with top-layer 'foreground' and layers of the
    // 'background'.
    // If 'background' is not an instance of 'Layered', 'background' is copied to a new object of
    // 'SingleLayer' which is then used to initialize the background.
    // Width and height of this raster is determined by width and height of the 'foreground'
    // raster.
    // Pixels that are not defined in the 'background' are assumed to have color (0,0,0,0).
    public MultiLayerRasterRGBA(SingleLayer foreground, RasterizedRGB background) {

        // TODO: implement constructor.
        this.foreground = foreground;
        if (background instanceof Layered) {
            this.background = (Layered) background;
        } else {
            this.background = new TreeSparseRasterRGBA(background.getWidth(),
                    background.getHeight());
            background.copyTo(this.background);
        }
    }

    @Override
    public int getWidth() {

        // TODO: implement method.
        return foreground.getWidth();
    }

    @Override
    public int getHeight() {

        // TODO: implement method.
        return foreground.getHeight();
    }

    @Override
    public Color getPixelColor(int x, int y) {

        // TODO: implement method.
        return RasterRGBA.over(foreground.getPixelColor(x,y),background.getPixelColor(x, y));
    }

    @Override
    public void setPixelColor(int x, int y, Color color) {

        foreground.setPixelColor(x, y, color);
    }

    @Override
    public void convolve(double[][] filterKernel) {

        foreground.convolve(filterKernel);
    }



    @Override
    public void crop(int width, int height) {

        foreground.crop(width, height);
        background.crop(width, height);
    }

    @Override
    public SingleLayer getForeground() {
        return foreground;
    }

    public Layered getBackground() {
        return background;
    }

    @Override
    public RasterizedRGBIterator iterator() {
        return new MyLayeredIter(this);
    }

    @Override
    public Layered newLayer() {
        return new MultiLayerRasterRGBA(new TreeSparseRasterRGBA(getWidth(), getHeight()), this);
    }

    @Override
    public int numberOfLayers() {
        return background.numberOfLayers() + foreground.numberOfLayers();
    }

}
