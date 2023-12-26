import java.util.*;

// Represents a variable.
// Each variable is uniquely identified by its instance. Two variables are considered equal only
// if they have the same identity (regardless of their name). (Different variables can
// have the same name. In order to avoid confusion, in 'PraxisTest2' all 'Variable' objects have
// different names.)
//
public class Variable {

    // TODO: define missing parts of this class.
    private String name;

    // Initializes 'this' with its name.
    public Variable(String name) {

        // TODO: implement constructor.
        this.name = name;
    }

    // Returns the name of this 'Variable'.
    public String getName() {

        // TODO: implement method.
        return name;
    }

    @Override
    // Returns the name of this 'Variable'.
    public String toString() {

        // TODO: implement method.
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
