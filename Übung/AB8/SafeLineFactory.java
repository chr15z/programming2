import java.awt.*;
import java.util.Scanner;

// A factory that creates an 'SafeLineOperation' object.
//
public class SafeLineFactory implements SafeFactory // TODO: activate clause.
{

    // TODO: define missing parts of this class.
    private Color[] color;

    public SafeLineFactory(Color[] color) {

        this.color = color;
    }

    @Override
    public SafeOperation create(Scanner sc) throws FactoryException {

        int x1, y1, x2, y2;
        if (!sc.hasNextInt()) {
            throw new FactoryException("Missing argument!");
        }
        x1 = sc.nextInt();
        if (!sc.hasNextInt()) {
            throw new FactoryException("Missing argument!");
        }
        y1 = sc.nextInt();
        if (!sc.hasNextInt()) {
            throw new FactoryException("Missing argument!");
        }
        x2 = sc.nextInt();
        if (!sc.hasNextInt()) {
            throw new FactoryException("Missing argument!");
        }
        y2 = sc.nextInt();
        return new SafeLineOperation(x1,y1,x2,y2,this.color[0]);
    }
}
