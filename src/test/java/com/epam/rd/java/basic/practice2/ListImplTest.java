package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListImplTest extends Assert {

    private List listByAsc;
    private List listByDesc;

    @Before
    public void fillListWithValuesByAscending(){
        listByAsc = new ListImpl();
        for (int i = 0; i < 5; i++) {
            listByAsc.addLast(i + 1);
        }
        listByAsc.addLast(null);
    }

    @Before
    public void fillListWithValuesByDescending(){
        listByDesc = new ListImpl();
        for (int i = 0; i < 5; i++) {
            listByDesc.addFirst(i + 1);
        }
        listByDesc.addFirst(null);
    }

    @Test
    public void returnListSizeIfNotEmptyTest() {
        assertEquals("AssertionError", 6, listByAsc.size());
        assertEquals("AssertionError", 6, listByDesc.size());
    }

    @Test
    public void returnListSizeIfEmptyTest() {
        listByAsc = new ListImpl();
        assertEquals("AssertionError", 0, listByAsc.size());
    }

    @Test
    public void shouldClearListTest(){
        listByAsc.clear();
        assertEquals("AssertionError", 0, listByAsc.size());
        assertEquals("AssertionError", "[]", listByAsc.toString());
    }

    @Test
    public void toStringByAscTest() {
        assertEquals("AssertionError", "[1, 2, 3, 4, 5, null]", listByAsc.toString());
    }

    @Test
    public void toStringByDescTest() {
        assertEquals("AssertionError", "[null, 5, 4, 3, 2, 1]", listByDesc.toString());
    }

}
