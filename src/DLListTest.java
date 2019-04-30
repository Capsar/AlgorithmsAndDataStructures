
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Quentin
 */
public class DLListTest {
    @Test
    public void testDLListConstructor() {
        DLList list = new DLList();
        assertEquals(0, list.size());
    }

    @Test
    public void testOneElement() {
        DLList list = new DLList();
        list.addFirst(42);
        assertEquals(42, list.getHead());
        assertEquals(42, list.getTail());
        assertEquals(1, list.size());
        assertEquals(42, list.removeLast());
    }

    @Test
    public void testAddAtPosition() {
        DLList list = new DLList();
        list.addFirst(3);
        list.addLast(2);
        list.addAtPosition(1, 5);
        assertEquals(3, list.size());
        assertNull(list.removeFromPosition(10));
        assertEquals(3, list.size());
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(2, list.removeFirst());
    }

    @Test
    public void testRemoveAtPosition() throws Exception {
        DLList list = new DLList();
        list.addFirst(3);
        list.addLast(2);
        list.addAtPosition(1, 5);
        assertEquals(5, list.removeFromPosition(1));
    }

    @Test
    public void testReverse1() throws Exception {
        DLList list = new DLList();
        list.addFirst(1);
        DLList reverse = list.reverse();
        assertEquals(1, reverse.removeFirst());
    }

    @Test
    public void testRemoveFromPosition() throws Exception {
        DLList list = new DLList();
        assertNull(list.removeLast());
        list.addFirst(1);
        assertEquals(1, list.removeLast());
        assertEquals(0, list.size());
        assertNull(list.removeFirst());
        list.addFirst(1);
        assertEquals(1, list.removeFirst());
        assertEquals(0, list.size());
        list.addFirst(2);
        assertEquals(1, list.size());
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        assertEquals(5, list.size());
        assertEquals(2, list.removeFromPosition(1));
        assertEquals(4, list.size());

        assertEquals(3, list.removeFromPosition(1));
        assertEquals(3, list.size());

        assertEquals(4, list.removeFromPosition(1));
        assertEquals(2, list.size());

        assertEquals(5, list.removeFromPosition(1));
        assertEquals(1, list.size());


    }

    @Test
    public void testAddToPos() throws Exception {
        DLList list = new DLList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addAtPosition(2, 6);
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(6, list.removeFirst());

    }

    @Test
    public void testAddOne() throws Exception {
        DLList list = new DLList();
        list.addFirst(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddTwoRemoveSecond() throws Exception {
        DLList list = new DLList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

//	        list.removeFromPosition(1);
        list.removeLast();
        assertEquals(2, list.size());
    }

    @Test
    public void testReverse2() throws Exception {
        DLList list = new DLList();
        DLList empty = list.reverse();
        assertEquals(0, empty.size());
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        DLList reverse = list.reverse();
        assertEquals(4, reverse.removeFirst());
        assertEquals(3, reverse.removeFirst());
        assertEquals(2, reverse.removeFirst());
        assertEquals(1, reverse.removeFirst());
    }

    @Test
    public void testRemoveAtPostion() throws Exception {
        DLList list = new DLList();
        assertNull(list.removeFromPosition(0));
        list.addFirst(1);
        assertEquals(1, list.removeFromPosition(0));
        assertEquals(0, list.size());
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        assertEquals(3, list.removeFromPosition(2));
        assertNull(list.removeFromPosition(-2));
        assertEquals(2, list.removeFromPosition(1));

    }

    @Test
    public void testAddingToPosition() throws Exception {
        DLList list = new DLList();
        list.addAtPosition(1, 1);
        assertEquals(1, list.removeFromPosition(0));
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addAtPosition(2, 3.2);
        assertEquals(5, list.size());
        assertEquals(3.2, list.removeFromPosition(2));
        list.addAtPosition(-2, 10);
        assertEquals(10, list.removeLast());

    }

    @Test
    public void testRemoveFirst() throws Exception {
        DLList list = new DLList();
        assertNull(list.removeFirst());
        list.addFirst(1);
        assertEquals(1, list.removeFirst());
        list.addFirst(1);
        list.addLast(2);
        assertEquals(2, list.size());
        assertEquals(1, list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(2, list.removeFirst());
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeFirst());
        assertEquals(4, list.removeFirst());
    }

    @Test
    public void testRemoveLast() throws Exception {
        DLList list = new DLList();
        assertNull(list.removeLast());
        list.addFirst(1);
        assertEquals(1, list.removeLast());
        assertEquals(0, list.size());
        list.addFirst(1);
        list.addLast(2);
        assertEquals(2, list.size());
        assertEquals(2, list.removeLast());
        assertEquals(1, list.size());
        assertEquals(1, list.removeLast());
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        assertEquals(4, list.removeLast());
        assertEquals(3, list.removeLast());
        assertEquals(2, list.removeLast());
        assertEquals(1, list.removeLast());
    }

    @Test
    public void testAddAtSpecificPosition() throws Exception {
        DLList list = new DLList();
        list.addAtPosition(10, 1);
        assertEquals(1, list.removeLast());

        list.addAtPosition(0, 1);
        list.addAtPosition(1, 2);
        list.addAtPosition(2, 3);
        list.addAtPosition(3, 4);
        list.addAtPosition(4, 5);
        list.addAtPosition(2, 3.1);
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(3.1, list.removeFirst());
        assertEquals(3, list.removeFirst());
        assertEquals(4, list.removeFirst());
        assertEquals(5, list.removeFirst());
        list.addAtPosition(0, 1);
        list.addAtPosition(1, 2);
        list.addAtPosition(2, 3);
        list.addAtPosition(3, 4);
        list.addAtPosition(4, 5);
        list.addAtPosition(0, 1.1);
        assertEquals(1.1, list.removeFirst());
        list.addAtPosition(10, 6);
        assertEquals(6, list.removeLast());
    }

    @Test
    public void testRemoveFromSpecificPosition() throws Exception {
        DLList list = new DLList();
        assertNull(list.removeFromPosition(0));
        assertNull(list.removeFromPosition(2));
        assertNull(list.removeFromPosition(-2));

        list.addFirst(1);
        assertNull(list.removeFromPosition(20));
        assertNull(list.removeFromPosition(-20));

        assertEquals(1, list.removeFromPosition(0));
        list.addFirst(1);

        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        assertEquals(3, list.removeFromPosition(2));
        assertEquals(3, list.size());
        assertNull(list.removeFromPosition(20));
        assertEquals(1, list.removeFromPosition(0));
    }

    @Test
    public void testReverse() throws Exception {
        DLList list = new DLList();
        assertEquals(0, list.reverse().size());
        assertNull(list.reverse().removeFromPosition(0));
        assertNull(list.reverse().removeFromPosition(1));
        list.addFirst(1);
        assertEquals(1, list.reverse().size());
        assertEquals(1, list.reverse().removeFromPosition(0));
        list.addLast(2);
        assertEquals(2, list.size());
        DLList reverse = list.reverse();
        assertEquals(2, reverse.removeFirst());
        assertEquals(1, reverse.removeFirst());
    }
}
