package gmu.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class LinkedListTest2 {

    private LinkedList<String> list;
    private LinkedList<String> emptyList;

    @BeforeEach
    public void setUp() {
        list = new LinkedList<>();
        emptyList = new LinkedList<>();
    }


    /* remove(Object o) — removes first occurrence of element */

    @Test
    public void testRemoveObject_existingElement() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertTrue(list.remove("B"));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testRemoveObject_firstElement() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }

    @Test
    public void testRemoveObject_lastElement() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove("B"));
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testRemoveObject_notPresent() {
        list.add("A");
        assertFalse(list.remove("Z"));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveObject_emptyList() {
        assertFalse(emptyList.remove("A"));
    }

    // Null-element branches in remove(Object)
    @Test
    public void testRemoveObject_null_present() {
        list.add("A");
        list.add(null);
        list.add("B");
        assertTrue(list.remove(null));
        assertEquals(2, list.size());
        assertFalse(list.contains(null));
    }

    @Test
    public void testRemoveObject_null_notPresent() {
        list.add("A");
        list.add("B");
        assertFalse(list.remove(null));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveObject_null_fromEmptyList() {
        assertFalse(emptyList.remove(null));
    }

    @Test
    public void testRemoveObject_onlyNullElement() {
        list.add(null);
        assertTrue(list.remove(null));
        assertEquals(0, list.size());
    }

    // remove(Object) only removes FIRST occurrence
    @Test
    public void testRemoveObject_removesOnlyFirstOccurrence() {
        list.add("A");
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0)); // second "A" should still be there
        assertEquals("B", list.get(1));
    }


    /* remove() — removes and returns head; throws if empty */

    @Test
    public void testRemoveNoArg_nonEmpty() {
        list.add("X");
        list.add("Y");
        assertEquals("X", list.remove());
        assertEquals(1, list.size());
    }

    @Test
	public void testRemoveNoArg_emptyList_throws() {
		assertThrows(NoSuchElementException.class, () -> emptyList.remove());
	}


    /* removeFirst() */

    @Test
    public void testRemoveFirst_nonEmpty() {
        list.add("First");
        list.add("Second");
        assertEquals("First", list.removeFirst());
        assertEquals(1, list.size());
        assertEquals("Second", list.get(0));
    }

	@Test
	public void testRemoveFirst_emptyList_throws() {
		assertThrows(NoSuchElementException.class, () -> emptyList.removeFirst());
	}

    @Test
    public void testRemoveFirst_singleElement() {
        list.add("Only");
        assertEquals("Only", list.removeFirst());
        assertEquals(0, list.size());
    }


    /* removeLast() */

    @Test
    public void testRemoveLast_nonEmpty() {
        list.add("First");
        list.add("Last");
        assertEquals("Last", list.removeLast());
        assertEquals(1, list.size());
        assertEquals("First", list.get(0));
    }

	@Test
	public void testRemoveLast_emptyList_throws() {
		assertThrows(NoSuchElementException.class, () -> emptyList.removeLast());
	}

    @Test
    public void testRemoveLast_singleElement() {
        list.add("Only");
        assertEquals("Only", list.removeLast());
        assertEquals(0, list.size());
    }


    /* removeFirstOccurrence(Object) — delegates to remove(Object) */

    @Test
    public void testRemoveFirstOccurrence_present() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertTrue(list.removeFirstOccurrence("A"));
        assertEquals(2, list.size());
        assertEquals("B", list.get(0));
        assertEquals("A", list.get(1));
    }

    @Test
    public void testRemoveFirstOccurrence_notPresent() {
        list.add("A");
        assertFalse(list.removeFirstOccurrence("Z"));
    }

    @Test
    public void testRemoveFirstOccurrence_null() {
        list.add(null);
        list.add("A");
        assertTrue(list.removeFirstOccurrence(null));
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }


    /* removeLastOccurrence(Object) */

    @Test
    public void testRemoveLastOccurrence_present() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertTrue(list.removeLastOccurrence("A"));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testRemoveLastOccurrence_notPresent() {
        list.add("A");
        assertFalse(list.removeLastOccurrence("Z"));
    }

    @Test
    public void testRemoveLastOccurrence_emptyList() {
        assertFalse(emptyList.removeLastOccurrence("A"));
    }

    // Null-element branches in removeLastOccurrence
    @Test
    public void testRemoveLastOccurrence_null_present() {
        list.add("A");
        list.add(null);
        list.add("B");
        list.add(null);
        assertTrue(list.removeLastOccurrence(null));
        // The last null (index 3) should be removed, first null (index 1) stays
        assertEquals(3, list.size());
        assertNull(list.get(1));  // first null still remaining
        assertEquals("B", list.get(2));
    }

    @Test
    public void testRemoveLastOccurrence_null_notPresent() {
        list.add("A");
        list.add("B");
        assertFalse(list.removeLastOccurrence(null));
    }

    @Test
    public void testRemoveLastOccurrence_null_emptyList() {
        assertFalse(emptyList.removeLastOccurrence(null));
    }

    @Test
    public void testRemoveLastOccurrence_onlyNullElement() {
        list.add(null);
        assertTrue(list.removeLastOccurrence(null));
        assertEquals(0, list.size());
    }


    /* indexOf(Object) */

    @Test
    public void testIndexOf_present() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(1, list.indexOf("B"));
    }

    @Test
    public void testIndexOf_notPresent() {
        list.add("A");
        assertEquals(-1, list.indexOf("Z"));
    }

    @Test
    public void testIndexOf_emptyList() {
        assertEquals(-1, emptyList.indexOf("A"));
    }

    @Test
    public void testIndexOf_firstOccurrenceReturned() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertEquals(0, list.indexOf("A")); // should return first index
    }

    // Null-element branches in indexOf
    @Test
    public void testIndexOf_null_present() {
        list.add("A");
        list.add(null);
        list.add("B");
        assertEquals(1, list.indexOf(null));
    }

    @Test
    public void testIndexOf_null_notPresent() {
        list.add("A");
        list.add("B");
        assertEquals(-1, list.indexOf(null));
    }

    @Test
    public void testIndexOf_null_emptyList() {
        assertEquals(-1, emptyList.indexOf(null));
    }

    @Test
    public void testIndexOf_null_firstOccurrence() {
        list.add(null);
        list.add("A");
        list.add(null);
        assertEquals(0, list.indexOf(null));
    }


    /* lastIndexOf(Object) */

    @Test
    public void testLastIndexOf_present() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(1, list.lastIndexOf("B"));
    }

    @Test
    public void testLastIndexOf_notPresent() {
        list.add("A");
        assertEquals(-1, list.lastIndexOf("Z"));
    }

    @Test
    public void testLastIndexOf_emptyList() {
        assertEquals(-1, emptyList.lastIndexOf("A"));
    }

    @Test
    public void testLastIndexOf_lastOccurrenceReturned() {
        list.add("A");
        list.add("B");
        list.add("A");
        assertEquals(2, list.lastIndexOf("A")); // should return last index
    }

    // Null-element branches in lastIndexOf
    @Test
    public void testLastIndexOf_null_present() {
        list.add("A");
        list.add(null);
        list.add("B");
        assertEquals(1, list.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOf_null_notPresent() {
        list.add("A");
        list.add("B");
        assertEquals(-1, list.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOf_null_emptyList() {
        assertEquals(-1, emptyList.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOf_null_lastOccurrence() {
        list.add(null);
        list.add("A");
        list.add(null);
        assertEquals(2, list.lastIndexOf(null));
    }


    // Queue and dequeue operations

    @Test
    public void testPeekPollOnEmptyList() {
        assertNull(emptyList.peek());
        assertNull(emptyList.peekFirst());
        assertNull(emptyList.peekLast());
        assertNull(emptyList.poll());
        assertNull(emptyList.pollFirst());
        assertNull(emptyList.pollLast());
    }

    @Test
    public void testPeekPollOnNonEmptyList() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.peek());
        assertEquals("A", list.peekFirst());
        assertEquals("C", list.peekLast());

        assertEquals("A", list.poll());
        assertEquals("B", list.pollFirst());
        assertEquals("C", list.pollLast());

        assertEquals(0, list.size());
    }

    @Test
    public void testOfferOfferFirstOfferLast() {
        assertTrue(list.offer("X"));
        assertTrue(list.offerFirst("Y"));
        assertTrue(list.offerLast("Z"));

        assertEquals("Y", list.getFirst());
        assertEquals("X", list.get(1));
        assertEquals("Z", list.getLast());
    }

    @Test
    public void testPushPopElement() {
        list.push("First");
        list.push("Second");

        assertEquals("Second", list.element());
        assertEquals("Second", list.pop());
        assertEquals("First", list.pop());

        // Empty list exceptions
        assertThrows(NoSuchElementException.class, () -> emptyList.element());
        assertThrows(NoSuchElementException.class, () -> emptyList.pop());
    }

    @Test
    public void testNullElementsInQueueMethods() {
        list.add(null);
        list.add("NotNull");

        assertNull(list.peek());
        assertNull(list.poll());
        assertEquals("NotNull", list.poll());

        list.offer(null);
        list.offerFirst(null);
        assertEquals(2, list.size());
        assertNull(list.getFirst());
    }
}