import java.awt.*;

// This class represents a sparse 2D raster of RGB color entries. It has the same functionality
// as the class 'SimpleRasterRGB', but its implementation differs. It additionally has a
// flood-fill method.
//
// This class is efficient for representing images where only a small fraction of pixels is
// non-empty, meaning they have a color different from (0,0,0) corresponding to Color.BLACK.
// The class uses internally an object of 'SimplePointColorMap' to associate each non-empty
// pixel position (x,y) to the corresponding color. Only pixels with non-zero values are stored.
// Positions that are not in the set of keys of the map are considered to have value (0,0,0).
//
public class SimpleSparseRasterRGB {

    private int width;
    private int height;
    private SimplePointColorMap map;

    // Initialises this raster of the specified size as an empty
    // raster (all pixels being black, i.e. (R,G,B) = (0,0,0)).
    // Preconditions: height > 0, width > 0
    public SimpleSparseRasterRGB(int width, int height) {

        // TODO: implement constructor.
        this.width = width;
        this.height = height;
        map = new SimplePointColorMap(width * height / 10);
    }

    // Returns the color of the specified pixel.
    // Preconditions: (x,y) is a valid coordinate of the raster
    public Color getPixelColor(int x, int y) {

        // TODO: implement method.
        Color c = map.get(new Point(x, y));
        if (c != null) {
            return c;
        }
        return new Color(0, 0, 0);
    }

    // Sets the color of the specified pixel. (If 'color' is 'Color.BLACK', the method
    // ensures that the pixel is not contained in the internal map.)
    // Preconditions: (x,y) is a valid coordinate of the raster, color != null
    public void setPixelColor(int x, int y, Color color) {

        // TODO: implement method.
        if (!color.equals(Color.BLACK)) {
            map.put(new Point(x, y), color);
        } else {
            map.remove(new Point(x, y));
        }
    }

    // Returns the result of convolution of 'this' with the specified filter kernel. 'this' is not
    // changed by the method call.
    // The implementation of this method exploits the sparse structure of the raster by
    // calculating the convolution only at non-empty pixel positions.
    // Preconditions:
    // filterKernel != null && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[i].length (for valid i) &&
    // filterKernel.length < this.getWidth() &&
    // filterKernel.length < this.getHeight().
    public SimpleSparseRasterRGB convolve(double[][] filterKernel) {

        // TODO: implement method.
        int filterSideLength = filterKernel.length / 2;
        SimpleSparseRasterRGB resultRaster = new SimpleSparseRasterRGB(this.width, this.height);

        //get all non-black pixel coordinates and the neighborhood to a new ColorMap
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
            double redComponent = 0, greenComponent = 0, blueComponent = 0;
            for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {
                    redComponent += this.getPixelColor(x - xx, y - yy).getRed() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    greenComponent += this.getPixelColor(x - xx, y - yy).getGreen() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    blueComponent += this.getPixelColor(x - xx, y - yy).getBlue() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                }
            }
            resultRaster.setPixelColor(x, y, new Color((int) redComponent, (int) greenComponent, (int) blueComponent));
        }
        return resultRaster;
    }


    // ALTERNATIVE IMPLEMENTATION
    /*
    public SimpleSparseRasterRGB convolve(double[][] filterKernel) {

        SimpleSparseRasterRGB result = new SimpleSparseRasterRGB(this.width, this.height);

        int filterSideLength = filterKernel.length / 2;
        SimplePointQueue changingPixels = this.map.keys();

        // loop only through relevant positions
        while (changingPixels.size() > 0) {
            Point centerPoint = changingPixels.poll();

            //at every , compute filter result
            double redComponent = 0, greenComponent = 0, blueComponent = 0;
            for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {
                    Point neighbor = new Point(centerPoint.getX() + xx, centerPoint.getY() + yy);

                    redComponent += this.getPixelColor(neighbor.getX(), neighbor.getY()).getRed() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    greenComponent += this.getPixelColor(neighbor.getX(), neighbor.getY()).getGreen() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    blueComponent += this.getPixelColor(neighbor.getX(), neighbor.getY()).getBlue() * filterKernel[xx + filterSideLength][yy + filterSideLength];

                    // update relevant positions: include all neighbors in the kernel region of
                    // non-black points while avoiding duplicate entries. Only neighbor
                    // points with color (0,0,0) need to be considered (others are already in the
                    // queue).
                    if (neighbor.compareTo(centerPoint) != 0 && Color.BLACK.equals(this.getPixelColor(neighbor.getX(), neighbor.getY()))) {
                        boolean found = false;

                        for (int j = 0; j < changingPixels.size(); j++) {

                            Point p = changingPixels.poll();
                            if (neighbor.compareTo(p) == 0) {
                                found = true;
                            }
                            changingPixels.add(p);
                        }

                        if (!found && !Color.BLACK.equals(this.getPixelColor(centerPoint.getX(),
                                centerPoint.getY()))) {
                            changingPixels.add(neighbor);
                        }
                    }
                }
            }

            result.setPixelColor(centerPoint.getX(), centerPoint.getY(), new Color((int) redComponent,
                    (int) greenComponent,
                    (int) blueComponent));

        }

        return result;

    }
    */

    // Returns the width of this raster.
    public int getWidth() {

        // TODO: implement method.
        return width;
    }

    // Returns the height of this raster.
    public int getHeight() {

        // TODO: implement method.
        return height;
    }

    // Sets the area of contiguous pixels of the same color to the specified color 'color', starting from
    // the initial pixel with position (x,y) and using 4-neighborhood. The method is not
    // recursive, instead it internally uses an object of 'SimplePointQueue' to which unprocessed
    // neighboring positions of the current position are added (the queue stores positions
    // that are still waiting to be processed).
    // 'floodFill' does nothing if the pixel at position (x,y) already has color 'color'.
    // Preconditions: (x,y) are valid coordinates of the raster, color != null.
    public void floodFill(int x, int y, Color color) {

        // TODO: implement method.
        if (!this.getPixelColor(x, y).equals(color)) {
            SimplePointQueue queue = new SimplePointQueue(10);
            queue.add(new Point(x, y));
            Color oldColor = this.getPixelColor(x, y);
            while (queue.size() > 0) {
                Point p = queue.poll();
                x = p.getX();
                y = p.getY();
                if (this.getPixelColor(x, y).equals(oldColor)) {
                    this.setPixelColor(x, y, color);
                    if (x < width - 1 && this.getPixelColor(x + 1, y).equals(oldColor)) queue.add(new Point(x + 1, y));
                    if (x > 0 && this.getPixelColor(x - 1, y).equals(oldColor)) queue.add(new Point(x - 1, y));
                    if (y < height - 1 && this.getPixelColor(x, y + 1).equals(oldColor))
                        queue.add(new Point(x, y + 1));
                    if (y > 0 && this.getPixelColor(x, y - 1).equals(oldColor)) queue.add(new Point(x, y - 1));
                }
            }
        }
    }

    // Draws a line from (x1,y1) to (x2,y2) in the raster using the Bresenham algorithm.
    // Preconditions:
    // (x1,y1) and (x2,y2) are valid coordinates of the raster, color != null.
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {

        // TODO: implement method.
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (x1 != x2 || y1 != y2) {
            this.setPixelColor(x1, y1, color);

            int err2 = 2 * err;
            if (err2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (err2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
        this.setPixelColor(x1, y1, color);
    }
}
