package com.jmx.algorithm.array.easy;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int test = 123;
        int result = Solution.reverse(test);
        System.out.println(result);
    }
}

class Solution {
    /**
     * 解题核心：如何解决溢出的问题
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        while(x != 0) {
            if (res < Integer.MIN_VALUE / 10) return 0;
            if (res > Integer.MAX_VALUE / 10) return 0;
            res *= 10;
            int m = x % 10;
            if (m < 0 && res < Integer.MIN_VALUE - m) return 0;
            if (m > 0 && res > Integer.MAX_VALUE - m) return 0;
            res += m;
            x /= 10;
        }
        return res;
    }
}
