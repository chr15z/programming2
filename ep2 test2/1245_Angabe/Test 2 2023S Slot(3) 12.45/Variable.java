import java.util.*;

// Represents a variable.
// Each variable is uniquely identified by its instance. Two variables are considered equal only
// if they have the same identity (regardless of their name). (Different variables can
// have the same name. In order to avoid confusion, in 'PraxisTest2' all 'Variable' objects have
// different names.)
//
public class Variable {

    private final String name;
    // Initializes 'this' with its name.
    public Variable(String name) {
        this.name = name;
    }

    // Returns the name of this 'Variable'.
    public String getName() {
        return name;
    }

    @Override
    // Returns the name of this 'Variable'.
    public String toString() {
        return name;
    }


}
