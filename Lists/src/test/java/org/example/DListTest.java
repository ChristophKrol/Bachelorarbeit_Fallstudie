package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

class DListTest {

    @Test
    void isEmpty() {
        DList emptyList = new DList();

        DList list = new DList();
        list.addLast("TEST");

        Assertions.assertTrue(emptyList.isEmpty());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void addFirst() throws ListEmptyException {
        DList list = new DList();
        list.addFirst("first");


        Assertions.assertEquals("first", list.getFirst());
    }

    @Test
    void removeFirst() throws ListEmptyException {
        DList list = new DList();

        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");

        list.removeFirst();

        Assertions.assertEquals("2", list.getFirst());
    }

    @Test
    void getLast() throws ListEmptyException {
        DList list = new DList();

        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");

        Assertions.assertEquals("1", list.getLast());
    }

    @Test
    void addLast() throws ListEmptyException {
        DList list = new DList();

        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addLast("4");

        Assertions.assertEquals("4", list.getLast());
    }

    @Test
    void removeLast() throws ListEmptyException {
        DList list = new DList();

        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");


        list.removeLast();

        Assertions.assertEquals("2", list.getLast());
    }

    @Test
    void toStringTest() {
        DList emptyList = new DList();
        DList list = new DList();
        list.addFirst("1");
        list.addFirst("2");

        String emptyListToString = emptyList.toString();
        String listToString = list.toString();

        Assertions.assertEquals("[HEAD]<->[2]<->[1]<->[TAIL]", listToString);
        Assertions.assertEquals("[HEAD]<->[TAIL]", emptyListToString);
    }

}