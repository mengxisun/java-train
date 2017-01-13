package com.zeta.ex01;

import com.zeta.TestRunner;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

/**
 * Created by kang on 11/12/2016.
 */
public class Tester {
    private Random random = new Random(System.currentTimeMillis());

    private double generateDouble() {
        return random.nextDouble() * 1e4 * (random.nextBoolean() ? 1 : -1);
    }

    private int[] generateRandomIntArray() {
        int length = random.nextInt(10) + 1;
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }

    private double[] generateRandomDoubleArray() {
        int length = random.nextInt(10) + 1;
        double[] array = new double[length];

        for (int i = 0; i < length; i++) {
            array[i] = generateDouble();
        }

        return array;
    }

    public static void main(String[] args) {
        String[] params = new String[] {"", ""};
        for (int i = 0; i < args.length; i++) {
            if (i >= params.length)
                break;

            params[i] = args[i];
        }
        TestRunner.runTests(Tester.class, params[0], params[1]);
    }

    @Test
    public void testIntArrayToString() {
        assertEquals("空数组", "{}", Homework.arrayToString(new int[] {}));

        int[] array = new int[] {random.nextInt()};
        assertEquals("数组[" + array[0] + "]", "{" + array[0] + "}", Homework.arrayToString(array));

        array = generateRandomIntArray();
        assertEquals(String.format("数组%s", Arrays.toString(array)),
                Arrays.toString(array).replace('[', '{').replace(']', '}'),
                Homework.arrayToString(array));
    }

    @Test
    public void testDoubleArrayToString() {
        assertEquals("空数组", "{}", Homework.arrayToString(new int[] {}));

        double[] array = new double[] { generateDouble() };
        assertEquals("数组[" + array[0] + "]", "{" + array[0] + "}", Homework.arrayToString(array));

        array = generateRandomDoubleArray();
        assertEquals(String.format("数组%s", Arrays.toString(array)),
                Arrays.toString(array).replace('[', '{').replace(']', '}'),
                Homework.arrayToString(array));
    }

    @Test
    public void testContainsInArray() {
        assertFalse("空数组中查找0", Homework.containsInArray(new int[] {}, 0));

        int[] array = generateRandomIntArray();
        int key = array[random.nextInt(array.length)];
        assertTrue(String.format("数组%s中查找%d", Arrays.toString(array), key), Homework.containsInArray(array, key));

        key = random.nextInt();
        for (int i = 0; i < array.length; i++) {
            do {
                array[i] = random.nextInt();
            } while (array[i] == key);
        }
        assertFalse(String.format("数组%s中查找%d", Arrays.toString(array), key), Homework.containsInArray(array, key));
    }

    @Test
    public void testSearchInArray() {
        assertEquals("在空数组中查找-1",-1, Homework.searchInArray(new int[] {}, -1));

        int[] array = generateRandomIntArray();
        int index = random.nextInt(array.length);
        assertEquals(String.format("数组%s中查找%d", Arrays.toString(array), array[index]), index, Homework.searchInArray(array, array[index]));

        int key = random.nextInt();
        for (int i = 0; i < array.length; i++) {
            do {
                array[i] = random.nextInt();
            } while (array[i] == key);
        }
        assertEquals(String.format("数组%s中查找%d", Arrays.toString(array), key), -1, Homework.searchInArray(array, key));

        key = random.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = key;
            } else {
                do {
                    array[i] = random.nextInt();
                } while (array[i] == key);
            }
        }
        assertEquals(String.format("数组%s中查找%d", Arrays.toString(array), key), 1, Homework.searchInArray(array, key));
    }

    @Test
    public void testEqualsArray() {
        assertTrue("空数组vs空数组", Homework.equalsArray(new int[] {}, new int[] {}));
        assertFalse("空数组vs null", Homework.equalsArray(new int[] {}, null));
        assertTrue("null vs null", Homework.equalsArray(null, null));

        int[] array1 = new int[] {random.nextInt(), random.nextInt(), random.nextInt()};
        int[] array2 = new int[] {array1[0], random.nextInt(), array1[2]};
        assertFalse(String.format("数组%s vs 数组%s", Arrays.toString(array1), Arrays.toString(array2)), Homework.equalsArray(array1, array2));

        array2 = new int[] { array1[0], array1[1] };
        assertFalse(String.format("数组%s vs 数组%s", Arrays.toString(array1), Arrays.toString(array2)), Homework.equalsArray(array1, array2));

        array2 = new int[] { array1[0], array2[1], array1[2] };
        assertTrue(String.format("数组%s vs 数组%s", Arrays.toString(array1), Arrays.toString(array2)), Homework.equalsArray(array1, array2));

        array2 = array1;
        assertTrue(String.format("数组%s vs 自身", Arrays.toString(array1)), Homework.equalsArray(array1, array2));
    }

    @Test
    public void testCopyArray() {
        int[] array = new int[] {};
        assertTrue("复制空数组", Arrays.equals(array, Homework.copyArray(array)));
        int length = random.nextInt();
        assertTrue("复制空数组（length=" + length + "）", Arrays.equals(array, Homework.copyArray(array, length)));

        array = generateRandomIntArray();
        assertTrue(String.format("数组%s全复制", Arrays.toString(array)), Arrays.equals(array, Homework.copyArray(array)));

        array = generateRandomIntArray();
        length = random.nextInt(array.length);
        assertTrue(String.format("数组%s部分复制（length=%d）", Arrays.toString(array), length),
                Arrays.equals(Arrays.copyOf(array, length), Homework.copyArray(array, length)));

        array = generateRandomIntArray();
        length = random.nextInt(array.length);
        assertTrue(String.format("数组%s部分复制（length=%d）", Arrays.toString(array), length),
                Arrays.equals(Arrays.copyOf(array, length), Homework.copyArray(array, length)));

        array = generateRandomIntArray();
        length = array.length * 2;
        assertTrue(String.format("数组%s全复制（length=%d）", Arrays.toString(array), length),
                Arrays.equals(Arrays.copyOf(array, array.length), Homework.copyArray(array, length)));
    }
}
