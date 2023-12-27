import java.io.*;
import java.util.Scanner;

public class SafeSaveFactory implements SafeFactory {

    private final SafeOperation[] operations;

    public SafeSaveFactory(SafeOperation[] operations) {
        this.operations = operations;
    }

    @Override
    public SafeOperation create(Scanner sc) throws FactoryException {
        if (!sc.hasNext()) {
            throw new FactoryException("Missing filename!");
        }

        try {
            Writer r = new FileWriter(sc.next());
            BufferedWriter out = new BufferedWriter(r);
            out.write(operations[0].toString());
            out.close();
        } catch (IOException ex) {
            throw new FactoryException("File could not be saved!");
        }

        return SafeDoNothing.DO_NOTHING;
    }
}
