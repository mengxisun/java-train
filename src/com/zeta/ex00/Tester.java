package com.zeta.ex00;

import org.junit.Test;
import static org.junit.Assert.*;
import com.zeta.TestRunner;

/**
 * Created by kang on 05/01/2017.
 */
public class Tester {
    public static void main(String[] args) {
        String[] params = new String[] {"", ""};
        for (int i = 0; i < args.length; i++) {
            if (i >= params.length)
                break;

            params[i] = args[i];
        }
        TestRunner.runTests(Tester.class, args[0], args[1]);
    }

    @Test
    public void testZero() {
        assertEquals("0结果错误", 0, Homework.getSumOfDigits(0));
    }

    @Test
    public void testPositive() {
        assertEquals("1位正整数结果错误", 8, Homework.getSumOfDigits(8));
        assertEquals("3位正整数结果错误", 16, Homework.getSumOfDigits(907));
        assertEquals("5位正整数结果错误", 15, Homework.getSumOfDigits(12345));
    }

    @Test
    public void testNegative() {
        assertEquals("1位负整数结果错误", 4, Homework.getSumOfDigits(-4));
        assertEquals("3位负整数结果错误", 1, Homework.getSumOfDigits(-100));
        assertEquals("5位负整数结果错误", 6, Homework.getSumOfDigits(10203));
    }
}
