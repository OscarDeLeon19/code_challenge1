package org.example;

import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test1() {

        Object[] array1 = {1, 2, new Object[]{"3", "4"} };
        Object[] array2 = App.transformArray(array1);

        Object[] result = {1, 2, "3", "4"};

        Assertions.assertArrayEquals(result, array2);

    }

    @Test
    public void test2() {

        Object[] array1 = {1, 2, new Object[]{3, 4, new Object[]{5, 6}} };
        Object[] array2 = App.transformArray(array1);

        Object[] result = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(array2, result);

    }

    @Test
    public void test3() {

        Object[] array1 = {1, 2, new Object[]{"a", "b", new Object[]{5, 6}} };
        Object[] array2 = App.transformArray(array1);

        Object[] result = {1, 2, "a", "b", 5, 6};
        Assertions.assertArrayEquals(array2, result);

    }

    @Test
    public void test4() {

        Object[] array1 = {1, 2, new Object[]{3, 4, new Object[]{5, 6, new Object[]{7, 8, new Object[]{9, 10}}}} };
        Object[] array2 = App.transformArray(array1);

        Object[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertArrayEquals(array2, result);

    }
}
