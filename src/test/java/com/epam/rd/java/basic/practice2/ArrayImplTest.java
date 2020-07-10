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
    public void shouldReturnArraySizeIfNotEmptyTest() {
        assertEquals("AssertionError", 4, array.size());
    }

    @Test
    public void shouldReturnArraySizeIfEmptyTest() {
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
    public void shouldSetElementAtSpecificPosition(){
        array.set(2, 10);
        assertEquals("AssertionError", "[1, 2, 10, null]", array.toString());
    }

    @Test
    public void shouldReturnElementByIndexIfNotNull(){
        assertEquals("AssertionError", 2, array.get(1));
    }

    @Test
    public void shouldReturnElementByIndexIfNull(){
        assertNull("AssertionError", array.get(3));
    }

    @Test
    public void shouldReturnIndexOfNotNullElement(){
        assertEquals("AssertionError", 1, array.indexOf(2));
    }

    @Test
    public void shouldReturnIndexOfNullElement(){
        assertEquals("AssertionError", 3, array.indexOf(null));
    }

    @Test
    public void shouldReturnIndexIfNotExistElement(){
        assertEquals("AssertionError", -1, array.indexOf(100));
    }

    @Test
    public void shouldRemoveElementByIndex(){
        array.remove(2);
        assertEquals("AssertionError", "[1, 2, null]", array.toString());
    }

    @Test
    public void toStringTest() {
        assertEquals("AssertionError", "[1, 2, 3, null]", array.toString());
    }



}
