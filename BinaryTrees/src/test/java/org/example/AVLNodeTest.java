package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AVLNodeTest {

    @Test
    void getLeft() {
        AVLNode root = new AVLNode("ROOT");
        AVLNode l = new AVLNode("L");
        AVLNode r = new AVLNode("R");

        root.setLeft(l);
        root.setRight(r);

        Assertions.assertEquals("ROOT", root.getKey());
        Assertions.assertEquals("L", root.getLeft().getKey());
        Assertions.assertEquals("R", root.getRight().getKey());

    }

    @Test
    void setLeft() {
        AVLNode root = new AVLNode("ROOT");
        AVLNode l = new AVLNode("L");
        AVLNode r = new AVLNode("R");

        root.setLeft(l);
        root.setRight(r);

        Assertions.assertEquals("ROOT", root.getKey());
        Assertions.assertEquals("L", root.getLeft().getKey());
        Assertions.assertEquals("R", root.getRight().getKey());
    }

    @Test
    void getRight() {
        AVLNode root = new AVLNode("ROOT");
        AVLNode l = new AVLNode("L");
        AVLNode r = new AVLNode("R");

        root.setLeft(l);
        root.setRight(r);

        Assertions.assertEquals("ROOT", root.getKey());
        Assertions.assertEquals("L", root.getLeft().getKey());
        Assertions.assertEquals("R", root.getRight().getKey());
    }

    @Test
    void setRight() {
        AVLNode root = new AVLNode("ROOT");
        AVLNode l = new AVLNode("L");
        AVLNode r = new AVLNode("R");

        root.setLeft(l);
        root.setRight(r);

        Assertions.assertEquals("ROOT", root.getKey());
        Assertions.assertEquals("L", root.getLeft().getKey());
        Assertions.assertEquals("R", root.getRight().getKey());
    }

    @Test
    void getBalance() {
        AVLNode root = new AVLNode("ROOT");


        Assertions.assertEquals(0, root.getBalance());

        AVLNode l = new AVLNode("L");
        root.setLeft(l);

        Assertions.assertEquals(0, root.getBalance());

    }

    @Test
    void setBalance() {
        AVLNode node = new AVLNode("ROOT");
        node.setBalance(1000);
        Assertions.assertEquals(1000, node.getBalance());
    }

    @Test
    void getHeight() {
        AVLNode root = new AVLNode("ROOT");
        root.setHeight(1000);

        Assertions.assertEquals(1000, root.getHeight());
    }

    @Test
    void setHeight() {
        AVLNode root = new AVLNode("ROOT");
        root.setHeight(1000);

        Assertions.assertEquals(1000, root.getHeight());
    }

    @Test
    void getTotalNumberOfChildren() {
        AVLNode root = new AVLNode("ROOT");
        AVLNode l = new AVLNode("L");
        AVLNode r = new AVLNode("R");

        root.setLeft(l);
        root.setRight(r);

        Assertions.assertEquals(3, root.getTotalNumberOfChildren());
    }
}