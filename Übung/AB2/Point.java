// A class for representing points with integer coordinates in 2D.
public class Point {
    private final int x, y;

    // Initializes this point with its coordinates.
    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    // Returns the x-coordinate of this point.
    public int getX() {

        return x;
    }

    // Returns the y-coordinate of this point.
    public int getY() {

        return y;
    }

    // Compares this point with a specified point. Defines an order relation ("less-than"
    // relation) on objects of 'Point'. Returns 0 if and only if the two coordinates of 'this'
    // and 'p' are equal. Returns -1 if 'this' is less than 'p' or 1 otherwise.
    // Precondition: p != null
    public int compareTo(Point p) {

        // TODO: implement method.
        if (this.x < p.x) return -1;
        if (this.x > p.x) return 1;
        if (this.y < p.y) return -1;
        if (this.y > p.y) return 1;
        return 0;
    }
}
