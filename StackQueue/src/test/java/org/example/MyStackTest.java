package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {


    @Test
    public void TestisEmpty(){
        MyStack stack = new MyStack();
        assertTrue(stack.isEmpty());
        stack.push("test");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void TestPush(){
        MyStack stack = new MyStack();
        stack.push("test");
        assertFalse(stack.isEmpty());
    }

    public void TestPop() throws ListEmptyException {
        MyStack stack = new MyStack();
        stack.push("test");
        String s = (String) stack.pop();
        assertTrue(stack.isEmpty());
        assertEquals("test", s);
    }
}