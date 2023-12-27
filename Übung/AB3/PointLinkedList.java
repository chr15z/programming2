// A list of 2D-points (objects of type 'Point') implemented as a linked list.
// The number of elements of the list is not limited.
//
// TODO: define further classes and methods for the implementation of the linked list,
//  if needed.
//
public class PointLinkedList {

    //TODO: declare variables.
    private MyListNode head, tail;
    private int size = 0;

    // Initializes 'this' as an empty list.
    public PointLinkedList() {

        //TODO: define constructor.
    }

    // Inserts the specified element 'point' at the beginning of this list.
    // Precondition: point != null.
    public void addFirst(Point point) {

        if (head == null) {
            head = tail = new MyListNode(point, null);
        } else {
            head = new MyListNode(point, head);
        }
        size++;
    }

    // Appends the specified element 'point' to the end of this list.
    // Precondition: point != null.
    public void addLast(Point point) {

        //TODO: implement method.
        if (head == null) {
            head = tail = new MyListNode(point, null);
        } else {
            MyListNode newNode = new MyListNode(point, null);
            MyListNode oldTail = tail;
            oldTail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    // Returns the last element in this list.
    // Returns 'null' if the list is empty.
    public Point getLast() {

        //TODO: implement method.
        if (size == 0) {
            return null;
        }
        return tail.getPoint();
    }

    // Returns the first element in this list.
    // Returns 'null' if the list is empty.
    public Point getFirst() {

        //TODO: implement method.
        if (size == 0) {
            return null;
        }
        return head.getPoint();
    }

    // Retrieves and removes the first element in this list.
    // Returns 'null' if the list is empty.
    public Point pollFirst() {

        //TODO: implement method.
        if (size == 0) {
            return null;
        }
        Point toReturn = head.getPoint();
        head = head.getNext();
        if (size-- <= 2) { //special case: list has 0 or 1 elements after poll
            tail = head;
        }
        return toReturn;
    }

    // Retrieves and removes the last element in this list.
    // Returns 'null' if the list is empty.
    public Point pollLast() {

        //TODO: implement method.
        if (size <= 1) {
            return pollFirst();
        }
        Point toReturn = tail.getPoint();
        MyListNode node = head;
        //traverse to next-to-last element
        while (node.getNext() != tail) {
            node = node.getNext();
        }
        //unlink last node
        node.setNext(null);
        tail = node;
        size--;
        return toReturn;
    }

    // Inserts the specified element 'point' at the specified position in this list.
    // Precondition: i >= 0 && i <= size() && point != null.
    public void add(int i, Point point) {

        //TODO: implement method.
        if (i == 0) {
            addFirst(point);
        } else {
            int cnt = 1;
            MyListNode node = head;
            //traverse to next-to-ith element
            while (cnt++ < i) {
                node = node.getNext();
            }
            MyListNode newNode = new MyListNode(point, node.getNext());
            node.setNext(newNode);
            if (i == size) { //special case: added at last position
                tail = newNode;
            }
            size++;
        }

    }

    // Returns the element at the specified position in this list.
    // Precondition: i >= 0 && i < size().
    public Point get(int i) {

        //TODO: implement method.
        MyListNode node = head;
        while (i-- > 0) {
            node = node.getNext();
        }
        return node.getPoint();
    }

    // Returns the index of the first occurrence (element with equal coordinates to 'point') of the
    // specified element in this list, or -1 if this list does not contain the element.
    // Precondition: point != null.
    public int indexOf(Point point) {

        //TODO: implement method.
        int index = 0;
        MyListNode node = head;
        while (node != null) {
            if (node.getPoint().compareTo(point) == 0) {
                return index;
            }
            node = node.getNext();
            index++;
        }

        return -1;
    }

    // Returns the number of elements in this list.
    public int size() {

        //TODO: implement method.
        return size;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
//node class for the singly linked list
class MyListNode {
    private final Point p;
    private MyListNode next;

    MyListNode(Point b, MyListNode next) {
        this.p = b;
        this.next = next;
    }

    public void setNext(MyListNode node) {
        this.next = node;
    }

    public Point getPoint() {
        return this.p;
    }

    public MyListNode getNext() {
        return this.next;
    }
}