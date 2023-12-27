import java.util.Scanner;

// A factory that creates an 'SafeCreateOperation' object.
//
public class SafeCreateFactory implements SafeFactory // TODO: activate clause.
{

    // TODO: define missing parts of this class.
    public SafeOperation create(Scanner sc) throws FactoryException {
        if (!sc.hasNextInt()) {
            throw new FactoryException("Missing argument!");
        }
        int width = sc.nextInt();
        if (!sc.hasNextInt()) {
            throw new FactoryException("Missing argument!");
        }
        int height = sc.nextInt();
        return new SafeCreateOperation(width, height);
    }
}
