package gmu.edu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

/**
 * Unit tests for LinkedList(), testing constructors, getters/setters, fundamental structure methods
 */
public class CoreOperationsTest {


    //test that default linkedlist constructor creates non-null list
    @Test
    public void testDefaultConstructorNotNull() {
        LinkedList<Integer> list = new LinkedList<>();
        assertNotNull(list);
    }
    //test that default linkedlist constructor creates an empty list
    @Test
    public void testDefaultConstructorIsEmpty(){
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
    }

    //test that getFirst throws exception on empty list
    @Test
    public void testDefaultConstructorThrowsExceptionFirst(){
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    //test that getLast throws exception on empty list

    @Test
    public void testDefaultConstructorThrowsExceptionLast(){
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> list.getLast());
    }

    //test that a new linked list populated by a non-null list is not null

    @Test
    public void testCopyConstructorNotNull(){
        LinkedList<Integer> original = new LinkedList<>();
        original.add(1);
        original.add(2);
        original.add(3);
        LinkedList<Integer> copy = new LinkedList<>();
        assertNotNull(copy);
    }

    //test that new linked list populated from a different list is the same size as the original list

    @Test
    public void testCopyConstructorSameSize(){
        LinkedList<Integer> original = new LinkedList<>();
        original.add(1);
        original.add(2);
        original.add(3);
        LinkedList<Integer> copy = new LinkedList<>(original);
        assertEquals (original.size(), copy.size());
    }

    //new linked list contains same elements in the same order as original list

    @Test
    public void testCopyConstructorSameElements(){
        LinkedList<Integer> original = new LinkedList<>();
        original.add(1);
        original.add(2);
        original.add(3);
        LinkedList<Integer> copy = new LinkedList<>(original); 
        assertEquals(original.get(0), copy.get(0));
        assertEquals(original.get(1), copy.get(1));
        assertEquals(original.get(2), copy.get(2));
    }

    //new linked list correctly copies over an empty list
    @Test
    public void testCopyConstructorCopiesEmptyList(){
        LinkedList<Integer> original = new LinkedList<>();
        LinkedList<Integer> copy = new LinkedList<>(original); 
        assertNotNull(copy);
        assertEquals(0, copy.size());
    }

    //tests for add(E e): 
    //ensure that size increases
    //ensure that elements end up in correct position
    //ensure that adding multiple elements maintains correct order
    //test that add() returns true

    @Test
    public void testAddIncreasesListSize(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddElementToEnd(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.get(2));
    }
    @Test
    public void testAddElementMaintainsCorrectOrder(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testAddReturnsTrue(){
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.add(1));
    }

    //tests for addFirst(E e): 
    //ensure that size increases
    //ensure that elements end up in correct position
    //ensure that adding multiple elements maintains correct order
    //test that addFirst() works on empty list

    @Test
    public void testAddFirstIncreasesListSize(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddFirstElementToBeginning(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.addFirst(3);
        assertEquals(3, list.get(0));
    }
    @Test
    public void testAddFirstElementMultipleElements(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    public void testAddFirstToEmptyList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        assertEquals(1, list.getFirst());
        assertEquals(1, list.getLast());
    }

    //tests for addLast(E e): 
    //ensure that size increases
    //ensure that elements end up in correct position
    //ensure that adding multiple elements maintains correct order
    //test that addLast() works on empty list

    @Test
    public void testAddLastIncreasesListSize(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddLastElementToEnd(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.addLast(3);
        assertEquals(3, list.getLast());
    }
    @Test
    public void testAddLastElementMultipleElements(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testAddLastToEmptyList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        assertEquals(1, list.getFirst());
        assertEquals(1, list.getLast());
    }
    //tests for addAll(LinkedList<E> c)
    //expected behavior: appends all elements from one linked list to the end of another linked list
    //test that addAll appends a list to another list
    //test that addAll appends all elements in order
    //test that addAll non-empty list returns true
    //test that addAll empty list returns false

    @Test
    public void testAddAllAppendsList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(1);
        newList.add(2);
        list.addAll(newList);
        assertEquals(4, list.size());
    }

    @Test
    public void testAddAllAppendsElementsInOrder(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(3);
        newList.add(4);
        list.addAll(newList);
        assertEquals(3, list.get(2)); 
        assertEquals(4, list.get(3));
    }

    @Test
    public void testAddAllNonEmptyReturnsTrue(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(3);
        newList.add(4);
        assertTrue(list.addAll(newList));
    }

    @Test
    public void testAddAllEmptyReturnsFalse(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        LinkedList<Integer> newList = new LinkedList<>();
        assertFalse(list.addAll(newList));
    }

    //tests for addAll(int index, LinkedList<E> c)
    //expected behavior: appends all elements from one linked list at a specific point in another linked list
    //test that addAll appends a list to end of another list
    //test that addAll appends all elements to middle of another list and bumps remaining elements
    //test insertion at beginning of list
    //test that passing an empty list returns false
    //test that passing to an invalid index throws IndexOutOfBounds exception

    @Test
    public void testAppendToEndOfList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(3);
        newList.add(4);
        list.addAll(2, newList);
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void testAppendToMiddleOfList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(4);
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(2);
        newList.add(3);
        list.addAll(1, newList);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void testAppendToStartOfList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(1);
        newList.add(2);
        list.addAll(0, newList);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void testAddAllEmptyListReturnsFalse(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        LinkedList<Integer> newList = new LinkedList<>();
        assertFalse(list.addAll(1, newList));
    }

    @Test
    public void testAddAllToNegativeIndexThrows(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        LinkedList<Integer> newList = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAll(-1, newList));
    }

    @Test
    public void testAddAllToIndexTooLargeThrows(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAll(2, newList));
    }

}
