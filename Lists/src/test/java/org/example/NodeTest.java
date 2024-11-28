package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    void test_constructor(){
        Node node = new Node("test", new Node("next"));
        assertEquals(node.getValue(), "test");
        assertEquals(node.getNext().getValue(), "next");
    }

    @Test
    void testSetValue() {
        Node node = new Node("test");
        node.setValue("new value");
        assertEquals(node.getValue(), "new value");
    }

    @Test
    void testGetLastElement() {
        Node node1 = new Node("test1");
        Node node2 = new Node("test2");
        node1.setNext(node2);
        assertEquals(node1.getLastElement().getValue(), "test2");
    }

    @Test
    void testGetLastElementNoNext(){
        Node node1 = new Node("test1");
        assertEquals(node1.getLastElement().getValue(), "test1");
    }

    @Test
    void testRemoveLast() {
        Node node1 = new Node("test1");
        Node node2 = new Node("test2");
        node1.setNext(node2);
        assertEquals(node1.removeLast(), "test2");
    }

    void testRemoveLast_No_Next() {
        Node node1 = new Node("test1");
        assertEquals(node1.removeLast(), "test1");
    }

    @Test
    void testToString() {
        Node node1 = new Node("test1");
        assertEquals(node1.toString(), "[test1]");

        Node node2 = new Node("test2");
        node1.setNext(node2);
        assertEquals(node1.toString(), "[test1]->[test2]");
    }
}