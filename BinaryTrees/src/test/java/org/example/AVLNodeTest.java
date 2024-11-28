package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AVLNodeTest {

    @Test
    public void testInsertLeft() {
        // Create an instance of your AVL tree class
        AVLTree<Integer> avl = new AVLTree<>();

        // Create some sample data to insert
        Integer value1 = 5;
        Integer value2 = 3;
        Integer value3 = 7;

        // Insert the values into the AVL tree
        avl.insert(value1);
        avl.insert(value2);
        avl.insert(value3);

        // Verify that the AVL tree is in the correct state after insertion
        assertNotNull(avl.getRoot()); // Check if the root is not null

        Integer[] expectedOrder = {value2, value1, value3};
        Object[] actualOrder = avl.inOrder();
        assertArrayEquals(expectedOrder, actualOrder); // Check if the in-order traversal matches your expected order
    }




// Repeat this process for each method you want to test.
}