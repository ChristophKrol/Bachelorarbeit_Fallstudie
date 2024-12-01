package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @Test
    void isEmpty() {
        MyList list = new MyList();
        assertTrue(list.isEmpty());
    }

    @Test
    void addFirst() {
        Node testNode = new Node(1);
        MyList list = new MyList();
        list.addFirst(testNode);
        assertFalse(list.isEmpty());
    }

    @Test
    void getFirst() throws ListEmptyException {
        Node testNode = new Node(1);
        MyList list = new MyList();
        list.addFirst(testNode);
        assertEquals(testNode, list.getFirst());
    }

    @Test
    void removeFirst() throws ListEmptyException {
        Node testNode = new Node(1);
        MyList list = new MyList();
        list.addFirst(testNode);
        list.removeFirst();
        assertThrowsExactly(ListEmptyException.class, list::getFirst);
    }

    @Test
    void getLast() throws ListEmptyException {
        Node testNode = new Node(1);
        Node testNode2 = new Node(2);
        MyList list = new MyList();
        list.addFirst(testNode);
        list.addFirst(testNode2);
        assertEquals(testNode, list.getLast());
    }

    @Test
    void addLast() throws ListEmptyException {
        Node testNode = new Node(1);
        Node testNode2 = new Node(2);
        MyList list = new MyList();
        list.addLast(testNode);
        list.addLast(testNode2);
        assertEquals(testNode2, list.getLast());
    }

    @Test
    void removeLast() throws ListEmptyException {
        Node testNode = new Node(1);
        Node testNode2 = new Node(2);
        MyList list = new MyList();
        list.addFirst(testNode);
        list.addFirst(testNode2);
        list.removeLast();
        list.removeLast();
        assertThrowsExactly(ListEmptyException.class, list::removeLast);
    }

    @Test
    void testToString() {
        Node testNode = new Node(1);
        MyList list = new MyList();
        list.addFirst(testNode);
        assertEquals("[HEAD]->[" + testNode.toString() + "]", list.toString());
    }
}