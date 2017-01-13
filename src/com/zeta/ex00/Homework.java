package com.zeta.ex00;

/**
 * Created by kang on 05/01/2017.
 */
public class Homework {
    /*
    * 编写GetSumOfDigits方法，接受一个正整数作为参数，返回其各位数之和
    * 如果输入参数为负数，请按其绝对值计算。
    * 方法的骨架已经写好，请编写内部实现，不要修改方法的签名。
    */
    static int getSumOfDigits(int number) {
        int sum = 0;

        // write your code here.
        String literal = Integer.toString(number > 0 ? number : -number);
        for (int i = 0; i < literal.length(); i++) {
            sum += literal.charAt(i) - '0';
        }

        return sum;
    }
}
