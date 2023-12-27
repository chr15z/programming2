import java.awt.*;

// This class represents a sparse 2D raster of RGB color entries.
//
// This class is efficient for representing images where only a small fraction of pixels is
// non-empty, meaning they have a color different from (0,0,0) corresponding to Color.BLACK.
// The class uses internally an object of 'HashPointColorMap' to associate each non-empty
// pixel position (x,y) to the corresponding color. Only pixels with non-zero values are stored.
// Positions that are not in the set of keys of the map are considered to have value (0,0,0).
//
public class HashSparseRasterRGB implements RasterizedRGB {

    // TODO: declare variables.
    private int width;
    private int height;
    private HashPointColorMap map;

    // Initialises this raster of the specified size as an empty
    // raster (all pixels being black, i.e. (R,G,B) = (0,0,0)).
    // Preconditions: height > 0, width > 0
    public HashSparseRasterRGB(int width, int height) {

        // TODO: implement constructor.
        this.width = width;
        this.height = height;
        map = new HashPointColorMap();
    }

    // Returns the color of the specified pixel.
    // Preconditions: (x,y) is a valid coordinate of the raster
    public Color getPixelColor(int x, int y) {

        // TODO: implement method.
        Color c = map.get(new Point(x, y));
        if (c != null) return c;
        return new Color(0, 0, 0);
    }

    // Sets the color of the specified pixel. (If 'color' is 'Color.BLACK', the method
    // ensures that the pixel is not contained in the internal map.)
    // Preconditions: (x,y) is a valid coordinate of the raster, color != null
    public void setPixelColor(int x, int y, Color color) {

        // TODO: implement method.
        if (!color.equals(Color.BLACK)) map.put(new Point(x, y), color);
        else map.remove(new Point(x, y));
    }

    // Returns the width of this raster.
    public int getWidth() {

        // TODO: implement method.
        return this.width;
    }

    // Returns the height of this raster.
    public int getHeight() {

        // TODO: implement method.
        return this.height;
    }

    // Performs the convolution of 'this' with the specified filter kernel. 'this' is the result of
    // the operation.
    // The implementation of this method exploits the sparse structure of the raster by
    // calculating the convolution only at non-empty pixel positions.
    // Preconditions:
    // filterKernel != null && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[i].length (for valid i) &&
    // filterKernel.length < this.getWidth() &&
    // filterKernel.length < this.getHeight().
    public void convolve(double[][] filterKernel) {

        // TODO: implement method.
        double[] temp_result;
        int filterSideLength = filterKernel.length / 2;
        HashSparseRasterRGB resultRaster = new HashSparseRasterRGB(this.width, this.height);

        //put all non-black pixel coordinates and the neighborhood to a new ColorMap
        SimplePointQueue nonEmptyPoints = map.keys();
        SimplePointColorMap computablePoints = new SimplePointColorMap(10);
        while (nonEmptyPoints.size() > 0 ) {
            Point p = nonEmptyPoints.poll();
            int x = p.getX();
            int y = p.getY();
            for (int i = x - filterSideLength; i <= x + filterSideLength ; i++) {
                for (int j = y - filterSideLength; j <= y  + filterSideLength ; j++) {
                    computablePoints.put(new Point(i, j), this.getPixelColor(i, j));
                }

            }
        }

        //process all points of the ColorMap to compute convolution result only for required pixels
        SimplePointQueue points = computablePoints.keys();
        while (points.size() > 0 ) {
            //at every position, compute filter result
            Point p = points.poll();
            int x = p.getX();
            int y = p.getY();
            temp_result = new double[3];
            for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {
                    temp_result[0] += this.getPixelColor(x - xx, y - yy).getRed() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    temp_result[1] += this.getPixelColor(x - xx, y - yy).getGreen() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    temp_result[2] += this.getPixelColor(x - xx, y - yy).getBlue() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                }
            }
            resultRaster.setPixelColor(x, y, new Color((int) temp_result[0], (int) temp_result[1], (int) temp_result[2]));
        }
        this.map = resultRaster.map;
    }

    // Crops 'this' to the rectangular region with upper left coordinates (0,0)
    // and lower right coordinates (width-1, height-1).
    // Precondition: width <= this.getWidth() && height <= this.getHeight().
    public void crop(int width, int height) {

        // TODO: implement method.
        for (int x = width; x < this.width; x++) {
            for (int y = height; y < this.height; y++) {
                map.remove(new Point(x, y));
            }

        }
        this.width = width;
        this.height = height;
    }
}
