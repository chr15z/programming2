import java.awt.*;

// This class represents a line operation. More specifically, it allows to draw a line into
// a raster.
//
public class SafeLineOperation implements SafeOperationSingle // TODO: activate clause.
{

    // TODO: define missing parts of this class.
    private int x1, x2, y1, y2;
    private Color color;

    public SafeLineOperation(int x1, int y1, int x2, int y2, Color color) {

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public RasterizedRGB execute(RasterizedRGB raster) throws OperationException {

        int x1 = this.x1;
        int y1 = this.y1;
        int x2 = this.x2;
        int y2 = this.y2;

        if (raster == null || x1 < 0 || y1 < 0 || x1 >= raster.getWidth() || y1 >= raster.getHeight() ||
                x2 < 0 || y2 < 0 || x2 >= raster.getWidth() || y2 >= raster.getHeight()) {
            throw new OperationException("Illegal Arguments!");
        }
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (x1 != x2 || y1 != y2) {
            raster.setPixelColor(x1, y1, color);

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

        raster.setPixelColor(x1, y1, color);
        return raster;
    }

    @Override
    public String toString() {
        return "line " + x1 +
                " " + y1 +
                " " + x2 +
                " " + y2;
    }
}
