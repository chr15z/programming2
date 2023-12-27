import codedraw.CodeDraw;
import java.awt.*;

public class PhotoApp1 {

    public static void main(String[] args) {

        SimpleRasterRGB raster = new SimpleRasterRGB(40, 60);

        raster.drawLine(0, 1, 35, 9, new Color(20, 25, 250));
        raster.drawLine(30, 5, 0, 30, Color.ORANGE);
        raster.drawLine(2, 0, 7, 40, Color.GREEN);
        draw(raster);

        raster = raster.convolve(new double[][]{
                {0.077847, 0.123317, 0.077847},
                {0.123317, 0.195346, 0.123317},
                {0.077847, 0.123317, 0.077847}
        });
        draw(raster);

    }

    // Draws the image with fixed pixel size in a new window.
    public static void draw(SimpleRasterRGB raster) {

        int cellSize = 10;
        CodeDraw cd = new CodeDraw(raster.getWidth() * cellSize, raster.getHeight() * cellSize);

        // draw a square of size 'cellSize' for each pixel
        for (int j = 0; j < raster.getHeight(); j++) {
            for (int i = 0; i < raster.getWidth(); i++) {
                int x = i * cellSize;
                int y = j * cellSize;
                cd.setColor(raster.getPixelColor(i, j));
                cd.fillSquare(x, y, cellSize);
            }
        }
        cd.show();
    }
}
