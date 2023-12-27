import java.awt.*;
import java.util.Scanner;

// A factory that creates a 'UnsafeConvolveOperation' object.
public class UnsafeSetColorFactory implements UnsafeFactory {

    private final Color[] colorRef;

    // Initialises 'this' with the specified color.
    //Precondition: color != null
    public UnsafeSetColorFactory(Color[] colorRef) {

        this.colorRef = colorRef;
    }

    // Returns a new 'UnsafeSetColorOperation'. The RGB values of the
    // returned setcolor operation are provided by the scanner object 'sc'.
    @Override
    public UnsafeOperation create(Scanner sc) {

        return new UnsafeSetColorOperation(colorRef, new Color(sc.nextInt(), sc.nextInt(),
                sc.nextInt(), sc.nextInt())); // since AB6 4 components
    }
}
