// An exception indicating the existence of two variables with the same
// name but different identities.
// The message of this exception is "different variables with same name 'x'!"
// where x is to be replaced with the same name of the different variables.
//
public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException(String s) {
        super(s);
    }

    //TODO: define missing parts of this class, as needed.
}
