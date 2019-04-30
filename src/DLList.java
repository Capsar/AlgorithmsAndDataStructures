public class DLList {
    public static void main(String... args) {
        DLList list = new DLList();

        list = new DLList();
        System.out.println("Test 3: list assigned to new list");
        list.addFirst(3);
        System.out.println("Test 3: Added first 3");
        list.addLast(2);
        System.out.println("Test 3: Added last 2");
        list.addAtPosition(1, 5);
        System.out.println("Test 3: Added 5 at position 1");
        System.out.println("Test 3: list size should be 3 " + list.size());
        System.out.println("Test 3: Position 10 is null so removed should be null: " + list.removeFromPosition(10));
        System.out.println("Test 3: list size is still 3 " + list.size());
        System.out.println("Test 3: removed the first and this is equal to 3 " + list.removeFirst());
        System.out.println("Test 3: removed the first and this is equal to 5 " + list.removeFirst());
        System.out.println("Test 3: removed the first and this is equal to 2 " + list.removeFirst());

        System.out.println();

        list = new DLList();
        list.addFirst(1);
        System.out.println("added first 1, head:" + list.getHead() + " tail: " + list.getTail());
        list.addFirst(2);
        System.out.println("added first 2, head:" + list.getHead() + " tail: " + list.getTail());
        list.addFirst(3);
        System.out.println("added first 3, head:" + list.getHead() + " tail: " + list.getTail());
        list.addFirst(4);
        System.out.println("added first 4, head:" + list.getHead() + " tail: " + list.getTail());
        list.addFirst(5);
        System.out.println("added first 5, head:" + list.getHead() + " tail: " + list.getTail());
        list.addFirst(6);
        System.out.println("added first 6, head:" + list.getHead() + " tail: " + list.getTail());


        System.out.println("Added all numbers from 1 to 6");
        DLList newList = list.reverse();

        System.out.println("List reversed.");
        System.out.println("removed " + list.removeFirst());
        System.out.println("head should be 5 " + list.getHead());
        System.out.println("removed " + list.removeLast());
        System.out.println("tail should be 2 " + list.getTail());
        System.out.println("removed " + list.removeFirst());
        System.out.println("head should be 4 " + list.getHead());
        System.out.println("removed " + list.removeLast());
        System.out.println("tail should be 3 " + list.getTail());
        System.out.println("removed " + list.removeFirst());
        System.out.println("size should be 1 " + list.size());
        System.out.println("head should be 3 " + list.getHead());
        System.out.println(list.removeLast());
        System.out.println(list.removeFirst());

        System.out.println("List list is now empty: " + list.size());

        System.out.println("Other newList size is 6: " + newList.size());
        System.out.println(newList.getHead() + ": head tail: " + newList.getTail());
        newList.addAtPosition(5, 10);
        System.out.println("New list size is 7: " + newList.size());
        System.out.println(newList.getHead() + ": head tail: " + newList.getTail());
        System.out.println("removed first 1: " + newList.removeFirst());
        System.out.println("removed last 6: " + newList.removeLast());
        System.out.println("removed 10 from location 6: " + newList.removeFromPosition(4));
        System.out.println("removed first 2: " + newList.removeFirst());
        System.out.println("removed 4: " + newList.removeFirst());
        System.out.println("removed 5: " + newList.removeFirst());
        System.out.println("removed 10: " + newList.removeFromPosition(1));
        System.out.println("removed " + newList.removeFirst());
    }

    class Node {
        // Each node object has these three fields
        private Object element;
        private Node previous;
        private Node next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        Node(Object e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        // This function gets Object e as input and sets e as the element of the Node
        public void setElement(Object e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public Object getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }

        // This function gets Node p as input and sets the previous variable of the current Node object as p.
        public void setPrevious(Node p) {
            previous = p;
        }

        // This function returns the previous Node
        public Node getPrevious() {
            return previous;
        }
    }

    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private Node head;
    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private Node tail;

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public DLList() {
        head = null;
        tail = null;
    }

    /**
     * @return The element in the head Node of the DLL
     */
    public Object getHead() {
        return head.getElement();
    }

    /**
     * @return The element in the tail Node of the DLL
     */
    public Object getTail() {
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(Object e) {
        if (size() == 0) {
            head = new Node(e, null, null);
            tail = head;
        } else {
            tail.setNext(null);
            Node newHead = new Node(e, null, head);
            head.setPrevious(newHead);
            head = newHead;
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        if (size() == 0) {
            return null;
        }

        Object e = head.getElement();
        if (head == tail) {
            head = null;
            tail = null;
            return e;
        }
        head = head.getNext();
        return e;
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e The element to add.
     */
    public void addLast(Object e) {
        if (size() == 0) {
            tail = new Node(e, null, null);
            head = tail;
        } else {
            head.setPrevious(null);
            Node newTail = new Node(e, tail, null);
            tail.setNext(newTail);
            tail = newTail;
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (head == null || tail == null) {
            return null;
        }

        Object e = tail.getElement();
        if (head == tail) {
            head = null;
            tail = null;
            return e;
        }
        tail = tail.getPrevious();
        return e;
    }

    /**
     * @return the number of Nodes in the list
     */
    public int size() {
        if (head == null && tail == null)
            return 0;

        int size = 1;
        Node n = head;

        while (true) {
            if (n == tail)
                break;
            size++;
            n = n.getNext();
        }
        return size;
    }

    /**
     * Adds element e in a new Node which is inserted at position pos.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
     * If there is no Node in position pos, this method adds it to the last position.
     *
     * @param pos The position to insert the element at.
     * @param e   The element to add.
     */
    public void addAtPosition(int pos, Object e) {
        if (pos >= size() || pos < 0) {
            addLast(e);
            return;
        } else if (pos == 0) {
            addFirst(e);
            return;
        }

        int index = 0;
        Node n = head;
        while (true) {
            if (index == pos) {
                Node newNode = new Node(e, n.getPrevious(), n);
                n.getPrevious().setNext(newNode);
                n.setPrevious(newNode);
                break;
            }
            n = n.getNext();
            index++;
        }

    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (pos > size() - 1 || pos < 0)
            return null;
        if (pos == 0 || pos == 1 && size() == 1)
            return removeFirst();
        if (pos == size() - 1)
            return removeLast();

        int index = 0;
        Node n = head;
        Object e = null;
        while (true) {
            if (pos == index) {
                e = n.getElement();
                n.getPrevious().setNext(n.getNext());
                n.getNext().setPrevious(n.getPrevious());
                break;
            }
            n = n.getNext();
            index++;
        }
        return e;
    }

    /**
     * @return A new DLL that contains the elements of the current one in reversed order.
     */
    public DLList reverse() {
        DLList newList = new DLList();
        if (size() == 0)
            return newList;

        newList.addFirst(head.getElement());
        Node n = head;
        while (n.getNext() != null) {
            n = n.getNext();
            newList.addFirst(n.getElement());
        }
        return newList;
    }

}
