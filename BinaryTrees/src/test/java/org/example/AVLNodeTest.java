package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLNodeTest {

    @Test
    public void testGetTotalNumberOfChildren() {
        // Create an AVL node with no children
        AVLNode<Integer> root = new AVLNode<>(1);
        assertEquals(1, root.getTotalNumberOfChildren());

        // Add a left child to the root
        root.setLeft(new AVLNode<>(2));
        assertEquals(2, root.getTotalNumberOfChildren());

        // Add a right child to the root
        root.setRight(new AVLNode<>(3));
        assertEquals(3, root.getTotalNumberOfChildren());

        // Add a left child to the left child of the root
        root.getLeft().setLeft(new AVLNode<>(4));
        assertEquals(4, root.getTotalNumberOfChildren());

        // Add a right child to the left child of the root
        root.getLeft().setRight(new AVLNode<>(5));
        assertEquals(5, root.getTotalNumberOfChildren());

        // Add a left child to the right child of the root
        root.getRight().setLeft(new AVLNode<>(6));
        assertEquals(6, root.getTotalNumberOfChildren());

        // Add a right child to the right child of the root
        root.getRight().setRight(new AVLNode<>(7));
        assertEquals(7, root.getTotalNumberOfChildren());

        // Test case with no left child and a right child
        AVLNode<Integer> node = new AVLNode<>(1);
        node.setRight(new AVLNode<>(2));
        assertEquals(2, node.getTotalNumberOfChildren());
    }
}