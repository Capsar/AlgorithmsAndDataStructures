import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {
    private Object[] elements;
    private int size;
    private int capacity;

    /**
     * Creates an empty ArrayStack with capacity 1.
     */
    public ArrayStack() {
        this.size  = 0;
        this.capacity = 1;
        this.elements = new Object[1];
    }

    /**
     * @return The size of this ArrayStack.
     */
    public int size() {
        return this.size;
    }

    /**
     * @return `true` iff this ArrayStack is empty, `false` otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return `true` iff the size is equal to the capacity, `false` otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * @return the top element of the stack without removing it
     */
    public Object peek() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        Object e = elements[size-1];
        return e;
    }

    /**
     * Adds `o` to the stack.
     * If capacity of stack was too small, capacity is doubled and `o` is added.
     *
     * @param o
     *     the element to add to the stack.
     */
    public void push(Object o) {
        if(isFull()) {
            capacity*=2;
            Object[] newarray = new Object[capacity];
            for(int i = 0; i < size; i++) {
                newarray[i] = elements[i];
            }
            newarray[size] = o;
            elements = newarray;
        } else {
            elements[size] = o;
        }
        size++;
    }

    /**
     * Removes the top element from the stack.
     * If removing top would make the stack use less than 25% of its capacity,
     * then the capacity is halved.
     *
     * @return the element which was at the top of the stack.
     * @throws EmptyStackException
     *     iff the queue is empty
     */
    public Object pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        if((double)size/(double)capacity <= 0.25) {
            capacity/=2;
            Object[] newarray = new Object[capacity];
            for(int i = 0; i < size; i++) {
                newarray[i] = elements[i];
            }
            elements = newarray;
        }
        Object e = peek();
        elements[size-1] = null;
        size--;
        return e;
    }

    /**
     * @return a String representation of the ArrayStack
     * Example output for ArrayStack with 2 elements and capacity 5:
     * <ArrayStack[1,2]>(Size=2, Cap=5)
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<ArrayStack[");
        for(int i = 0; i < size; i++) {
            Object e = elements[i];
            if(e != null) {
                builder.append(e);
            }
            if(i != size-1) {
               builder.append(",");
            }
        }
        builder.append("]>(Size=");
        builder.append(size);
        builder.append(", Cap=");
        builder.append(capacity);
        builder.append(")");
        return builder.toString();
    }

    // For testing, do not remove or change.
    public Object[] getElements() {
        return elements;
    }
}
