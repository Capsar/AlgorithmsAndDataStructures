
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Bas
 */
public class UTest {
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
    public void testReverse1() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        DLList reverseList = list.reverse();

        assertEquals(1, list.getHead());
        assertEquals(3, list.getTail());

        assertEquals(3, reverseList.getHead());
        assertEquals(1, reverseList.getTail());

        assertEquals(2, reverseList.removeFromPosition(1));
        assertEquals(2, list.removeFromPosition(1));

    }

    @Test
    public void testReverse2() {
        DLList list = new DLList();
        list.addLast(1);

        DLList reverseList = list.reverse();

        assertEquals(1, list.getHead());
        assertEquals(1, list.getTail());

        assertEquals(1, reverseList.getHead());
        assertEquals(1, reverseList.getTail());

    }

    @Test
    public void testReverse3() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);

        DLList reverseList = list.reverse();

        assertEquals(1, list.getHead());
        assertEquals(2, list.getTail());

        assertEquals(2, reverseList.getHead());
        assertEquals(1, reverseList.getTail());

    }

    @Test
    public void testReverse9000() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        DLList reverseList = list.reverse();
        assertEquals(1, reverseList.removeLast());
        assertEquals(2, reverseList.removeLast());
        assertEquals(3, reverseList.removeLast());
        assertEquals(4, reverseList.removeLast());
        assertEquals(5, reverseList.removeLast());

    }

    @Test
    public void testReverse9001() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        DLList reverseList = list.reverse();
        assertEquals(5, reverseList.removeFirst());
        assertEquals(4, reverseList.removeFirst());
        assertEquals(3, reverseList.removeFirst());
        assertEquals(2, reverseList.removeFirst());
        assertEquals(1, reverseList.removeFirst());

    }

    @Test
    public void testNullReverse() {
        DLList list = new DLList();
        DLList reverseList = list.reverse();
        assertNull(reverseList.removeFirst());
    }

    @Test
    public void testAddToHighPos() {
        DLList list = new DLList();

        list.addAtPosition(10, 1);
        assertEquals("Size should be 1", 1, list.size());
        list.addAtPosition(8, 2);
        assertEquals("The last element should be 2", 2, list.removeLast());
        list.addAtPosition(1, 3);
        assertEquals(3, list.getTail());
    }

    @Test
    public void testRemovePos() {
        DLList list = new DLList();
        list.addLast(1);
        assertEquals(1, list.size());
        assertNull("There should be nothing there.", list.removeFromPosition(1));
    }

    @Test
    public void testRemovePos2() {
        DLList list = new DLList();
        list.addLast(1); //pos = 0
        list.addLast(2); //pos = 1
        list.addLast(3); //pos = 2
        list.addLast(4); //pos = 3
        assertEquals(4, list.size());
        assertEquals(3, list.removeFromPosition(2));
        assertEquals(1, list.removeFromPosition(0));
        assertEquals(4, list.getTail());
    }

    @Test
    public void testAddToSamePos() {
        DLList list = new DLList();
        list.addAtPosition(0, 1);
        list.addAtPosition(0, 2);
        assertEquals(1, list.getTail());
        assertEquals(2, list.getHead());
    }

    @Test
    public void testAddToSamePos2() {
        DLList list = new DLList();
        list.addFirst(1);
        list.addAtPosition(1, 2);
        list.addAtPosition(1, 3);
        assertEquals(1, list.getHead());
        assertEquals(2, list.getTail());
    }

    @Test
    public void testAddRemoveToPos() {
        DLList list = new DLList();
        list.addFirst(1);
        list.addAtPosition(1, 2);
        list.addAtPosition(2, 3);
        assertEquals(1, list.getHead());
        assertEquals(3, list.getTail());
        assertEquals(2, list.removeFromPosition(1));
        assertEquals(3, list.getTail());
        assertEquals(3, list.removeFromPosition(1));
    }

    @Test
    public void testRemoveFinalElement() {
        DLList list = new DLList();
        list.addFirst(1);
        assertEquals(1, list.removeLast());
    }

    @Test
    public void testRemoveFinalElement2() {
        DLList list = new DLList();
        list.addLast(1);
        assertEquals(1, list.removeLast());
    }

    @Test
    public void TestRemoveFromEmtyList() {
        DLList list = new DLList();
        assertNull(list.removeLast());
    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    @Test
    public void TestRemoveFromList() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(1, list.removeFromPosition(0));
        assertEquals(2, list.removeFromPosition(0));
        assertEquals(3, list.removeFromPosition(0));
    }

    @Test
    public void TestRemoveFromList2() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(2, list.removeFromPosition(1));
        assertEquals(3, list.removeFromPosition(1));
        assertEquals(null, list.removeFromPosition(1));
    }

    @Test
    public void TestRemoveFromList3() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(3, list.removeFromPosition(2));
        assertEquals(null, list.removeFromPosition(2));
        assertEquals(null, list.removeFromPosition(2));
    }

    @Test
    public void TestRemoveFirst() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);

        assertEquals(1, list.removeFirst());
        assertEquals(list.getHead(), list.getTail());
        assertEquals(1, list.size());
    }

    @Test
    public void TestRemoveLast() {
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);

        assertEquals(2, list.removeLast());
        assertEquals(list.getHead(), list.getTail());
        assertEquals(1, list.size());
    }

    @Test
    public void TestMoreReverse(){
        DLList list = new DLList();
        list.addLast(1);
        list.addLast(2);

        assertEquals(1, list.getHead());
        assertEquals(2, list.getTail());

        DLList reverse = list.reverse();

        assertEquals(2, reverse.getHead());
        assertEquals(1, reverse.getTail());
    }

    @Test
    public void TestMoreReverseeee(){
        DLList list = new DLList();
        list.addLast(1);

        assertEquals(1, list.getHead());
        assertEquals(1, list.getTail());
        assertEquals(1, list.size());

        DLList reverse = list.reverse();

        assertEquals(1, reverse.getHead());
        assertEquals(1, reverse.getTail());
        assertEquals(1, reverse.size());
    }
}
//
