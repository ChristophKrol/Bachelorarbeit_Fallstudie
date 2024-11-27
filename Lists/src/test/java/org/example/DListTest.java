package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DListTest {
    private DList dList;

    @BeforeEach
    void setUp() {
        dList = new DList();
    }

    @Test
    void testIsEmptyInitially() {
        assertTrue(dList.isEmpty(), "List should be empty after initialization.");
    }

    @Test
    void testAddFirst() throws ListEmptyException {
        dList.addFirst("Node1");
        assertFalse(dList.isEmpty(), "List should not be empty after adding an element.");
        assertEquals("Node1", dList.removeFirst(), "The first node should be the one added.");
    }

    @Test
    void testAddLast() throws ListEmptyException {
        dList.addLast("Node1");
        assertFalse(dList.isEmpty(), "List should not be empty after adding an element.");
        assertEquals("Node1", (String) dList.getLast(), "The last node should be the one added.");
    }

    @Test
    void testRemoveFirstFromEmptyListThrowsException() {
        assertThrows(ListEmptyException.class, () -> dList.removeFirst(), "Removing from an empty list should throw an exception.");
    }

    @Test
    void testRemoveLastFromEmptyListThrowsException() {
        assertThrows(ListEmptyException.class, () -> dList.removeLast(), "Removing from an empty list should throw an exception.");
    }

    @Test
    void testGetLastFromEmptyListThrowsException() {
        assertThrows(ListEmptyException.class, () -> dList.getLast(), "Getting the last element from an empty list should throw an exception.");
    }

    @Test
    void testAddAndRemoveMultipleElements() throws ListEmptyException {
        dList.addFirst("Node1");
        dList.addLast("Node2");
        dList.addFirst("Node0");

        assertEquals("Node0", dList.removeFirst(), "The first element should be Node0.");
        assertEquals("Node2", dList.removeLast(), "The last element should be Node2.");
        assertEquals("Node1", dList.removeFirst(), "The last remaining element should be Node1.");
        assertTrue(dList.isEmpty(), "List should be empty after removing all elements.");
    }

    @Test
    void testToStringEmptyList() {
        assertEquals("[HEAD]<->[TAIL]", dList.toString(), "toString for an empty list should return the correct format.");
    }

    @Test
    void testToStringNonEmptyList() {
        dList.addFirst("Node1");
        dList.addLast("Node2");
        assertTrue(dList.toString().contains("Node1"), "toString should include Node1.");
        assertTrue(dList.toString().contains("Node2"), "toString should include Node2.");
    }

}