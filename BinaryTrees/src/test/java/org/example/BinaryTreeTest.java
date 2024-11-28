package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testIsEmpty() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        assertTrue(tree.isEmpty());

        tree.insert(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    void testGetRoot() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
        assertEquals(1, tree.getRoot().getKey());
    }

    @Test
    void testInsert() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
        tree.insert(2);
        tree.insert(3);
        assertEquals("( [1] ( [2]  [3]  ) )", tree.toString());
    }

    @Test
    void testFind() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
        tree.insert(2);
        tree.insert(3);
        assertTrue(tree.find(2));
        assertFalse(tree.find(4));
    }

    @Test
    void testFindRekursiv() throws EmptyTreeException {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        assertEquals(1, tree.findMinRekursiv());
    }

    @Test
    void testFindRekursivEcxeption() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        assertThrows(EmptyTreeException.class, () -> tree.findMinRekursiv());
    }

    @Test
    void testFindIterativ() throws EmptyTreeException {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertEquals(1, tree.findMinIterativ());
    }

    @Test
    void testFindIterativEcxeption() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        assertThrows(EmptyTreeException.class, () -> tree.findMinIterativ());
    }

    @Test
    void testTraverse() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertEquals(" [1]  [2]  [3] ", tree.traverse(Traversal.INORDER));
        assertEquals(" [1]  [2]  [3] ", tree.traverse(Traversal.PREORDER));
        assertEquals(" [3]  [2]  [1] ", tree.traverse(Traversal.POSTORDER));
    }

    @Test
    void testToString() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertEquals("( [1] ( [2]  [3]  ) )", tree.toString());
    }

}