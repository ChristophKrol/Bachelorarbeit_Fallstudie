package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @Test
    void emptyTestEmpty(){
        MyList list = new MyList();
        assertTrue(list.isEmpty());
    }
    @Test
    void emptyTestNotEmpty(){
        MyList list = new MyList();
        list.addLast(new Node("Test"));
        assertFalse(list.isEmpty());
    }


    @Test
    void testGetFirst_NonEmptyList() throws ListEmptyException {
        MyList list = new MyList();
        list.addLast("A");
        list.addLast("B");
        assertEquals(list.getFirst(), "A");
    }

    @Test
    void testGetFirst_EmptyList() throws ListEmptyException {
        MyList list = new MyList();
        assertThrowsExactly(ListEmptyException.class, list::getFirst);
    }
    @Test
    void testRemoveFirst_NonEmptyList() throws ListEmptyException {
        MyList list = new MyList();
        list.addLast("A");
        list.addLast("B");
        assertEquals(list.removeFirst(), "A");
        assertEquals(list.getFirst(), "B");
    }

    @Test
    void testRemoveFirst_EmptyList() {
        MyList list = new MyList();
        assertThrows(ListEmptyException.class, list::removeFirst);
    }

    @Test
    void testAddLast_NonEmptyList() throws ListEmptyException {
        MyList list = new MyList();
        list.addLast("A");
        assertEquals(list.getLast(), "A");
        list.addLast("B");
        assertEquals(list.getLast(), "B");
    }

    @Test
    void testAddLast_EmptyList() {
        MyList list = new MyList();
        list.addLast("A");
        assertFalse(list.isEmpty());
    }

    @Test
    void testGetLast_NonEmptyList() throws ListEmptyException {
        MyList list = new MyList();
        list.addLast("A");
        list.addLast("B");
        assertEquals(list.getLast(), "B");
    }

    @Test
    void testGetLast_EmptyList() {
        MyList list = new MyList();
        assertThrows(ListEmptyException.class, list::getLast);
    }
    @Test
    void testRemoveLast_NonEmptyList() throws ListEmptyException {
        MyList list = new MyList();
        list.addLast("A");
        assertEquals(list.removeLast(), "A");
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveLast_EmptyList() {
        MyList list = new MyList();
        assertThrows(ListEmptyException.class, list::removeLast);
    }
    @Test
    void testToString_NonEmptyList() {
        MyList list = new MyList();
        list.addLast("A");
        assertEquals(list.toString(), "[" + "HEAD]" + "->"+ "[A" + "]");
    }

    @Test
    void testToString_EmptyList() {
        MyList list = new MyList();
        assertEquals(list.toString(), "[" + "HEAD" + "]");
    }


}