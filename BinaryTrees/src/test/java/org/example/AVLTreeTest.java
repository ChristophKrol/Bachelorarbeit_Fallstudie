package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void getRoot() {
        AVLTree<String> tree = new AVLTree<>("ROOT");
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");

        Assertions.assertEquals("2", tree.getRoot().getKey());
    }

    @Test
    void setRoot() {
        AVLTree<String> tree = new AVLTree<>("ROOT");
        tree.setRoot(new AVLNode<>("NEW_ROOT"));

        Assertions.assertEquals("NEW_ROOT", tree.getRoot().getKey());
    }

    @Test
    void height() {
        AVLTree<String> tree = new AVLTree<>("ROOT");
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");

        Assertions.assertEquals(2, tree.height());
    }

    @Test
    void isEmpty() {
        AVLTree<String> emptyTree = new AVLTree<>(null);
        AVLTree<String> tree = new AVLTree<>("ROOT");
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");

        // Assertions.assertTrue(emptyTree.isEmpty());
        Assertions.assertFalse(tree.isEmpty());
    }

    @Test
    void find() {
        AVLTree<String> tree = new AVLTree<>("ROOT");
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");

        Assertions.assertTrue(tree.find("3"));
        Assertions.assertFalse(tree.find("4"));
    }

    @Test
    void insert() {
        AVLTree<String> tree = new AVLTree<>("ROOT");
        tree.insert("1");

        Assertions.assertTrue(tree.find("1"));
        Assertions.assertFalse(tree.find("2"));

    }

    @Test
    void traverse() {
        AVLTree<String> tree = new AVLTree<>("ROOT");
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");

        Assertions.assertEquals(" [1]  [2]  [3]  [ROOT] ", tree.traverse(Traversal.INORDER));
    }

    @Test
    void testToString() {
        AVLTree<String> tree = new AVLTree<>("ROOT");
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");


        Assertions.assertEquals("(  [1]  [2] (  [3] [ROOT] ) )", tree.toString());
        Assertions.assertEquals(" [null] ", new AVLTree<String>(null).toString());
    }
}