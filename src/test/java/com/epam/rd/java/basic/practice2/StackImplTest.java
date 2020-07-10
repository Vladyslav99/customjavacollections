package com.epam.rd.java.basic.practice2;


import org.junit.Assert;
import org.junit.Test;

public class StackImplTest extends Assert {

    @Test
    public void returnQueueSizeIfNotEmptyTest() {
        Stack stack = new StackImpl();
        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
        }
        assertEquals("AssertionError", 5, stack.size());
    }

}
