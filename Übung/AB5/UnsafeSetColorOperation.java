import java.awt.*;

public class UnsafeSetColorOperation implements UnsafeOperation {
    private Color[] colorRef;
    private Color newColor;

    //Initializes 'this' with the specified colorRef and newColor
    public UnsafeSetColorOperation(Color[] colorRef, Color newColor) {
        this.colorRef = colorRef;
        this.newColor = newColor;
    }

    @Override
    //Executes the color change, i.e. the element at index 0 of the color array is set to the new color.
    //'raster' is not changed by this method call.
    public RasterizedRGB execute(RasterizedRGB raster) {
        colorRef[0] = newColor;
        return raster;
    }
}
