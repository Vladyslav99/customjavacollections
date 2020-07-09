package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ArrayImplTest extends Assert {

    private Array array;

    @Before
    public void fillArrayWithValues(){
        array = new ArrayImpl();
        for (int i = 0; i < 3; i++) {
            array.add(i + 1);
        }
        array.add(null);
    }

    @Test
    public void returnArraySizeIfNotEmptyTest() {
        assertEquals("AssertionError", 4, array.size());
    }

    @Test
    public void returnArraySizeIfEmptyTest() {
        array = new ArrayImpl();
        assertEquals("AssertionError", 0, array.size());
    }

    @Test
    public void shouldClearArrayTest(){
        array.clear();
        assertEquals("AssertionError", 0, array.size());
        assertEquals("AssertionError", "[]", array.toString());
    }

    @Test
    public void toStringTest() {
        assertEquals("AssertionError", "[1, 2, 3, null]", array.toString());
    }

}
