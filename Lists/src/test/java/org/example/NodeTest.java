package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void createNode() {
        Node node = new Node("NODE", null);

        Assertions.assertEquals(null, node.getNext());
        Assertions.assertEquals("NODE", node.getValue());
    }

    @Test
    void createEmptyNode() {
        Node emptyNode = new Node();

        Assertions.assertNull(emptyNode.getNext());
        Assertions.assertNull(emptyNode.getValue());
    }

    @Test
    void createFullList() {
        Node nodeList = new Node("VALUE", new Node("NEXT"), new Node("PREV"));

        Assertions.assertEquals("PREV", nodeList.getPrev().getValue());
        Assertions.assertEquals("VALUE", nodeList.getValue());
        Assertions.assertEquals("NEXT", nodeList.getNext().getValue());
    }

    @Test
    void getPrev() {
    }

    @Test
    void setPrev() {
    }

    @Test
    void getValue() {
    }

    @Test
    void setValue() {
        Node node = new Node();
        node.setValue("VALUE");

        Assertions.assertEquals("VALUE", node.getValue());
    }

    @Test
    void getNext() {
    }

    @Test
    void setNext() {
    }

    @Test
    void addLast() {
        Node node = new Node("FIRST");
        node.addLast("SEC");

        Assertions.assertNotNull(node.getNext());

        Assertions.assertEquals("SEC", node.getNext().getValue());
    }

    @Test
    void getLastElement() {
        Node node = new Node("INIT");
        node.setNext(new Node("NEXT"));

        Assertions.assertEquals("NEXT", node.getLastElement().getValue());
    }

    @Test
    void getLast() {
        Node node = new Node("INIT");
        node.addLast(new Node("SEC"));
        node.addLast(new Node("LAST"));

        Assertions.assertEquals("[LAST]", node.getLast().toString());
    }

    @Test
    void removeLast() {
        Node node = new Node("INIT");
        node.addLast(new Node("SEC"));
        node.addLast(new Node("LAST"));

        node.removeLast();

        Assertions.assertEquals("[SEC]", node.getLast().toString());
    }

    @Test
    void testToString() {
        Node node = new Node("TEST");

        Node doubleNode = new Node("FIRST", new Node("SEC"));

        Assertions.assertEquals("[TEST]", node.toString());
        Assertions.assertEquals("[FIRST]->[SEC]", doubleNode.toString());

    }
}