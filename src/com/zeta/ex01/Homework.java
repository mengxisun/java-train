package com.zeta.ex01;

/**
 * 本文件是课后编程作业的骨架代码。
 * 原始代码给出了每一道题目的说明（注释）和方法骨架，请按照注释中的题目要求补充完成方法的内部实现。
 * 注意：要按照基本的编码规范编写代码。
 * 每一道题的代码提交后都会经过单元测试。
 */
public class Homework {
    /*
     * 第1题：
     * 编写arrayToString方法，接受一个数组作为参数，把该数组的内容按如下形式作成字符串返回： {a1, a2, ..., an}。
     * 该方法有两个重载，分别接受int数组和double数组作为参数。
     * 方法的骨架已经写好，请编写内部实现，不要修改方法的签名。
     */
    public static String arrayToString(int[] array) {
        String arrayString = "";

        // write your code here.

        return arrayString;
    }

    public static String arrayToString(double[] array) {
        String arrayString = "";

        // write your code here.

        return arrayString;
    }


    /*
     * 第2题：
     * 编写containsInArray方法，接受一个int数组(array)和一个int值(key)作为参数，查找key是否在array内，如果在则返回true，不在则返回false。
     * 方法的骨架已经写好，请编写内部实现，不要修改方法的签名。
     */
    public static boolean containsInArray(int[] array, int key) {
        boolean exists = false;

        // write your code here.

        return exists;
    }

    /*
     * 第3题：
     * 编写searchInArray方法，接受一个int数组(array)和一个int值(key)作为参数，查找key在数组内位置的索引并返回。
     * 如果array内不含有key，则返回-1。如果array内有重复的key，返回第一个key的索引。
     * 注意数组的索引是从0开始排列的
     * 方法的骨架已经写好，请编写内部实现，不要修改方法的签名。
     */
    public static int searchInArray(int[] array, int key) {
        int index = -1;

        // write your code here.

        return index;
    }

    /*
     * 第4题：
     * 编写equalsArray方法，接受两个int数组作为参数，判断两个数组的内容是否相同。
     * 如果两个数组长度、内容完全相同，则返回true，否则返回false。
     * 方法的骨架已经写好，请编写内部实现，不要修改方法的签名。
     */
    public static boolean equalsArray(int[] array1, int[] array2) {
        boolean equals = false;

        // write your code here.

        return equals;
    }

    /*
     * 第5题：
     * 编写copyArray方法，执行对int数组的拷贝。有两个重载方法：
     * 重载1：接受一个int数组作为参数，返回对该数组完全复制的副本。
     * 重载2：接受一个int数组(array)和一个int值(length)作为参数，只array的前length个元素复制并返回出来；
     *       如果length超过array本身的长度，则执行完全复制；如果length小于或等于0，则返回空数组。
     * 方法的骨架已经写好，请编写内部实现，不要修改方法的签名。
     */
    public static int[] copyArray(int[] array) {
        int[] copiedArray = null;

        // write your code here.

        return copiedArray;
    }

    public static int[] copyArray(int[] array, int length) {
        int[] copiedArray = null;

        // write your code here.

        return copiedArray;
    }
}
