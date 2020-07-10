package com.epam.rd.java.basic.practice2;


import org.junit.Assert;
import org.junit.Test;

public class QueueImplTest extends Assert {

    @Test
    public void returnQueueSizeIfNotEmptyTest() {
        Queue queue = new QueueImpl();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i + 1);
        }
        assertEquals("AssertionError", 5, queue.size());
    }

}
