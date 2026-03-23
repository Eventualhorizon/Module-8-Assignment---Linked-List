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
        LinkedList<Integer> copy = new LinkedList<>(original);
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

    //test size function:
    //intended result: returns size of list
    //test size of empty list == 0
    //test size increments after element is added
    //test size decrements after element is removed
    @Test
    public void testSizeOfEmptyList(){
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void testSizeOfListAfterIncrement(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testSizeOfListAfterDecrement(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(1, list.size());
    }

    //test contains() function
    //expected behavior: returns true if index of object o is not -1 (recall that function indexOf() returns
    //-1 if object is not in list), returns false otherwise
    //test contains null object
    //test does not contain null object

    @Test
    public void testContainsObjectInList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertTrue(list.contains(1));
    }

    @Test
    public void testContainsObjectNotInList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertFalse(list.contains(2));
    }

    @Test
    public void testContainsOnEmptyList(){
        LinkedList<Integer> list = new LinkedList<>();
        assertFalse(list.contains(1));
    }

    @Test
    public void testContainsNullObject(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(null);
        list.add(1);
        assertTrue(list.contains(null));
    }

    @Test
    public void testDoesNotContainNullObject(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertFalse(list.contains(null));
    }

    //test Clear() function
    //expected behavior: traverses linked list, setting all elements to null and resetting header and size to 0
    //test size set to zero
    //test all elements null

    @Test
    public void testClearEmptyList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testClearNonEmptyList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testClearThenAdd(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.clear();
        list.add(3);
        assertEquals(1, list.size());
        assertEquals(3, list.get(0));
    }

    @Test
    public void testClearListIsEmpty(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.clear();
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    //test get()
    //expected behavior: returns the item at a certain index
    //relies on implementation of entry() which traverses linked list from the front if the requested index
    //is less than half the size of the list, and traverses from the back if the requested index is more
    //than half the size.
    //So we will test get() with an entry from the beginning and end of the list

    @Test
    public void testGetFirstItem(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
    }

    @Test
    public void testGetLastItem(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, list.get(1));
    }
    
    @Test
    public void testGetMiddleElement(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
    }

    @Test
    public void testGetFromFirstHalf(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        assertEquals(2, list.get(1));
    }

    @Test
    public void testGetFromLastHalf(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        assertEquals(5, list.get(4));
    }

    @Test
    public void testGetItemAtNegativeIndexThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-2));
    }

    @Test
    public void testGetItemAtIndexExceedingSizeThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    //test set(index, obj)
    //expected behavior: replaces object at specified index with new object, returns old object
    //test to make sure item is replaced, test to make sure function returns old object,
    //test to make sure index out of bonds throws exception

    @Test
    public void testSetReplacesElementInList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1,99);
        assertEquals(99, list.get(1));
    }

    @Test
    public void testSetReturnsReplacedElement(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.set(1, 99));
    }

    @Test
    public void testSetFirstElement(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(0,99);
        assertEquals(99, list.get(0));
    }

    @Test
    public void testSetLastElement(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3); 
        list.set(2, 99);
        assertEquals(99, list.get(2));
    }

    @Test
    public void testSetNegativeIndexThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1,99));
    }

    @Test
    public void testSetIndexExceedingSizeThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3); 
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(4, 99));
    }

    //test add(int index, E element)
    //expected behavior: inserts specified element at specified index in the list
    //test to add an element at beginning, middle, end of index
    //test that adding element increases size of list
    //test that adding element increments position of subsequent elements in list
    //test that adding element at invalid index throws exception

    @Test
    public void testAddSingleElementToStart(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 99);
        assertEquals(99, list.get(0));
    }

    @Test
    public void testAddSingleElementToEnd(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3, 99);
        assertEquals(99, list.get(3));
    }

    @Test
    public void testAddSingleElementNegativeIndexThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-2, 99));
    }

    @Test
    public void testAddSingleElementTooLargeIndexThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 99));
    }

    //test toArray()
    //expected behavior: takes a list and creates an array that is a copy of the elements in the list,
    //in order. The new array is independent from the list and may be changed without affecting the list.

    @Test
    public void testToArrayEmptyList(){
        LinkedList<Integer> list = new LinkedList<>();
        Object[] array = list.toArray();
        assertNotNull(array);
        assertEquals(0, array.length);
    }

    @Test
    public void testToArraySingleElementList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(99);
        Object[] array = list.toArray();
        assertEquals(1, array.length);
        assertEquals(99, array[0]);
    }

    @Test
    public void testToArrayMultipleElementList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    public void testToArrayCreatesIndependentArray(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] array = list.toArray();
        array[0] = 99;
        assertEquals(1, list.get(0));
    }
//test toArray(T[] a)
//expected functionality: returns an array of the items of the list in order, where the type of the returned array
//is the same as the specified array
//test for the case where specified array is smaller than list
//test for case where specified array is same size as list
//test for case where specified array is larger than list, should return null as entry following last item in list

    @Test
    public void testToArrayTypedArrayTooSmall(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] small = new Integer[0];
        Integer[] result = list.toArray(small);
        assertEquals(3, result.length);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);
    }

    @Test
    public void testToArrayTypedArraySameSize(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] sameSize = new Integer[3];
        Integer[] result = list.toArray(sameSize);
        assertEquals(3, result.length);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);  
    }

    @Test
    public void testToArrayTypedArrayLarger(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] larger = new Integer[5];
        Integer[] result = list.toArray(larger);
        assertEquals(5, result.length);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);
        assertNull(result[3]);
    }

    @Test
    public void testToArrayTypedWithSupertype(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Number[] array = new Number[3];
        Number[] result = list.toArray(array);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);
    }

    @Test
    public void testToArrayTypedWithEmptyList(){
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] array = new Integer[0];
        Integer[] result = list.toArray(array);
        assertEquals(0, result.length);
    }

}
