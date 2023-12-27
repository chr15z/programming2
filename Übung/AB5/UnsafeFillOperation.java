import java.awt.*;

// This class represents a flood fill operation. More specifically, it allows to set the area of
// contiguous pixels of the same color to a specified color, starting from an initial position and
// using 4-neighborhood.
//
public class UnsafeFillOperation implements UnsafeOperation {

    // TODO: define missing parts of this class.
    private Point start;
    private Color color;

    public UnsafeFillOperation(Point start, Color color) {
        this.start = start;
        this.color = color;
    }

    public Point getStart() {
        return start;
    }

    public Color getColor() {
        return color;
    }

    // TODO: add method specification.
    // Sets the area of contiguous pixels of the same color to the specified color 'getColor()', starting from
    // the initial pixel with position (getStart().getX(), getStart().getY()) and using 4-neighborhood.
    // The method does nothing if the pixel at the start position already has color 'getColor()'.
    // Preconditions: (getStart().getX(), getStart().getY()) are valid coordinates of the raster, getColor() != null.
    public RasterizedRGB execute(RasterizedRGB raster) {

        // TODO: implement method.
        int x = start.getX();
        int y = start.getY();
        if (!raster.getPixelColor(x, y).equals(color)) {
            SimplePointQueue queue = new SimplePointQueue(10);
            queue.add(new Point(x, y));
            Color oldColor = raster.getPixelColor(x, y);
            while (queue.size() > 0) {
                Point p = queue.poll();
                x = p.getX();
                y = p.getY();
                if (raster.getPixelColor(x, y).equals(oldColor)) {
                    raster.setPixelColor(x, y, color);
                    if (x < raster.getWidth() - 1 && raster.getPixelColor(x + 1, y).equals(oldColor)) queue.add(new Point(x + 1, y));
                    if (x > 0 && raster.getPixelColor(x - 1, y).equals(oldColor)) queue.add(new Point(x - 1, y));
                    if (y < raster.getHeight() - 1 && raster.getPixelColor(x, y + 1).equals(oldColor))
                        queue.add(new Point(x, y + 1));
                    if (y > 0 && raster.getPixelColor(x, y - 1).equals(oldColor)) queue.add(new Point(x, y - 1));
                }
            }
        }
        return raster;
    }
}
