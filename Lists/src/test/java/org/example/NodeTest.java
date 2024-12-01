package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void setValue() {
        Node testNode = new Node("Test");
        testNode.setValue("Test2");
        assertEquals("Test2", testNode.getValue());
    }

    @Test
    void addLast() {
        Node testNode = new Node("Test");
        testNode.addLast("Test2");
        assertEquals("Test2", testNode.getLast());
    }

    @Test
    void getLastElement() {
        Node testNode = new Node("Test");
        testNode.addLast("Test2");
        assertEquals("Test2", testNode.getLastElement().getValue());
    }

    @Test
    void removeLast() {
        Node testNode = new Node("Test");
        testNode.addLast("Test2");
        testNode.addLast("Test3");
        testNode.removeLast();
        assertEquals("Test2", testNode.getLast());
    }
}