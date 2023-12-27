public class SimplePointQueue {

    //TODO: declare variables.
    private Point[] queue;
    private int head, tail;

    // Initializes this queue with an initial capacity (length of internal array).
    // Precondition: initialCapacity > 0.
    public SimplePointQueue(int initialCapacity) {

        //TODO: define constructor.
        queue = new Point[initialCapacity];
    }

    // Adds the specified point 'p' to this queue.
    // Precondition: p != null.
    public void add(Point p) {

        //TODO: implement method.
        queue[tail] = p;
        tail = (tail + 1) % queue.length;
        if (tail == head) doubleCapacity();
    }

    //Precondition: head == tail;
    private void doubleCapacity() {

        //TODO: implement method.
        Point[] newQueue = new Point[queue.length * 2];
        //copy sequence until head to beginning of new array
        System.arraycopy(queue, 0, newQueue, 0, head);
        //change head and copy sequence after head to end of new array
        head += queue.length;
        System.arraycopy(queue, head - queue.length, newQueue, head, queue.length - (head - queue.length));
        queue = newQueue;
    }

    // Retrieves and removes the head of this queue, or returns 'null'
    // if this queue is empty.
    public Point poll() {

        //TODO: implement method.
        Point toReturn = queue[head];
        queue[head] = null;
        if (head != tail) {
            head = (head + 1) % queue.length;
        }
        return toReturn;
    }

    // Retrieves, but does not remove the head of this queue, or returns 'null'
    // if this queue is empty.
    public Point peek() {

        //TODO: implement method.
        return queue[head];
    }

    // Returns the number of entries in this queue.
    public int size() {

        //TODO: implement method.
        if (head <= tail) {
            return (tail - head);
        }
        return (queue.length - head) + tail;
    }
}
