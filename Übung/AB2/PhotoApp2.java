import codedraw.CodeDraw;

import java.awt.*;

public class PhotoApp2 {

    public static void main(String[] args) {

        // TODO: change this method according to 'Aufgabenblatt2.md'.
        SimpleSparseRasterRGB raster = new SimpleSparseRasterRGB(100, 100);
        raster.drawLine(50, 20, 70, 80, Color.PINK);
        raster.drawLine(70, 80, 30, 80, Color.YELLOW);
        raster.drawLine(50, 20, 30, 80, Color.GREEN);

        draw(raster);
        raster.floodFill(50, 50, Color.RED);
        draw(raster);
        raster = raster.convolve(new double[][]{{0.11, 0.11, 0.11}, {0.11, 0.11, 0.11}, {0.11, 0.11, 0.11}});
        draw(raster);
        raster.floodFill(50, 50, Color.BLACK);
        draw(raster);

    }

    // Draws the image (specified by a sparse raster) with fixed pixel size in a new window.
    // Precondition: raster != null.
    public static void draw(SimpleSparseRasterRGB raster) {

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
