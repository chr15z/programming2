import java.awt.*;
import java.util.Scanner;

// A factory that creates a 'UnsafeFillOperation' object.
//
public class UnsafeFillFactory implements UnsafeFactory {

    // TODO: define missing parts of this class.
    private Color[] color;

    // TODO: add constructor specification.
    public UnsafeFillFactory(Color[] c) {

        // TODO: implement constructor.
        this.color = c;
    }

    // TODO: add method specification.
    // Returns a new 'UnsafeFillOperation' object. The starting point coordinates 'x' and 'y' of the
    // returned object are provided by the scanner object 'sc'.
    public UnsafeFillOperation create(Scanner sc) {

        // TODO: implement method.
        return new UnsafeFillOperation(new Point(sc.nextInt(), sc.nextInt()), color[0]);
    }
}
