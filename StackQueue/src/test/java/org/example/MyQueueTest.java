package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MyQueueTest {
    @Test
    public void testQueueEmpty(){
        MyQueue q = new MyQueue();
        assertTrue(q.isEmpty());
        q.enter("test");
        assertFalse(q.isEmpty());
    }

    @Test
    public void testQueueEnter(){
        MyQueue q = new MyQueue();
        q.enter("test");
        assertFalse(q.isEmpty());
    }

    @Test
    public void testQueueLeave() throws ListEmptyException {
        MyQueue q = new MyQueue();
        q.enter("test");
        String s = (String) q.leave();
        assertTrue(q.isEmpty());
        assertEquals(s, "test");
    }


}