import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
        ArrayStack s = new ArrayStack();
        assertEquals(true, s.isEmpty());
    }

    @Test
    public void isFull() {
        ArrayStack s = new ArrayStack();
        s.push(11);
        assertEquals(false, s.isEmpty());
        assertEquals(true, s.isFull());
        s.push(22);
        assertEquals(true, s.isFull());
        assertEquals(false, s.isEmpty());
        s.push(32);
        assertEquals(false, s.isFull());
        assertEquals(false, s.isEmpty());
        s.push(43);
        assertEquals(true, s.isFull());
        assertEquals(false, s.isEmpty());
        s.push(55);
        assertEquals(false, s.isFull());

    }

    @Test
    public void peek() {
        ArrayStack s = new ArrayStack();
        s.push(11);
        s.push(22);
        s.push(32);
        s.push(43);
        s.push(55);
        assertEquals(55, s.peek());
        s.pop();
        assertEquals(43, s.peek());
        Object e = s.peek();
        s.pop();
        assertNotEquals(s.peek(), e);
        assertEquals(32, s.peek());
    }

    @Test
    public void push() {
        ArrayStack s = new ArrayStack();
        s.push(11);
        s.push(22);
        s.push(32);
        s.push(43);
        s.push(55);
        assertEquals(8, s.getElements().length);
    }

    @Test
    public void pop() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        assertEquals(8, s.getElements().length);
        assertEquals(5, s.pop());
        assertEquals(4, s.pop());
        assertEquals(3, s.pop());
        assertEquals(2, s.pop());
        assertEquals(4, s.getElements().length);
    }

    @Test
    public void getElements() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertArrayEquals(new Object[]{1,2}, s.getElements());
    }

    @Test
    public void testConstructor() {
        ArrayStack tmp = new ArrayStack();
        assertArrayEquals(tmp.getElements(), new Object[1]);
    }

    @Test
    public void testToString() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
        s.push(2);
        assertEquals("<ArrayStack[1,2,2]>(Size=3, Cap=4)", s.toString());
        s.push(10000);
        assertEquals("<ArrayStack[1,2,2,10000]>(Size=4, Cap=4)", s.toString());
    }

    @Test
    public void testGrowShrink() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
        s.push(3);
        assertEquals(4, s.getElements().length);
        s.pop();
        s.pop();
        s.pop();
        assertEquals(2, s.getElements().length);
    }
}