package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void testSetRoot() {
        AVLTree<Integer> avlTree = new AVLTree<Integer>(8);
        assertEquals(8, avlTree.getRoot().getKey());
    }

    @Test
    public void testInsert() {
        // Arrange
        AVLTree<Integer> tree = new AVLTree<>(1);
        tree.insert(2);
        tree.insert(3);

        // Act
        tree.insert(4);

        // Assert
        assertEquals("(  [1]  [2] ( [3]  [4]  ) )", tree.toString());
    }

    @Test
    public void testInsertSameValueTwice() {
        // Arrange
        AVLTree<Integer> tree = new AVLTree<>(1);
        tree.insert(2);
        tree.insert(3);

        // Act
        tree.insert(4);
        tree.insert(4);

        // Assert
        assertEquals("(  [1]  [2] ( [3]  [4]  ) )", tree.toString());
    }

    @Test
    public void testHeight() {
        // Arrange
        AVLTree<Integer> tree = new AVLTree<>(1);
        tree.insert(2);
        tree.insert(3);

        // Act
        int height = tree.height();

        // Assert
        assertEquals(1, height);
    }

    @Test
    public void testIsEmpty() {
        // Arrange
        AVLTree<Integer> tree = new AVLTree<>(1);

        // Act
        boolean isEmpty = tree.isEmpty();

        // Assert
        assertFalse(isEmpty);
    }

    @Test
    public void testFind() {
        // Arrange
        AVLTree<Integer> tree = new AVLTree<>(1);
        tree.insert(2);
        tree.insert(3);

        // Act
        boolean found = tree.find(3);

        // Assert
        assertTrue(found);
    }

    @Test
    public void testTraverse() {
        // Create a new AVL tree with some nodes
        AVLTree<Integer> tree = new AVLTree<>(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);

        // Test traverse method with INORDER traversal
        String actual = tree.traverse(Traversal.INORDER);
        String expected = " [1]  [2]  [3]  [4] ";
        assertEquals(expected, actual);

        // Test traverse method with POSTORDER traversal
        actual = tree.traverse(Traversal.POSTORDER);
        expected = " [1]  [4]  [3]  [2] ";
        assertEquals(expected, actual);

        // Test traverse method with PREORDER traversal
        actual = tree.traverse(Traversal.PREORDER);
        expected = " [2]  [1]  [3]  [4] ";
        assertEquals(expected, actual);
    }

    @Test
    public void toString_returnsCorrectStringRepresentation() {
        // Create an empty tree
        AVLTree<Integer> avl = new AVLTree<>(1);
        assertEquals(" [1] ", avl.toString());

        // Insert some values into the tree
        avl.insert(2);
        avl.insert(3);

        // Check that the string representation is correct
        assertEquals("(  [1]  [2]  [3]  )", avl.toString());
    }

}